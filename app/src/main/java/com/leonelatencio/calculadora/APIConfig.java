package com.leonelatencio.calculadora;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Leonel on 02/01/2017.
 */

public class APIConfig {
    private static API REST_CLIENT;
    private static final String API_URL = "http://leonelatencio.com/PokemonQR/"; //Change according to your API path.

    static {
        setupRestClient();
    }

    private APIConfig() {
    }

    public static API get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();


        REST_CLIENT = retrofit.create(API.class);
    }
}
