package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    //inisialisasi
    EditText et_name, et_password;
    Button login;
    TextView regis;
    String name,password;
    String isiName = "Pascal";
    String isiPassword = "iniPascal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);


        regis = findViewById(R.id.textView4);
        et_name = findViewById(R.id.etName);
        et_password = findViewById(R.id.etpassword);
        login = findViewById(R.id.bt_signin);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(getApplicationContext(), home.class);
                //memasukan bundle kedalam intent
                //berpindah ke halaman lain
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasi();
            }
        });




    }



    public  void validasi(){
        name = et_name.getText().toString();
        password = et_password.getText().toString();

        if(name.isEmpty() ) {

            et_name.setError("Name Diperlukan");

        }
        else if(password.isEmpty()){
            et_password.setError("Password Diperlukan");
        }

        else{

             if (!name.equals(isiName) && !password.equals(isiPassword)){
                Toast toast= Toast.makeText(getApplicationContext(),
                        "Email dan Password Salah "  , Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
            else if(!name.equals(isiName) ){
               Toast toast= Toast.makeText(getApplicationContext(),
                       "Nama Salah "  , Toast.LENGTH_LONG);
               toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
               toast.show();
            }
           else if(!password.equals(isiPassword)){
               Toast toast= Toast.makeText(getApplicationContext(),
                       "Password Salah "  , Toast.LENGTH_LONG);
               toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
               toast.show();
           }

           else {
               Bundle b = new Bundle();
               //key parsing data dimasukan kedalam bundle
               b.putString("a", name.trim());


               //membuat objek untuk pindah halaman
               Intent i  = new Intent(getApplicationContext(), Register.class);
               //memasukan bundle kedalam intent
               i.putExtras(b);
               //berpindah ke halaman lain
               startActivity(i);
               Toast toast= Toast.makeText(getApplicationContext(),
                       "Login Sukses "  , Toast.LENGTH_LONG);

               toast.show();
               //menghapus isi dari edittext
               et_name.getText().clear();
               et_password.getText().clear();
           }
        }

    }




}