package com.automation.utils;

import com.automation.pages.BasePage;
import okhttp3.*;
import java.io.IOException;

public class HttpClient {

    private static final OkHttpClient client = new OkHttpClient.Builder().build();
    private static final String csrfToken = BasePage.getCsrfmiddlewaretoken();

    public static void createUser() throws IOException {

    /*
     * I tried using JsonObject, but this API does not support it. I should send the body as a FormBody instead.
    */
        RequestBody body = new FormBody.Builder()
                .add("csrfmiddlewaretoken", csrfToken)
                .add("name",RandomDataManager.getRandomName() )
                .add("email_address", RandomDataManager.getRandomEmail() )
                .add("password", RandomDataManager.getRandomPassword())
                .add( "days", "18")
                .add( "years", "2005")
                .add( "months", "11")
                .add( "newsletter", "1")
                .add( "optin", "1")
                .add( "first_name", "test firstName")
                .add( "last_name", "test lastName")
                .add( "company", "test company")
                .add( "address1", "test address1")
                .add( "address2", "test address2")
                .add( "country", "India")
                .add( "state", "test state")
                .add( "city", "test city")
                .add( "zipcode", "56656")
                .add( "mobile_number", "44545")
                .add( "form_type", "create_account")
                .build();

        Request request = new Request.Builder()
                .url(ConfigManager.getBaseUrl()+"/signup")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("X-CSRFToken", csrfToken)
                .addHeader("Cookie", "csrftoken=" + csrfToken)
                .addHeader("User-Agent", "Mozilla/5.0")
                .addHeader("Referer", ConfigManager.getBaseUrl()+"/form_page")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println("email " + RandomDataManager.getRandomEmail());
            System.out.println("Password " + RandomDataManager.getRandomPassword());
            System.out.println("Response Code: " + response.code());

        }
    }
}
