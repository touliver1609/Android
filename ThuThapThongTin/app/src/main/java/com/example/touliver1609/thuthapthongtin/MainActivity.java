package com.example.touliver1609.thuthapthongtin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnXn;
    EditText editTextHoTen;
    CheckBox cbCsharp;
    CheckBox cbPython;
    CheckBox cbJava;
    CheckBox cbRuby;
    CheckBox cbCplusplus;
    RadioButton radLT;
    RadioButton radMang;
    String msg;
    String tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnXn = findViewById(R.id.btnXacNhan);
        editTextHoTen = findViewById(R.id.editTextHoTen);
        cbCsharp = findViewById(R.id.chkCsharp);
        cbPython = findViewById(R.id.chkPython);
        cbJava = findViewById(R.id.chkJava);
        cbRuby = findViewById(R.id.chkRuby);
        cbCplusplus = findViewById(R.id.chkCplusplus);
        radLT = findViewById(R.id.radLt);
        radMang = findViewById(R.id.radM);
        msg = "Họ tên:" + editTextHoTen.getText() +"\n" + "Ngôn ngữ yêu thích: ";
        if (cbCsharp.isChecked())
            msg += cbCsharp.getText() + ",";
        if (cbPython.isChecked())
            msg += cbPython.getText() + ",";
        if (cbJava.isChecked())
            msg += cbJava.getText() + ",";
        if (cbRuby.isChecked())
            msg += cbRuby.getText() + ",";
        if (cbCplusplus.isChecked())
            msg += cbCplusplus.getText() + ",";
        msg += "\nNgành: ";
        if (radMang.isChecked())
            msg += radLT.getText();
        else
            msg += radMang.getText();




        btnXn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông tin cá nhân")
                        .setMessage(msg)
                        .setNegativeButton("Bỏ qua", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tb = "Bạn vừa chọn bỏ qua ";
                                Toast.makeText(MainActivity.this, tb, Toast.LENGTH_SHORT).show();
                            }


                        })
                        .setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tb = "Bạn vừa chọn lưu";
                                Toast.makeText(MainActivity.this, tb, Toast.LENGTH_SHORT).show();
                            }
                        });
                Dialog dialog = builder.create();
                dialog.show();

            }
        });
    }
}
