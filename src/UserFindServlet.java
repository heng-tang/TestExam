import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           UserDao dao = new UserDao();
           PrintWriter out;
           List<Users> list = dao.find(); //第1步
           response.setContentType("text/html;charset=utf-8"); //2步
           out = response.getWriter(); //将用户信息结合标签命令写入响应包
           out.print("<table border='2' align='center'>");
           out.println("<tr>");
           out.println("<td>用户编号</td>");
           out.println("<td>用户名</td>");
           out.println("<td>密码</td>");
           out.println("<td>性别</td>");
           out.println("<td>邮箱</td>");
           out.println("<td>操作</td>");
           out.println("</tr>");
            for(Users user : list){
                out.println("<tr>");
                out.println("<td>"+ user.getUserId() +"</td>");
                out.println("<td>"+ user.getUserName() +"</td>");
                out.println("<td>*******</td>");
                out.println("<td>"+ user.getSex() +"</td>");
                out.println("<td>"+ user.getEmail() +"</td>");
                out.println("<td><a href='//localhost:8080/myweb/user/delete?userId="+user.getUserId()+"'>删除用户<a/></td>");
                out.println("</tr>");
            }
           out.print("</table>");
    }
}
