package booksmore.varun.com.booksmore.model.response;

import booksmore.varun.com.booksmore.model.User;

/**
 * Created by Varun on 4/5/2017.
 */

public class ServerResponse {
    private String result;
    private String message;
    private User user;

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
