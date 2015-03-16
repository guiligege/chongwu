package org.guili.ecshop.bean.common;

public enum EscapUrlHeader {
	Tmall("detail.tmall.com"),
	Taobao("item.taobao.com"),
	Taobao_redirect("redirect.simba.taobao.com"),
	Taobao_click("s.click.taobao.com"),
	Juhuasuan("detail.ju.taobao.com")
	;
	public String url;
	// 构造方法  
    private EscapUrlHeader(String url) {  
        this.url = url;  
    }
}
