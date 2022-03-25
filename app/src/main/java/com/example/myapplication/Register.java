package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Register extends AppCompatActivity {

    TextView Email,Task, JenisTask,Lamatask;
    FloatingActionButton fab;
    private Spinner spinner;
    private static final String[] paths = {"item 1", "item 2", "item 3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        Task = findViewById(R.id.et_task);
        JenisTask = findViewById(R.id.et_jenistask);
        Lamatask = findViewById(R.id.et_lamatask);
        Email = findViewById(R.id.tf_parsing);

        fab = findViewById(R.id.floatingActionButton);

        Bundle bundle = getIntent().getExtras();

        String email = bundle.getString("a");
        String password = bundle.getString("b");

        Email.setText(email);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.mnDaftar){
            validate();
        }
        else {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void validate(){
        if (Task.getText().toString().isEmpty() && JenisTask.getText().toString().isEmpty() &&Lamatask.getText().toString().isEmpty() ){
            Toast toast= Toast.makeText(getApplicationContext(),
                    "Isi Semua Data "  , Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }
        else if (Task.getText().toString().isEmpty() ){
            Task.setError("Masukan Task!");
        }
        else if (JenisTask.getText().toString().isEmpty() ){
            JenisTask.setError("Jenis Task!");
        }
        else if (Lamatask.getText().toString().isEmpty() ){
            Lamatask.setError("Lama Task!");
        }
        else{

            Bundle b = new Bundle();
            //key parsing data dimasukan kedalam bundle
            b.putString("a", Task.getText().toString().trim());
            b.putString("b", JenisTask.getText().toString().trim());
            b.putString("c", Lamatask.getText().toString().trim());
            Intent i  = new Intent(getApplicationContext(), hasil.class);
            i.putExtras(b);
            startActivity(i);
            Toast toast= Toast.makeText(getApplicationContext(),
                    "Berhasil"  , Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }
    }
}