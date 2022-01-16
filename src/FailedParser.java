import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FailedParser {

    public static void main(String[] args) throws IOException {

        String daum = "https://search.daum.net/search?w=tot&q=%EC%A3%BC%EA%B0%84%EB%82%A0%EC%94%A8&nzq=%EB%82%A0%EC%94%A8&DA=RSJ";
        HttpURLConnection con = (HttpURLConnection)new URL(daum).openConnection();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String tmp = "";
            while((tmp = br.readLine())!= null){
                System.out.println(tmp); //크롤링 막는 로직이 있는듯함. 실패!
            }
        }

    }
}
