package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.OnDelivery;

public class OnDeliveryFormController {
    public TableView tblOnDelivery;
    public TableColumn colVehicleNum;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;

    public void loadDetails() {
        ObservableList<OnDelivery> tmObservableList= FXCollections.observableArrayList();
        for(OnDelivery tempOnDelivery: FrontWindowFormController.onDeliveryList) {
            tmObservableList.add(new OnDelivery(tempOnDelivery.getVehicleNumber(), tempOnDelivery.getVehicleType(), tempOnDelivery.getDriverName(), tempOnDelivery.getLeftTime()));
        }
        tblOnDelivery.setItems(tmObservableList);
    }
        public void initialize(){
            colVehicleNum.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
            colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
            colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
            colLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));

        }
   }
