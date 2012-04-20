package com.allplayers.net;

import static org.junit.Assert.*;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.allplayers.net.HttpClient;
import com.allplayers.net.RestApiV1;

public class HttpClientTest {

    private static boolean mPrint = false;

    private static void println(String text) {
        if (mPrint) {
            System.out.println(text);
        }
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        println("setUpBeforeClass");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        println("tearDownAfterClass");
    }

    @Before
    public void setUp() throws Exception {
        println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        println("tearDown");
    }

    @Test
    public final void index() {
        RestApiV1 client = new RestApiV1();
        JSONArray response = client.index("groups&search=\"YMCA\"", null);
        println(response.toString());
        assertTrue((response.length() > 0));
    }

    @Test
    public final void login() {
        RestApiV1 client = new RestApiV1();
        JSONObject response = client.userLogin("admin", "APCI4ever");
        println(response.toString());
        assertTrue((response.length() > 0));
    }

    @Test
    public final void session() throws JSONException {
        RestApiV1 client = new RestApiV1();
        JSONObject response = client.userLogin("admin", "APCI4ever");
        String uuid = response.getJSONObject("user").getString("uuid");
        List<String> cookies = client.getCookies();
        response = client.userGet(uuid);
        response = client.userGet(uuid);

        // Reset client. TODO - AuthClient
        client = new RestApiV1();
        client.setCookies(cookies);
        response = client.userGet(uuid);
        response = client.userGet(uuid);
        println(response.toString());
        assertTrue((response.length() > 0));
    }

    @Test
    public final void myGroups() throws JSONException {
        RestApiV1 client = new RestApiV1();
        JSONObject login = client.userLogin("admin", "APCI4ever");
        String uuid = login.getJSONObject("user").getString("uuid");
        //String uuid = "2531d044-f611-11e0-a44b-12313d04fc0f";
        JSONArray response = client.index("users/" + uuid + "/groups", null);
        println(response.toString());
        assertTrue((response.length() > 0));
    }

}
