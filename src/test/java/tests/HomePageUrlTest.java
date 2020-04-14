package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageUrlTest extends BaseTest {

    HomePage homePage;
    @Test
    public  void testMethodOne(){
         homePage = new HomePage(driver);
         homePage.testSomething();

     String urltitle= "www.google.com";
        Assert.assertSame(urltitle,driver.getCurrentUrl());
        System.out.println(driver.getCurrentUrl());


    }
}
