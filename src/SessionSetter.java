import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SessionSetter {
    public static void main(String[] args) throws IOException {
        String url = "https://www.naver.com/";
        HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
        String cookie = con.getHeaderField("Set-Cookie");
        System.out.println("cookie : " + cookie);
        String tmp = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            while((tmp = br.readLine())!= null){
                    System.out.println(tmp);
                }
            }
        }
    }
}
