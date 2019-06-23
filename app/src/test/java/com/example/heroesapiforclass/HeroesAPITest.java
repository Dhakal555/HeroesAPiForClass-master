package com.example.heroesapiforclass;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import BLL.LoginBLL;
import heroesapi.HeroesAPI;
import model.LoginSignupResponse;
import retrofit2.Call;
import retrofit2.Response;
import url.Url;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class HeroesAPITest {

    LoginBLL bll;
    @Mock
    LoginActivity activity;


    @Before
    public void initMock()
    {

        MockitoAnnotations.initMocks(this);

    }
    @Test
    public void testLogin() throws IOException
    {

        bll=new LoginBLL(activity);
        Mockito.when(bll.checkUser("kiran","kiran")).thenReturn(true);
        assertTrue(bll.checkUser("kiran","kiran"));

    }

//    @Test
//    public void testCookie()
//    {
//        HeroesAPI heroesAPI = Url.getInstance().create(HeroesAPI.class);
//        Call<LoginSignupResponse> call = heroesAPI.checkUser("kiran","kiran");
//        try
//        {
//            // Synchronous method
//            Response<LoginSignupResponse> response= call.execute();
//            Url.Cookie = response.headers().get("Set-Cookie");
//            assertThat(Url.Cookie,is(IsNull.notNullValue()));
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
//    }
}




