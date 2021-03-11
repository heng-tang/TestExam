import Question.Question;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class examServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(false);
          ServletContext application =  request.getServletContext(); //application也可以
         QusetionDao dao = new QusetionDao();
        List<Question> list = dao.exam_find();
//        session.setAttribute("key",list);
         application.setAttribute("key",list);
        request.getRequestDispatcher("/exam.jsp").forward(request,response);
    }
}
