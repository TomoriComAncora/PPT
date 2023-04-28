package com.example.ppt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ImageView resultado;
    TextView txt_result;

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }


    public void opcaoSelecionada(String opcaoSelecionada) {

        resultado = findViewById(R.id.visorResult);
        txt_result = findViewById(R.id.txt_result);


        int num = new Random().nextInt(3);
        String[] opcao = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcao[num];

        switch (opcaoApp) {
            case "pedra":
                resultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                resultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                resultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if ((opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
                (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")) {
            txt_result.setText("Você Perdeu!!!");

        } else if ((opcaoSelecionada == "tesoura" && opcaoApp == "papel") ||
                (opcaoSelecionada == "papel" && opcaoApp == "pedra") ||
                (opcaoSelecionada == "pedra" && opcaoApp == "tesoura")) {
            txt_result.setText("Você Ganhou!!!");

        } else {
            txt_result.setText("Empatamos!!!");
        }
    }

}