import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
           HttpServletRequest request = (HttpServletRequest) servletRequest; //向下转型
           HttpServletResponse response = (HttpServletResponse) servletResponse;
           HttpSession session = request.getSession(false);
           String uri = request.getRequestURI(); //url完整的资源路径，uri部分资源名
           if(uri.indexOf("login") != -1 || "/myweb/".equals(uri)){
               filterChain.doFilter(servletRequest,servletResponse);
               return;
           }
           if(session == null){ //拒绝访问
                response.sendRedirect("login_error.html"); //这里也可以请求重发
                return;
           }else {
                filterChain.doFilter(servletRequest,servletResponse);
           }
    }

}
