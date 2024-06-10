package com.curso.android.app.practica.planetsapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet> planetArrayList;

    private static MyCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // AdapterView: in this case a ListView
        listView = findViewById(R.id.listview);

        // Data Source: ArrayList <com.curso.android.app.practica.planetsapp.Planet>
        planetArrayList = new ArrayList<>();

        Planet planet1 = new Planet("Mercury","0 moons",R.drawable.mercury);
        Planet planet2 = new Planet("Venus","0 moons",R.drawable.venus);
        Planet planet3 = new Planet("Earth","1 moon",R.drawable.earth);
        Planet planet4 = new Planet("Mars","2 moons",R.drawable.mars);
        Planet planet5 = new Planet("Jupiter","79 moons",R.drawable.jupiter);
        Planet planet6 = new Planet("Saturn","83 moons",R.drawable.saturn);
        Planet planet7 = new Planet("Uranus","27 moons",R.drawable.uranus);
        Planet planet8 = new Planet("Neptune","14 moons",R.drawable.neptune);

        planetArrayList.add(planet1);
        planetArrayList.add(planet2);
        planetArrayList.add(planet3);
        planetArrayList.add(planet4);
        planetArrayList.add(planet5);
        planetArrayList.add(planet6);
        planetArrayList.add(planet7);
        planetArrayList.add(planet8);

        // Adapter for ListView
        adapter = new MyCustomAdapter(planetArrayList, getApplicationContext());
        listView.setAdapter(adapter);

        // setting onClickListener
        listView.setOnItemClickListener((parent, view, position, id) -> {

            // Here, instead of a Toast, I can trigger an interface method for the
            // corresponding part of the architecture of the project, (like MVP, MVVM, etc)
            // TODO: Implement the interface method with MVP architecture

            Toast.makeText(getApplicationContext(),
                    "You Clicked on Planet " + adapter.getItem(position).getPlanetName()
                    , Toast.LENGTH_SHORT).show();
        });

    }
}