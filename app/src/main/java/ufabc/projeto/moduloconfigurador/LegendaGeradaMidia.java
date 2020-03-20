package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LegendaGeradaMidia extends AppCompatActivity {

    private ImageView iconeBotao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legenda_gerada_midia);

        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);


        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LegendaGeradaMidia.this,EstiloDigitacao.class));
            }
        });


    }
}
