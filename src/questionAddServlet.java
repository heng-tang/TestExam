import Question.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class questionAddServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              String tittle,optionA,optionB,optionC,optionD,answer;
              int result=0;
                tittle = request.getParameter("tittle");
              optionA = request.getParameter("optionA");
             optionB = request.getParameter("optionB");
            optionC = request.getParameter("optionC");
            optionD = request.getParameter("optionD");
            answer = request.getParameter("answer");
            Question question1 = new Question(null,tittle,optionA,optionB,optionC,optionD,answer);
            QusetionDao dao = new QusetionDao();
             result = dao.add(question1);
            if(result == 1){
                request.setAttribute("key2","添加试题成功");
            }else {
                request.setAttribute("key2","添加试题失败");
            }
            request.getRequestDispatcher("/question_add.jsp").forward(request,response);
    }

}
