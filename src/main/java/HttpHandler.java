import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HttpHandler {

    private HttpsURLConnection conn;
    private final String USER_AGENT = "Mozilla/5.0";
    private List<String> cookies;

    public HttpHandler() {

        CookieHandler.setDefault(new CookieManager());
    }

    public String GetPageContent(String url) {
        try {
            URL obj = new URL(url);
            conn = (HttpsURLConnection) obj.openConnection();

            conn.setRequestMethod("GET");
            conn.setUseCaches(false);

            //Act like a browser
            conn.setRequestProperty("User-Agent", USER_AGENT);
            conn.setRequestProperty("Accept",
                    "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            if (cookies != null) {
                for (String cookie : this.cookies) {
                    conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
                }
            }

            int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            
            in.close();
        
            setCookies(conn.getHeaderFields().get("Set-Cookie"));
            
            return response.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String getFormParams(String page, String email, String password) {
        System.out.println("Extracting form's data...");

        Document doc = Jsoup.parse(page);

        //

        return "";
    }

    public void sendPost(String url, String postParams) {

    }

    public String getPageContent(String startDownloadPage) {
        return "";
    }

    public void setCookies(List<String> cookies) {
        this.cookies = cookies;
    }
}
