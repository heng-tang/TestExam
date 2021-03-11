import Question.Question;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class exam_FindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //直接从私人储物柜中取出答得4道题
//        HttpSession session = request.getSession(false);
        ServletContext application =  request.getServletContext();
        List<Question> list = (List) application.getAttribute("key");
        int score=0;
        Integer questionId;
        String answer,exam_answer;

        for(Question question:list){
            questionId = question.getQuestionId();
            answer = question.getAnswer();
            exam_answer = request.getParameter("answer_"+questionId);
            if(answer.equals(exam_answer)){  //字符串能用==吗
                score+=25;
            }
        }
        application.setAttribute("key","你的考试成绩是："+score);
        request.getRequestDispatcher("/question_update.jsp").forward(request,response);
    }
}
