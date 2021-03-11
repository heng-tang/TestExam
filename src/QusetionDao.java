import Question.Question;
import com.mysql.jdbc.PreparedStatement;
import util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QusetionDao {
    private JdbcUtil util = new JdbcUtil();
    public int add(Question question1){
        int res=0;
        String sql = "insert into question(tittle,optionA,optionB,optionC,optionD,answer)" +
                "value(?,?,?,?,?,?)";
        PreparedStatement ps = (PreparedStatement) util.createStatement(sql);
        try {
//            ps.setString(1,question.getQuestionId());
            ps.setString(1,question1.getTittle());
            ps.setString(2,question1.getOptionA());
            ps.setString(3,question1.getOptionB());
            ps.setString(4,question1.getOptionC());
            ps.setString(5,question1.getOptionD());
            ps.setString(6,question1.getAnswer());
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return res;
    }
    public  List<Question>  find(){
        Integer questionId;
        String tittle,optionA,optionB,optionC,optionD,answer;
        ResultSet result=null;
        String sql = "select *from question";
        PreparedStatement ps = (PreparedStatement) util.createStatement(sql);
        List<Question> list = new ArrayList<>();
        try {
            result = ps.executeQuery();
            while (result.next()){
                questionId = result.getInt("questionId");
                tittle = result.getString("tittle");
                optionA = result.getString("optionA");
                optionB = result.getString("optionB");
                optionC = result.getString("optionC");
                optionD = result.getString("optionD");
                answer = result.getString("answer");
                Question question = new Question(questionId,tittle,optionA,optionB,optionC,optionD,answer);
                list.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return list;
    }

    public int delete(String questionId){
         String sql = "delete from question where questionId=?";
         int res=0;
         PreparedStatement ps = (PreparedStatement) util.createStatement(sql);
        try {
            ps.setInt(1, Integer.valueOf(questionId)); //传入int
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return res;
    }

    public Question findById(String questionId){
        ResultSet question=null;
        Question question1=null;
        String sql = "select * from question where questionId=?";
        PreparedStatement ps = (PreparedStatement) util.createStatement(sql);
        try {
            ps.setInt(1, Integer.valueOf(questionId));
            question = ps.executeQuery();
            while (question.next()){
                Integer questionId1 = question.getInt("questionId");
                String tittle = question.getString("tittle");
                String optionA = question.getString("optionA");
                String optionB = question.getString("optionB");
                String optionC = question.getString("optionC");
                String optionD = question.getString("optionD");
                String answer = question.getString("answer");
                question1 = new Question(questionId1,tittle,optionA,optionB,optionC,optionD,answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return question1;
    }
    public int update(Question question){
        int res=0;
        String sql = "update question set tittle=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionId=?";
        PreparedStatement ps = (PreparedStatement) util.createStatement(sql);
        try {
            ps.setString(1,question.getTittle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            ps.setInt(7,question.getQuestionId());
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return res;
    }

    public List<Question> exam_find(){
        Integer questionId;
        String tittle,optionA,optionB,optionC,optionD,answer;
        ResultSet result=null;
        String sql = "select * from question order by rand() limit 0,4";
        PreparedStatement ps = (PreparedStatement) util.createStatement(sql);
        List<Question> list = new ArrayList<>();
        try {
            result = ps.executeQuery();
            while (result.next()){
                questionId = result.getInt("questionId");
                tittle = result.getString("tittle");
                optionA = result.getString("optionA");
                optionB = result.getString("optionB");
                optionC = result.getString("optionC");
                optionD = result.getString("optionD");
                answer = result.getString("answer");
                Question question = new Question(questionId,tittle,optionA,optionB,optionC,optionD,answer);
                list.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return list;
    }

}
