public class Person {
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    Person(String firstname, String lastname, String email, String password){
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setEmail(email);
        this.setPassword(password);
    }
    public void AfficherPerson(String firstname, String lastname, String email, String password){
        this.getFirstname();
        this.getLastname();
        this.getEmail();
        this.getPassword();
       // system.out.println(objperson(firstname,lastname,email,password));
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
