<%--
  Created by IntelliJ IDEA.
  User: tangheng
  Date: 2020/11/16
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String val = (String) application.getAttribute("key");
//    String val1 = (String) session.getAttribute("key_");
%>
<html>
<%
   if(val == null){
%>
<font style="align-content: center;color: red;font-size: 40px">请先参加考试！</font><br/>
<%
    }else{
%>
<font style="align-content: center;color: red;font-size: 40px"><%=val%></font>
<%
    }
%>
</html>
