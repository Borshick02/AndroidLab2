package com.example.recyclerviewapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewapp.adapter.ItemAdapter;
import com.example.recyclerviewapp.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Item> itemList;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        Button addButton = findViewById(R.id.add_button);

        // Инициализация списка
        itemList = new ArrayList<>();
        itemList.add(new Item("Элемент 1", "Описание 1", R.drawable.item1));
        itemList.add(new Item("Элемент 2", "Описание 2", R.drawable.item2));

        adapter = new ItemAdapter(this, itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Обработчик клика кнопки
        addButton.setOnClickListener(v -> {
            itemList.add(new Item("Новый элемент", "Новое описание", R.drawable.item1));
            adapter.notifyItemInserted(itemList.size() - 1);
        });
    }
}
