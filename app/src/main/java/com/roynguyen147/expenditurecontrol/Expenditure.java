package com.roynguyen147.expenditurecontrol;

public class Expenditure {
    private int id;
    private String title;
    private String time;
    private int money;
    private boolean type; // 0: pay and 1:earn
    private int category;

    public Expenditure(int id, String title, String time, int money, boolean type, int category) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.money = money;
        this.type = type;
        this.category = category;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
