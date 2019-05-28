package edu.upc.dsa.minimo2examen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.ListIterator;

import edu.upc.dsa.minimo2examen.models.Element;
import edu.upc.dsa.minimo2examen.models.Museums;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("pag-ini/1/pag-fi/3")
    Call<Museums> get();

}
