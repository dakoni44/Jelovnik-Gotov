package com.example.termin17_d.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.termin17_d.R;
import com.example.termin17_d.model.Jelo;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Activity activity;
    private List<Jelo> data;

    public MyAdapter(Activity activity, List<Jelo> data) {
        this.activity = activity;
        this.data = data;
    }

        @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=activity.getLayoutInflater().inflate(R.layout.my_single_item,null);
        }
        TextView tvNaziv=convertView.findViewById(R.id.lvNaziv);
        tvNaziv.setText(data.get(position).getNaziv());
        TextView tvCena=convertView.findViewById(R.id.lvCena);
        tvCena.setText(String.valueOf(data.get(position).getCena())+" dinara");
        return convertView;
    }
}
