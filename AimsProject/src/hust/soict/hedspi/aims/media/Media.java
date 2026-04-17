package hust.soict.hedspi.aims.media;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    public Media(int id2, String title2, String category2, float cost2) {
        this.id = id2;
        this.title = title2;
        this.category = category2;
        this.cost = cost2;
    }
    public Media() {
        //TODO Auto-generated constructor stub
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public void setId(int id) {
        this.id = id;
    }

}
