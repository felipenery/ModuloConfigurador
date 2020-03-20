package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Destacar extends AppCompatActivity {


    private TextView tela1;
    private TextView tela2;
    private TextView tela3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destacar);


        tela1 = (TextView) findViewById(R.id.textView);
        tela2 = (TextView) findViewById(R.id.textView1);
        tela3 = (TextView) findViewById(R.id.textView3);





        tela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Destacar.this,EstiloDestaque.class));
            }
        });

        tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Destacar.this,EstiloDestaque.class));
            }
        });

        tela3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Destacar.this,EstiloDestaque.class));
            }
        });
    }
}
