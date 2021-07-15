package com.ambitsolutions.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ambitsolutions.mvvm.home.ProductModel;
import com.ambitsolutions.mvvm.repository.HomeRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    // AndroidViewModel is a subclass of ViewModel
    // In AndroidViewModel we pass Application and constructor and don't pass or store any activity Context
    // because is can cause a memory leak

    private HomeRepository repository;
    private LiveData<List<ProductModel>> allProducts;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        repository = new HomeRepository(application);
        allProducts = repository.getAllProducts();// call the main function to get list of all items to show in home
    }

    //then make some public function that will call the other function in repository and pass the given data if any.


    public LiveData<List<ProductModel>> getAllProducts() {
        return allProducts;
    }
}
