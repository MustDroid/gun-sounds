package com.emokehajdu.gunsounds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private GunsAdapter mAdapter;
    private RecyclerView gunsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createGunsAdapter();
    }

    private void createGunsAdapter() {
        gunsRecyclerView = findViewById(R.id.gunsRecyclerView);
        mAdapter = new GunsAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        gunsRecyclerView.setLayoutManager(mLayoutManager);
        gunsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        gunsRecyclerView.setAdapter(mAdapter);
    }
}
