package tests;


import pages.HttpRequestStatus;

import org.testng.annotations.Test;



public class PagesHTTPStatus extends BaseTest {

    HttpRequestStatus getstatus;


    //Enter all urls from portal to verify if server returns a 200.
    @Test
    public void getPagesStatus() {
           getstatus = new HttpRequestStatus(driver);
        getstatus.HttpURLStatus("https://www.google.com");
//        getstatus.HttpURLStatus("https://www.");
//        getstatus.HttpURLStatus("https://www.");
//        getstatus.HttpURLStatus("https://www.");
//        getstatus.HttpURLStatus("https://www.");
//        getstatus.HttpURLStatus("https://www.");
//        getstatus.HttpURLStatus("https://www.");
    }
}