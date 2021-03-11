import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class questionDeleteServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String questionId;
           int res=0;
           QusetionDao dao = new QusetionDao();
           questionId = request.getParameter("questionId");
           res = dao.delete(questionId);
           if(res == 1){
                request.setAttribute("delete","试卷信息删除成功");
           }else {
               request.setAttribute("delete","试卷信息删除失败");
           }
           request.getRequestDispatcher("/question_delete.jsp").forward(request,response);
    }
}
