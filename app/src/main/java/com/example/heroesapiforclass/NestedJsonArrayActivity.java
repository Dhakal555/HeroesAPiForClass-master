package com.example.heroesapiforclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import heroesapi.HeroesAPI;
import model.Comments;
import model.LoginSignupResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class NestedJsonArrayActivity extends AppCompatActivity {

    private TextView textView;
    private  String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_json_array);

        textView = findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            id = bundle.getString("id");
        }

        Toast.makeText(this, "Id : " + id, Toast.LENGTH_SHORT).show();
        loadNestedArray();
    }

    private void loadNestedArray()
    {
        HeroesAPI heroesAPI = Url.getInstance().create(HeroesAPI.class);

        Call<List<Comments>> call = heroesAPI.getComments(Url.Cookie,id);

        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(NestedJsonArrayActivity.this, "Server says : " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Comments> comment = response.body();

                for(Comments comments : comment)
                {
                    String str="";
                    str += "Rating : " + comments.getRating() + "\n";
                    str += "comments : " + comments.getComment() + "\n";

                    textView.append(str);
                }
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                Toast.makeText(NestedJsonArrayActivity.this, "Failed" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}