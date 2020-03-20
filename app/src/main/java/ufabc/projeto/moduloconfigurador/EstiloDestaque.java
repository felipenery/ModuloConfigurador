package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EstiloDestaque extends AppCompatActivity {

    private TextView tela1;
    private ImageView tela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estilo_destaque);

        tela1 = (TextView) findViewById(R.id.textView);
        tela2 = (ImageView) findViewById(R.id.imageView2Id);

        tela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EstiloDestaque.this,FalarDigitacao2.class));
            }
        });

        tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EstiloDestaque.this,CorDestaque.class));
            }
        });
    }
}
