package com.example.heroesapiforclass;

import org.junit.Test;

import com.example.heroesapiforclass.BLL.LoginBLL;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    @Test
    public void testLogin() {
        LoginBLL loginBLL = new LoginBLL("kiran", "kiran");
        boolean result = loginBLL.checkUser();
        assertEquals(true, result);
    }
}