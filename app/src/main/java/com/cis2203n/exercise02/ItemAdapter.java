package com.cis2203n.exercise02;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.cis2203n.exercise02.databinding.ItemCartBinding;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    List<Item> itemList;
    OnQuantityChangeListener listener;
    public interface OnQuantityChangeListener{
        void onQuantityChanged();
    }

    public ItemAdapter(List<Item> itemList, OnQuantityChangeListener listener){
        this.itemList = itemList;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ItemCartBinding binding;
        public ViewHolder(ItemCartBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        ItemCartBinding binding = ItemCartBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        Item item = itemList.get(position);
        holder.binding.tvName.setText(item.name);
        holder.binding.tvPrice.setText("₱" + item.price);
        holder.binding.tvQty.setText(String.valueOf(item.quantity));
        holder.binding.btnPlus.setOnClickListener(v -> {
            item.quantity++;
            holder.binding.tvQty.setText(String.valueOf(item.quantity));
            listener.onQuantityChanged();
        });
        holder.binding.btnMinus.setOnClickListener(v ->{
            if(item.quantity > 0){
                item.quantity--;
                holder.binding.tvQty.setText(String.valueOf(item.quantity));
                listener.onQuantityChanged();
            }
        });
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }
}