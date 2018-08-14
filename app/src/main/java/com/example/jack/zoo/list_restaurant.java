package com.example.jack.zoo;

public class list_restaurant
{
    private String name;
    private String location;
    private int img;
    public list_restaurant(int img,String name,String location)
    {
        this.img = img;
        this.name = name;
        this.location = location;
    }
    public void set_Img(int img)
    {
        this.img = img;
    }
    public void set_Name(String name)
    {
        this.name = name;
    }
    public  void  set_Lacation(String location)
    {
        this.location = location;
    }
    public int get_Img()
    {
        return img;
    }
    public String get_Name() {
        return name;
    }
    public String get_Location() {
        return location;
    }
}
