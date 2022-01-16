import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class NaverTimeParser {

    public static void main(String[] args) throws IOException {

        String naver = "https://www.naver.com/";
        HttpURLConnection con = (HttpURLConnection)new URL(naver).openConnection();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String tmp = "";
            while((tmp = br.readLine())!= null){
                if(tmp.contains("svt")){
                    tmp = tmp.split(" ")[1].split(",")[0];
                    System.out.println(tmp);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                    LocalDateTime paresdTime = LocalDateTime.parse(tmp, formatter);
                    String naverTime = paresdTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
                    System.out.println(naverTime);
                    break;
                }
            }
        }

    }
}
