package com.example.aceahmer.taskfive;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

public class RecyclerViewImplementation extends RecyclerView.Adapter<RecyclerViewImplementation.InnerViewHolder> {
    private List<DataModel> employeelist;
    Context context;
    public TextView wholename_txt;
    public CardView cview;
    DataModel dm=new DataModel();
    public RecyclerViewImplementation(Context context,List<DataModel> employeelist) {
        this.employeelist = employeelist;
        this.context=context;
    }

    @NonNull
    @Override
    public InnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.customrecyclerlayout,parent,false);
        RecyclerViewImplementation.InnerViewHolder innerViewHolder=new RecyclerViewImplementation.InnerViewHolder(view);
        return innerViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull InnerViewHolder holder, final int position) {

        dm=employeelist.get(position);
        wholename_txt.setText(dm.getFirstName()+" "+dm.getSecondName()+" "+dm.getAge());
        cview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dm=employeelist.get(position);
                Intent i=new Intent(context,Details.class);
                i.putExtra("data",dm);
                context.startActivity(i);
            }
        });
        cview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dm=employeelist.get(position);
                Intent in=new Intent(context,Delete.class);
                in.putExtra("data",dm);
                context.startActivity(in);
                return false;
            }
        });
    }
    @Override
    public int getItemCount() {
        return employeelist.size();
    }
    public class InnerViewHolder extends  RecyclerView.ViewHolder{
        public InnerViewHolder(View itemView) {
            super(itemView);
            wholename_txt=(TextView)itemView.findViewById(R.id.wholename_txt);
            cview=(CardView)itemView.findViewById(R.id.view);
        }
    }
}
