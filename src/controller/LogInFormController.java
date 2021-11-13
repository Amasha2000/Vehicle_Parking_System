package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;

public class LogInFormController {
    public AnchorPane logInContext;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;

    public void openViewTableWindow(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().equals("admin")&&txtPassword.getText().equals("ad1234")&&!("".equalsIgnoreCase(txtUserName.getText()) || "".equalsIgnoreCase(txtPassword.getText()))){
            URL resource = getClass().getResource("../view/ViewTableForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) logInContext.getScene().getWindow();
            window.setScene(new Scene(load));
            return;
        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).showAndWait();
            txtUserName.clear();
            txtPassword.clear();
        }
    }

    public void cancelOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/FrontWindowForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) logInContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
