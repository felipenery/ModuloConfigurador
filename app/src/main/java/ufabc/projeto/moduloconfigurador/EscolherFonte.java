package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EscolherFonte extends AppCompatActivity {



    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;
    private Typeface tf1, tf2, tf3, tf4;
    private ImageView iconeBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_fonte);
        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);

        t1 = (TextView) findViewById(R.id.textView4);
        t2 = (TextView) findViewById(R.id.textView);
        t3 = (TextView) findViewById(R.id.textView1);
        t4 = (TextView) findViewById(R.id.textView2);

        tf1 = Typeface.createFromAsset(getAssets(), "caveat-regular-maisfontes.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "courier-new.ttf");
        tf3 = Typeface.createFromAsset(getAssets(), "lobster.ttf");
        tf4 = Typeface.createFromAsset(getAssets(), "arial.ttf");

        t1.setTypeface(tf1);
        t2.setTypeface(tf2);
        t3.setTypeface(tf3);
        t4.setTypeface(tf4);

        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EscolherFonte.this,FonteVideo.class));
            }
        });
    }
}
