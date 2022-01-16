import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DaumParser {

    public static void main(String[] args) throws IOException {

        String daum = "https://search.daum.net/search?w=tot&q=%EC%A3%BC%EA%B0%84%EB%82%A0%EC%94%A8&nzq=%EB%82%A0%EC%94%A8&DA=RSJ";
        HttpURLConnection con = (HttpURLConnection)new URL(daum).openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String tmp = "";
            while((tmp = br.readLine())!= null){
                    System.out.println(tmp);
                if(tmp.contains("<span class=\"keyword_rank\"")){
                    System.out.println(tmp);
                }
            }
        }

    }
}
