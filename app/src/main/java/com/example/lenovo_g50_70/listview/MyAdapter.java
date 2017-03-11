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
        View view;
        ViewHolder viewHolder;
        if(convertView==null){//converView用于缓存已加载的布局，此处不重复加载布局
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.girlImage= (ImageView) view.findViewById(R.id.iv);
            viewHolder.girlName= (TextView) view.findViewById(R.id.tv);
            view.setTag(viewHolder);//将ViewHolder存储在View中
        }else{
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();//重新获取ViewHolder
        }
        viewHolder.girlImage.setImageResource(girl.getImage());
        viewHolder.girlName.setText(girl.getName());
        return view;
    }
    class ViewHolder{//新增内部类用于对控件的实例缓存
        ImageView girlImage;
        TextView girlName;
    }
}
