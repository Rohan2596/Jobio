package com.spatalabz.jobio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.spatalabz.jobio.model.Job;

import java.util.ArrayList;

public class JobListing extends AppCompatActivity {

    RecyclerView job_recycler_view;
    ArrayList<Job>jobs=new ArrayList<>();

    RecyclerView.LayoutManager  layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_listing);
        /*
        * Jobs Recycler View
        * */
        job_recycler_view=findViewById(R.id.job_recycler_view);
        layoutManager=new LinearLayoutManager(JobListing.this,LinearLayoutManager.VERTICAL,false);
        job_recycler_view.setLayoutManager(layoutManager);



    }
}