package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class AtivarZoom extends AppCompatActivity {

    public ScrollView l;

    private Button simBotao;
    private Button naoBotao;
    private ImageView iconeBotao;
    private TextView testando;
    public Boolean teste;
    public LinearLayout layout;
    public ScrollView testeC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ativar_zoom);

        l = (ScrollView) findViewById(R.id.layoutId);
        simBotao = (Button) findViewById(R.id.simId);
        naoBotao = (Button) findViewById(R.id.naoId);
        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);
        testando = (TextView) findViewById(R.id.textView2);




        //l.setBackgroundColor(testeC);

        teste = ((ConfigHelper)this.getApplication()).getAtivarOLeitorTela();// testando a variavel global
        Log.i("zoom", "hello --"+teste);

        simBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AtivarZoom.this,SeguirFoco.class));

            }
        });

        naoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AtivarZoom.this,AtivarLupa.class));
            }
        });

        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.texto_ativar_zoom);
            }
        });
    }
}
