package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.InParking;

import java.io.IOException;
import java.net.URL;

public class InParkingFormController {
    public TableView tblPark;
    public TableColumn colNum;
    public TableColumn colName;
    public TableColumn colSlotNumber;
    public TableColumn colParkedTime;
    public AnchorPane InParkingContext;

    public void initialize(){
        colNum.setCellValueFactory(new PropertyValueFactory<>("vehicleNum"));
        colName.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colSlotNumber.setCellValueFactory(new PropertyValueFactory<>("slotNumber"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory<>("dataAndTime"));

    }

    public void loadDetails() {
        ObservableList<InParking> tmObservableList1= FXCollections.observableArrayList();
        for(InParking tempParking: FrontWindowFormController.parkingList) {
            tmObservableList1.add(new InParking(tempParking.getVehicleNum(), tempParking.getVehicleType(), tempParking.getSlotNumber(), tempParking.getDataAndTime()));
        }
        tblPark.setItems(tmObservableList1);
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ViewTableForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) InParkingContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
