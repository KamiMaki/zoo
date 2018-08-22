package com.example.jack.zoo;

import java.io.Serializable;

public class list_menu implements Serializable
{
    private String name;
    private int price;
    private int img;
    public list_menu(int img,String name,int price)
    {
        this.img = img;
        this.name = name;
        this.price = price;
    }
    public void set_Img(int img)
    {
        this.img = img;
    }
    public void set_Name(String name)
    {
        this.name = name;
    }
    public  void  set_Price(int price)
    {
        this.price = price;
    }
    public int get_Img()
    {
        return img;
    }
    public String get_Name() {
        return name;
    }
    public int get_Price() {
        return price;
    }

}
