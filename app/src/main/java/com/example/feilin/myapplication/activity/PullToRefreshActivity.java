package com.example.feilin.myapplication.activity;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.feilin.myapplication.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PullToRefreshActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private final static int COMPLETE_REFRESH = 0x1010;
    private SwipeRefreshLayout layout;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> datas = new ArrayList<>(Arrays.asList("Java", "JavaScript", "C++", "Python", "Ruby", "HTML"));

    private Handler handler = new Handler() {

        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case COMPLETE_REFRESH:
                    datas.addAll(Arrays.asList("Bitmap", "CSS", "Canvas"));
                    adapter.notifyDataSetChanged();
                    layout.setRefreshing(false);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh);

        listView = (ListView) findViewById(R.id.swipe_list);
        layout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);

        layout.setOnRefreshListener(this);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        //Toast.makeText(this, "下拉刷新", Toast.LENGTH_SHORT).show();
        handler.sendEmptyMessageDelayed(COMPLETE_REFRESH, 2000);
    }
}

