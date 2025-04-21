package com.example.signuplogin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AllSubjectsAdapter extends RecyclerView.Adapter<AllSubjectsAdapter.ViewHolder> {

    private List<Subject> subjectList;
    private OnAddClickListener listener;

    public interface OnAddClickListener {
        void onAddClick(Subject subject);
    }

    public AllSubjectsAdapter(List<Subject> subjectList, OnAddClickListener listener) {
        this.subjectList = subjectList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_subject_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Subject subject = subjectList.get(position);
        holder.tvName.setText(subject.getName());
        holder.tvForm.setText(subject.getForm());
        holder.btnAdd.setOnClickListener(v -> listener.onAddClick(subject));
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvForm;
        Button btnAdd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvSubjectName);
            tvForm = itemView.findViewById(R.id.tvForm);
            btnAdd = itemView.findViewById(R.id.btnAdd);
 }
}
}
