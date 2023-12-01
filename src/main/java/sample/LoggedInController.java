package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    @FXML
    private Button button_logout;
    @FXML
    private Button button_wordle;
    @FXML
    private Button button_flags;
    @FXML
    Label lable_welcome;

    //TODO: apskatīties vai man vajag arī bildes ielinkot

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Ja lietotājs noklikšķina uz šo pogu, tad tiek izpildīts šis
        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //switch between log in and sign in and logg out
                DBUtils.changeScene(event, "sample.fxml","Log in!", null, null);
            }
        });

    }

    //Metode, kura paņems no DB informāciju par lietotāju
    public void setUserInformation(String username){
        lable_welcome.setText(("Welcome " + username + "!"));
        //Te var pielikt klāt wins ectr. no DB
    }
}
