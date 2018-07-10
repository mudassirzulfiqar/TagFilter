package com.softvidia.chipfilter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.ArrayList;

public class ChipFilter extends RecyclerView {

    private ChipAdapter chipAdapter;
    private ArrayList<Filter> filterList;
    private FilterSelect filterSelect;
    private Object selectedChip;

    public ChipFilter(Context context) {
        super(context);
    }


    public ChipFilter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ChipFilter(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public void init(Context context) {

        filterList = new ArrayList<>();

        initializeRecyclerview(context);

    }

    private void initializeRecyclerview(Context context) {
        chipAdapter = new ChipAdapter(context, filterList);
        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        this.setLayoutManager(verticalLayoutmanager);

        this.setAdapter(chipAdapter);

    }

    private void setListener() {
        if (filterSelect != null) {

            chipAdapter.addFilterSelect(new ChipAdapter.onTagsCallback() {
                @Override
                public void onChipClicked(Filter tag, int position) {
                    filterSelect.onSelect(tag);
                }
            });
        }
    }

    public void addFilter(Filter filter) {
        filterList.add(filter);
        if (chipAdapter != null) {
            chipAdapter.notifyDataSetChanged();
        }
    }

    public void addFilter(ArrayList<Filter> filterlist) {
        filterlist.clear();
        filterList.addAll(filterlist);
        if (chipAdapter != null) {
            chipAdapter.notifyDataSetChanged();
        }
    }

    public void setOnFilterSelectListener(FilterSelect filterSelect) {

        this.filterSelect = filterSelect;
        setListener();

    }

    public Filter getSelectedChip() {
        return this.filterList.get(chipAdapter.getSelectedIndex());
    }

    public interface FilterSelect {
        void onSelect(Filter tag);
    }
}
