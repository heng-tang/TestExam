<%--
  Created by IntelliJ IDEA.
  User: tangheng
  Date: 2020/11/16
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        String val = (String) request.getAttribute("key2");
    %>
   <html>
     <font style="align-content: center;color: red;font-size: 40px"><%=val%></font>
   </html>
