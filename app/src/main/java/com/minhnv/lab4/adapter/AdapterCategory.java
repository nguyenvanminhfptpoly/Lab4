package com.minhnv.lab4.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minhnv.lab4.R;
import com.minhnv.lab4.model.Categoryy;
import com.minhnv.lab4.model.Links;
import com.minhnv.lab4.ultil.OnItemListener;

import java.util.List;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.Viewhodel> {
    public List<Categoryy> categoryys;
    public Context context;
    OnItemListener onItemListener;

    public AdapterCategory(List<Categoryy> categoryys, Context context,OnItemListener onItemListener) {
        this.categoryys = categoryys;
        this.context = context;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public Viewhodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
       View v = layoutInflater.inflate(R.layout.item_category,viewGroup,false);
        return new Viewhodel(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhodel viewhodel,final int i) {
       final Categoryy categoryy = categoryys.get(i);
       viewhodel.tvTitle.setText(categoryy.getName());
       viewhodel.contr_cates.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onItemListener.OnItemlistener(i);
           }
       });
    }

    @Override
    public int getItemCount() {
        return categoryys.size();
    }

    public static class Viewhodel extends RecyclerView.ViewHolder{
    public TextView tvTitle;
    public ConstraintLayout contr_cates;
        public Viewhodel(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            contr_cates = itemView.findViewById(R.id.contr_cates);
        }
    }
}
