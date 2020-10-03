package com.spatalabz.jobio;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.spatalabz.jobio.adapter.CategoryAdapter;
import com.spatalabz.jobio.adapter.PopularJobAdapter;
import com.spatalabz.jobio.adapter.RecentJobsAdapter;
import com.spatalabz.jobio.model.Job;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView category_recycler_view,recent_jobs_view,popular_jobs_view;
    RecyclerView.LayoutManager category_layout_manager,recent_layout_manager,popular_layout_manager;
    CategoryAdapter categoryAdapter;
    RecentJobsAdapter recentJobsAdapter;
    PopularJobAdapter popularJobAdapter;
    Intent toJobListing;
    ImageView popular_view_all,recent_view_all;

    ArrayList category_list=new ArrayList();
    ArrayList recent_jobs_list=new ArrayList();
    ArrayList popular_jobs_list=new ArrayList();


    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setActionBar(toolbar);
        /*Category Recycler View Setup*/
        category_list.add("Design");
        category_list.add("Software");
        category_list.add("Network");
        category_list.add("Data");
        category_list.add("Testing");
        category_list.add("DevOPs");
        category_list.add("AI/ML");

        category_layout_manager=new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        categoryAdapter=new CategoryAdapter(category_list,MainActivity.this);
        category_recycler_view=findViewById(R.id.category_recycler_view);
        category_recycler_view.setLayoutManager(category_layout_manager);
        category_recycler_view.setAdapter(categoryAdapter);
        /*
        * Recent Jobs Recycler View Setup.
        * */

        recent_jobs_list.add(new Job("Product Engineer","Google","$70/hr","$70k/yr"));
        recent_jobs_list.add(new Job("UI/UX Engineer","Google","$100/hr","$70k/yr"));
        recent_jobs_list.add(new Job("Software Engineer","Google","$60/hr","$70k/yr"));
        recent_jobs_list.add(new Job("Data Engineer","Google","$40/hr","$70k/yr"));
        recent_jobs_list.add(new Job("Public Relations","Google","$80/hr","$70k/yr"));
        recent_jobs_list.add(new Job("Lead Manager","Google","$120/hr","$70k/yr"));

        recent_layout_manager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
         recentJobsAdapter=new RecentJobsAdapter(recent_jobs_list,MainActivity.this);
         recent_jobs_view=findViewById(R.id.recent_job_recycler_view);
         recent_jobs_view.setLayoutManager(recent_layout_manager);
         recent_jobs_view.setAdapter(recentJobsAdapter);
         recent_view_all=findViewById(R.id.recent_viewAll);
         recent_view_all.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 toJobListingActivities();
             }
         });
         /*
         * Popular Jobs Sections recycler View
         * */
        popular_jobs_list.add(new Job("Product Engineer","Google","$70/hr","$70k/yr"));
        popular_jobs_list.add(new Job("UI/UX Engineer","Google","$100/hr","$100k/yr"));
        popular_jobs_list.add(new Job("Software Engineer","Google","$60/hr","$50k/yr"));
        popular_jobs_list.add(new Job("Data Engineer","Google","$40/hr","$80k/yr"));
        popular_jobs_list.add(new Job("Public Relations","Google","$80/hr","$200k/yr"));
        popular_jobs_list.add(new Job("Lead Manager","Google","$120/hr","$220k/yr"));


        popular_jobs_view=findViewById(R.id.popular_recycler_view);
         popular_layout_manager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
         popular_jobs_view.setLayoutManager(popular_layout_manager);
         popularJobAdapter=new PopularJobAdapter(popular_jobs_list,MainActivity.this);
         popular_jobs_view.setAdapter(popularJobAdapter);
         /**/
        popular_view_all=findViewById(R.id.popular_button);
        popular_view_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toJobListingActivities();
                }
        });

    }

    public void toJobListingActivities(){
        toJobListing=new Intent(MainActivity.this,JobListing.class);
        startActivity(toJobListing);

    }
}