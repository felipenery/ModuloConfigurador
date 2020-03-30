package ufabc.projeto.moduloconfigurador;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
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

public class CorFundoTexto extends AbstractConfigAllActivity implements TextToSpeech.OnInitListener {

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
                 //salvarBotao.setBackgroundColor(pixelFundo);
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

                    //salvarBotao.setTextColor(pixelText);



                        clickTexto(pixelText);





                }



                return false;
            }
        });
/*
        if (pixelText == 0 && sharedPreferences.getInt(KEY_COR_TEXTO, corText) == 0 ) {
            pixelText = -16187385;
            clickTexto(pixelText);
        }
        */
        Log.i("@pixelText","cor - "+ pixelText);
        //som
        if (ativarLeitorTela() == 1) {
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
    public void clickTexto(int corText){
        //Para armazenar um valor
            sharedPreferences.edit().putInt(KEY_COR_TEXTO, corText).commit();

    }

    @Override
    public void onInit(int status) { //FALANDO assim que abre a atividade
        String falar = "Escolha a cor do fundo em texto"+ "\n Em seguida"+" Escolha a cor do texto." + "\n Botão salvar" ;
        if (status != TextToSpeech.ERROR) {
            textToSpeech.setLanguage(Locale.getDefault());
            //usar a velocidade de fala
            textToSpeech.setSpeechRate(velocidadeFala());
            //usar o tom de fala
            textToSpeech.setPitch(tomFala());
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