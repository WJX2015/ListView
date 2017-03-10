package com.example.lenovo_g50_70.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo-G50-70 on 2017/3/3.
 */
public class MyAdapter extends ArrayAdapter<Girl> {
    private int resourceId;

    public MyAdapter(Context context, int textViewResourceId, List<Girl> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Girl girl=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView iv= (ImageView) view.findViewById(R.id.iv);
        TextView tv= (TextView) view.findViewById(R.id.tv);
        iv.setImageResource(girl.getImage());
        tv.setText(girl.getName());
        return view;
    }
}
