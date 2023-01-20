package RocketleagueApi;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Weather {

    public static void main(String[] args) {
        try {

            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Nagoya,jp&APPID=6136ad9e3aad1394587b85783e55a687");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                Scanner scanner = new Scanner(url.openStream());

                System.out.println(scanner.nextLine());

                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}