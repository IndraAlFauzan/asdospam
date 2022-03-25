package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class home extends AppCompatActivity {

    EditText nama, email, pass, repass;
    Button regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nama = findViewById(R.id.edh_name);
        email = findViewById(R.id.edh_email);
        pass = findViewById(R.id.edh_pass);
        repass = findViewById(R.id.edh_repwd);
        regis = findViewById(R.id.bt_register);


        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nama.getText().toString().isEmpty() || email.getText().toString().isEmpty()){
                  nama.setError("Masukan Nama");
                  email.setError("Masukan Email");
                }
                else if (!pass.getText().toString().equals(repass.getText().toString())){

                    Toast toast= Toast.makeText(getApplicationContext(),
                            "Password Salah "  , Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
                else{

                    Bundle b = new Bundle();
                    //key parsing data dimasukan kedalam bundle
                    b.putString("a", nama.getText().toString().trim());
                    Intent intent = new Intent(getApplicationContext(), Register.class);
                    intent.putExtras(b);
                    Toast toast= Toast.makeText(getApplicationContext(),
                            "Login Berhasil"  , Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();

                    startActivity(intent);
                }
            }
        });

    }

}