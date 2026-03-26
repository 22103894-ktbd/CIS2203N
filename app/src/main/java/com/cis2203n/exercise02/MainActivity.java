package com.cis2203n.exercise02;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.cis2203n.exercise02.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private ActivityMainBinding binding;
    List<Item> itemList;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        itemList = new ArrayList<>();
        itemList.add(new Item("Coke", 20));
        itemList.add(new Item("Sprite", 18));
        itemList.add(new Item("Royal", 15));
        adapter = new ItemAdapter(itemList, this::updateTotal);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        updateTotal();
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void updateTotal(){
        double total = 0;
        for(Item item : itemList){
            total += item.price * item.quantity;
        }
        binding.tvTotal.setText("Total: ₱" + String.format("%.2f", total));
    }
}