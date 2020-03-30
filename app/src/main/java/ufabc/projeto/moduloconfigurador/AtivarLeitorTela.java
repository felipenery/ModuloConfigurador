package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Locale;

public class AtivarLeitorTela extends AbstractConfigAllActivity {

    private Button simBotao;
    private Button naoBotao;
    private Button mostrarBotao;
    private ImageView iconeBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ativar_leitor_tela);

        simBotao = (Button) findViewById(R.id.simId);
        naoBotao = (Button) findViewById(R.id.naoId);
        mostrarBotao = (Button) findViewById(R.id.mostrarId);
        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);




        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {

                    int resukt = textToSpeech.setLanguage(Locale.forLanguageTag("BR"));
                    if (resukt == TextToSpeech.LANG_MISSING_DATA

                            || resukt == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Linguagem não suportada");
                    } else {
                       // iconeSom.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Falha");
                }
            }
        });



        simBotao.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View view) {
              // startActivityForResult(new Intent(Settings.ACTION_CAPTIONING_SETTINGS),0); LEGENDA
                ativarOLeitorTela = 1;
                click(ativarOLeitorTela);
                startActivity(new Intent(AtivarLeitorTela.this,VelocidadeFala.class));

               // startActivityForResult(new Intent(Settings.ACTION_DISPLAY_SETTINGS),0);  FONT TIPO NEGRITO
               
               // startActivityForResult(new Intent(Settings.ACTION_NIGHT_DISPLAY_SETTINGS),0); Night Light



            }




        });



        naoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ativarOLeitorTela = 0;
                click(ativarOLeitorTela);
                //startActivity(new Intent(AtivarLeitorTela.this,AtivarZoom.class));
                startActivity(new Intent(AtivarLeitorTela.this,CorFundoTexto.class));
            }
        });



        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.texto_info_leitor_tela);
            }
        });


        mostrarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "Deseja ativar o leitor de tela ";

                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);

                //startActivity(new Intent(AtivarLeitorTela.this,DisponivelLegendaSurdo.class));
               // startActivityForResult(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS),0);


            }
        });




}

    public void click(int ativarOLeitorTela){
        //((ConfigHelper) this.getApplication()).setAtivarOLeitorTela(ativarOLeitorTela);
        sharedPreferences.edit().putInt(KEY_ATIVAR_LEITOR_TELA , ativarOLeitorTela).commit();




    }


    @Override
    public void onInit(int i) {

    }
}