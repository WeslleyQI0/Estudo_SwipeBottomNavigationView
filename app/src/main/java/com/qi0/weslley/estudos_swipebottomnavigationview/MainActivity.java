package com.qi0.weslley.estudos_swipebottomnavigationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.qi0.weslley.estudos_swipebottomnavigationview.helper.BottomNavigationBehaviour;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private CoordinatorLayout rootLayout;
    private List<String> stringList = new ArrayList<>();
    private RecyclerView recyclerView;
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    BottomNavigationBehaviour.removeBadge(navigation, R.id.navigation_notifications);
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //rootLayout = findViewById(R.id.rootLayout);
        recyclerView = findViewById(R.id.rv);

        mTextMessage = findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationBehaviour.showBadge(this,navigation, R.id.navigation_notifications, "2");

        getData();
    }

    private void getData() {
        for (int i=0; i<100; i++){
            stringList.add(new StringBuilder("Item ").append(i+1).toString());
            MyAdapter myAdapter = new MyAdapter(this, stringList);
            recyclerView.setAdapter(myAdapter);
        }
    }

}
