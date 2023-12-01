package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.channels.ConnectionPendingException;

public class DBUtils {

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username, String favChannel){
        Parent root = null;

        if(username != null ){
            try{
                //loads objects from fxml file
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                LoggedInController loggedInController = loader.getController();
                loggedInController.setUserInformation(username);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            try{
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

    //TODO man nesavienojas ar DB [54:10]
    public static void signUpUser(ActionEvent event, String username, String password, String email){
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExits = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordle_2023","root","edann130822");
            psCheckUserExits = connection.prepereStatement("SELECT * FROM user_information WHERE username = ?");
            psCheckUserExits.setString(1, username);
            resultSet = psCheckUserExits.executeQuery();

            if(resultSet.isBeforeFirst()){
                System.out.println("User already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username");
                alert.show();
            }else{
                psInsert = connection.prepereStatement("INSERT INTO user_information (username, password, email VALUES(?, ?, ?))");
                psInsert.setString(1, username);
                psInsert.setString(2, password);
                psInsert.setString(3, email);
                psInsert.executeUpdate();

                changeScene(event, "logged-in.fxml", "Welcome!", username);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try{
                    resultSet.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
