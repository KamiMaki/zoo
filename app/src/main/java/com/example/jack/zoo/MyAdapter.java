package com.example.jack.zoo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

class MyAdapter extends BaseAdapter {
    LayoutInflater myInflater;
    Context context;
    List<list_restaurant> list_restaurants;
    MyAdapter(Context context, List<list_restaurant> list_restaurants){
        myInflater = LayoutInflater.from(context);
        this.context = context;
        this.list_restaurants = list_restaurants;
    }

    @Override
    public int getCount() {
        return list_restaurants.size();
    }

    @Override
    public Object getItem(int position) {
        return list_restaurants.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list_restaurants.indexOf(getItem(position));
    }
    public class ViewHolder {
        ImageButton img;
        TextView tv_name;
        TextView tv_location;
        public ViewHolder(ImageButton img,TextView tv_name, TextView tv_location){
            this.img = img;
            this.tv_name = tv_name;
            this.tv_location = tv_location;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyAdapter.ViewHolder holder;
        myInflater = LayoutInflater.from(context);
            convertView = myInflater.inflate(R.layout.activity_list_restaurant, null);
            holder = new MyAdapter.ViewHolder((ImageButton) convertView.findViewById(R.id.imageButton2),
                    (TextView) convertView.findViewById(R.id.textView),
                    (TextView) convertView.findViewById(R.id.textView2)
            );
        list_restaurant pos = list_restaurants.get(position);
        holder.img.setImageResource(pos.get_Img());
        holder.tv_name.setText(pos.get_Name());
        holder.tv_location.setText(pos.get_Location());
        convertView.setTag(holder);
        return convertView;
    }
}