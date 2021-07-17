package com.ambitsolutions.mvvm.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.ambitsolutions.mvvm.home.AdViewModel;
import com.ambitsolutions.mvvm.repository.HomeRepository;

public class HomeViewModel extends AndroidViewModel {
    // AndroidViewModel is a subclass of ViewModel
    // In AndroidViewModel we pass Application and constructor and don't pass or store any activity Context
    // because is can cause a memory leak

    private HomeRepository repository;
    private MutableLiveData<AdViewModel> allProducts;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        repository = new HomeRepository(application);
        allProducts = new MutableLiveData<>();
        //  allProducts = repository.getAllProducts();// call the main function to get list of all items to show in home
    }

    //then make some public function that will call the other function in repository and pass the given data if any.


    public MutableLiveData<AdViewModel> getAllProducts(String s) {
        allProducts = repository.getAllProducts(s);
        Log.i("VM", String.valueOf(allProducts));
        return allProducts;
    }
}
