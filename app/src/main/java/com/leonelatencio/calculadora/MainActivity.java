package com.leonelatencio.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public int digit1;
    public int digit2;
    public char oper = '+';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button uno =  (Button) findViewById(R.id.uno);
        String texto = uno.getText().toString();

        //Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    }


    public void asignarValor(View v) {
        Button bvalor = (Button) v;
        String valor = bvalor.getText().toString();

        if (digit1 > 0) {
            digit2 = Integer.parseInt(valor);
        } else {
            digit1 = Integer.parseInt(valor);
        }
        Toast.makeText(this, "Digit1: " + digit1 + " Digit2: " + digit2, Toast.LENGTH_SHORT).show();
        TextView display = (TextView) findViewById(R.id.display);
        display.append(valor);
    }

    public void asignarOperacion(View v) {
        Button boper = (Button) v;
        oper = boper.getText().charAt(0);
        Toast.makeText(this, "Oper: " + oper, Toast.LENGTH_SHORT).show();
        TextView display = (TextView) findViewById(R.id.display);
        display.append("" + oper);
    }

    public void realizarOperacion(View v) {
        Call<Result> call = APIConfig.get().getResult(digit1, digit2, oper);
        call.enqueue(new Callback<Result>() {

            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.d("SUCCESS", "onResponse: " + response.toString());
                Result result = response.body();
                Toast.makeText(MainActivity.this, "Resultado: " + result.getResultado() + " Operacion: " + result.getOperation(), Toast.LENGTH_SHORT).show();

                TextView display = (TextView) findViewById(R.id.display);
                display.setText("" + result.getResultado());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d("FAIL", "onFailure: " + t.getMessage());
            }
        });

    }

}
