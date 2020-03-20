package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.graphics.Typeface;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisponivelLegendaSurdo extends AppCompatActivity {



    private Button simBotao;
    private Button naoBotao;
    private Button mostrarBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disponivel_legenda_surdo);



        simBotao = (Button) findViewById(R.id.simId);
        naoBotao = (Button) findViewById(R.id.naoId);
        mostrarBotao = (Button) findViewById(R.id.mostrarId);


        simBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DisponivelLegendaSurdo.this,TipoLegenda.class));
            }
        });

        naoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DisponivelLegendaSurdo.this,ReconhecimentoToque.class));
            }
        });

        mostrarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DisponivelLegendaSurdo.this,TextoNegrito.class));
                startActivityForResult(new Intent(Settings.ACTION_CAPTIONING_SETTINGS),0);

            }
        });
    }
}
