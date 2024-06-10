package com.curso.android.app.practica.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.curso.android.app.practica.planetsapp.Planet;
import com.curso.android.app.practica.planetsapp.R;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter <Planet> {
    // Using custom layouts --> com.curso.android.app.practica.planetsapp.MyCustomAdapter
    // Using custom Objects --> extends ArrayAdapter<com.curso.android.app.practica.planetsapp.Planet>

    // Variables
    private ArrayList<Planet> planetsArrayList;
    Context context;

    // Constructor


    public MyCustomAdapter(ArrayList<Planet> planetsArrayList, Context context1) {
        super(context1, R.layout.item_list_layout, planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context1;
    }

    @Override
    public int getCount() {
        return planetsArrayList.size();
    }

    @Override
    public Planet getItem(int position) {
        return planetsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Getting planet object
        Planet planet = getItem(position);

        // inflate layout if the existing view is null
        MyViewHolder myViewHolder;
        final View result;
        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );

            // finding views
            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.moons);
            myViewHolder.planetImage = (ImageView) convertView.findViewById(R.id.image);

            result = convertView;
            convertView.setTag(myViewHolder);

        } else {
            // reuse existing view
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        // get data from the model and set it to the views
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonCount.setText(planet.getMoonCount());
        myViewHolder.planetImage.setImageResource(planet.getPlanetImage());

        return result;
    }

    // Un ViewHolder es una clase que sirve para guardar las referencias a
    // los elementos de una vista para que no se repitan los findViewById
    // cada vez que se invoque el método getView
    // Es un cache de vistas para optimizar el rendimiento de la aplicación

    private static class MyViewHolder {
        TextView planetName;
        ImageView planetImage;
        TextView moonCount;

    }



}
