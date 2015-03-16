package org.guili.ecshop.bean.common;

/**
 * 成果网链接转换工具
 * @author guili
 *
 */
public enum ChanetUrlRedirectBean {
	//成果网所有cps网站推广信息
	JD("jd.com", 22338),
	SUNING("suning.com", 109438),
	YIXUN("yixun.com", 134272),
	VIP("vip.com", 86419),
	VJIA("vjia.com", 132173),
	YHD("yhd.com", 41922),
	DANGDANG("dangdang.com", 5775),
	JUMEI("jumei.com", 206104),
	LEFENG("lefeng.com", 83382),
	GOME("gome.com.cn", 122139),
	NEWEGG("newegg.cn", 38972),
	WOMAI("womai.com", 215653),
	M18("m18.com", 53804),
	MASAMASO("masamaso.com", 69710),
	MOONBASA("moonbasa.com", 100683),
	MEITUAN("meituan.com", 196861),
	LAMIU("lamiu.com", 86640),
	CAMEL("camel.com.cn", 263390),
	HODO("hodo.cn", 319032),
	BANGGO("banggo.com", 271038),
	ESPRIT("esprit.cn", 289430),
	HANDU("handu.com", 338413),
	QIPAI("qipaimall.com", 342977),
	JIUXIAN("jiuxian.com", 219208),
	GAP("gap.cn", 348898),
	LIEBO("liebo.com", 357030),
	IHUSH("ihush.com", 187903),
	REDBABY("redbaby.suning.com", 8837),
	
	
	D1("d1.com.cn", 4984),
	MENGLU("menglu.com", 5071),
	OFCARD("ofcard.com", 8307),
	OCJ("ocj.com.cn", 8340),
	BOOKCHINA("bookschina.com", 9074),
	MBAOBAO("mbaobao.com", 44041),
	VNV("venusveil.com", 48911),
	UIYI("uiyi.cn", 54377),
	JJLG("jjlg.com.cn", 62730),
	PB89("pb89.com", 85803),
	WINXUAN("winxuan.com", 90285),
	FCLUB("fclub.cn", 94659),
	MYZJ("muyingzhijia.com", 96533),
	MXK("s.cn", 106000),
	TIANTIAN("tiantian.com", 116842),
	XIU("xiu.com", 126845),
	MAIDANGAO("maidangao.com", 127774),
	NARUKO("naruko.com.cn", 129821),
	YINTAI("yintai.com", 155558),
	LIKEFACE("likeface.com", 168698),
	SHOPIN("shopin.net", 168764),
	YMW("yesmywine.com", 189051),
	YOUGOU("yougou.com", 209500),
	NALA("nala.com.cn", 210590),
	NOP("nop.cn", 238068),
	WINENICE("winenice.com", 245347),
	MFPLAZA("mfplaza.com", 247372),
	BOOKUU("bookuu.com", 247909),
	WINEKE("winekee.com", 248164),
	ZHIWO("zhiwo.com", 248545),
	J1("j1.com", 259544),
	LIKETUAN("liketuan.com", 261158),
	MEIWEI77("yummy77.com", 262157),
	MYXIEQU("myxiequ.com", 266388),
	METRO("metromall.com.cn", 268290),
	WBIAO("wbiao.cn", 272309),
	LECAKE("lecake.com", 274506),
	ZGJF("zgjf168.com", 281979),
	STAPLES("staples.cn", 299417),
	JIANKANG("1jiankang.com", 324465),
	ONE11("111.com.cn", 332812),
	ITRUELIFE("itruelife.com", 360108),
	AI360("360ai.com.cn", 360139),
	VMALL("vmall.com", 360244),
	ORBIS("orbis.com.cn", 366399)
	;
	// 构造方法  
    private ChanetUrlRedirectBean(String url, int chanetIndex) {  
        this.url = url;  
        this.chanetIndex = chanetIndex;  
    }
	 // 成员变量
    public String url;  
    public int chanetIndex;
    public static final int womaimeChanetId=507612;
    
}
