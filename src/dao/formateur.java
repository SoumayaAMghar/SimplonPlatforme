package dao;

import org.checkerframework.checker.units.qual.C;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import email.SendingEmail;


public class formateur extends dao {



    public void addapprenant(String[] apprenants, int idPromotion) throws SQLException {
        PreparedStatement preparedStatement = this.connect().prepareStatement("update users set idpromotion = ? where role = 'apprenant' AND iduser=?");

        for (int i = 0; i < apprenants.length; i++) {
            preparedStatement.clearParameters();
            preparedStatement.setInt(1, (int) idPromotion);
            preparedStatement.setInt(2, Integer.parseInt(apprenants[i]));
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        }
    }
    public boolean addbrief(String titre, String description, int idpromotion) throws SQLException {
        PreparedStatement preparedStatement = this.connect().prepareStatement("insert into briefs (titre, description,idpromotion, display ) values (?,?,?,0)");
        preparedStatement.setString(1,titre);
        preparedStatement.setString(2,description);
        preparedStatement.setInt(3,idpromotion);
        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean UpdatebriefDislpay(int idBrief){

        try {

            PreparedStatement preparedStatement = this.connect().prepareStatement("UPDATE briefs SET display =1 WHERE idbrief = ? ");

            preparedStatement.setInt(1, idBrief);



            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return true;
            } else {
                return false;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void Displaybriefs(int idPromtion) throws SQLException {
        PreparedStatement preparedStatement = this.connect().prepareStatement("select  * from briefs where display = 0  AND idpromotion=?");
        preparedStatement.setInt(1,idPromtion);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("idbrief");
            String titre = resultSet.getString("titre");
            String description = resultSet.getString("description");
            System.out.println("apprenant id: " + id + "  fullname: " + titre + " " + description);
        }


    }
    public void sendemail(int idBrief , int idPromtion) throws SQLException {

        PreparedStatement preparedStatement = this.connect().prepareStatement("select * from users JOIN briefs ON users.idpromotion =? AND briefs.idbrief=? ");
        preparedStatement.setInt(1,idPromtion);
        preparedStatement.setInt(2,idBrief);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            String email = resultSet.getString("email");
            String titre = resultSet.getString("titre");
            SendingEmail.send(email,firstname,lastname,titre);
        }

    }

}
