package booksmore.varun.com.booksmore.model.request;

import booksmore.varun.com.booksmore.model.User;

/**
 * Created by Varun on 4/5/2017.
 */

public class ServerRequest {
    private String operation;
    private User user;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
