package com.leonelatencio.calculadora;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * API with Methods Interface.
 * Created by Leonel on 02/01/2017.
 */

public interface API {

    @GET("calculator")
    Call<Result> getResult(@Query("digit1") int digit1,
                           @Query("digit2") int digit2,
                           @Query("operation") char operator);
}
