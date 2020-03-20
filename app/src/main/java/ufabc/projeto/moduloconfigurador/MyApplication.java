package ufabc.projeto.moduloconfigurador;

import android.app.Application;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by F.Nery on 22/01/2020.
 */
public class MyApplication {

    private TextView someVariable;

    private Boolean ativarOLeitorTela; // esta funcionando cuidado
    private float velocidadeFala;
    private float tomFala;
    private int corFundo;
    public int corTexto ;



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

/*
    public int getCorTexto() {

        return corTexto;
    }

    public void setCorTexto(int corTexto) {

        this.corTexto = corTexto;
    }

*/

}
