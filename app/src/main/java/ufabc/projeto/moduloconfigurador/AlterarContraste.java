package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlterarContraste extends AppCompatActivity {

    private Button simBotao;
    private Button naoBotao;
    private Button mostrarBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_contraste);

        simBotao = (Button) findViewById(R.id.simId);
        naoBotao = (Button) findViewById(R.id.naoId);
        mostrarBotao = (Button) findViewById(R.id.mostrarId);

        simBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlterarContraste.this,TemaAltoContraste.class));
                startActivityForResult(new Intent(Settings.ACTION_NIGHT_DISPLAY_SETTINGS),0);
            }
        });

        naoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlterarContraste.this,InverterCores.class));
            }
        });

        mostrarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlterarContraste.this,InverterCores.class));
                startActivityForResult(new Intent(Settings.ACTION_NIGHT_DISPLAY_SETTINGS),0);

            }
        });


    }
}
