package com.softvidia.chipfilter;

public class Filter {

    private String title;
    private String id;
    private int resId;
    private String tag;
    private boolean selected = false;

    public Filter(String title, String id, int resId, String tag, boolean selected) {
        this.title = title;
        this.id = id;
        this.resId = resId;
        this.tag = tag;
        this.selected = selected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isSelected() {

        return this.selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
