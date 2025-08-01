package com.example.arassignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arassignment.model.Drill;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button startButton;
    private List<Drill> drillList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.drill_spinner);
        startButton = findViewById(R.id.btn_start);

        drillList = Arrays.asList(
                new Drill("Drill 1", R.drawable.drill1, "Drill 1 Description", "Tip 1"),
                new Drill("Drill 2", R.drawable.drill2, "Drill 2 Description", "Tip 2"),
                new Drill("Drill 3", R.drawable.drill3, "Drill 3 Description", "Tip 3")
        );
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                drillList.stream().map(d -> d.name).toArray(String[]::new));
        spinner.setAdapter(adapter);

        startButton.setOnClickListener(v -> {
            int index = spinner.getSelectedItemPosition();
            Drill selected = drillList.get(index);
            Intent intent = new Intent(this, DrillActivity.class);
            intent.putExtra("drill_name", selected.name);
            intent.putExtra("drill_image", selected.imageResId);
            intent.putExtra("drill_desc", selected.description);
            intent.putExtra("drill_tips", selected.tips);
            startActivity(intent);
        });
    }
    }
