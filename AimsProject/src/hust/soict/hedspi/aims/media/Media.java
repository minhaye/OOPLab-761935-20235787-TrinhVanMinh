package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id2, String title2, String category2, float cost2) {
        this.id = id2;
        this.title = title2;
        this.category = category2;
        this.cost = cost2;
    }
    public Media() {
        
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
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
    public String toString() {
        return this.getTitle() + " - " + this.getCategory() + ": " + this.getCost() + "$";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return this.getTitle().equals(media.getTitle());
        //return this.getTitle().equals(media.getTitle())&& this.getCategory().equals(media.getCategory()) && this.getCost() == media.getCost() && this.getId() == media.getId();
    }
}
