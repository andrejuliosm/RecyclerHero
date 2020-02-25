package com.example.heroapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHero = findViewById(R.id.activitymain_rv_hero);
        rvHero.setLayoutManager(new LinearLayoutManager(this));

        HeroesAdapter heroesAdapter = new HeroesAdapter(getApplicationContext(),HeroesData.getHeroList());

        rvHero.setAdapter(heroesAdapter);

    }
}
