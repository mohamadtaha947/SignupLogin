package com.example.signuplogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.MyViewHolder> {
    Context context;
    ArrayList<User> usersList;
    private FireBaseServices fbs;

    public myadapter(Context context, ArrayList<User> usersList) {
        this.context = context;
        this.usersList = usersList;
        this.fbs = FireBaseServices.getInstance();
    }

    @NonNull
    @Override
    public myadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v= LayoutInflater.from(context).inflate(R.layout.user_item,parent,false);
        return  new myadapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.MyViewHolder holder, int position) {
        User s = usersList.get(position);
        holder.tvusernameUseritem.setText(s.getUserName());
        holder.tvphoneUseritem.setText(s.getPhone());
    }

    @Override
    public int getItemCount(){
        return usersList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvusernameUseritem, tvphoneUseritem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvusernameUseritem=itemView.findViewById(R.id.tvusernameUseritem);
            tvphoneUseritem=itemView.findViewById(R.id.tvphoneUseritem);

        }
    }}
