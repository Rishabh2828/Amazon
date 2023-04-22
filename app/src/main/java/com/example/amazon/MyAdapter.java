package com.example.amazon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewHolder>  {

    ArrayList<ModelClass> list;

    Context context;

    public MyAdapter(ArrayList<ModelClass> list, Context context) {
        this.list = list;
        this.context = context;

    }

    public void filterList(ArrayList<ModelClass> filterlist) {
        // below line is to add our filtered
        // list in our course array list.
        list = filterlist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_category, parent , false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ModelClass modelClass = list.get(position);
        Glide.with(context)
                .load(modelClass.getImg())
                .into(holder.imageView);
        holder.textView.setText(modelClass.getText());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DescriptionActivity.class);
                intent.putExtra("image_resource_id", modelClass.getImg());
                intent.putExtra("name", modelClass.getText());
                 intent.putExtra("desc1", modelClass.getDesc1());
                 intent.putExtra("desc2", modelClass.getDesc2());
                 intent.putExtra("desc3", modelClass.getDesc3());
                 intent.putExtra("desc4", modelClass.getDesc4());
                 intent.putExtra("price", modelClass.getPrice());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }






    public  class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.sample_image);
            textView = itemView.findViewById(R.id.sample_text);
        }
    }
}
