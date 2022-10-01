public class Brief {

    private String title;
    private String description;

    public Brief(String title, String description) {
        this.title = title;
        this.description = description;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Brief{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}