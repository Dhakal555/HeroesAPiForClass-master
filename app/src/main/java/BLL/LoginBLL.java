package BLL;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import com.example.heroesapiforclass.LoginActivity;
import com.example.heroesapiforclass.MainActivity;

import java.io.IOException;

import heroesapi.HeroesAPI;
import model.ImageResponse;
import model.LoginSignupResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class LoginBLL {
    private String username;
    private String password;
    //Context context;
    boolean isSuccess = false;

    Context context;

    public LoginBLL(){

        super();
    }
    public LoginBLL(Context context)
    {
        this.context=context;
    }
    public LoginBLL(Context context , String username, String password) {
        //this.context = context;
        this.username = username;
        this.password = password;
        this.context = context;
    }


    //Async method




    public boolean checkUser(String _username,String _password) {

        HeroesAPI heroesAPI = Url.getInstance().create(HeroesAPI.class);
        Call<LoginSignupResponse> usersCall = heroesAPI.checkUser(_username, _password);
        usersCall.enqueue(new Callback<LoginSignupResponse>() {

            @Override
            public void onResponse(Call<LoginSignupResponse> call, Response<LoginSignupResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, " Either username or password is incorrect", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (response.body().getSuccess()) {
                        Url.Cookie = response.headers().get("Set-Cookie");
                        Toast.makeText(context, "Success and cookie :" + Url.Cookie, Toast.LENGTH_SHORT).show();
                        isSuccess=true;
                    }
                }
            }
            @Override
            public void onFailure(Call<LoginSignupResponse> call, Throwable t) {
                Toast.makeText(context, " Error : " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return isSuccess;
    }






    public boolean checkUser() {
        HeroesAPI heroesAPI = Url.getInstance().create(HeroesAPI.class);
        Call<LoginSignupResponse> usersCall = heroesAPI.checkUser(username, password);

        try {
            Response<LoginSignupResponse> imageResponseResponse = usersCall.execute();
            // After saving an image, retrieve the current name of the image
            if (imageResponseResponse.body().getSuccess()) {
                Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public boolean checkUserForTesting(String username,String password) {
        HeroesAPI heroesAPI = Url.getInstance().create(HeroesAPI.class);
        Call<LoginSignupResponse> usersCall = heroesAPI.checkUser(username, password);

        try {
            Response<LoginSignupResponse> imageResponseResponse = usersCall.execute();
            // After saving an image, retrieve the current name of the image
            if (imageResponseResponse.body().getSuccess()) {
                Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }
}