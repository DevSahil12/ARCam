package com.example.arassignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class DrillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill);
        Intent intent = getIntent();

        ((TextView) findViewById(R.id.drill_name)).setText(intent.getStringExtra("drill_name"));
        ((ImageView) findViewById(R.id.drill_image)).setImageResource(intent.getIntExtra("drill_image", 0));
        ((TextView) findViewById(R.id.drill_desc)).setText(intent.getStringExtra("drill_desc"));
        ((TextView) findViewById(R.id.drill_tips)).setText(intent.getStringExtra("drill_tips"));

        findViewById(R.id.btn_launch_ar).setOnClickListener(v -> {
            startActivity(new Intent(this, ARActivity.class));
        });
    }
}


