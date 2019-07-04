package com.example.heroesapiforclass.BLL;

import java.io.IOException;

import heroesapi.HeroesAPI;
import model.LoginSignupResponse;
import retrofit2.Call;
import retrofit2.Response;
import url.Url;

public class LoginBLL {
    private String username;
    private String password;
    boolean isSuccess = false;

    public LoginBLL(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public boolean checkUser() {
        HeroesAPI heroesAPI = Url.getInstance().create(HeroesAPI.class);
        Call<LoginSignupResponse> usersCall = heroesAPI.checkUser(username, password);

        try {
            Response<LoginSignupResponse> imageResponseResponse = usersCall.execute();
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






