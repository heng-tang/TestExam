import Question.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class findByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId;
        Question res=null;
        QusetionDao dao = new QusetionDao();
        questionId = request.getParameter("questionId");
        res = dao.findById(questionId);
        request.setAttribute("findId",res);
        request.getRequestDispatcher("/question_findId.jsp").forward(request,response);
    }

}
