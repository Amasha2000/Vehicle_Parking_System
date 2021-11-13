package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.InParking;
import model.OnDelivery;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ViewTableFormController{
    public AnchorPane viewTableContext;


    static ArrayList<InParking> parkingList=new ArrayList();

    public void loadDetail(String vehicleNum,String vehicleType,String slotNum,String parkedTime)  {

        InParking inParking=new InParking(vehicleNum,vehicleType,slotNum,parkedTime);

         if(parkingList.add(inParking)){

         }

    }

    static ArrayList<OnDelivery> onDeliveryList=new ArrayList();

    public void loadDetails(String vehicleNum,String vehicleType,String name,String leftTime) {

        OnDelivery onDelivery=new OnDelivery(vehicleNum,vehicleType,name,leftTime);

        if(onDeliveryList.add(onDelivery)){

        }

    }



    public void openAddVehicleWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(){


    }

    public void openAddDriverWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/FrontWindowForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) viewTableContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }


    public void addDetailParking(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/InParkingForm.fxml"));
        Parent parent = loader.load();
        InParkingFormController inParkingFormController=loader.getController();
        inParkingFormController.loadDetails();
        Scene scene=new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void addOnDeliveryDetail(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/OnDeliveryForm.fxml"));
        Parent parent = loader.load();
        OnDeliveryFormController onDeliveryFormController=loader.getController();
        onDeliveryFormController.loadDetails();
        Scene scene=new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
