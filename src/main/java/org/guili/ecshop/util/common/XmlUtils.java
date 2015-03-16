package org.guili.ecshop.util.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.guili.ecshop.util.ResourceUtil;

/**
 * 
 * @author zhengdong.xiao
 *
 */
public class XmlUtils {

	public static final String CHANGEFREQ="weekly";
	public static ResourceBundle	domain = ResourceBundle.getBundle("config/file_config");
	private static final String sitemapdomain=ResourceUtil.getValue(domain, "sitemapurl");
	
	public static Document createSitemap(){
		Document document = DocumentHelper.createDocument();
        return document;
	}
	 /**
     * 一个一个加入sitemap
     * @param 
     * @return
     */
    public  static void addOneElement(Element urlsetElement,String url,String changefreq) {
        //添加元素 url
        Element urlElement = urlsetElement.addElement("url");
        //添加url子元素 loc
        Element locElement = urlElement.addElement("loc");
        //给loc元素赋值
        locElement.setText(url);
        //添加url子元素 lastmod
        Element lastmodElement = urlElement.addElement("lastmod");
        //给lastmod元素赋值
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        lastmodElement.setText(sdf.format(new Date()));
        //添加url子元素 changefreq
        Element changefreqElement = urlElement.addElement("changefreq");
        //给changefreq元素赋值
        changefreqElement.setText(changefreq);
        //添加url子元素 priority
        Element priorityElement = urlElement.addElement("priority");
        priorityElement.setText("1.0");
    }
    
    
    /**
     * 生成xml文件
     */
    public static void generateXmlFile(Document document) {
        XMLWriter out = null;
        BufferedWriter bw = null;
        OutputStreamWriter osw = null;
        FileOutputStream fos = null;
        String SITEMAP_DOMAIN = sitemapdomain;
        try {
            File xmlFile = new File(SITEMAP_DOMAIN);//输出xml的路径
            if(!xmlFile.exists()){
            	xmlFile.createNewFile();
            }
            fos = new FileOutputStream(xmlFile);
            osw = new OutputStreamWriter(fos,"UTF-8");//指定编码，防止写中文乱码
            bw = new BufferedWriter(osw);
            //对xml输出格式化
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            out = new XMLWriter(bw, format);
            out.write(document);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out != null) {
                    out.close();
                }
                if(bw != null) {
                    bw.close();
                }
                if(osw != null) {
                    osw.close();
                }
                if(fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //test
    public static void main(String[] args) {
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(new Date()));
	}
}
