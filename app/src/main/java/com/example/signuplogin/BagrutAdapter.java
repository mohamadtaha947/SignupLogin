package com.example.signuplogin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BagrutAdapter extends RecyclerView.Adapter<BagrutAdapter.ViewHolder> {

    private List<Bagrut> bagrutList;
    private Context context;

    public BagrutAdapter(List<Bagrut> bagrutList, Context context) {
        this.bagrutList = bagrutList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bagrut_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bagrut bagrut = bagrutList.get(position);
        holder.tvMoed.setText("מועד " + bagrut.getMoed());
        holder.tvSemester.setText("סמסטר: " + bagrut.getSemester());

        holder.btnDownloadExam.setOnClickListener(v -> downloadFile(bagrut.getBagrutFileUrl()));
        holder.btnDownloadSolution.setOnClickListener(v -> downloadFile(bagrut.getSolutionFileUrl()));
    }

    private void downloadFile(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return bagrutList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMoed, tvSemester;
        Button btnDownloadExam, btnDownloadSolution;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMoed = itemView.findViewById(R.id.tvMoed);
            tvSemester = itemView.findViewById(R.id.tvSemester);
            btnDownloadExam = itemView.findViewById(R.id.btnDownloadExam);
            btnDownloadSolution = itemView.findViewById(R.id.btnDownloadSolution);
 }
}
}
