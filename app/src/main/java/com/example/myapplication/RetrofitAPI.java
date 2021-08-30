package com.example.myapplication;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.GET;
        import retrofit2.http.POST;
        import retrofit2.http.Path;

public interface RetrofitAPI {


    // post
    @POST("/createUser")
    //creating a method to post our data.
    Call<User> createUser(@Body User user);

    @GET("/api/user/{id}")
    Call<User> getUserById(@Path("id") int id);

    @GET("/findUser/{email}")
    Call<User> retrieveUserByEmail(@Path("email") String email);

    @GET("/api/user")
    Call<List<User>> getAllUsers();

}
