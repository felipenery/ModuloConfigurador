package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class AtalhoAcessibilidade extends AppCompatActivity {

    private ImageView iconeInfo;
    private ImageView iconeBotao;

    ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atalho_acessibilidade);

        iconeInfo = (ImageView) findViewById(R.id.botaoInfo);
        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);

        ListView lv = (ListView) findViewById(R.id.listViewId);

        ArrayList<String> arrayContry = new ArrayList<>();
        arrayContry.addAll(Arrays.asList(getResources().getStringArray(R.array.array)));

        adapter = new ArrayAdapter<>(
                AtalhoAcessibilidade.this,
                android.R.layout.simple_list_item_1,
                arrayContry);
        lv.setAdapter(adapter);

        iconeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AtalhoAcessibilidade.this,TextoInstrucoes.class));
            }
        });



        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AtalhoAcessibilidade.this,OqueConfigurar.class));
            }
        });
    }
}
