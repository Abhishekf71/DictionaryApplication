package com.example.worddictionary;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {
    public TextField input_fld;
    public Button search_btn;
    public TextArea textarea_fld;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void getMeaning(ActionEvent actionEvent) {
        String word = input_fld.getText();
        InternetConnection internetConnection = new InternetConnection();
        String data = internetConnection.getOnlineData(word);

        if (data.equalsIgnoreCase("error")){
            textarea_fld.setText("Something Went Wrong! Try Again Later!!");
        } else {
            textarea_fld.setText(data);
        }


    }
}
