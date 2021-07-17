package com.ambitsolutions.mvvm.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.ambitsolutions.mvvm.home.AdViewModel;
import com.ambitsolutions.mvvm.retrofit.RetrofitInstance;
import com.ambitsolutions.mvvm.retrofit.WebApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {
    private final List<AdViewModel> products;// LiveData will provide us realtime changing in Products list
    private final WebApi webApi; //no need to initialize webApi or Retrofit class in main class repository will pas the application instance
    // to Retrofit as a context because Application is a subclass of ApCompact
    Application application;
    // Repository is our abstract layer that will be used by ViewModel to call api and room operations without disturbing our UI.
    private MutableLiveData<AdViewModel> allProducts;

    public HomeRepository(Application application) {
        webApi = RetrofitInstance.getClient(application).create(WebApi.class);
        products = new ArrayList<>();
        allProducts = new MutableLiveData<>();
        this.application = application;
        //call a generic API to populate the home for the first time
    }

    // and here make public functions of all other calls
    // Now make all the calls to server here and save data to room
    public MutableLiveData<AdViewModel> getAllProducts(String s) {
        Map<String, String> field = new HashMap<>();
        field.put("categoryID", s);
        field.put("userID", "");
        field.put("pageno", "1");
        Call<AdViewModel> fetchCowBuffaloBull = webApi.fetchCowBuffaloBull(field);

        fetchCowBuffaloBull.enqueue(new Callback<AdViewModel>() {
            @Override
            public void onResponse(Call<AdViewModel> call, Response<AdViewModel> response) {
                if (response.isSuccessful()) {

                    AdViewModel model = response.body();
                    allProducts.postValue(model);
                    Log.i("Ok", String.valueOf(allProducts));

                    Toast.makeText(application, "ok", Toast.LENGTH_SHORT).show();
                } else {

                }
            }

            @Override
            public void onFailure(Call<AdViewModel> call, Throwable t) {
                allProducts.postValue(null);
            }
        });
        Log.i("Re", String.valueOf(allProducts));
        return allProducts;

    }
}
