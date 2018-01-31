import java.net.CookieHandler;
import java.net.CookieManager;

public class KattisDownloader {

    /**
     * Taken from example tutorial from Mkyong
     * https://www.mkyong.com/java/how-to-automate-login-a-website-java-example/
     * @param args
     */
    public static void main(String[] args){
        String url = "https://open.kattis.com/login/email";
        String startDownloadPage = "https://open.kattis.com/problems?show_solved=on&show_tried=off&show_untried=off";


        KattisDownloader http = new KattisDownloader();

        CookieHandler.setDefault(new CookieManager());

        String page = http.GetPageContent(url);

    }

    private String GetPageContent(String url) {

        return "";
    }
}
