package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import java.util.Objects;

import hust.soict.hedspi.aims.exception.InvalidMediaException;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        setId(id);
        setTitle(title);
        setCategory(category);
        setCost(cost);
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
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidMediaException("Media title must not be empty.");
        }
        this.title = title;
    }
    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new InvalidMediaException("Media category must not be empty.");
        }
        this.category = category;
    }
    public void setCost(float cost) {
        if (cost < 0) {
            throw new InvalidMediaException("Media cost must be non-negative.");
        }
        this.cost = cost;
    }
    public void setId(int id) {
        if (id <= 0) {
            throw new InvalidMediaException("Media id must be positive.");
        }
        this.id = id;
    }
    public String toString() {
        return this.getTitle() + " - " + this.getCategory() + ": " + this.getCost() + "$";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        Media media = (Media) o;
        return Objects.equals(this.getTitle(), media.getTitle())
                && Float.compare(this.getCost(), media.getCost()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, cost);
    }

    @Override
    public int compareTo(Media media) {
        if (media == null) return 1;

        int titleCompare = this.getTitle().compareTo(media.getTitle());
        if (titleCompare != 0) return titleCompare;

        return Float.compare(this.getCost(), media.getCost());
    }
}
