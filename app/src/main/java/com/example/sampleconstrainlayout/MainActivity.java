package com.example.sampleconstrainlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk buttom//
    Button btnLogin;

    //Deklarasi variabel untuk EditText//
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password//
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan button pada layout
        btnLogin=findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan com[onen button pada layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan component button pada layout
        edpassword=findViewById(R.id.edPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();

                //Menyimpan input user di edtittext password kedalam variabel password
                password = edpassword.getText().toString();

                //menengeset email yang benar
                String email = "admin@email.com";

                //mengeset password yang benar
                String pass = "123";

                //mengecek apakah isi dari email dan password sudah sama dengan email dan
                //password yang sudah di set
                if (nama.equals(email) && password.equals(pass)) {

                    //Menyimpan variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                    Toast t = Toast.makeText(getApplicationContext(),
                            "email anda: " + nama + " danPassword anda: " + password + "", Toast.LENGTH_LONG);
                    //Menampilkan toast
                    t.show();

                    //membuat objek bundle
                    Bundle b = new Bundle();

                    //memasukan value dari variable nama dengan kunci "a"
                    //dan dimasukan kedalam bundle
                    b.putString("a", nama.trim());

                    //memasukan value dari variable password dengan kunci "b"
                    //dan dimasukan kedalam bundle
                    b.putString("b", password.trim());

                    //membuat objek intent berpindah activity dari mainactivity ke activityhasil
                    Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                    //memasukan bundle kedalam intent untuk dikirimkan ke activityHsil
                    i.putExtras(b);

                    //berpindah ke ActivityHasil
                    startActivity(i);
                } else {
                    //membuat variable toast dan membuat toast dan menampilkan pesan "Login gagal"

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Gagal", Toast.LENGTH_LONG);

                    //menampilkan toast
                    t.show();
                }
            }
        });
    }
}