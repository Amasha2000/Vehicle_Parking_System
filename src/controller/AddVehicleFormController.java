package controller ;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Vehicle;

import java.util.ArrayList;

public class AddVehicleFormController {
    public JFXTextField txtVehicleNumber;
    public JFXTextField txtMaximumWeight;
    public JFXTextField txtNumberOfPassengers;
    public JFXComboBox cmbVehicleType;

    public void initialize(){
        cmbVehicleType.getItems().addAll(
                "Bus","Van","Cargo Lorry"
        );
    }

    static ArrayList<Vehicle> vehicleList=new ArrayList<>();
    static ArrayList<String> vNum=new ArrayList<>();

    public boolean isExists(Vehicle vehicle){
        for(Vehicle v:vehicleList){
            if(v.getVehicleNumber().equalsIgnoreCase(vehicle.getVehicleNumber())){
                return true;
            }
        }
        return false;
    }

    public void addVehicleOnAction(ActionEvent actionEvent) {
            FrontWindowFormController.slotNumbers();
            try {
                Vehicle vehicle = new Vehicle(txtVehicleNumber.getText(), (String) cmbVehicleType.getValue(), Integer.parseInt(txtMaximumWeight.getText()), Integer.parseInt(txtNumberOfPassengers.getText()));
                if (isExists(vehicle)) {
                    new Alert(Alert.AlertType.WARNING, "Already Exists", ButtonType.CLOSE).show();
                } else {
                    if (vehicleList.add(vehicle) && !("".equals(txtVehicleNumber.getText()) || "".equals(txtMaximumWeight.getText()) || ("".equals(txtNumberOfPassengers.getText()) || "".equals((String) cmbVehicleType.getValue())))) {

                        new Alert(Alert.AlertType.CONFIRMATION, "Successfully added", ButtonType.CLOSE).show();
                        vNum.add(txtVehicleNumber.getText());
                        txtVehicleNumber.clear();
                        txtMaximumWeight.clear();
                        txtNumberOfPassengers.clear();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE).show();
                    }
                }
            } catch (NumberFormatException exception) {
                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE).show();
            }
    }
}
