package com.ambitsolutions.mvvm.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ambitsolutions.mvvm.R;
import com.ambitsolutions.mvvm.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AdViewAdapter adsAdapter;
    List<AdViewModel> adViewModels;
    List<brajanwar> adsList;
    RecyclerView recyclerView;
    private HomeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.cowAdsRecyclerView);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);// call new ViewModelProvider
        // and pass activity context so it can attach to our activity and get destroyed after our activity
        // is completely destroyed
        // While using Fragments pass getActivity() in ViewModelProvider(this) so the ViewModel will be registered to
        // that underline fragments activity and will not be destroyed until the activity is destroyed. This is used
        // when we have to share data with multiple fragments.
        // You can also pass fragmentName.this to register ViewModel to the fragment lifecycle and will be destroyed
        // after fragment.onDetach() is called.

        adViewModels = new ArrayList<>();
        adsList = new ArrayList<>();

        GridLayoutManager layoutManager = new GridLayoutManager
                (MainActivity.this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adsAdapter = new AdViewAdapter(getApplicationContext(), adsList, 11);
        recyclerView.setAdapter(adsAdapter);

        viewModel.getAllProducts("1").observe(this, new Observer<AdViewModel>() { // since wo are using
            // LiveData so we have to use .observe to get the live updates/
            @Override
            public void onChanged(AdViewModel productModels) { // this function will be triggered when
                // their's any change in the data
                // Update RecyclerView or UI
                adsList.clear();
                adsList.addAll(productModels.getBrajanwar());
                adsAdapter.filterResult(adsList);
            }
        });
    }
}