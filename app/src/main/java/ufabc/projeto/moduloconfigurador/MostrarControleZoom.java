package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MostrarControleZoom extends AppCompatActivity {

    private Button simBotao;
    private Button naoBotao;
    private ImageView iconeBotao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_controle_zoom);




        simBotao = (Button) findViewById(R.id.simId);
        naoBotao = (Button) findViewById(R.id.naoId);
        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);

        simBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MostrarControleZoom.this,VisibilidadeControleOcioso.class));
            }
        });

        naoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MostrarControleZoom.this,DefinirTelaZoom.class));
            }
        });

        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.texto_controle_zoom);
            }
        });

    }
}
