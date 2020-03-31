package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class AlterarTomVoz extends AbstractConfigAllActivity implements TextToSpeech.OnInitListener {

    private TextView textView;
    private ScrollView s;
    private TextToSpeech mTTS;
    private SeekBar seekBar;
    private ImageView iconeBotao, iconeSom;


    private final String REQUEST_ID = ""; //Ohar pq foi alterado



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_tom_voz);

        iconeSom = (ImageView) findViewById(R.id.icone_som);
        iconeBotao = (ImageView) findViewById(R.id.botaoIconeId);
        textView = (TextView) findViewById(R.id.textView4);
        Tv = (TextView) findViewById(R.id.textView2);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        s = (ScrollView) findViewById(R.id.layoutId);




        //cor texto e fundo
        //TELA
        s.setBackgroundColor(corTela());
        //NEGRITO
        calligrapher.setFont(this, negrito(), true);
        //Cor Fonte
        Tv.setTextColor(corTexto());
        textView.setTextColor(corTexto());
        //Fonte
        calligrapher.setFont(this, fonte(), true);


        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                if(i == TextToSpeech.SUCCESS){
                    int resukt = mTTS.setLanguage(Locale.forLanguageTag("BR"));
                    if (resukt == TextToSpeech.LANG_MISSING_DATA
                            || resukt == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS","Language não suportada");
                    }else {
                        iconeSom.setEnabled(true);
                    }
                }else {
                    Log.e("TTS","Falha");
                }
            }
        });



        //Executar a voz assim que entra na pagina
        if (ativarLeitorTela() == 1) {
            textToSpeech = new TextToSpeech(this,  this);
        }


        iconeSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak();
            }
        });

        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                long milliseconds = 350;
                vibrator.vibrate(milliseconds);
                //startActivity(new Intent(AlterarTomVoz.this,FalarPontuacao.class)); // esse é o caminho do botão correto no prototipo
                startActivity(new Intent(AlterarTomVoz.this,CorFundoTexto.class));// caminho para testes
            }
        });



    }
    @Override
    public void onInit(int status) { //FALANDO assim que abre a atividade
        String falar = "Alterar o tom"+ "\nDeixa a voz do leitor de tela mais grave ou mais aguda." + "\n Barra de rolagem para definir o Tom " + "\n Botão para testar o tom" + "\n Botão para passar e ir para proxima tela" ;
        if (status != TextToSpeech.ERROR) {
            textToSpeech.setLanguage(Locale.getDefault());
            textToSpeech.setSpeechRate(velocidadeFala());
            textToSpeech.speak(falar, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }
    public void speak(){
        String text = "Alterar oo Toomm";
        float pitch = (float) seekBar.getProgress() /50;
        if (pitch < 0.1) pitch = 0.1f;

        sharedPreferences.edit().putFloat(KEY_TOM_FALA, pitch).commit();
        mTTS.setPitch(pitch);
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null, REQUEST_ID);
    }

    @Override
    protected void onDestroy() {
        if (mTTS != null){
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();


    }



}
