package org.guili.ecshop.bean.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.guili.ecshop.util.common.UrlHelper;

/**
 * 成果网链接转换
 * @author guili
 *
 */
public class ChanetUrlChangeUtil {

    /**
     * 转换url
     * @param url
     * @return
     */
    public static String getChanetUrl(String url){
    	//防止空传入
    	if(url==null || url.isEmpty()){
    		return "";
    	}
    	//处理传入url为chanetUrl的链接格式
    	String chanetUrl=url;
    	String mainUrl=UrlHelper.getMainUrl(url);
//    	www.jd.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.JD.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.JD.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.suning.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.SUNING.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.SUNING.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.yixun.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.YIXUN.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.YIXUN.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.vip.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.VIP.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.VIP.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.vjia.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.VJIA.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.VJIA.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.yhd.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.YHD.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.YHD.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.dangdang.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.DANGDANG.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.DANGDANG.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.jumei.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.JUMEI.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.JUMEI.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.lefeng.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.LEFENG.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.LEFENG.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.gome.com.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.GOME.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.GOME.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.newegg.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.NEWEGG.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.NEWEGG.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.womai.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.WOMAI.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.WOMAI.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.m18.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.M18.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.M18.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.masamaso.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.MASAMASO.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.MASAMASO.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.moonbasa.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.MOONBASA.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.MOONBASA.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.meituan.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.MEITUAN.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.MEITUAN.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.lamiu.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.LAMIU.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.LAMIU.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.camel.com.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.CAMEL.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.CAMEL.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.hodo.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.HODO.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.HODO.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.banggo.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.BANGGO.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.BANGGO.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.esprit.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.ESPRIT.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.ESPRIT.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.handu.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.HANDU.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.HANDU.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.qipaimall.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.QIPAI.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.QIPAI.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.jiuxian.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.JIUXIAN.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.JIUXIAN.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.gap.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.GAP.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.GAP.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.liebo.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.LIEBO.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.LIEBO.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.ihush.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.IHUSH.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.IHUSH.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	redbaby.suning.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.REDBABY.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.REDBABY.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.yintai.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.YINTAI.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.YINTAI.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.mfplaza.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.MFPLAZA.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.MFPLAZA.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.zhiwo.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.ZHIWO.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.ZHIWO.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	
// 
    	
    	
//www.d1.com.cn链接转换
    	if(mainUrl.contains(ChanetUrlRedirectBean.D1.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.D1.chanetIndex,"","",url);
    	}
//    	www.menglu.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.MENGLU.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.MENGLU.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.ofcard.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.OFCARD.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.OFCARD.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.ocj.com.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.OCJ.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.OCJ.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.bookschina.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.BOOKCHINA.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.BOOKCHINA.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.mbaobao.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.MBAOBAO.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.MBAOBAO.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.venusveil.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.VNV.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.VNV.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.uiyi.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.UIYI.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.UIYI.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.jjlg.com.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.JJLG.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.JD.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.pb89.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.PB89.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.PB89.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.winxuan.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.WINXUAN.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.WINXUAN.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	fclub.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.FCLUB.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.FCLUB.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.muyingzhijia.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.MYZJ.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.MYZJ.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.s.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.MXK.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.MXK.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.tiantian.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.TIANTIAN.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.TIANTIAN.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.xiu.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.XIU.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.XIU.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.maidangao.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.MAIDANGAO.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.MAIDANGAO.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.naruko.com.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.NARUKO.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.NARUKO.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.likeface.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.LIKEFACE.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.LIKEFACE.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.shopin.net
    	if(mainUrl.contains(ChanetUrlRedirectBean.SHOPIN.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.SHOPIN.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.yesmywine.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.YMW.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.YMW.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.yougou.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.YOUGOU.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.YOUGOU.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.nala.com.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.NALA.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.NALA.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.nop.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.NOP.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.NOP.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.winenice.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.WINENICE.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.WINENICE.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.bookuu.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.BOOKUU.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.BOOKUU.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.winekee.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.WINEKE.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.WINEKE.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.j1.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.J1.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.J1.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.liketuan.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.LIKETUAN.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.LIKETUAN.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.yummy77.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.MEIWEI77.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.MEIWEI77.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.myxiequ.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.MYXIEQU.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.MYXIEQU.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.metromall.com.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.METRO.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.METRO.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.wbiao.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.WBIAO.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.WBIAO.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.lecake.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.LECAKE.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.LECAKE.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.zgjf168.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.ZGJF.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.ZGJF.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.staples.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.STAPLES.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.STAPLES.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	1jiankang.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.JIANKANG.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.JIANKANG.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.111.com.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.ONE11.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.ONE11.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.itruelife.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.ITRUELIFE.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.ITRUELIFE.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.360ai.com.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.AI360.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.AI360.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.vmall.com
    	if(mainUrl.contains(ChanetUrlRedirectBean.VMALL.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.VMALL.chanetIndex,"","",url);
    		return chanetUrl;
    	}
//    	www.orbis.com.cn
    	if(mainUrl.contains(ChanetUrlRedirectBean.ORBIS.url)){
    		chanetUrl=changeToChanetUrl(ChanetUrlRedirectBean.womaimeChanetId,ChanetUrlRedirectBean.ORBIS.chanetIndex,"","",url);
    		return chanetUrl;
    	}
    	return chanetUrl;
    }
    
    /**
     * 
     * @param aid
     * @param did
     * @param u
     * @param e
     * @param url
     * @return
     */
    public static String changeToChanetUrl(Integer aid,Integer did,String u,String e,String url){
    	//http://count.chanet.com.cn/click.cgi?a=507612&d=4984&u=&e=&url=[BACKURL]
    	//url must encode
    	if(aid==null || did==null){
    		return url;
    	}
    	String encodeurl="";
    	try {
			encodeurl=URLEncoder.encode(url, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			encodeurl=url;
			e1.printStackTrace();
		}
    	return "http://count.chanet.com.cn/click.cgi?a="+aid+"&d="+did+"&u="+u+"&e="+e+"&url="+encodeurl;
    }
    //test ChanetUrl
    public static void main(String[] args) {
    	System.out.println(ChanetUrlChangeUtil.getChanetUrl("http://www.orbis.com.cn/"));
	}
}
