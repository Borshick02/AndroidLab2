package com.example.recyclerviewapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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
        itemList.add(new Item("клубничный котик", "съел всю клубнику с грядки ", R.drawable.item1));
        itemList.add(new Item("кот бонсай", "Приносит богатство", R.drawable.item2));

        adapter = new ItemAdapter(this, itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        addButton.setOnClickListener(v -> showAddItemDialog());
    }

    private void showAddItemDialog() {
        // Создаем диалоговое окно
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Добавить новый элемент");

        // Создаем пользовательский макет для ввода
        final EditText inputTitle = new EditText(this);
        inputTitle.setHint("Введите имя");
        final EditText inputDescription = new EditText(this);
        inputDescription.setHint("Введите описание");

        // Используем LinearLayout для размещения двух EditText
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(inputTitle);
        layout.addView(inputDescription);
        builder.setView(layout);

        // Добавляем кнопки диалога
        builder.setPositiveButton("Добавить", (dialog, which) -> {
            String title = inputTitle.getText().toString().trim();
            String description = inputDescription.getText().toString().trim();

            if (!title.isEmpty() && !description.isEmpty()) {
                // Добавляем новый элемент в список
                itemList.add(new Item(title, description, R.drawable.item3));
                adapter.notifyItemInserted(itemList.size() - 1);
            } else {
                Toast.makeText(this, "Имя и описание не должны быть пустыми", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Отмена", (dialog, which) -> dialog.cancel());

        // Показываем диалог
        builder.show();
    }
}
