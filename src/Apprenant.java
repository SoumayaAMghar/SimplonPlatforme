public class Apprenant extends Person{

    private boolean available = false;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Apprenant (boolean available , String firstname, String lastname, String email, String password)
    {
        super(firstname, lastname, email, password);
        this.setAvailable(true);
    }

}
