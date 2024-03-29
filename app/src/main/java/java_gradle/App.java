/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package java_gradle;

import java.io.IOException;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;

import app.jackychu.api.simplegoogletranslate.Language;
import app.jackychu.api.simplegoogletranslate.SimpleGoogleTranslate;

public class App {
    static String Input = "Erledigt";
    
    public static String translate(String Input) {
        SimpleGoogleTranslate translate = new SimpleGoogleTranslate();        
        //String result;
        try {
            String result = translate.doTranslate(Language.de,Language.it, Input);
            String[] a = result.split("\\\\");
            System.out.println(Input);
            System.out.println(a[0]);
            result = a[0];
            return result;

        } catch (IOException e) {
            // Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
        public static void main(String[] args) {
        // Ascii Art
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(120).height(20);
        builder.element(new PseudoText(translate(Input)));
        ICanvas canvas = render.render(builder.build());
        String s = canvas.getText();
        System.out.println(s);
    }
}
