package com.example.jokenpo;

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

    public void selecionarPedra(View view){

        verificarGanhador("pedra");
    }
    public void selecionarPapel(View view){

        verificarGanhador("papel");
    }
    public void selecionarTesoura(View view){

        verificarGanhador("tesoura");
    }
    private String gerarEscolhaAleatoriaApp() {
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);
        String escolhaApp = opcoes[numeroAleatorio];
        ImageView imageApp = findViewById(R.id.image_app);
        switch (escolhaApp){
            case "pedra" :
                    imageApp.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imageApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;
    }

    private void verificarGanhador(String escolhaUsuario) {
        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if (
                (escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura")) ||
                        (escolhaApp.equals("papel") && escolhaUsuario.equals("pedra")) ||
                        (escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel"))
        ) {
            textoResultado.setText("Você Perdeu");
        } else if (
                (escolhaUsuario.equals("pedra") && escolhaApp.equals("tesoura")) ||
                        (escolhaUsuario.equals("papel") && escolhaApp.equals("pedra")) ||
                        (escolhaUsuario.equals("tesoura") && escolhaApp.equals("papel"))
        ) {
            textoResultado.setText("Você Ganhou");
        } else {
            textoResultado.setText("Empate");
        }

        //System.out.println("Item clicado:" + escolhaUsuario);
    }

    /*private void verificarGanhador( String escolhaUsuario){

        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if(
            (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
            (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
            (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
        ){
            textoResultado.setText("Voce Perdeu");


        }else(
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||

                ){ textoResultado.setText("Voce Ganhou");

        }else{
            textoResultado.setText("Empate");
        }


        //System.out.println("Item clicado:" + escolhaUsuario);
    }
*/


}