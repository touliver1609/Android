package com.example.touliver1609.listviewmusic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<Song> list = new ArrayList<Song>();
    ListView listViewSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(new Song("Boulevard","Dan Byrd",R.drawable.boulevard));
        list.add(new Song("Happy New Year","Abba",R.drawable.happy_new_year));
        list.add(new Song("Right Here Waiting","Richard Marx",R.drawable.right_here_waiting));
        list.add(new Song("That's Why","Michael Learns To Rock",R.drawable.thats_why));
        list.add(new Song("While Your Lips Are Still Red","Nightwish ",R.drawable.while_your_lips_are_still_red));

        MyAdapter adapter = new MyAdapter(this,R.layout.custom_row,list);

        listViewSong = findViewById(R.id.lvwSong);
        listViewSong.setAdapter(adapter);

        listViewSong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, list.get(position).getName().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
