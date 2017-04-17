package booksmore.varun.com.booksmore;

import booksmore.varun.com.booksmore.model.request.ServerRequest;
import booksmore.varun.com.booksmore.model.response.ServerResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Varun on 4/5/2017.
 */

public interface RequestInterface {

    @POST("android/")
    Call<ServerResponse> operation(@Body ServerRequest request);
}
