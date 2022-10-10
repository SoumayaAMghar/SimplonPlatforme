package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class apprenant extends dao {



    public void Displaybriefs(int idPromtion) throws SQLException {
        PreparedStatement preparedStatement = this.connect().prepareStatement("select  * from briefs where display = 1  AND idpromotion=?");
        preparedStatement.setInt(1,idPromtion);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("idbrief");
            String titre = resultSet.getString("titre");
            String description = resultSet.getString("description");
            System.out.println("apprenant id: " + id + "  fullname: " + titre + " " + description);
        }


    }
}
