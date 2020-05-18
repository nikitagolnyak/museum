package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.myapplication.database.Group;
import com.example.myapplication.database.ObjectDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.yandex.mapkit.geometry.Point;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class Info_main extends AppCompatActivity {

    //private Button navButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_main);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        /*
        final Uri addres = Uri.parse("yandexmaps://maps.yandex.ru/?ll=37.619902,55.753716&z=16&text=кафе%20с%20wi-fi");

        navButton = findViewById(R.id.navigation_button);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, addres);
                startActivity(intent);

            }
        });
        */

    }



}
