package com.example.yo_job.JobSearch;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yo_job.Activities.JobDescriptionActivity;
import com.example.yo_job.SimpleClasses.Job;
import com.example.yo_job.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Job> jobs;

    public MyAdapter (Context c, ArrayList<Job> j){
        context = c;
        jobs = j;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.titleV.setText("Title: "+jobs.get(position).getTitle());
        holder.titleV.setTypeface(null, Typeface.BOLD);

        holder.durationV.setText("Duration: "+jobs.get(position).getDuration()+" hours.");
        holder.durationV.setTypeface(null,Typeface.BOLD);

        holder.salaryV.setText("Salary: "+jobs.get(position).getSalary()+" £/hour. ");
        holder.salaryV.setTypeface(null, Typeface.BOLD);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print(position+" is clicked");
                Job selected = jobs.get(position);
                Intent i = new Intent(context, JobDescriptionActivity.class);
                i.putExtra("job",selected);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView titleV, durationV, salaryV;
        private View layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            titleV = (TextView) itemView.findViewById(R.id.title_list);
            durationV = (TextView) itemView.findViewById(R.id.duration_list);
            salaryV = (TextView) itemView.findViewById(R.id.salary_list);
            layout = (View) itemView.findViewById(R.id.relativeLayout);
        }
    }
}
