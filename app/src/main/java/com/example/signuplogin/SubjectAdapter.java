package com.example.signuplogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {

    private List<Subject> subjectList;

    public SubjectAdapter(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subject_item, parent, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        Subject subject = subjectList.get(position);
        holder.tvName.setText(subject.getName());
        holder.tvForm.setText(subject.getForm());
        holder.itemView.setOnClickListener(v -> {
            Fragment fragment = new BagrutFragment();
            Bundle bundle = new Bundle();
            bundle.putString("subjectId", subject.getId()); // or name if using name as doc ID
            fragment.setArguments(bundle);

            ((FragmentActivity) v.getContext())
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.FrameLayoutsMain, fragment)
                    .addToBackStack(null).commit();
        });
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    public static class SubjectViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvForm;

        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvSubjectName);
            tvForm = itemView.findViewById(R.id.tvForm);
        }
    }
}