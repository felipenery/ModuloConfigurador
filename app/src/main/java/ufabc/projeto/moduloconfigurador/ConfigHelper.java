package ufabc.projeto.moduloconfigurador;

import android.app.Application;
import android.preference.PreferenceManager;
import android.widget.TextView;

import me.anwarshahriar.calligrapher.Calligrapher;

/**
 * Created by F.Nery on 17/02/2020.
 */
public class ConfigHelper extends Application {

    private TextView someVariable;

    private Boolean ativarOLeitorTela; // esta funcionando cuidado
    private float velocidadeFala;
    private float tomFala;
    private int corFundo;
    private Calligrapher textoNegrito;
    private String fonte;


    public static final int CONFIG_EXAMPLE_1 = 1, CONFIG_EXAMPLE_2 = 2;

    public static final int CONFIG_EXAMPLE_2_MODE_A = 0, CONFIG_EXAMPLE_2_MODE_B = 0;
    private int corTexto , configExample2Status;



    boolean salvarDeuErrado = true;

 //   private ConfigHelper(){} se tornar ele privado não é possivel o tornar uma classe de aplicação.


    //gets publicos, sets privados
    public int getConfig(int requestCode){
        switch (requestCode){
            case CONFIG_EXAMPLE_1:
                return corTexto;
            case CONFIG_EXAMPLE_2:
                return configExample2Status;
            default:
                return -1;
        }
    }


    public void setConfig(int requestCode,  int corTexto){
        switch (requestCode) {
            case CONFIG_EXAMPLE_1:
                this.corTexto = corTexto;

        }
    }

    public static ConfigHelper load(){
        StringBuffer a = abrirArquivoExemplo();
        if(a == null) return null;

        ConfigHelper ch = new ConfigHelper();
        /*
            ler o arquivo interno
         */
        return ch;
    }




    public static class Editor {

        private ConfigHelper myConfigHelper;
        private boolean salvarDeuErrado;

        private Editor(){

        }

        public static Editor tryLoad(){
            Editor e = new Editor();

            StringBuffer a = abrirArquivoExemplo();
            if(a == null) return e; // se falhar não retorna nulo, só vazio;


            e.myConfigHelper = new ConfigHelper();
            //lê o arquivo de fato

            return e;
        }



        //helper não salva pq não modifica, editor salva;
        public boolean save(){

            if(salvarDeuErrado) return false;
            return true;
        }

        //acesso público ao set
        public void setConfig(int requestCode, int corTexto){
            myConfigHelper.setConfig(requestCode, corTexto);
        }

    }


    private static StringBuffer abrirArquivoExemplo() {
        return null;
    }

    public TextView getSomeVariable(TextView teste) {

        return someVariable;
    }

    public void setSomeVariable(TextView someVariable) {

        this.someVariable = someVariable;
    }

    public Boolean getAtivarOLeitorTela() {

        return ativarOLeitorTela;
    }

    public void setAtivarOLeitorTela(Boolean ativarOLeitorTela) {

        this.ativarOLeitorTela = ativarOLeitorTela;
    }

    public float getVelocidadeFala() {

        return velocidadeFala;
    }

    public void setVelocidadeFala(float velocidadeFala) {

        this.velocidadeFala = velocidadeFala;
    }

    public float getTomFala() {

        return tomFala;
    }

    public void setTomFala(float tomFala) {

        this.tomFala = tomFala;
    }

    public int getCorFundo() {

        return corFundo;
    }

    public void setCorFundo(int corFundo) {

        this.corFundo = corFundo;
    }


    public int getCorTexto() {

        return corTexto;
    }

    public void setCorTexto(int corTexto) {

        this.corTexto = corTexto;
    }

    public Calligrapher getTextoNergrito() {

        return textoNegrito;
    }

    public void setTextoNegrito(Calligrapher textoNegrito) {

        this.textoNegrito = textoNegrito;
    }

    public String getFonte() {

        return fonte;
    }

    public void setFonte(String fonte) {

        this.fonte = fonte;
    }


}



/* para eu usar:
*
*   onCreate(...){
*       super(...);
*
*       ConfigHelper config = ConfigHelper.load();
*       if (config != null){
*           // Aplicar as configurações aqui
*       } else {
*           Intent intent = new Intent(this, ConfigMainActivity.class);
*           intent.putExtra("ConfigAndExit",true) // para saber que não entrou sozinho, eu que chamei
*           startActivityForResult(intent,12345); // para eu poder saber que você terminou (e dar um recreate() provavelmente)
*       }
*   }
*/

/* para você usar:
*
*   onCreate(...){
*       super(...)
*
*       ConfigHelper.Editor configEditor = ConfigHelper.Editor.tryLoad(); //editor nunca é nulo, no máximo vazio
*       // começar a configurar
*   }
 */
