package com.leonelatencio.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button uno =  (Button) findViewById(R.id.uno);
        String texto = uno.getText().toString();

        //Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    }


    public void mostrarToast(View v) {
        Button uno =  (Button) v;
        String text = uno.getText().toString();
        Toast.makeText(this, "Ud hizo click en: " + text, Toast.LENGTH_LONG).show();
    }

}
