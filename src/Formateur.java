public class Formateur extends Person{
    public Formateur (String firstname,String lastname,String email,String password){

        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setEmail(email);
        this.setPassword(password);

    }

    public void display(){
        System.out.println("firstname "+this.getFirstname());
        System.out.println("lastname "+this.getLastname());
        System.out.println("email "+this.getEmail());
        System.out.println("password "+this.getPassword());
    }

}
