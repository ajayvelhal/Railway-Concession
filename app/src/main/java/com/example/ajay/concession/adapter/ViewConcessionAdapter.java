package com.example.ajay.concession.adapter;

import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ajay.concession.R;
import com.example.ajay.concession.models.ViewConcessionStud;
import com.example.ajay.concession.utils.RetrofitUtils;
import com.example.ajay.concession.utils.SharedPreference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajay on 2/2/2018.
 */

public class ViewConcessionAdapter extends RecyclerView.Adapter<ViewConcessionAdapter.MyViewHolder> {

    ArrayList<ViewConcessionStud> list;
    View view;

    public ViewConcessionAdapter(ArrayList<ViewConcessionStud> list)     {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.concession_item,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ViewConcessionStud concess=list.get(position);
        holder.Source.setText(concess.getSource());
        holder.Destination.setText(concess.getDestination());
        holder.Class.setText(concess.getClss());
        holder.NoOfMonths.setText(concess.getNoOfMonths());
        holder.TokenNo.setText(concess.getToken());    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name,Source,Destination,Class,NoOfMonths,TokenNo;
        Button Cancel;
        SharedPreference pref;
        public MyViewHolder(View view) {
            super(view);

            Name=(TextView) view.findViewById(R.id.viewname);
            Source=(TextView) view.findViewById(R.id.viewsource);
            Destination=(TextView) view.findViewById(R.id.viewdest);
            Class=(TextView) view.findViewById(R.id.viewclss);
            NoOfMonths=(TextView)  view.findViewById(R.id.viewnom);
            TokenNo=(TextView) view.findViewById(R.id.viewtoken);

            pref = new SharedPreference(view.getContext());

            Name.setText(pref.getName());

        }
    }
}
