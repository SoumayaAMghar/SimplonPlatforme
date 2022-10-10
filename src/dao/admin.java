package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class admin extends dao {

    public boolean addFormateur(String firstname, String lastname, String email, String password) throws SQLException {
        PreparedStatement preparedStatement = this.connect().prepareStatement("INSERT INTO users ( firstname, lastname, email, password,role) VALUES (?, ?, ?,?, 'formateur')");
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void DisplayFormateur() {
        try {
            PreparedStatement preparedStatement = this.connect().prepareStatement("select * from users where role = 'formateur'");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                System.out.println("formateur id is" + id + ", fullname : " + firstname + " " + lastname + "  email: " + email);
            }
        } catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }

    public boolean addApprenant(String firstname, String lastname, String email, String password) throws SQLException {


        PreparedStatement preparedStatement = this.connect().prepareStatement("INSERT INTO users ( firstname, lastname, email, password,role) VALUES (?, ?, ?,?, 'apprenant')");
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void DisplayApprenant() {
        try {
            PreparedStatement preparedStatement = this.connect().prepareStatement("select * from users where role = 'apprenant'");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                System.out.println("apprenant id is" + id + ", fullname : " + firstname + " " + lastname + "  email: " + email);
            }
        } catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }

    public void DisplayFormateurWithoutPromo() {
        try {
            PreparedStatement preparedStatement = this.connect().prepareStatement("select * from users where role = 'formateur' AND idPromotion IS NULL ");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                System.out.println("formateur id: " + id + "  fullname is: " + firstname + " " + lastname);
            }
        } catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }

    public void createPromotion(String name, int idFormateur, String[] listApprenant) {
        try {

            PreparedStatement preparedStatement = this.connect().prepareStatement("insert into promotions(name) values(?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);

            int affectedRows = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                updateFormateur(idFormateur, resultSet.getLong(1), listApprenant);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateFormateur(int idFormateur, long idPromotion, String[] listApprenant) {
        PreparedStatement ps;
        try {
            ps = this.connect().prepareStatement("UPDATE users SET idpromotion = ? WHERE iduser = ? ");
            ps.setInt(1, (int) idPromotion);
            ps.setInt(2, idFormateur);
            ps.addBatch();
            ps.executeBatch();

            for (int i = 0; i < listApprenant.length; i++) {
                ps.clearParameters();
                ps.setInt(1, (int) idPromotion);
                ps.setInt(2, Integer.parseInt(listApprenant[i]));
                ps.addBatch();
                ps.executeBatch();
            }

        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void ApprenantsWithoutPromotion() throws SQLException {
        PreparedStatement preparedStatement = this.connect().prepareStatement("select  * from users where role = 'apprenant' AND idpromotion IS NULL");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("idUser");
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            String email = resultSet.getString("email");
            System.out.println("apprenant id: " + id + "  fullname: " + firstname + " " + lastname);
        }


    }

    public void DisplayPromotion() {
        try {
            PreparedStatement preparedStatement = this.connect().prepareStatement("select * from promotions JOIN users ON users.idpromotion = promotions.idpromotion ");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idPromotion");
                String name = rs.getString("name");
                String formateurName = rs.getString("lastname");

                System.out.println("Promo id " + id + ", name : " + name + ", FormateurName : " + formateurName);
            }
        } catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }

}
