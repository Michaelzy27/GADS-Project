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

public class SkillIqLeaderAdapter extends RecyclerView.Adapter<SkillIqLeaderAdapter.ViewHolder> {

    List<SkillListModel> skillModelList; // = new ArrayList<>();

    public SkillIqLeaderAdapter(List<SkillListModel> listModelList) {
        this.skillModelList = listModelList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView titleText, summaryText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.skillImageView);
            titleText = itemView.findViewById(R.id.skillTitleText);
            summaryText = itemView.findViewById(R.id.skillSummaryText);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skilliq_leaders_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillListModel model = skillModelList.get(position);

        logInfo(model.getNameText());
        holder.titleText.setText(model.getNameText());
        holder.summaryText.setText(model.getHoursText());
        holder.imageView.setImageResource(R.drawable.skilltrimmed);

    }

    @Override
    public int getItemCount() {
        return skillModelList.size();
    }

    public void addLearners(SkillListModel listModel) {
        skillModelList.add(listModel);
        notifyDataSetChanged();
    }

    public void logInfo(String text) {
        Log.i("info ", text);
    }
}
