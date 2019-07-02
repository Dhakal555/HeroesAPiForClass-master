package com.example.heroesapiforclass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import heroesapi.HeroesAPI;
import model.LoginSignupResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestWithMockito {


    @Test
    public void TestWithMockito() {
        HeroesAPI heroesAPI = Mockito.mock(HeroesAPI.class);
        final Call<LoginSignupResponse> mockedCall = Mockito.mock(Call.class);
       when(heroesAPI.checkUser("kiran1","kiran2")).thenReturn(mockedCall);

       Mockito.doAnswer(new Answer() {
           @Override
           public Object answer(InvocationOnMock invocation) throws Throwable {
               Callback<LoginSignupResponse> callback = invocation.getArgument(0, Callback.class);
               callback.onResponse(mockedCall, Response.success(new LoginSignupResponse()));

              // callback.onResponse(mockedCall, Response.success(new UserNotifications()));
               return null;
           }
       }).when(mockedCall).enqueue(any(Callback.class));
    }

    @Test
    public void test_when_thenReturn(){
        LoginActivity activity = Mockito.mock(LoginActivity.class);
        when(LoginActivity.TAG).thenReturn("LoginActivity");
        assertThat(activity.getClass().getName(),is("LoginActivity"));
    }
}