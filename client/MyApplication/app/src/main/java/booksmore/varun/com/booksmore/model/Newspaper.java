package booksmore.varun.com.booksmore.model;

/**
 * Created by Varun on 4/18/2017.
 */

public class Newspaper {
    private String title,price;
    private int imageID;

    public Newspaper(String title, String price, int imageID) {
        this.title = title;
        this.price = price;
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
