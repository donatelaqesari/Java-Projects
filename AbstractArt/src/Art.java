import com.sun.org.apache.xml.internal.utils.XMLStringDefault;

public abstract class Art {
    private String title;
    private String author;
    private String description;

    public Art(String title, String author, String description){
        this.title = title;
        this.author = author;
        this.description = description;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    //an abstract method called
    public abstract void viewArt();
}
