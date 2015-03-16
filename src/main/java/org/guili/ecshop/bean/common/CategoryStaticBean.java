package org.guili.ecshop.bean.common;

public enum  CategoryStaticBean {
	    FUZHUANG("服饰鞋包", 1), HUWAI("运动户外", 2), SHUMA("手机数码", 3)
	    , JIADIAN("家用电器", 4), MEIZHUANG("护肤美妆", 5), BANGONG("办公用品", 6), MUYING("母婴用品", 7)
	    , RIYONG("日用百货", 8), MEISHI("美食特产", 9), JIAJU("家居家纺", 10), TUSHU("图书音像", 11)
	    , QICHE("汽车用品", 12), OTHER("其他类别", 13);  
	    // 成员变量
	    public String name;  
	    public int index;  
	    // 构造方法  
	    private CategoryStaticBean(String name, int index) {  
	        this.name = name;  
	        this.index = index;  
	    }
	    public static String getCategoryName(int categoryid){
	    	if(categoryid==FUZHUANG.index){
	    		return FUZHUANG.name;
	    	}
	    	if(categoryid==HUWAI.index){
	    		return HUWAI.name;
	    	}
	    	if(categoryid==SHUMA.index){
	    		return SHUMA.name;
	    	}
	    	if(categoryid==JIADIAN.index){
	    		return JIADIAN.name;
	    	}
	    	if(categoryid==MEIZHUANG.index){
	    		return MEIZHUANG.name;
	    	}
	    	if(categoryid==BANGONG.index){
	    		return BANGONG.name;
	    	}
	    	if(categoryid==MUYING.index){
	    		return MUYING.name;
	    	}
	    	if(categoryid==RIYONG.index){
	    		return RIYONG.name;
	    	}
	    	if(categoryid==MEISHI.index){
	    		return MEISHI.name;
	    	}
	    	if(categoryid==JIAJU.index){
	    		return JIAJU.name;
	    	}
	    	if(categoryid==TUSHU.index){
	    		return TUSHU.name;
	    	}
	    	if(categoryid==QICHE.index){
	    		return QICHE.name;
	    	}
	    	if(categoryid==OTHER.index){
	    		return OTHER.name;
	    	}
	    	return "";
	    }
}