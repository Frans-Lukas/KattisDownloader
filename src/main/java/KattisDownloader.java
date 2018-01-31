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
        System.out.println();
        String password = askForPassword();

        KattisDownloader http = new KattisDownloader();

        CookieHandler.setDefault(new CookieManager());

        String page = http.GetPageContent(url);
        //String postParams = http.getFormParams(page, email, password)

    }

    private static String askForPassword() {
        System.out.print("Please enter your password: ");
        return reader.nextLine();
    }

    private static String askForEmail() {
        System.out.print("Please enter your email: ");
        return reader.nextLine();
    }

    private String GetPageContent(String url) {

        return "";
    }
}
