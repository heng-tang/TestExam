<%@ page import="java.util.List" %>
<%@ page import="Question.Question" %><%--
  Created by IntelliJ IDEA.
  User: tangheng
  Date: 2020/11/17
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="/myweb/exam_find">
    <table border="2" style="font-size: 30px">
        <tr align="center">
            <td>用户编号</td>
            <td>题目信息</td>
            <td>A:</td>
            <td>B:</td>
            <td>C:</td>
            <td>D:</td>
            <td>正确答案</td>
<%--            <td colspan="2">操作</td>--%>
        </tr>
        <%
            List<Question> list = (List) application.getAttribute("key");
            for(int i=0;i<list.size();i++){
        %>
        <tr>
            <td><%=list.get(i).getQuestionId()%></td>
            <td><%=list.get(i).getTittle()%></td>
            <td><%=list.get(i).getOptionA()%></td>
            <td><%=list.get(i).getOptionB()%></td>
            <td><%=list.get(i).getOptionC()%></td>
            <td><%=list.get(i).getOptionD()%></td>

            <td>
                <input type="radio" name="answer_<%=list.get(i).getQuestionId()%>" value="A"  />A
                <input type="radio" name="answer_<%=list.get(i).getQuestionId()%>" value="B"  />B
                <input type="radio" name="answer_<%=list.get(i).getQuestionId()%>" value="C"  />C
                <input type="radio" name="answer_<%=list.get(i).getQuestionId()%>" value="D"  />D
            </td>
        </tr>
        <%
            }
        %>
        <tr align="center">
            <td colspan="3"><input type="submit" value="提交" /></td>
            <td colspan="4"><input type="reset" /></td>
        </tr>
    </table>
    </form>
</center>
</body>
</html>
