package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.example.recyclerview.Data.TYPE_HEADER;
import static com.example.recyclerview.Data.TYPE_ITEM;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ListActivityAdapter adapter = new ListActivityAdapter(mockData());
        recyclerView.setAdapter(adapter);
    }

    private List<Data> mockData() {
        List<Data> dataSet = new ArrayList<>();
        String title = "title";
        String desp = "desp";
        for(int i = 0; i < 16; ++i) {
            int type = TYPE_ITEM;
            String number = String.valueOf(i);
            if (i == 0) {
                type = TYPE_HEADER;
                Data data = new Data("This is header", null, i, type);
                dataSet.add(data);
                continue;
            }
            Data data = new Data(title.concat(number), desp.concat(number), i, type);
            dataSet.add(data);
        }

        return dataSet;
    }
}
