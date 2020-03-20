package ufabc.projeto.moduloconfigurador;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class CorTela extends AppCompatActivity {

    private ImageView iconeBotao;


    private ImageView iconeLibras;
    private ImageView close;
    Dialog Mydialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cor_tela);

        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);


        iconeLibras = (ImageView) findViewById(R.id.imageView3);

        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CorTela.this,IntensidadeTela.class));
            }
        });

        iconeLibras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCustomAlertDialog();
            }
        });

    }

    public void MyCustomAlertDialog(){
        Mydialog = new Dialog(CorTela.this);
        Mydialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Mydialog.setContentView(R.layout.customdialog);
        Mydialog.setTitle("Meu primeiro teste");

        close = (ImageView) Mydialog.findViewById(R.id.close);
        close.setEnabled(true);



        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mydialog.cancel();
            }
        });

        Mydialog.show();
    }
}
