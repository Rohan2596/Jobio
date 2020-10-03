package com.spatalabz.jobio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.spatalabz.jobio.R;
import com.spatalabz.jobio.model.Job;

import java.util.ArrayList;

import static com.spatalabz.jobio.R.drawable.ic_google;
import static com.spatalabz.jobio.R.drawable.ic_launcher_background;
import static com.spatalabz.jobio.R.drawable.ic_launcher_foreground;


public class RecentJobsAdapter extends RecyclerView.Adapter<RecentJobsAdapter.MyViewHolderRecent>{

    private ArrayList<Job> recentJobList;
    private Context context;

    public RecentJobsAdapter(ArrayList<Job> recentJobList, Context context) {
        this.recentJobList = recentJobList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolderRecent onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext())
                .inflate(R.layout.recent_jobs_layout,parent,false);

        return new MyViewHolderRecent(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderRecent holder, int position) {
        holder.rc_title.setText(recentJobList.get(position).getTitle());
        holder.rc_company.setText(recentJobList.get(position).getCompany());
        holder.rc_WagePerHour.setText(recentJobList.get(position).getWagePerHour());
        holder.rc_logo.setImageResource(ic_google);

    }

    @Override
    public int getItemCount() {
        return recentJobList.size();
    }

    class MyViewHolderRecent extends  RecyclerView.ViewHolder{

        TextView rc_title,rc_company,rc_WagePerHour;
        ImageView rc_logo;
        public MyViewHolderRecent(@NonNull View itemView) {
            super(itemView);
            rc_title=itemView.findViewById(R.id.rc_job_title);
            rc_company=itemView.findViewById(R.id.rc_job_company);
            rc_WagePerHour=itemView.findViewById(R.id.rc_per_hour);
            rc_logo=itemView.findViewById(R.id.rc_job_logo);

        }
    }
}
