package ufabc.projeto.moduloconfigurador;

/**
 * Created by F.Nery on 11/02/2020.
 *
 * * Usando reflexão para substituir o tipo de letra padrão
 * AVISO: NÃO ESQUEÇA DE CONFIGURAR O TIPO DE APLICATIVO PARA O TEMA DE APP COMO TIPO DE PADRÃO PADRÃO QUE SERÁ SUBSTITUÍDO
 * contexto @param para trabalhar com ativos
 * @param defaultFontNameToOverride por exemplo "monospace"
 * @param customFontFileNameInAssets nome do arquivo da fonte dos ativos
 */
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public final class TypefaceUtil {



    public static void setDefaultFont(Context context,
                                      String staticTypefaceFieldName, String fontAssetName) {
        final Typeface regular = Typeface.createFromAsset(context.getAssets(),
                fontAssetName);
        replaceFont(staticTypefaceFieldName, regular);
    }

    protected static void replaceFont(String staticTypefaceFieldName,
                                      final Typeface newTypeface) {
        try {
            final Field staticField = Typeface.class
                    .getDeclaredField(staticTypefaceFieldName);
            staticField.setAccessible(true);
            staticField.set(null, newTypeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
