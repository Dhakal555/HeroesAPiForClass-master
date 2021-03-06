package com.example.heroesapiforclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.heroesapiforclass.BLL.LoginBLL;
import StrictMode.StrictMod;
import heroesapi.HeroesAPI;
import model.LoginSignupResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class LoginActivity extends AppCompatActivity {
    public final static String TAG = "LoginActivity";
    private EditText etUsername, etPassword;
    private Button btnLogin, btnRegister;
    private boolean isSuccess = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LoginBLL bll = new LoginBLL(etUsername.getText().toString(), etPassword.getText().toString());
                StrictMod.StrictMode();

                if (bll.checkUser()) {
                    Intent intent = new Intent(LoginActivity.this, AddCommentsActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Error aayo", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }







    boolean checkUser(String username, String password) {
        HeroesAPI heroesAPI = Url.getInstance().create(HeroesAPI.class);
        Call<LoginSignupResponse> usersCall = heroesAPI.checkUser(username, password);

        usersCall.enqueue(new Callback<LoginSignupResponse>() {
            @Override
            public void onResponse(Call<LoginSignupResponse> call, Response<LoginSignupResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, " Either username or password is incorrect" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (response.body().getSuccess()) {
                        Url.Cookie = response.headers().get("Set-Cookie");
                        Toast.makeText(LoginActivity.this, "Success and cookie :" + Url.Cookie, Toast.LENGTH_SHORT).show();
                        isSuccess = true;
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginSignupResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, " Error : " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return isSuccess;
    }
}


