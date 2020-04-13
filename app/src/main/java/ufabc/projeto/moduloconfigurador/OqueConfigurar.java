package ufabc.projeto.moduloconfigurador;

import android.app.SearchManager;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OqueConfigurar extends AbstractConfigAllActivity {
    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private ScrollView s;
    private EditText e;
    private ImageButton iconeBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oque_configurar);
        s = (ScrollView) findViewById(R.id.scrollId);
        Tv = (TextView) findViewById(R.id.textView1);
        e = (EditText) findViewById(R.id.editText2);
        iconeBotao = (ImageButton) findViewById(R.id.imageViewId);
        createExampleList();
        buildRecyclerView();

        iconeBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               speak();
            }
        });


        //cor texto e fundo
        //TELA
        s.setBackgroundColor(corTela());
        //NEGRITO
        calligrapher.setFont(this, negrito(), true);
        //Cor Fonte
        e.setTextColor(corTexto());
        e.setHintTextColor(corTexto());
        Tv.setTextColor(corTexto());
        //Fonte
        calligrapher.setFont(this, fonte(), true);
        //som
        if (ativarLeitorTela() == 1) {
            textToSpeech = new TextToSpeech(this,  this);
        }

        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

    }

    private void filter(String text) {
        ArrayList<ExampleItem> filteredList = new ArrayList<>();

        for (ExampleItem item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);

    }

    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem( "Ativar Leitor de tela"));
        mExampleList.add(new ExampleItem( "Velocidade da Fala"));
        mExampleList.add(new ExampleItem( "Tom de Voz"));
        mExampleList.add(new ExampleItem( "Cor da Tela"));
        mExampleList.add(new ExampleItem( "Cor do Texto"));
        mExampleList.add(new ExampleItem( "Texto em Negrito"));
        mExampleList.add(new ExampleItem( "Escolher Fonte"));
        mExampleList.add(new ExampleItem( "Tamanho da Fonte"));
        mExampleList.add(new ExampleItem("Brilho automatico"));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setBackgroundColor(corTela());
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void speak(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Qual configuração buscar ?");
        // start intent
        try{
            //Mostrar o dialogo
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);

        }catch (Exception e){
            // se houver erro
            Toast.makeText(this, "erro na obtenção do audio"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    // Receber e lidar com  entrada de voz.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQUEST_CODE_SPEECH_INPUT:{
                if (resultCode == RESULT_OK && null!=data){
                    // obter matriz de texto com intenção de voz.
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //set to text view
                    e.setText(result.get(0));
                }
                break;
            }
        }

    }

    @Override
    public void onInit(int status) {
        String falar = "O que você quer configurar?"+ "\n Digite oque você quer configurar " + "\n Ou segure o microfone e diga oque quer configurar" + "\n Botão buscar";
        if (status != TextToSpeech.ERROR) {
            textToSpeech.setLanguage(Locale.getDefault());
            //usar a velocidade de fala
            textToSpeech.setSpeechRate(velocidadeFala());
            //usar o tom de fala
            textToSpeech.setPitch(tomFala());
            textToSpeech.speak(falar, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }
}
