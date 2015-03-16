package org.guili.ecshop.util;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

/**
 * 专门用于Spring 自动properties注入的HttpComponent
 *
 * @author jack.zhang
 */

public class HttpComponent {

    private static final Logger LOG = LoggerFactory.getLogger(HttpComponent.class);
    private static final int MAX_TOTAL = 200;
    private static final int DEFAULT_TIMEOUT = 50000;
    private HttpClient httpClient;

    /**
     * 默认设置的HttpClient
     * <p/>
     * 单个站点最大允许连接:200
     * 单个站点最大允许连接数:200
     * 默认连接超时时间:200ms
     * 默认数据接收超时时间:200ms
     */
    public HttpComponent() {
        PoolingClientConnectionManager connectionManager = new PoolingClientConnectionManager();
        connectionManager.setDefaultMaxPerRoute(MAX_TOTAL);
        connectionManager.setMaxTotal(MAX_TOTAL);
        HttpParams httpParams = new BasicHttpParams();
        httpParams.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, DEFAULT_TIMEOUT);
        httpParams.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, DEFAULT_TIMEOUT);
        httpClient = new DefaultHttpClient(connectionManager, httpParams);
    }
    
    /**
     * 设置代理服务器访问目标网站，进行抓取
     * @param ip 代理服务器ip
     * @param port 代理服务器端口
     */
    public void setProxy(String ip,int port){
    	String proxyHost = ip;
    	 int proxyPort = port;
    	 HttpHost proxy = new HttpHost(proxyHost,proxyPort);
    	this.httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
    }

    /**
     * 带参数设置的HttpClient
     *
     * @param maxPerRoute    单个站点最大允许连接
     * @param maxTotal       单个站点最大允许连接数
     * @param connTimeout    连接超时时间
     * @param soTimeout      数据接收超时时间
     * @param staleConnCheck 是否进行陈旧连接检查, 如果不开启, 则启动陈旧连接关闭线程
     */
    @Autowired
    public HttpComponent(@Value("${http.max.per.route:300}") int maxPerRoute,
                         @Value("${http.max:100}") int maxTotal,
                         @Value("${http.conn.timeout:200}") int connTimeout,
                         @Value("${http.so.timeout:200}") int soTimeout,
                         @Value("${http.stale.check:true}") boolean staleConnCheck) throws Exception {
        PoolingClientConnectionManager connectionManager = new PoolingClientConnectionManager();
        connectionManager.setDefaultMaxPerRoute(maxPerRoute);
        connectionManager.setMaxTotal(maxTotal);
        HttpParams httpParams = new BasicHttpParams();
        httpParams.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connTimeout);
        httpParams.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, soTimeout);
        httpParams.setBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, staleConnCheck);
        if (!staleConnCheck) {
            new IdleConnectionMonitorThread(connectionManager).start();
        }
        /* 跳过SSL证书检查 */
        SSLContext sslcontext = SSLContext.getInstance("TLS");
        TrustManager truseAllManager = new X509TrustManager() {

            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] arg0, String arg1)
                    throws CertificateException {
            }

            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] arg0, String arg1)
                    throws CertificateException {
            }

            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

        };
        sslcontext.init(null, new TrustManager[]{truseAllManager}, null);
        SSLSocketFactory sf = new SSLSocketFactory(sslcontext, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        Scheme https = new Scheme("https", 443, sf);
        connectionManager.getSchemeRegistry().register(https);
        httpClient = new DefaultHttpClient(connectionManager, httpParams);
    }

    /**
     * Execute t.
     *
     * @param httpHost       the http host
     * @param httpUriRequest the http uri request
     * @param handler        the handler
     * @return the t
     * @throws java.io.IOException the iO exception
     */
    public <T> T execute(HttpHost httpHost, HttpUriRequest httpUriRequest, ResponseHandler<T> handler) throws IOException {
        return httpClient.execute(httpHost, httpUriRequest, handler, new BasicHttpContext());
    }

    /**
     * Execute t.
     *
     * @param httpUriRequest the http uri request
     * @param handler        the handler
     * @return the t
     * @throws java.io.IOException the iO exception
     */
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<T> handler) throws IOException {
        return httpClient.execute(httpUriRequest, handler, new BasicHttpContext());
    }

    /**
     * Execute with log
     *
     * @param httpUriRequest the http uri request
     * @param handler        the handler
     * @return the t
     * @throws java.io.IOException the iO exception
     */
    public <T> T executeWithLog(HttpUriRequest httpUriRequest, ResponseHandler<T> handler) throws IOException {
        long start = System.currentTimeMillis();
        T result = httpClient.execute(httpUriRequest, handler, new BasicHttpContext());
        LOG.info("send request to: {}, execute time: {}ms", httpUriRequest.getURI(), System.currentTimeMillis() - start);
        return result;
    }

    /**
     * Shutdown void.
     */
    public void shutdown() {
        LOG.debug("Connection manager is shutting down");
        httpClient.getConnectionManager().shutdown();
        LOG.debug("Connection manager shut down");
    }

    /**
     * The type Idle connection monitor thread.
     *
     * @author jack.zhang
     */
    public class IdleConnectionMonitorThread extends Thread {
        private final ClientConnectionManager connMgr;
        private volatile boolean shutdown;

        /**
         * Instantiates a new Idle connection monitor thread.
         *
         * @param connMgr the conn mgr
         */
        public IdleConnectionMonitorThread(ClientConnectionManager connMgr) {
            super();
            this.connMgr = connMgr;
        }

        @Override
        public void run() {
            try {
                while (!shutdown) {
                    synchronized (this) {
                        wait(5000);
                        // Close expired connections
                        connMgr.closeExpiredConnections();
                        // Optionally, close connections
                        // that have been idle longer than 30 sec
                        connMgr.closeIdleConnections(30, TimeUnit.SECONDS);
                    }
                }
            } catch (InterruptedException ex) {
                LOG.warn("exception occur, " + ex.getMessage());
            }
        }

        /**
         * Shutdown void.
         */
        public void shutdown() {
            shutdown = true;
            synchronized (this) {
                notifyAll();
            }
        }
    }
}
