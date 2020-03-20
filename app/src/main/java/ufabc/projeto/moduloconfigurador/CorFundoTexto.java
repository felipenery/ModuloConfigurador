package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;



import java.util.Locale;

import me.anwarshahriar.calligrapher.Calligrapher;
import yuku.ambilwarna.AmbilWarnaDialog;

public class CorFundoTexto extends ConfigAll implements TextToSpeech.OnInitListener {

    private Button salvarBotao;
    public LinearLayout l;
    public ScrollView s;
    public TextView text;
    public TextView text1;
    //fundo
    public ImageView mImageView;
    public Bitmap bitmap;
    private int pixelFundo;
    //texto
    public ImageView mImageViewText;
    public Bitmap bitmapText;
    private int pixelText;
    public ScrollView testeCor;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cor_fundo_texto);
        l = (LinearLayout) findViewById(R.id.layoutId);
        s = (ScrollView) findViewById(R.id.scrollId);
        salvarBotao = (Button) findViewById(R.id.botaoId);

        text = (TextView) findViewById(R.id.textView);
        text1 = (TextView) findViewById(R.id.textView1);


        mImageView = (ImageView) findViewById(R.id.imageColor);
        mImageViewText = (ImageView) findViewById(R.id.imageColor2);


        mImageView.setDrawingCacheEnabled(true);
        mImageView.buildDrawingCache(true);
        mImageViewText.setDrawingCacheEnabled(true);
        mImageViewText.buildDrawingCache(true);

        //fundo
        mImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
             if(motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE){
                bitmap = mImageView.getDrawingCache();

                 pixelFundo = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());

                 int r = Color.red(pixelFundo);
                 int g = Color.green(pixelFundo);
                 int b = Color.blue(pixelFundo);

                 String hex = "#"+ Integer.toHexString(pixelFundo);

                 s.setBackgroundColor(pixelFundo);
                 salvarBotao.setBackgroundColor(pixelFundo);
                 clickFundo(pixelFundo);


             }

                return false;
            }
        });

        //texto
        mImageViewText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE){
                    bitmapText = mImageViewText.getDrawingCache();

                    pixelText = bitmapText.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());

                    int r = Color.red(pixelText);
                    int g = Color.green(pixelText);
                    int b = Color.blue(pixelText);

                    String hex = "#"+ Integer.toHexString(pixelText);
                    text.setTextColor(Color.rgb(r,g,b));
                    text1.setTextColor(Color.rgb(r,g,b));

                    salvarBotao.setTextColor(Color.rgb(r,g,b));


                    clickTexto(Color.rgb(r,g,b));

                }
                return false;
            }
        });

        //som
        ativarOLeitorTela = sharedPreferences.getInt(KEY_ATIVAR_LEITOR_TELA, ativarOLeitorTela);
        velocidadeFala = sharedPreferences.getFloat(KEY_VELOCIDADE_FALA, velocidadeFala);
        tomFala = sharedPreferences.getFloat(KEY_TOM_FALA, tomFala);
        if (ativarOLeitorTela == 1) {
            textToSpeech = new TextToSpeech(this,  this);
        }

        ((ConfigHelper) this.getApplication()).setSomeVariable(text);

        salvarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                long milliseconds = 350;
                vibrator.vibrate(milliseconds);
                //startActivity(new Intent(CorFundoTexto.this,AtivarZoom.class)); TELA CERTA
                startActivity(new Intent(CorFundoTexto.this,TextoNegrito.class)); // PARA TESTE
            }
        });
    }

    public void clickFundo(int corTela){
        //Para armazenar um valor
        sharedPreferences.edit().putInt(KEY_COR_TELA, corTela).commit();

    }
    public void clickTexto(int corTexto){
        //Para armazenar um valor
        sharedPreferences.edit().putInt(KEY_COR_TEXTO, corTexto).commit();

    }

    @Override
    public void onInit(int status) { //FALANDO assim que abre a atividade
        String falar = "Escolha a cor do fundo em texto"+ "\n Em seguida"+" Escolha a cor do texto." + "\n Botão salvar" ;
        if (status != TextToSpeech.ERROR) {
            textToSpeech.setLanguage(Locale.getDefault());
            textToSpeech.setSpeechRate(velocidadeFala);
            textToSpeech.setPitch(tomFala);
            textToSpeech.speak(falar, TextToSpeech.QUEUE_FLUSH, null, null);
        }

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