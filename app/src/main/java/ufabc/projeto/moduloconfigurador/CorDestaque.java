package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CorDestaque extends AppCompatActivity {

    private ImageView tela1;
    private ImageView tela2;
    private ImageView tela3;
    private ImageView tela4;
    private ImageView tela5;
    private ImageView tela6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cor_destaque);

        tela1 = (ImageView) findViewById(R.id.imageView1Id);
        tela2 = (ImageView) findViewById(R.id.imageView2Id);
        tela3 = (ImageView) findViewById(R.id.imageView3Id);
        tela4 = (ImageView) findViewById(R.id.imageView4Id);
        tela5 = (ImageView) findViewById(R.id.imageView5Id);
        tela6 = (ImageView) findViewById(R.id.imageView6Id);

        tela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CorDestaque.this,FalarDigitacao2.class));
            }
        });

        tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CorDestaque.this,FalarDigitacao2.class));
            }
        });

        tela3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CorDestaque.this,FalarDigitacao2.class));
            }
        });
        tela4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CorDestaque.this,FalarDigitacao2.class));
            }
        });

        tela5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CorDestaque.this,FalarDigitacao2.class));
            }
        });

        tela6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CorDestaque.this,FalarDigitacao2.class));
            }
        });


    }
}
