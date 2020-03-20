package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ConfigurarRetornoVoz extends AppCompatActivity {

    private ImageView iconeBotao;
    private ImageView iconeInfo;
    private ImageView iconeInfo1;
    private ImageView iconeInfo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_retorno_voz);

        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);
        iconeInfo = (ImageView) findViewById(R.id.imageView);
        iconeInfo1 = (ImageView) findViewById(R.id.imageView1);
        iconeInfo2 = (ImageView) findViewById(R.id.imageView2);


        iconeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConfigurarRetornoVoz.this,TextoSempreAtivo.class));
            }
        });
        iconeInfo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConfigurarRetornoVoz.this,TextoSeletor.class));
            }
        });
        iconeInfo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConfigurarRetornoVoz.this,TextoHandsfree.class));
            }
        });


        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConfigurarRetornoVoz.this,AgitarDesfazer.class));
            }
        });
    }
}
