import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String userId;
         int res=0;
        PrintWriter out=null;
         UserDao dao = new UserDao();
          //1调用请求对象读取请求头的参数
          userId =request.getParameter("userId");
          //2调用Dao将用户填充到delete命令并发送到数据库服务器
           res = dao.delete(userId);
          //3 将处理结果写入响应体，给浏览器
          response.setContentType("text/html;charset=utf-8");
          out = response.getWriter();
          if(res == 1){
               out.print("<font style='color:red;font-size:30'>用户删除成功</font>");
          }else {
               out.print("<font style='color:red;font-size:30'>用户删除失败</font>");
          }
    }
}
