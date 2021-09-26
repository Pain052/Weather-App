package com.example.weatherapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WeatherRVAdapter extends RecyclerView.Adapter<WeatherRVAdapter.ViewHolder> {
    Context context;
    List<WeatherRVModel> modelList;

    public WeatherRVAdapter(Context context, List<WeatherRVModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public WeatherRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weather_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherRVAdapter.ViewHolder holder, int position) {

        WeatherRVModel model = modelList.get(position);
        holder.tvTemperature.setText(model.getTemp_c() + "°c");
        try{
            Picasso.get().load("http:".concat(model.getIcon())).into(holder.ivCondition);
        }catch (Exception e){
            Log.e("ERROR", e.getMessage());
        }
        holder.tvWinSpeed.setText(model.getWind_kph() + "Km/h");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat outPut = new SimpleDateFormat("hh:mm aa");
        try{
            Date date = dateFormat.parse(model.getTime());
            holder.tvTime.setText(outPut.format(date));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTime, tvTemperature, tvWinSpeed;
        ImageView ivCondition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTime = itemView.findViewById(R.id.tvTime2);
            tvTemperature = itemView.findViewById(R.id.tvTemperature2);
            tvWinSpeed = itemView.findViewById(R.id.tvTime2);
            tvTime = itemView.findViewById(R.id.tvWinSpeed2);
            ivCondition = itemView.findViewById(R.id.ivCondition2);
        }
    }
}
