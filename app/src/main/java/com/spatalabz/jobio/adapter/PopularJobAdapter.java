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

public class PopularJobAdapter extends RecyclerView.Adapter<PopularJobAdapter.MyPopularViewHolder> {

    private ArrayList<Job> popularJobList=new ArrayList();
    private Context context;

    public PopularJobAdapter(ArrayList<Job> popularJobList, Context context) {
        this.popularJobList = popularJobList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyPopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.popular_jobs_layout,parent,false);
        return new MyPopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPopularViewHolder holder, int position) {
         holder.po_title.setText(popularJobList.get(position).getTitle());
        holder.po_company.setText(popularJobList.get(position).getCompany());
        holder.po_WagePerHour.setText(popularJobList.get(position).getWagePerYear());
        holder.po_location.setText("New York");
        holder.po_type.setText("Full-Time");

    }

    @Override
    public int getItemCount() {
        return popularJobList.size();
    }


    class MyPopularViewHolder extends RecyclerView.ViewHolder{
        TextView po_title,po_company,po_WagePerHour,po_type,po_location;

        public MyPopularViewHolder(@NonNull View itemView) {
            super(itemView);
            po_title=itemView.findViewById(R.id.popular_job_title);
            po_company=itemView.findViewById(R.id.popular_job_company);
            po_WagePerHour=itemView.findViewById(R.id.popular_job_per_year);
            po_location=itemView.findViewById(R.id.popular_job_location);
            po_type=itemView.findViewById(R.id.popular_job_type);


        }
    }

}
