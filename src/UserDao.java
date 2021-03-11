import com.mysql.jdbc.PreparedStatement;
import util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
     private JdbcUtil util = new JdbcUtil();
     //用户注册
    public int add(Users users){  //为什么返回int, 0/1
          String sql = "insert into users(userName,passWord,sex,email)" +
                       "value(?,?,?,?)";
          int result=0;
        PreparedStatement ps = (PreparedStatement) util.createStatement(sql);
        try {
            ps.setString(1,users.getUserName());
            ps.setString(2,users.getPassWord());
            ps.setString(3,users.getSex());
            ps.setString(4,users.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
    public List find(){ //和mysql服务器通信查询用户信息，服务器返回查询到的集合
        List list = new ArrayList();
        String sql = "select * from users";
        PreparedStatement ps = (PreparedStatement) util.createStatement(sql); //和mysql需要jdbc规范接口
        ResultSet result = null;
        try {
            result = ps.executeQuery();  //query?
            while (result.next()){
                Integer userId = result.getInt("userId");
                String userName = result.getString("userName");
                String passWord = result.getString("passWord");
                String sex = result.getString("sex");
                String email = result.getString("email");
                Users users = new Users(userId,userName,passWord,sex,email);
                list.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(result);
        }
       return list;
    }
    public int delete(String userId){
        int result=0;
        String sql = "delete from users where userId=?";
        PreparedStatement ps = (PreparedStatement) util.createStatement(sql);
        try {
            ps.setInt(1,Integer.valueOf(userId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
       return result;
    }
    public int login(String userName,String passWord){
        ResultSet rs=null;
        int result=0;
        String sql = "select count(*) from users where userName=? and passWord=?";
        PreparedStatement ps = (PreparedStatement) util.createStatement(sql);
        try {
            ps.setString(1,userName);
            ps.setString(2,passWord);
            rs = ps.executeQuery();
            while (rs.next()){
                 result = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return result;
    }

}
