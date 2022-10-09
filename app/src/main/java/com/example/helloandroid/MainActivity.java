package com.example.helloandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText eName;
    private Button bClick;
    private TextView tName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText eName = (EditText) findViewById(R.id.eName);
        Button bClick = (Button) findViewById(R.id.bClick);
        TextView tName = (TextView) findViewById(R.id.tName);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        bClick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String afisare= "Hello, " + eName.getText() + "!"; //luam un string in care stocam ce vrem sa afisam.
                tName.setText(afisare); //afisarea stringului
                builder.setMessage(afisare); //setam mesajul pentru popup-window
                builder.setCancelable(true);

                builder.setPositiveButton(":)", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Have a nice day", Toast.LENGTH_SHORT).show();//afisarea mesajului cu ajutorul metodei Toast, length short reprezinta durata perioadei in care este afisat mesajul.
                    }
                }); // cream un buton pentru situatia pozitiva
                builder.setNegativeButton(":(", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Be happy ", Toast.LENGTH_SHORT).show();
                    }
                }); // cream un buton pentru situatia negativa
                AlertDialog alert = builder.create(); //declaram o alerta
                alert.show();//afisarea alertei
            }
        });
    }
}