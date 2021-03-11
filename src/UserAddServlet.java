import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String userName,passWord,sex,email;
           UserDao dao = new UserDao();
           int result=0;
           Users users=null;
           PrintWriter out = null;
           //第一步
            userName= request.getParameter("userName");
            passWord = request.getParameter("passWord");
            sex = request.getParameter("sex");
            email = request.getParameter("email");
           //第二步
           users = new Users(null,userName,passWord,sex,email);
           result = dao.add(users);
           //第三步
            response.setContentType("text/html;charset=utf-8");
            out = response.getWriter();  //拿到输出流之前一定要设置好格式
//            response.setContentType("text/html;charset=utf-8");
            if(result==1){
                 out.println("<font style='color:red;font-size:30'>用户注册成功</font>");
            }else {
                out.println("<font style='color:red;font-size:30'>用户注册失败</font>");
            }
    }
}
