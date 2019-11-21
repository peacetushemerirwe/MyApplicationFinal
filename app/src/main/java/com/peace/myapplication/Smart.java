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
        itemlist.add(new Items(R.drawable.ic_phonelink_ring_black_24dp,"contact_us", "o754536512"));
        itemlist.add(new Items(R.drawable.ic_settings_remote_black_24dp,"google keep", "Use this app to keep data"));
        itemlist.add(new Items(R.drawable.ic_highlight_black_24dp,"lights on ", "use this app to control lights"));
        itemlist.add(new Items(R.drawable.ic_share_black_24dp,"share our app", "Thank you"));
        itemlist.add(new Items(R.drawable.ic_highlight_off_black_24dp,"hangouts", "thanks for using our app"));
        itemlist.add(new Items(R.drawable.ic_get_app_black_24dp,"share our app", "Thank you"));
        itemlist.add(new Items(R.drawable.ic_inbox_black_24dp,"hangouts", "thanks for using our app"));
        itemlist.add(new Items(R.drawable.ic_insert_comment_black_24dp,"share our app", "Thank you"));
        itemlist.add(new Items(R.drawable.ic_inbox_black_24dp,"hangouts", "thanks for using our app"));
        itemlist.add(new Items(R.drawable.ic_share_black_24dp,"share our app", "Thank you"));
        itemlist.add(new Items(R.drawable.ic_delete_black_24dp,"hangouts", "thanks for using our app"));
        itemlist.add(new Items(R.drawable.ic_info_black_24dp,"share our app", "Thank you"));
        itemlist.add(new Items(R.drawable.ic_highlight_off_black_24dp,"hangouts", "thanks for using our app"));


        recycle= findViewById(R.id.recycle);
        recycle.setHasFixedSize(true);
        manager= new LinearLayoutManager(this);
        adapt=new ItemAdapter(itemlist);
        recycle.setLayoutManager(manager);
        recycle.setAdapter(adapt);

    }
}

