package com.example.mytodolistapps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    EditText edtUsername, edtPassword, edtGmail;
    Button btnBuatAkun, btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtGmail = (EditText) findViewById(R.id.edtGmail);

        btnBuatAkun = (Button) findViewById(R.id.btnBuatAkun);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        // Buat Akun Dan Simpan Ke Local Storage
        btnBuatAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputUsername = edtUsername.getText().toString();
                String inputPassword = edtPassword.getText().toString();
                String inputGmail = edtGmail.getText().toString();

                if (inputUsername.isEmpty() || inputPassword.isEmpty() || inputGmail.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Tidak Boleh Ada Yang Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    // menggunakan sharedpreference untuk akses local storage
                    SharedPreferenceHelper sph = new SharedPreferenceHelper(MainActivity2.this);
                    // memasukan data
                    sph.InsertAccountData(inputUsername, inputPassword);
                    Toast.makeText(MainActivity2.this, "Akun Berhasil Untuk Dibuat", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Kembali ke halaman login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}