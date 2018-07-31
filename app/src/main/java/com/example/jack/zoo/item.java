package com.example.jack.zoo;

public class item {
    private String name;
    private String place;
    private int iconnum;
    private String id;
    public item(String h_name, String h_place) {//說明格式(順序)
        this.name = h_name;
        this.place = h_place;
        this.iconnum = iconnum;
    }
    public String getname() {
        return name;
    }
    public String getplace() {
        return place;
    }
    public void setMember_name(String h_name) {
        this.name = h_name;
    }
    public int getIcon() {
        return iconnum;
    }
}
