package com.peace.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.NotificationManager;
//import androidx.fragment.app.FragmentManager;

//import android.app.Activity;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
//import android.content.BroadcastReceiver;
//import android.content.Context;
import android.content.Context;
import android.content.Intent;
//import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Set<BluetoothDevice> pairedDevices;
    private BluetoothAdapter bAdapter;
    public static int REQUEST_BLUETOOTH = 1;
    private ArrayAdapter<String> aAdapter;
    private ArrayAdapter<String> newDevicesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         bAdapter = BluetoothAdapter.getDefaultAdapter();


        //setResult(Activity.RESULT_CANCELED);
        setContentView(R.layout.layout_main);


        Button enable=(Button)findViewById(R.id.enable);
        enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enableBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBT, REQUEST_BLUETOOTH);


            }
        });

        Button off = (Button)findViewById(R.id.off);
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bAdapter.disable();
                Toast.makeText(getApplicationContext(),"Bluetooth Turned OFF", Toast.LENGTH_SHORT).show();
                recreate();
            }
        });
        Button discoverable =(Button)findViewById(R.id.off1);
        discoverable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                getVisible.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 100);
                startActivityForResult(getVisible, 0);
                recreate();

            }
        });


        Button rbroadcast;
        rbroadcast=findViewById(R.id.paybtn);
        rbroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction("com.peace.myapplication.CUSTOM_INTENT");
                sendBroadcast(intent);
            }
        });
         Button searchdevices;
         searchdevices=findViewById(R.id.searchdevice);
         searchdevices.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(MainActivity.this,DeviceList.class));

             }
         });

        Button download;
        download=findViewById(R.id.button_download);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DownloadActivity.class));
            }
        });
        Button listactivity;
        listactivity=findViewById(R.id.list_activity);
        listactivity.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DeviceListActivity.class));

            }
        });

    }
    public void sendNotification(View view){
        NotificationCompat.Builder mBulder=new NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_light_sunny_black_24dp).setContentTitle("My notification").setContentText("Hollow");
        NotificationManager mNotificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(001,mBulder.build());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_share) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
