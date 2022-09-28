package com.nandaiqbalh.aplikasimodul1kel15;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.nandaiqbalh.aplikasimodul1kel15.helper.listadapter.AnggotaAdapter;


public class MainActivity extends AppCompatActivity {

    private TextView tvNameMain;
    private Button btnLogoutMain;

    private ListView anggotaListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init
        initView();

        // get data from intent
        getDataFromIntent();

        // logout
        mainButton();

        // show list item
        displayListAnggota();
    }

    private void initView() {
        tvNameMain = findViewById(R.id.tvNameMain);
        btnLogoutMain = findViewById(R.id.btnLogoutMain);

        anggotaListView = findViewById(R.id.lv_anggota);
    }

    private void getDataFromIntent() {
        String username = getIntent().getStringExtra("name");
        tvNameMain.setText(username + "!");
    }

    // button triggered
    private void mainButton() {

        btnLogoutMain.setOnClickListener(view -> showAlertDialog());

    }


    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setMessage("Apa kalian ingin Logout?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent login = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(login);
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void displayListAnggota() {
        String namaList[] = {"Nanda Iqbal Hanafi", "Alya Zahra Fatikha", "Anggi Nikmatun Zahra", "Novita Auliya"};
        String nimList[] = {"21120120130109", "21120120140056", "21120120120008", "21120120140114"};

        AnggotaAdapter customAdapter = new AnggotaAdapter(getApplicationContext(), namaList, nimList);
        anggotaListView.setAdapter(customAdapter);
    }
}

