package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InverterCores extends AppCompatActivity {


    private TextView tela1;
    private TextView tela2;
    private TextView tela3;
    private Button mostrarBotao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inverter_cores);



        tela1 = (TextView) findViewById(R.id.textView);
        tela2 = (TextView) findViewById(R.id.textView1);
        tela3 = (TextView) findViewById(R.id.textView3);
        mostrarBotao = (Button) findViewById(R.id.mostrarId);





        tela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InverterCores.this,AtivarBrilhoAutomatico.class));
            }
        });

        tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InverterCores.this,AtivarBrilhoAutomatico.class));
            }
        });

        tela3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InverterCores.this,AtivarBrilhoAutomatico.class));
            }
        });

        mostrarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityForResult(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS),0);


            }
        });





    }
}
