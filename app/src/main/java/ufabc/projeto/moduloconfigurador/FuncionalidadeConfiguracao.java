package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FuncionalidadeConfiguracao extends AppCompatActivity {
    private ImageView iconeBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionalidade_configuracao);

        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);

        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FuncionalidadeConfiguracao.this,AtivarZoom.class));
            }
        });
    }
    public void startSecondActivity(View view) {

        Intent secondActivity = new Intent(this, VisualizacoesTela.class);
        startActivity(secondActivity);
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        long milliseconds = 500;
        vibrator.vibrate(milliseconds);
    }
}
