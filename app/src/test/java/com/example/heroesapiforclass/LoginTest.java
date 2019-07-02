package com.example.heroesapiforclass;

import org.junit.Test;

import BLL.LoginBLL;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    // For testing Synchronous method
    @Test
    public void testUserSync() {
        LoginBLL loginBLL = new LoginBLL();
        boolean aa = loginBLL.checkUserForTesting("kiran", "kiran");
        assertEquals(true, aa);
    }

    // For testing ASynchronous method
    @Test
    public void testUserAsync() {
        LoginActivity loginBLL = new LoginActivity();
        boolean aa = loginBLL.checkUser("kiran", "kiran");
        assertEquals(true, aa);
    }
}