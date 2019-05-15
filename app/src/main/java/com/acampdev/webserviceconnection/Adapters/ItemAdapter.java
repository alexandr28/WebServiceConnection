package com.acampdev.webserviceconnection.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.acampdev.webserviceconnection.POJO.Item;
import com.acampdev.webserviceconnection.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    List<Item> itemList;
    Context context;
    public ItemAdapter(List<Item> itemList,Context context){
        this.itemList=itemList;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.title.setText(itemList.get(position).getName());
        viewHolder.social.setText(itemList.get(position).getSocialNetwork());
        Picasso.get().load(itemList.get(position).getImage()).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, social;
        ImageView imageView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView= itemView.findViewById(R.id.cardView);
            title=itemView.findViewById(R.id.title);
            social=itemView.findViewById(R.id.txtSocial);
            imageView=itemView.findViewById(R.id.image);
        }
    }

}
