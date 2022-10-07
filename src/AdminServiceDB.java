//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class AdminServiceDB {
//    protected static final Scanner scanner = new Scanner(System.in);
//    static Connection con = connectDB.connect();
//
//    public static boolean CreateFormateur() throws SQLException {
//        System.out.println("Entrer le prenom du formateur");
//        String firstname = scanner.next();
//        System.out.println("Entrer le nom du formateur");
//        String lastname = scanner.next();
//        System.out.println("Entrer l'email du formateur");
//        String email = scanner.next();
//        System.out.println("Entrer le password du formateur");
//        String password = scanner.next();
//        //getFormateurs().add( new Formateur(firstname, lastname, email,password) );
//
//        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO users ( firstname, lastname, email, password,role) VALUES (?, ?, ?,?, 'formateur')");
//        preparedStatement.setString(1, firstname);
//        preparedStatement.setString(2, lastname);
//        preparedStatement.setString(3, email);
//        preparedStatement.setString(4, password);
//        int affectedRows = preparedStatement.executeUpdate();
//        if (affectedRows > 0) {
//            return true;
//        }else{
//            return false;
//        }
//
//    }
//
//    public static void DisplayFormateur(){
//        try {
//            PreparedStatement preparedStatement = con.prepareStatement("select * from users where role = 'formateur'");
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("idUser");
//                String firstname = rs.getString("firstname");
//                String lastname = rs.getString("lastname");
//                String email = rs.getString("email");
//                System.out.println("formateur id is"+id + ", fullname : " + firstname + " "+ lastname + "  email: " + email );
//            }
//        }catch (SQLException e) {
//            System.out.println("Error in Login Function");
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static boolean addApprenant() throws SQLException {
//
//
//        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO users ( firstname, lastname, email, password,role) VALUES (?, ?, ?,?, 'apprenant')");
//        preparedStatement.setString(1, firstname);
//        preparedStatement.setString(2, lastname);
//        preparedStatement.setString(3, email);
//        preparedStatement.setString(4, password);
//        int affectedRows = preparedStatement.executeUpdate();
//        if (affectedRows > 0) {
//            return true;
//        }else{
//            return false;
//        }
//    }
//    public static void DisplayApprenant(){
//        try {
//            PreparedStatement preparedStatement = con.prepareStatement("select * from users where role = 'apprenant'");
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("idUser");
//                String firstname = rs.getString("firstname");
//                String lastname = rs.getString("lastname");
//                String email = rs.getString("email");
//                System.out.println("apprenant id is"+id + ", fullname : " + firstname + " "+ lastname + "  email: " + email );
//            }
//        }catch (SQLException e) {
//            System.out.println("Error in Login Function");
//            throw new RuntimeException(e);
//        }
//    }
//    public static void createPromotion(){
//        System.out.println("Entrer le nom de la promotion");
//        String promoName = scanner.next();
//        DisplayFormateur();
//
//
//        //DisplayApprenant();
//
//        System.out.println("Veuillez choisir l'id du formateur que vous voulez ");
//        String formateurDuPromo = scanner.next();
//
//        //DisplayPromotion();
//    }
//
//}
