package com.brab.joquemp;

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

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }



    public void opcaoSelecionada(String opcaoSelecionada){

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoAdversario = opcoes [numero];

        switch (opcaoAdversario){
            case "pedra" :
                imageResultado.setImageResource(R.drawable.pedra);//faz com que o imageResultado receba uma nova imagem
                break;
            case "papel" :
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (opcaoAdversario == "tesoura" && opcaoSelecionada == "papel") ||
                (opcaoAdversario == "pedra" && opcaoSelecionada == "tesoura") ||
                (opcaoAdversario == "papel" && opcaoSelecionada == "pedra")
        ){
            textoResultado.setText("Você Perdeu :( ");
        }else if (
                (opcaoAdversario == "tesoura" && opcaoSelecionada == "tesoura") ||
                (opcaoAdversario == "pedra" && opcaoSelecionada == "pedra") ||
                (opcaoAdversario == "papel" && opcaoSelecionada == "papel")
        ){
            textoResultado.setText("Empatou HAHAHAHA :| ");
        } else {
            textoResultado.setText("Você ganhou :) Aeeeeee!");
        }


       // System.out.println("Selecionado: " + opcaoAdversario);
    }
}