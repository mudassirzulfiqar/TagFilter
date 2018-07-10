package com.softvidia.chipfilter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by moodi on 19/06/2017.
 */

public class ChipAdapter extends RecyclerView.Adapter<ChipAdapter.ViewHolder> {

    Context context;
    ArrayList<Filter> tagslists;
    onTagsCallback callback;
    private int selectedIndex;

    public ChipAdapter(Context context, ArrayList<Filter> tags) {
        this.context = context;
        this.tagslists = tags;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void addFilterSelect(onTagsCallback callback) {
        this.callback = callback;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView filterImg;
        TextView filterTitle;
        LinearLayout chip;

        ViewHolder(View itemView) {
            super(itemView);

            filterImg = (ImageView) itemView.findViewById(R.id.filter_img);
            filterTitle = (TextView) itemView.findViewById(R.id.filter_text);
            chip = (LinearLayout) itemView.findViewById(R.id.main);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chip_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Filter tag = tagslists.get(position);

        holder.filterTitle.setText(tag.getTitle());
        holder.filterImg.setImageDrawable(ContextCompat.getDrawable(context, tag.getResId()));

        if (tag.isSelected()) {
            selectedIndex = position;
            holder.chip.setBackground(ContextCompat.getDrawable(context, R.drawable.chip_selected));
        } else {
            holder.chip.setBackground(ContextCompat.getDrawable(context, R.drawable.chip_deselect));
        }

        holder.chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (callback != null) {

                    if (selectedIndex == position) {
                        return;
                    }

                    tag.setSelected(true);

                    tagslists.get(selectedIndex).setSelected(false);

                    notifyDataSetChanged();
                    callback.onChipClicked(tag, position);
                }

//                tagslists.remove(tag);
//                notifyItemRemoved(position);
//
//                notifyItemRangeChanged(position, getItemCount());

            }
        });

    }

    @Override
    public int getItemCount() {
        return tagslists.size();
    }

    public interface onTagsCallback {
        void onChipClicked(Filter tag, int position);
    }

}
