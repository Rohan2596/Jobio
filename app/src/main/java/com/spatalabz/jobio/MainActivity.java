package com.spatalabz.jobio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
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

    ArrayList category_list=new ArrayList();
    ArrayList recent_jobs_list=new ArrayList();
    ArrayList popular_jobs_list=new ArrayList();


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

        recent_jobs_list.add(new Job("Product Engineer","Uber","$70/hr","$70k/yr"));
        recent_jobs_list.add(new Job("UI/UX Engineer","Google","$100/hr","$70k/yr"));
        recent_jobs_list.add(new Job("Software Engineer","Microsoft","$60/hr","$70k/yr"));
        recent_jobs_list.add(new Job("Data Engineer","Saptalabz Solutions","$40/hr","$70k/yr"));
        recent_jobs_list.add(new Job("Public Relations","Amazon","$80/hr","$70k/yr"));
        recent_jobs_list.add(new Job("Lead Manager","Apple","$120/hr","$70k/yr"));

        recent_layout_manager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
         recentJobsAdapter=new RecentJobsAdapter(recent_jobs_list,MainActivity.this);
         recent_jobs_view=findViewById(R.id.recent_job_recycler_view);
         recent_jobs_view.setLayoutManager(recent_layout_manager);
         recent_jobs_view.setAdapter(recentJobsAdapter);
         /*
         * Popular Jobs Sections recycler View
         * */
        popular_jobs_list.add(new Job("Product Engineer","Uber","$70/hr","$70k/yr"));
        popular_jobs_list.add(new Job("UI/UX Engineer","Google","$100/hr","$100k/yr"));
        popular_jobs_list.add(new Job("Software Engineer","Microsoft","$60/hr","$50k/yr"));
        popular_jobs_list.add(new Job("Data Engineer","Saptalabz Solutions","$40/hr","$80k/yr"));
        popular_jobs_list.add(new Job("Public Relations","Amazon","$80/hr","$200k/yr"));
        popular_jobs_list.add(new Job("Lead Manager","Apple","$120/hr","$220k/yr"));


        popular_jobs_view=findViewById(R.id.popular_recycler_view);
         popular_layout_manager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
         popular_jobs_view.setLayoutManager(popular_layout_manager);
         popularJobAdapter=new PopularJobAdapter(popular_jobs_list,MainActivity.this);
         popular_jobs_view.setAdapter(popularJobAdapter);


    }
}