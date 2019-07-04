package com.example.heroesapiforclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import StrictMode.StrictMod;
import heroesapi.HeroesAPI;
import model.Heroes;
import retrofit2.Call;
import retrofit2.Response;
import url.Url;

public class AddCommentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comments);

        addComments();
    }

    private void addComments()
    {
        HeroesAPI heroesAPI = Url.getInstance().create(HeroesAPI.class);

        Call<Heroes> listCall = heroesAPI.addComments(Url.Cookie,"5d0aeda5524f2c294c4b5e92",1,"mero comment");

        StrictMod.StrictMode();
        try {
            Response<Heroes> heroesResponse = listCall.execute();
            if(heroesResponse.body()!=null)
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Error " + heroesResponse.code(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
