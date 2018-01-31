import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.Scanner;

public class KattisDownloader {

    private static Scanner reader = new Scanner(System.in);

    /**
     * Taken from example tutorial from Mkyong
     * https://www.mkyong.com/java/how-to-automate-login-a-website-java-example/
     * @param args
     */
    public static void main(String[] args){
        String url = "https://open.kattis.com/login/email";
        String startDownloadPage = "https://open.kattis.com/problems?show_solved=on&show_tried=off&show_untried=off";

        String email = askForEmail();
        String password = askForPassword();

        HttpHandler http = new HttpHandler();

        CookieHandler.setDefault(new CookieManager());

        //1. Send "GET" request so that you can extract the forms data
        String page = http.GetPageContent(url);
        String postParams = http.getFormParams(page, email, password);

        //2. Construct above posts content and then send a POST request for
        //authentication
        http.sendPost(url, postParams);

    }

    private static String askForEmail() {
        System.out.print("Please enter your email: ");
        return reader.nextLine();
    }

    private static String askForPassword() {
        System.out.print("Please enter your password: ");
        return reader.nextLine();
    }
}
