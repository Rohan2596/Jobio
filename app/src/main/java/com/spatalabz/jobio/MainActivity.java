package com.spatalabz.jobio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.spatalabz.jobio.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView category_recycler_view;
    RecyclerView.LayoutManager category_layout_manager;
    CategoryAdapter categoryAdapter;
    ArrayList category_list=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setActionBar(toolbar);
        /**/
        category_list.add("Service");
        category_list.add("Ui/Ux");
        category_list.add("Developer");
        category_list.add("Operations");
        category_layout_manager=new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);


        categoryAdapter=new CategoryAdapter(category_list,MainActivity.this);

        /**/
        category_recycler_view=findViewById(R.id.category_recycler_view);
        category_recycler_view.setLayoutManager(category_layout_manager);
        category_recycler_view.setAdapter(categoryAdapter);


    }
}