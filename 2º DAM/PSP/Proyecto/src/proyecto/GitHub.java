package proyecto;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GitHub {

    public static String url;
    public static final int maxPages = 1;
    String texto;

    public GitHub(String texto, String url) {
        this.texto = texto;
        this.url = url;
        for (int i = 1; i < maxPages; i++) {
            String urlPage = String.format(url, i);
            if (getStatusConnectionCode(urlPage) == 200) {
                Document document = getHtmlDocument(urlPage);
                Elements entradas = document.select("div[class=question-summary narrow]");
                for (Element elem : entradas) {
                    Elements titulo = elem.getElementsByClass("question-hyperlink");
                    String enlaces = titulo.toString();
                    

                }
           
            } else {
                System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(urlPage));
                break;
            }
        }
    } 
      public static int getStatusConnectionCode(String url) {

        Connection.Response response = null;

        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }
        return response.statusCode();
    }

    public static Document getHtmlDocument(String url) {

        Document doc = null;

        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
        }

        return doc;

    }
    
}

