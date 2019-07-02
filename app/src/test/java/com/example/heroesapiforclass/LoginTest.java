package com.example.heroesapiforclass;

import org.junit.Test;
import BLL.LoginBLL;
import static org.junit.Assert.assertEquals;

public class LoginTest {
    @Test
    public void testUser()
    {
        LoginBLL loginBLL = new LoginBLL();
        boolean aa = loginBLL.checkUserForTesting(  "kiran","kiran");
        assertEquals(true,aa);
    }
}