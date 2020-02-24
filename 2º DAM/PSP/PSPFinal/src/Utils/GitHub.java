package Utils;

import Controladoras.GitHubController;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class GitHub {
    String code = null;

    public GitHub(String url) {
        document(url);
    }

    public String getCode() {
        if (code != null) {
            return code;
        } else {
            return "Elija una url valida";
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

    public void document(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            if (getStatusConnectionCode(url) == 200) {
                Document document = getHtmlDocument(url);
                Elements body = document.select("body");
                String codigo = body.toString();
                String[] partes = codigo.split(">");
                String[] res = partes[1].split("<");
                code = res[0];
            } else {
                System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(url));
            }
        } catch (IOException e) {
            code = "Elija una url valida";
        } catch (IllegalArgumentException ex){
            code = "Elija una url valida";
        }

    }
}
