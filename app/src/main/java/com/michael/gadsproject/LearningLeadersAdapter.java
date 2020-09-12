package com.michael.gadsproject;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {

    List<LearningListModel> learningModelList; // = new ArrayList<>();

    public LearningLeadersAdapter(List<LearningListModel> listModelList) {
        this.learningModelList = listModelList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView titleText, summaryText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.learningImageView);
            titleText = itemView.findViewById(R.id.learningTitleText);
            summaryText = itemView.findViewById(R.id.learningSummaryText);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learning_leaders_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LearningListModel model = learningModelList.get(position);

        logInfo(model.getNameText());
        holder.titleText.setText(model.getNameText());
        holder.summaryText.setText(model.getHoursText());
        holder.imageView.setImageResource(R.drawable.toplearner);

    }

    @Override
    public int getItemCount() {
        return learningModelList.size();
    }

    public void addLearners(LearningListModel listModel) {
        learningModelList.add(listModel);
          notifyDataSetChanged();
    }

    public void logInfo(String text) {
        Log.i("info ", text);
    }
}
