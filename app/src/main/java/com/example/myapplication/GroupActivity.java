package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.database.Group;
import com.example.myapplication.database.ObjectDao;
import com.example.myapplication.mock.MockAdapter;
import com.example.myapplication.ui.share.ShareFragment;

import java.util.ArrayList;
import java.util.List;

public class GroupActivity extends AppCompatActivity implements MockAdapter.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);


        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ShareFragment.newInstance())
                    .commit();
        }


        final ObjectDao objectDao = ((AppDelegate) getApplicationContext()).getmMuseumDatabase().getObjectDao();
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


    @Override // логика обрабоки клика по элементу списка
    public void onItemClick(String id) {
        Toast.makeText(this, "clikced "+id, Toast.LENGTH_SHORT).show();
    }
}
