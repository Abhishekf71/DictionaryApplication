package com.example.worddictionary;

import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InternetConnection {

    String data = "";
    String decodeData;
    public String getOnlineData(String word){

        try {

            URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/"+word);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            if (con.getResponseCode() == 200){
                InputStream inputStream = con.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = bufferedReader.readLine();

                while (line != null){
                    data += line;
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
                JSONDecoder jsonDecoder = new JSONDecoder();
                decodeData = jsonDecoder.decoder(data);
            }else {
                decodeData = "error";
//                System.out.println("Internet Connection failed");
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("Something Went Wrong! Try Again Later");
//                alert.show();
            }
        }catch (Exception e){
            try {
                decodeData = "error";
                System.out.println(e);
            } catch (Exception e1){
                System.out.println(e1);
            }
        }
        return decodeData;
    }
}
