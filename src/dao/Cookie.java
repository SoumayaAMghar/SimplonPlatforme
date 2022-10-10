package dao;

public class Cookie {

    private static String firstname;
    private static String lastname;
    private static String email ;
    private static String password;
    private static String role;
    private static int idPromtion;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        Cookie.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        Cookie.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Cookie.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Cookie.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        Cookie.role = role;
    }

    public int getIdPromtion() {
        return idPromtion;
    }

    public void setIdPromtion(int idPromtion) {
        Cookie.idPromtion = idPromtion;
    }
}
