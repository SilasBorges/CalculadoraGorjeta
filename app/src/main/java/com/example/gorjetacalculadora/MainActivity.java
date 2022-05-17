package com.example.gorjetacalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarProgress;
    private TextView textProgress;
    private TextInputEditText valorPedido;
    private TextView textGorjeta;
    private TextView textTotal;
    private Double gorjeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarProgress = findViewById(R.id.seekBarProgress);
        textProgress    = findViewById(R.id.textProgress);
        valorPedido     = findViewById(R.id.valorPedido);
        textGorjeta     = findViewById(R.id.textGorjeta);
        textTotal       = findViewById(R.id.textTotal);

        seekBarProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textProgress.setText(Math.round(porcentagem) + "%");
                calcular();

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });



    }

    public void calcular(){

        String valorSPedido = valorPedido.getText().toString();

        if(valorSPedido == null || valorSPedido.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "Informe um valor primeiro",
                    Toast.LENGTH_SHORT

            ).show();
        }
        else{
            double valorTotal = Double.parseDouble(valorSPedido);
            double gorjetaValor = valorTotal * (porcentagem / 100);
            textGorjeta.setText("R$: " + Math.round(gorjetaValor));

            double valorCompleto = valorTotal + gorjetaValor;
            textTotal.setText("R$: " + valorCompleto );



        }

    }

}