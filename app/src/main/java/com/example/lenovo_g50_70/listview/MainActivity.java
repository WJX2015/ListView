package com.example.lenovo_g50_70.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<Girl> girlList;
    private MyAdapter adapter;
    private int cons[]={R.drawable.image01,R.drawable.image02,R.drawable.image03,
            R.drawable.image04,R.drawable.image05,R.drawable.image06,
            R.drawable.image07,R.drawable.image08,R.drawable.image09,
            R.drawable.image10,R.drawable.image11,R.drawable.image12};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddListData();
        initView();
    }
    private void AddListData() {
        girlList=new ArrayList<Girl>();
        for(int i=0;i<cons.length;i++){
            Girl girl =new Girl("Girl"+(i+1),cons[i]);
            girlList.add(girl);
        }
    }

    private void initView() {
        lv = (ListView) findViewById(R.id.listView);
        adapter =new MyAdapter(MainActivity.this,R.layout.list_item,girlList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Girl girl=girlList.get(position);
                Toast.makeText(MainActivity.this,girl.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
