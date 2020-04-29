package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.database.Group;
import com.example.myapplication.database.ObjectDao;
import com.example.myapplication.mock.MockAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MockAdapter.OnItemClickListener {

    private AppBarConfiguration mAppBarConfiguration;

    private Button mAddBtn; // кнопка добавление в БД из представление send
    private Button mGetBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



        final ObjectDao objectDao = ((AppDelegate) getApplicationContext()).getmMuseumDatabase().getObjectDao();

        /* кнопки тестирования БД
        mAddBtn = (findViewById(R.id.add));
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectDao.insertGroup(createGroups());
            }
        });

        mGetBtn = (findViewById(R.id.get));
        mGetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(objectDao.getGroups());
            }
        });
         */



    }

    private List<Group> createGroups() {

        List<Group> groups = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            groups.add(new Group(i, "name_of_group" + i));
        }

        return groups;
    }

    private void showToast(List<Group> groups) { // Тост для тестрировния отображения записей в БД
        StringBuilder builder = new StringBuilder();
        for (int i = 0, size = groups.size(); i < size; i++) {
            builder.append(groups.get(i).toString()).append("\n");
        }

        Toast.makeText(this, builder.toString(), Toast.LENGTH_SHORT).show();
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override // логика обрабоки клика по элементу списка
    public void onItemClick(String id) {
        Toast.makeText(this, "clikced "+id, Toast.LENGTH_SHORT).show();
    }
}
