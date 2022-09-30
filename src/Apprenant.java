public class Apprenant extends Person{

    public Apprenant (String firstname,String lastname,String email,String password)
    {
        super(firstname, lastname, email, password);

    }


   public void display(){
       //System.out.println("id "+this.getFirstname());
       System.out.print("firstname: "+this.getFirstname());
       System.out.print(", lastname "+this.getLastname());
       System.out.print(", email "+this.getEmail());
       System.out.println(", password "+this.getPassword());
   }


}
