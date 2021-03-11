import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,passsWord;
        int result=0;
        PrintWriter out=null;
        UserDao dao = new UserDao();

        request.setCharacterEncoding("utf-8");
        userName =request.getParameter("userName");
        passsWord = request.getParameter("passWord");
        result = dao.login(userName,passsWord);
//        out = response.getWriter();
        if(result>0){
            HttpSession session = request.getSession();  //合法进入后给一个session
            response.sendRedirect("/myweb/index.html");
        }else {
            response.sendRedirect("/myweb/login_error.html");
        }
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
