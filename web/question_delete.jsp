<%--
  Created by IntelliJ IDEA.
  User: tangheng
  Date: 2020/11/16
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String res = (String) request.getAttribute("delete");
%>
     <center>
         <font style="color: red;font-size: 35px"><%=res%></font>
     </center>
</body>
</html>
