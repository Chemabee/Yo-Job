package com.example.yo_job;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class JobSearch extends AppCompatActivity {

    private RecyclerView mResultList;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_search);

        mResultList = findViewById(R.id.result_list);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseDatabase.getInstance();
        ref = db.getReference("Jobs");

        i = getIntent();

        jobSearch();
    }

    private void jobSearch(){

        Toast.makeText(JobSearch.this,"Started Search",Toast.LENGTH_LONG).show();

        Query searchQuery = ref.orderByChild("title").startAt(i.getStringExtra("title")).endAt(i.getStringExtra("title")+"\uf8ff");


        FirebaseRecyclerAdapter<Job, JobsViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Job, JobsViewHolder>(
                Job.class,
                R.layout.list_layout,
                JobsViewHolder.class,
                searchQuery
        ) {
            @Override
            protected void populateViewHolder(JobsViewHolder viewHolder, Job model, int position) {

                viewHolder.setDetails(model.getTitle(),model.getDate(),model.getSalary());
            }
        };
        mResultList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class JobsViewHolder extends RecyclerView.ViewHolder{
        View nView;

        public JobsViewHolder(View itemView){
            super(itemView);
            nView = itemView;
        }
        public void setDetails(String title, String duration, String salary){
            TextView t = (TextView) nView.findViewById(R.id.title_list);
            TextView dur = (TextView) nView.findViewById(R.id.duration_list);
            TextView sal = (TextView) nView.findViewById(R.id.salary_list);

            t.setText(title);
            dur.setText(duration);
            sal.setText(salary);
        }

    }
}
