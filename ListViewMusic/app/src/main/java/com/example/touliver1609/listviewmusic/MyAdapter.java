package com.example.touliver1609.listviewmusic;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter {

    Activity context;
    int resource;
    ArrayList<Song> list;
    public MyAdapter(Activity context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.list = objects;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(R.layout.custom_row,null);

        ImageView imgicon = row.findViewById(R.id.imageView);
        TextView txtname = row.findViewById(R.id.txtName);
        TextView txtartist =row.findViewById(R.id.txtArtist);

        Song s = list.get(position);
        imgicon.setImageResource(s.getIcon());
        txtname.setText(s.getName());
        txtartist.setText(s.getArtist());

        return row;

    }
}
