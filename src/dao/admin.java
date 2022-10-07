package dao;


import java.sql.*;

public class admin extends dao {

    public boolean addFormateur(String firstname, String lastname, String email, String password) throws SQLException {
        PreparedStatement preparedStatement = this.con.prepareStatement("INSERT INTO users ( firstname, lastname, email, password,role) VALUES (?, ?, ?,?, 'formateur')");
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows > 0) {
            return true;
        }else{
            return false;
        }
    }
    public void DisplayFormateur(){
        try {
            PreparedStatement preparedStatement = this.con.prepareStatement("select * from users where role = 'formateur'");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                System.out.println("formateur id is"+id + ", fullname : " + firstname + " "+ lastname + "  email: " + email );
            }
        }catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }
    public  boolean addApprenant(String firstname, String lastname, String email, String password) throws SQLException {


        PreparedStatement preparedStatement = this.con.prepareStatement("INSERT INTO users ( firstname, lastname, email, password,role) VALUES (?, ?, ?,?, 'apprenant')");
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows > 0) {
            return true;
        }else{
            return false;
        }
    }
    public void DisplayApprenant(){
        try {
            PreparedStatement preparedStatement = this.con.prepareStatement("select * from users where role = 'apprenant'");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                System.out.println("apprenant id is"+id + ", fullname : " + firstname + " "+ lastname + "  email: " + email );
            }
        }catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }
    public void DisplayFormateurWithoutPromo(){
        try {
            PreparedStatement preparedStatement = this.con.prepareStatement("select * from users where role = 'formateur' && idPromotion IS NULL ");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                System.out.println("formateur id is"+id + "  fullname is: " + firstname + " "+ lastname);
            }
        }catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }
    public void createPromotion(String name, int idFormateur){
        try {
            PreparedStatement preparedStatement = this.con.prepareStatement("insert into promotions(name) values(?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);

                ResultSet resultSet = preparedStatement.getGeneratedKeys();
            System.out.println(resultSet.getInt("id"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
