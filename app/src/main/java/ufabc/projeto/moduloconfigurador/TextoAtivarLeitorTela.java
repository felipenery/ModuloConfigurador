package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class TextoAtivarLeitorTela extends AbstractConfigAllActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto_ativar_leitor_tela);
        linearLayout = (LinearLayout) findViewById(R.id.layoutId);
        Tv = (TextView) findViewById(R.id.textView3);


        //cor texto e fundo
        linearLayout.setBackgroundColor(corTela()); // Mudando a cor da tela
        Tv.setTextColor(corTexto()); // Mudando a cor do texto
        //NEGRITO
        calligrapher.setFont(this, negrito(), true);
        //Fonte
        calligrapher.setFont(this, fonte(), true);
    }

    @Override
    public void onInit(int i) {

    }
}
