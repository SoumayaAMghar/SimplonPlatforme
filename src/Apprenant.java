public class Apprenant extends Person{

 public String firstname;
 public String lastname;
 public String email;
 public String password;

    public Apprenant (String firstname,String lastname,String email,String password){
        super( firstname, lastname, email, password);
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.password=password;
    }

   public void display(){
       System.out.println("name "+this.firstname);
       System.out.println("email "+this.email);
   }
}
