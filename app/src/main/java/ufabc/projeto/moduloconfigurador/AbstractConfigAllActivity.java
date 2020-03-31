package ufabc.projeto.moduloconfigurador;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Locale;

import me.anwarshahriar.calligrapher.Calligrapher;

public abstract class AbstractConfigAllActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    //Cor do fundo e texto e negrito
    protected int corTela;
    protected int corText;
    protected String fonte;

    //TTS mostrando a velocidade e tom
    protected TextToSpeech textToSpeech;
    protected int ativarOLeitorTela;
    protected float velocidadeFala;
    protected float tomFala;


    protected LinearLayout linearLayout;
    protected TextView Tv;

    //Valores das configurações
    protected static final String KEY_COR_TELA = "cor_tela";
    protected static final String KEY_COR_TEXTO = "cor_texto";
    protected static final String KEY_NEGRITO = "negrito";
    protected static final String KEY_FONTE = "fonte";
    protected static final String KEY_ATIVAR_LEITOR_TELA = "leitor_tela";
    protected static final String KEY_VELOCIDADE_FALA = "velocidade_fala";
    protected static final String KEY_TOM_FALA = "tom_fala";
    SharedPreferences sharedPreferences;
    Calligrapher calligrapher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_tamanho_fonte_texto);

        linearLayout = (LinearLayout) findViewById(R.id.layoutId);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        calligrapher = new Calligrapher(this);




    }

    public int corTela(){
        if(sharedPreferences.getInt(KEY_COR_TELA, corTela) != 0) {
            corTela = sharedPreferences.getInt(KEY_COR_TELA, corTela);
        }
        return corTela;
    }

    public int corTexto(){
        if (sharedPreferences.getInt(KEY_COR_TEXTO, corText) != 0){
            corText = sharedPreferences.getInt(KEY_COR_TEXTO, corText);
        } if (sharedPreferences.getInt(KEY_COR_TEXTO, corText) == 0 ) {
            sharedPreferences.edit().putInt(KEY_COR_TEXTO, -15920896).commit();
            corText = sharedPreferences.getInt(KEY_COR_TEXTO, corText);
        }
        return corText;
    }

    public int ativarLeitorTela(){
        if(sharedPreferences.getInt(KEY_ATIVAR_LEITOR_TELA, ativarOLeitorTela) != 0) {
            ativarOLeitorTela = sharedPreferences.getInt(KEY_ATIVAR_LEITOR_TELA, ativarOLeitorTela);
        }
        return ativarOLeitorTela;
    }


    public float velocidadeFala(){
        if(sharedPreferences.getFloat(KEY_VELOCIDADE_FALA, velocidadeFala) != 0) {
            velocidadeFala = sharedPreferences.getFloat(KEY_VELOCIDADE_FALA, velocidadeFala);
        }
        return velocidadeFala;
    }

    public float tomFala(){
        if(sharedPreferences.getFloat(KEY_TOM_FALA, tomFala) != 0) {
            tomFala = sharedPreferences.getFloat(KEY_TOM_FALA, tomFala);
        }
        return tomFala;
    }
    public String fonte(){
        if(sharedPreferences.getString(KEY_FONTE , fonte) != null){
            fonte = sharedPreferences.getString(KEY_FONTE , fonte);

        }if(sharedPreferences.getString(KEY_FONTE , fonte) == null){
            sharedPreferences.edit().putString(KEY_FONTE, "arial.ttf").commit();
            fonte = sharedPreferences.getString(KEY_FONTE, fonte);
        }
        return fonte;
    }
    public String negrito(){
        if(sharedPreferences.getString(KEY_NEGRITO, fonte) != null){
            fonte = sharedPreferences.getString(KEY_NEGRITO, fonte);
           // calligrapher = new Calligrapher(this);
        }if(sharedPreferences.getString(KEY_NEGRITO, fonte) == null){
            sharedPreferences.edit().putString(KEY_NEGRITO, "arial.ttf").commit();
            fonte = sharedPreferences.getString(KEY_NEGRITO, fonte);
        }
        return fonte;
    }


}