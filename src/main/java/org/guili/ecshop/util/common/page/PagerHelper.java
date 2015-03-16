package org.guili.ecshop.util.common.page;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/** 
 * 控制分页的类 
 */  
public class PagerHelper {  
  
    public static Pager getPager(HttpServletRequest req,  
            int totalRows) {  
  
        // 定义pager对象，用于传到页面  
        Pager pager = new Pager(totalRows);  
  
        // 从Request对象中获取当前页号  
        String currentPage = req.getParameter("cpage");  
  
        // 如果当前页号为空，表示为首次查询该页  
        // 如果不为空，则刷新pager对象，输入当前页号等信息  
        if (currentPage != null) {  
            pager.setStart(Integer.parseInt(currentPage));
        } else {  
            pager.setStart(1);  
        }
        //创建页面页码索引
        pager=createPagerIndex(pager);
        return pager;  
    }
    
    public static Pager getPager(String currentpage,  
            int totalRows,int pageSize) {  
  
        // 定义pager对象，用于传到页面  
        Pager pager = new Pager(totalRows,pageSize);  
  
        // 从Request对象中获取当前页号  
        String currentPage = currentpage;  
  
        // 如果当前页号为空，表示为首次查询该页  
        // 如果不为空，则刷新pager对象，输入当前页号等信息  
        if (currentPage != null) {  
            pager.setStart(Integer.parseInt(currentPage));
        } else {  
            pager.setStart(1);  
        }
        //创建页面页码索引
        pager=createPagerIndex(pager);
        return pager;  
    }
    /**
     * 创建页面页码索引
     * @param pager	分页信息
     * @return
     */
    private static Pager createPagerIndex(Pager pager){
    	List<Integer> results=new ArrayList<Integer>();
    	int index=pager.getCurrentPage()/pager.getPageindexsize();
    	/*//如果是最后一页
    	if(pager.getCurrentPage()==pager.getTotalPages()){
    		for(int i=pager.getCurrentPage()-pager.getPageindexsize()+1;i<pager.getCurrentPage();i++){
    			results.add(i);
    		}
    	}*/
//    	if(pager.getCurrentPage()%pager.getPageindexsize()==0){
//    		//索引在两端的判断
//    		for(int i=0;i<pager.getPageindexsize();i++){
//    			if(i>pager.getTotalPages()){
//    				break;
//    			}
//    			results.add(pager.getCurrentPage()+i);
//    		}
//    	}else{
    		//索引在中间的情况
//    		for(int i=index*pager.getPageindexsize();i<(index+1)*pager.getPageindexsize();i++){
//    			if(i>pager.getTotalPages()){
//    				break;
//    			}
//    			results.add(i);
//    		}
    		if(pager.getCurrentPage()<=pager.getPageindexsize()/2){
    			for(int i=1;i<pager.getPageindexsize();i++){
    				if(i>pager.getTotalPages()){
    					break;
    				}
    				results.add(i);
    			}
    		}else if(pager.getCurrentPage()>=pager.getTotalPages()-pager.getPageindexsize()/2){
    			for(int i=pager.getTotalPages()-pager.getPageindexsize();i<=pager.getTotalPages();i++){
    				if(i<1){
    					continue;
    				}
    				results.add(i);
    			}
    		}else{
    			for(int i=pager.getCurrentPage()-pager.getPageindexsize()/2;i<pager.getCurrentPage()+pager.getPageindexsize()/2;i++){
    				if(i>pager.getTotalPages()){
    					break;
    				}
    				results.add(i);
    			}
    		}
//    	}
    	pager.setResults(results);
    	return pager;
    }
}  