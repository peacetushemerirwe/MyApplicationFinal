package com.peace.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Smart extends AppCompatActivity {

    private RecyclerView recycle;
    private RecyclerView.Adapter adapt;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smarti);
        ArrayList<Items> itemlist=new ArrayList<>();
        itemlist.add(new Items(R.drawable.ic_phonelink_ring_black_24dp,"connecting", "Must wait"));
        itemlist.add(new Items(R.drawable.ic_settings_remote_black_24dp,"connecting remotely", "Use this app to know the type"));
        itemlist.add(new Items(R.drawable.ic_highlight_black_24dp,"lights on ", "Stay connected"));
        itemlist.add(new Items(R.drawable.ic_share_black_24dp,"share our app", "Thank you"));
        itemlist.add(new Items(R.drawable.ic_highlight_off_black_24dp,"Lghts off", "thanks for using our app"));


        recycle= findViewById(R.id.recycle);
        recycle.setHasFixedSize(true);
        manager= new LinearLayoutManager(this);
        adapt=new ItemAdapter(itemlist);
        recycle.setLayoutManager(manager);
        recycle.setAdapter(adapt);

    }
}

