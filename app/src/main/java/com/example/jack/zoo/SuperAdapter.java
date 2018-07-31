package com.example.jack.zoo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SuperAdapter extends BaseAdapter {//BaseAdapter:android內建基本函式   superAdapter

    Context context;//context:說明superAdapter內容格式
    List<item> rowItems;
    SuperAdapter(Context context, List<item> rowItems) {
        this.context  = context;
        this.rowItems = rowItems;}

    public int getCount(){return rowItems.size();};
    public Object getItem(int position){return rowItems.get(position);};
    public long getItemId(int position){return rowItems.indexOf(getItem(position));};

    private class ViewHolder {//記住item長什麼樣子 緩衝區的內容
        ImageView img;
        TextView name;
        TextView place;
    }


    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        LayoutInflater mInflater = LayoutInflater.from(context);
        convertView = mInflater.inflate(R.layout.activity_animal_list_form, null);
        holder = new ViewHolder();
        holder.name = (TextView) convertView.findViewById(R.id.textView9);
        holder.place = (TextView) convertView.findViewById(R.id.textView14);
        holder.img = (ImageView) convertView.findViewById(R.id.imageView2);
        item pos = rowItems.get(position);
        holder.place.setText(pos.getplace());
        holder.name.setText(pos.getname());
        convertView.setTag(holder);
        return convertView;
    };



}
