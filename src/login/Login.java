package login;

import dao.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends dao {
    public static Cookie cookie= new Cookie();
    public static boolean login(String email, String password,String role) throws SQLException {

        PreparedStatement preparedStatement = connect().prepareStatement("select * from users where role = ? AND email LIKE ? ");
        preparedStatement.setString(1, role);
        preparedStatement.setString(2, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            if (password.equals(resultSet.getString("password"))) {
                cookie.setFirstname(resultSet.getString("firstname"));
                cookie.setLastname(resultSet.getString("lastname"));
                cookie.setEmail(resultSet.getString("email"));
                cookie.setPassword(resultSet.getString("password"));
                cookie.setRole(resultSet.getString("role"));
                cookie.setIdPromtion(resultSet.getInt("idPromotion"));
                return true;
            }
        }

        return false;
    }
}
