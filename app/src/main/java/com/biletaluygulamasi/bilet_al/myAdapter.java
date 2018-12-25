package com.biletaluygulamasi.bilet_al;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder>{

    private List<list_item> listItems;
    private Context context;

    public myAdapter(List<list_item> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

     final list_item listItem = listItems.get(position);
     holder.textViewSaat.setText(listItem.getSaat());
     holder.textViewFiyat.setText(listItem.getFiyat());

        Picasso.with(context).load(listItem.getResim()).into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "you click"+listItem.getFiyat(),Toast.LENGTH_LONG).show();
                Intent ıntent3 = new Intent(context,KoltukSecimActivity.class);
                ıntent3.putExtra("fiyat",listItem.getFiyat());
                ıntent3.putExtra("saat",listItem.getSaat());
                ıntent3.putExtra("resim",listItem.getResim());
                context.startActivity(ıntent3);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewSaat;
        public TextView textViewFiyat;
        public ImageView imageView;
        public LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewSaat = (TextView) itemView.findViewById(R.id.textViewSaat);
            textViewFiyat = (TextView) itemView.findViewById(R.id.textViewFiyat);
            imageView = itemView.findViewById(R.id.imageView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }

}
