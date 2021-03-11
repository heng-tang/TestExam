<%@ page import="Question.Question" %><%--
  Created by IntelliJ IDEA.
  User: tangheng
  Date: 2020/11/16
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%--%>
<%--     Question question = (Question)request.getAttribute("findId");--%>
<%--%>--%>
<center>
    <form action="/myweb/update">
        <table border="2" >
            <tr style="font-size: 20px">
                <td>题目编号：</td>
                <td><input type="text" name="questionId" value="${requestScope.findId.questionId}" readonly class="put1"/></td>
            </tr>
            <tr style="font-size: 20px">
                <td>题目：</td>
                <td><input type="text" name="tittle" value="${requestScope.findId.tittle}" class="put1"/></td>
            </tr>
            <tr>
                <td>A：</td>
                <td><input type="text" name="optionA" value="${requestScope.findId.optionA}" class="put1"/></td>
            </tr>
            <tr>
                <td>B：</td>
                <td><input type="text" name="optionB" value="${requestScope.findId.optionB}" class="put1"/></td>
            </tr>
            <tr>
                <td>C：</td>
                <td><input type="text" name="optionC" value="${requestScope.findId.optionC}" class="put1"/></td>
            </tr>
            <tr>
                <td>D：</td>
                <td><input type="text" name="optionD" value="${requestScope.findId.optionD}" class="put1"/></td>
            </tr>
            <tr>
                <td>正确答案：</td>
                <td><input type="radio" name="answer" value="A" ${requestScope.findId.answer=="A"?"checked":""} />A
                    <input type="radio" name="answer" value="B" ${requestScope.findId.answer=="B"?"checked":""} />B
                    <input type="radio" name="answer" value="C" ${requestScope.findId.answer=="C"?"checked":""} />C
                    <input type="radio" name="answer" value="D" ${requestScope.findId.answer=="D"?"checked":""} />D </td>
            </tr>
            <tr>
                <td><input type="submit" value="更新试题" class="put1"/></td>
                <td><input type="reset" class="put1"/></td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
