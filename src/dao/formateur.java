package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class formateur extends dao{
    public  boolean login(String email, String password) throws SQLException {
        boolean flag = false;
        PreparedStatement preparedStatement = this.connect().prepareStatement("select * from users where role = 'formateur' AND email LIKE ? ");
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            if (password.equals(resultSet.getString("password"))){
                return flag= true;
            }
        }

        return flag;
    }


}
