package org.guili.ecshop.util.common.page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * 标签类 用于分页查询 
 * 
 */  
public class PageTag{
    /**   
    *    
    */  
    private static final long serialVersionUID = 1L;  
  
    public void getPageInfo(HttpServletRequest req,HttpServletResponse response,Pager pager) {  
        ////标签开始时调用的方法  
        try {
            PrintWriter out = response.getWriter(); 
            if(pager==null){
                out.print("没有记录");  
                out.flush();  
            }
            out.print("第 " + pager.getCurrentPage() + " 页/共 "  
                    + (pager.getTotalPages()) + " 页");  
  
            if (pager.getCurrentPage() == 1) {  
                out.print("[最首页]");  
                out.print("[上一页]");  
            }  
            if (pager.getCurrentPage() != 1) {  
                out.print("[<a href='" + pager.getLinkUrl()  
                        + "?cpage=1'>最首页</a>]");  
                out.print("[<a href='" + pager.getLinkUrl() + "?cpage="  
                        + (pager.getCurrentPage() - 1) + "'>上一页</a>]");  
            }  
  
            for (int i = pager.getCurrentPage() - 3; i <= pager  
                    .getCurrentPage() + 3; i++) {  
                if (i <= 0 || i > pager.getTotalPages()) {  
                    continue;  
                }  
                if (i == pager.getCurrentPage()) {  
                    out  
                            .print("[<span style='color:#FF0000; border: 1px solid #cccccc; font-weight:bold; width:15px;text-align: center;'> "  
                                    + i + " </span>]");  
                } else {  
                    out.print("[<a href='" + pager.getLinkUrl() + "?cpage="  
                            + i + "'> " + i + " </a>]");  
                }  
            }  
            if (pager.getCurrentPage() == pager.getTotalPages()  
                    || pager.getTotalPages() == 0) {  
                out.print("[下一页]");  
                out.print("[最末页]");  
  
            }  
            if (pager.getCurrentPage() != pager.getTotalPages()  
                    && pager.getTotalPages() != 0) {  
                out.print("[<a href='" + pager.getLinkUrl() + "?cpage="  
                        + (pager.getCurrentPage() + 1) + "'>下一页</a>]");  
                out.print("[<a href='" + pager.getLinkUrl() + "?cpage="  
                        + (pager.getTotalPages()) + "'>最末页</a>]");  
            }
            out.flush();  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
    }  
}