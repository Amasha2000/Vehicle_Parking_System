package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Driver;

import java.util.ArrayList;

public class AddDriverFormController {
    public JFXTextField txtName;
    public JFXTextField txtNIC;
    public JFXTextField txtDrivingLicenseNo;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;

    static ArrayList<Driver> driverList=new ArrayList<>();
    static ArrayList<String> dName=new ArrayList<>();

    public boolean isExist(Driver driver){
        for(Driver d:driverList){
            if(d.getNic().equalsIgnoreCase(driver.getNic())){
                return true;
            }
        }
        return false;
    }


    public void addDriverOnAction(ActionEvent actionEvent) {
        Driver driver = new Driver(txtName.getText(), txtNIC.getText(), txtDrivingLicenseNo.getText(),
                txtAddress.getText(), txtContact.getText());
        if (isExist(driver)) {
            new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE).show();
        } else {
            if (driverList.add(driver)&& !("".equals(txtName.getText()) || "".equals(txtNIC.getText())||"".equals(txtDrivingLicenseNo.getText()) || "".equals(txtAddress.getText())||"".equals(txtContact.getText()))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully added", ButtonType.CLOSE).show();
                dName.add(txtName.getText());
                txtName.clear();
                txtNIC.clear();
                txtDrivingLicenseNo.clear();
                txtAddress.clear();
                txtContact.clear();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE).show();
            }
        }
    }
}
