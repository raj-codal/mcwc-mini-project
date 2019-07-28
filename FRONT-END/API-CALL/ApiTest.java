package apitest;

import java.net.*;
import java.io.*;

public class ApiTest {

    public static void main(String[] args) {

        final String urlString = "https://xenotest.000webhostapp.com/techquiz.php";
        String data = "name=USERNAME&enrollment=ENROLLMENT&email=EMAILADDRESS";
        try {
            URL url = new URL(urlString);
            HttpURLConnection httpsCon = (HttpURLConnection) url.openConnection();
            httpsCon.setRequestMethod("POST");
            httpsCon.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(httpsCon.getOutputStream());
            out.writeBytes(data);
            out.flush();
            out.close();

            int responseCode = httpsCon.getResponseCode();
            System.out.println("Response Code:" + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(httpsCon.getInputStream()));
            String l;
            StringBuffer response = new StringBuffer();
            while ((l = in.readLine()) != null) {
                response.append(l);
            }
            in.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
