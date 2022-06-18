public class Painting extends Art {
    private String paintType;

    public Painting(String paintType, String title, String author, String description){
        super(title, author, description);
        this.paintType = paintType;
    }
    public void viewArt(){
        //String input = "";
        //input = "Tittle is: " + getTitle();
        //input = "Author is: " + getAuthor();
        //input = "Description: " + getDescription();
        System.out.println("Tittle is: " + getTitle());
        System.out.println("Author is: " + getAuthor());
        System.out.println("Description is: " + getDescription());

    }

    public String getPaintType(){
        return this.paintType;
    }
    public void setPaintType(String paintType){
        this.paintType = paintType;
    }
}
