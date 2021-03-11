import Question.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class questionUpdateServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tittle,optionA,optionB,optionC,optionD,answer;
        String questionId;
        int result=0;
        QusetionDao dao = new QusetionDao();
        tittle = request.getParameter("tittle");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");
        questionId = request.getParameter("questionId");
        Question question = new Question(Integer.valueOf(questionId),tittle,optionA,optionB,optionC,optionD,answer);
        result = dao.update(question);
        if(result == 1){
            request.setAttribute("key","更新试题成功");
        }else {
            request.setAttribute("key","更新试题失败");
        }
        request.getRequestDispatcher("/myweb/question_update.jsp").forward(request,response);
    }
}
