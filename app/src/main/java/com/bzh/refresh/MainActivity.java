package com.bzh.refresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int TRANSITION_ANIM_DURATION = 300;
    public static final float TRANSITION_START_VAL = 0.0f;
    public static final float TRANSITION_END_VAL = 1.0f;

//    Handler mHandler = new Handler();
//    float mProgress = 0.0f;
//    private RefreshView refreshView;
//
//    Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            setProgress();
//
//            if (mProgress <= 1.0f) {
//                mHandler.postDelayed(this, 0);
//            } else {
//            }
//        }
//    };
//
//    private void setProgress() {
//        mProgress += 0.01;
//        refreshView.setTransitionProgress(mProgress);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
//
//        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                refreshView.resetValues();
//                mProgress = 0.0f;
//                mHandler.removeCallbacks(runnable);
//                mHandler.post(runnable);
//            }
//        });

        refreshLayout.setOnRefreshListener(new RefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(MainActivity.this, "刷新回调被调用了", Toast.LENGTH_SHORT).show();
            }
        });

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            strings.add("我是别志华" + i);
        }

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings));

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshLayout.setRefreshing(true);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshLayout.setRefreshing(false);
            }
        });
    }
}
