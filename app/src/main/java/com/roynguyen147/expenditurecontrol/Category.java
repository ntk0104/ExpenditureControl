package com.roynguyen147.expenditurecontrol;

public class Category {
    private int id;
    private String title;
    private int group_id;

    public Category(int id, String title, int group_id) {
        this.id = id;
        this.title = title;
        this.group_id = group_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
}
