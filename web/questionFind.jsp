<%--
  Created by IntelliJ IDEA.
  User: tangheng
  Date: 2020/11/16
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Question.Question" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <table border="2" style="font-size: 30px">
        <tr align="center">
            <td>用户编号</td>
            <td>题目信息</td>
            <td>A:</td>
            <td>B:</td>
            <td>C:</td>
            <td>D:</td>
            <td>正确答案</td>
            <td colspan="2">操作</td>
        </tr>
        <%
            List<Question> list = (List) request.getAttribute("key");
            for(int i=0;i<list.size();i++){
        %>
        <tr>
            <td><%=list.get(i).getQuestionId()%></td>
            <td><%=list.get(i).getTittle()%></td>
            <td><%=list.get(i).getOptionA()%></td>
            <td><%=list.get(i).getOptionB()%></td>
            <td><%=list.get(i).getOptionC()%></td>
            <td><%=list.get(i).getOptionD()%></td>
            <td><%=list.get(i).getAnswer()%></td>
            <td><a href="/myweb/question/delete?questionId=<%=list.get(i).getQuestionId()%>">删除试题</a></td>
            <td><a href="/myweb/question/findById?questionId=<%=list.get(i).getQuestionId()%>">详细信息</a></td>
        </tr>
        <%
            }
        %>
    </table>
</center>
</body>
</html>
