package com.ambitsolutions.mvvm.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ambitsolutions.mvvm.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdViewAdapter extends RecyclerView.Adapter<AdViewAdapter.ViewHolder> {

    Context context;
    List<brajanwar> adsList;
    int activity;

    public AdViewAdapter(Context applicationContext, List<brajanwar> adsList, int activity) {
        this.context = applicationContext;
        this.adsList = adsList;
        this.activity = activity;
    }

    public void filterResult(List<brajanwar> filterAdsList) {
        // adsList.addAll(filterAdsList);
        //  notifyItemRangeChanged(1, adsList.size());
        // notifyDataSetChanged();
        this.adsList=filterAdsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recommended_design, parent, false);
        return new AdViewAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        holder.title.setText(adsList.get(position).getName();?

//        String[] imageArray = images.split(",");
//
//        for (String s : imageArray) {
//            remoteImages.add(new SlideModel(s, ScaleTypes.FIT));
//
//        }

        Glide.with(context)
                .load(adsList.get(position).getImage().split(",")[0])
                .into(holder.image);

        holder.price.setText(adsList.get(position).getPrice() + "روپے");
        holder.city.setText(adsList.get(position).name);
        holder.title.setText(adsList.get(position).getBreed() + " " + adsList.get(position).getCategory());
        holder.adcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "5555", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return adsList.size();
    }

    public void addAll(List<brajanwar> body) {
        int lastIndex = adsList.size() - 1;
        adsList.addAll(body);
        notifyItemRangeInserted(lastIndex, body.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, price, city, time;
        ImageView bookmark;
        CardView adcard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.featured_image);
            price = itemView.findViewById(R.id.priceField);
            title = itemView.findViewById(R.id.AdTitle);
            city = itemView.findViewById(R.id.cityTextField);
            adcard = itemView.findViewById(R.id.adCard);

        }
    }
}
