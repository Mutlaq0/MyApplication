package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<User> items = new ArrayList<User>();
        items.add(new User("ss","05277421", "sess@gmail.com", "Ss"));
        items.add(new User("reck","Recky", "saaas@gmail.com", "Ss"));
        items.add(new User("jack","norris", "ssooos@gmail.com", "Ss"));
        //items.add();
        User u = new User( "John Doe","0525252","email@gmail.com","password");
/**
 *  Post The users
 */


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://localhost:8011/myFirstApp/")
                // when sending data in json format we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // and build our retrofit builder.
                .build();
        // create an instance for our retrofit api class.
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

          Call<User> call = retrofitAPI.createUser(u);

          call.enqueue(new Callback<User>() {
              @Override
              public void onResponse(Call<User> call, Response<User> response) {
                  Toast.makeText(MainActivity.this, "User has been created", Toast.LENGTH_SHORT).show();
              }

              @Override
              public void onFailure(Call<User> call, Throwable t) {
                  Toast.makeText(MainActivity.this, "Failure, Please Do something.", Toast.LENGTH_SHORT).show();

              }


          });
/**
 *

      Call<User> callUser = retrofitAPI.retrieveUserByEmail("gmail.com");
Log.d("standby",callUser.toString());
      callUser.enqueue(new Callback<User>() {

          @Override
          public void onResponse(Call<User> call, Response<User> response) {
              if(response.isSuccessful() && response.body() !=null){
                  User u = response.body();
                  ArrayList<String> toShow = new ArrayList<String>();

                  toShow.add(u.getFullName());
                  toShow.add(u.getPhoneNumber());
                  toShow.add(u.getEmail());
                  ArrayAdapter<List<String>> itemsAdapter =
                          new ArrayAdapter<List<String>>(MainActivity.this, android.R.layout.simple_list_item_1, Collections.singletonList(toShow));
                  ListView listView = (ListView) findViewById(R.id.listview);

                  listView.setAdapter(itemsAdapter);
              }


          }

          @Override
          public void onFailure(Call<User> call, Throwable t) {
              Toast.makeText(MainActivity.this, "----Failure, Please Do something.---", Toast.LENGTH_SHORT).show();

          }
      });


 */

    }
}