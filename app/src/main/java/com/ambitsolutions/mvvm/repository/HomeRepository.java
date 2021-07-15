package com.ambitsolutions.mvvm.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.ambitsolutions.mvvm.home.ProductModel;
import com.ambitsolutions.mvvm.retrofit.RetrofitInstance;
import com.ambitsolutions.mvvm.retrofit.WebApi;

import java.util.List;

public class HomeRepository {
    // Repository is our abstract layer that will be used by ViewModel to call api and room operations without disturbing our UI.
    private LiveData<List<ProductModel>> allProducts; // LiveData will provide us realtime changing in Products list
    private WebApi webApi; //no need to initialize webApi or Retrofit class in main class repository will pas the application instance
    // to Retrofit as a context because Application is a subclass of ApCompact

    public HomeRepository(Application application) {
        webApi = RetrofitInstance.getClient(application).create(WebApi.class);
//call a generic API to populate the home for the first time
    }

    // and here make public functions of all other calls
    // Now make all the calls to server here and save data to room
    public LiveData<List<ProductModel>> getAllProducts() {
        return allProducts;
    }
}
