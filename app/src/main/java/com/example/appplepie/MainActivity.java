package com.example.appplepie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appplepie.model.Article;
import com.example.appplepie.model.MultipleArticles;
import com.example.appplepie.utils.NetworkHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);

     NetworkHelper.getInstance()
             .getAriticles().enqueue(new Callback<MultipleArticles>() {
         @Override
         public void onResponse(Call<MultipleArticles> call, Response<MultipleArticles> response) {
             if(response.isSuccessful()){

                 MultipleArticles multipleArticles = response.body();
                 Toast.makeText(getApplicationContext(),
                         ""+multipleArticles.getArticlesCount(),Toast.LENGTH_SHORT).show();
                 CustomAdapter mAdapter = new CustomAdapter(multipleArticles.getArticles());
                 listView.setAdapter(mAdapter);





             }
             else{
                 Toast.makeText(MainActivity.this, ""+response.message(),Toast.LENGTH_SHORT).show();
             }
         }




         @Override
         public void onFailure(Call<MultipleArticles> call, Throwable t) {
                t.printStackTrace();
             Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();

         }
     });


    }
}
