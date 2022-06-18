public class Sculpture extends Art{
    private String material;

    public Sculpture(String material, String title, String author, String description){
        super(title, author, description);
        this.material = material;
    }
    public void viewArt() {
        System.out.println("Tittle is: " + getTitle());
        System.out.println("Author is: " + getAuthor());
        System.out.println("Description is: " + getDescription());
        System.out.println("Material is: " + getMaterial());
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
