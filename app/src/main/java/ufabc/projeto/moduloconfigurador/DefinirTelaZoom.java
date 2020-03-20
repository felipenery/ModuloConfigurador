package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DefinirTelaZoom extends AppCompatActivity {


    private TextView tela2;
    private TextView tela;
    private TextView tela1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definir_tela_zoom);

        tela = (TextView) findViewById(R.id.textView2);
        tela1 = (TextView) findViewById(R.id.textView);
        tela2 = (TextView) findViewById(R.id.textView1);

        tela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DefinirTelaZoom.this,FiltroTelaZoom.class));
            }
        });

        tela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DefinirTelaZoom.this,FiltroTelaZoom.class));
            }
        });

        tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DefinirTelaZoom.this,FiltroTelaZoom.class));
            }
        });



    }
}
