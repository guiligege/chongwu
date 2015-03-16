<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>  
  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>My JSP 'index.jsp' starting page</title>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!--  
    <link rel="stylesheet" type="text/css" href="styles.css">  
    -->  
      
  <script>  
	  /** 
	 * 分页操作对象 
	 */  
	var Pager = function(){  
	    return{  
	            setUrlParam: function(param)  
	            {  
	                //为翻页标签链接增加显示flag参数  
	                var obj=$(".pagerTarge > a");//获得分页标签下的所有<a>  
	                //alert(obj.length);  
	                if(obj!=null && obj.length>0)  
	                {  
	                    for(var i=0;i<obj.length;i++)  
	                    {  
	                        var tempUrl=$(obj[i]).attr('href');  
	                        //添加flag  
	                        $(obj[i]).attr('href',tempUrl+param);  
	                    }  
	                }  
	        }  
	    }  
	}(); 
	</script> 
  </head>  
    
  <body>  
  <div style="margin-left: 110px;">  
    <table>  
        <tr>  
            <th colspan="4" ><p style="font-family: sans-serif;font-size: 20px">测试分页</p></th>  
        </tr>  
        <tr>  
            <td width="80px">ID</td>  
            <td width="80px">Name</td>  
            <td width="80px">Age</td>  
            <td width="80px">Email</td>
            <td width="80px">time</td>   
        </tr>  
        <c:forEach var="store" items="${bList}" varStatus="index">
            <tr>  
                <td width="80px">${store.productName}</td>  
                <td width="80px">${store.goodsImage}</td>  
                <td width="80px">${store.price}</td>  
                <td width="80px">${store.zhekou}</td>
                <td width="80px">${store.createTime}</td>  
            </tr>  
        </c:forEach>  
    </table>  
   
  </div>  
        <jsp:include page="/views/commons/page.jsp"></jsp:include>  
  </body>
  <script>  
    Pager.setUrlParam("${urlParam}");  
</script>   
</html>  