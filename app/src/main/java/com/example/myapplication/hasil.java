package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class hasil extends AppCompatActivity {

    TextView Task,Jenis,Lama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        Task = findViewById(R.id.tf_task);
        Jenis = findViewById(R.id.tf_jenistask);
        Lama = findViewById(R.id.tf_lama);

        Bundle bundle = getIntent().getExtras();

        String task = bundle.getString("a");
        String jenis = bundle.getString("b");
        String lama = bundle.getString("c");

        Task.setText(task);
        Jenis.setText(jenis);
        Lama.setText(lama);
    }
}