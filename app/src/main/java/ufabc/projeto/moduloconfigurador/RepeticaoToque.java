package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RepeticaoToque extends AppCompatActivity {

    private ImageView iconeBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeticao_toque);

        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);

        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RepeticaoToque.this,ToqueAssistido.class));
            }
        });
    }
}
