package booksmore.varun.com.booksmore.fragment.dummy;

/**
 * Created by Varun on 4/17/2017.
 */

public class Data {
    public final String id;
    public String title;
    public String description;
    public int imageId;

    public Data(String id, String title, String description, int imageId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageId = imageId;
    }
}