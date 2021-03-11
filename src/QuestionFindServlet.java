import Question.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         QusetionDao dao = new QusetionDao();
//        Integer questionId;
         List<Question> list = dao.find(); //list中是n个ques对象
         request.setAttribute("key",list);

         request.getRequestDispatcher("/questionFind.jsp").forward(request,response);
    }
}
