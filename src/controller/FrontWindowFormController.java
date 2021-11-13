package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Slots;
import model.Vehicle;



import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FrontWindowFormController extends ViewTableFormController {
    public Label lblDateAndTime;
    public AnchorPane firstWindowContext;
    public JFXComboBox cmbVehicleNum;
    public JFXComboBox cmbDriverName;
    public Label lblSlotNumber;
    public TextField txtVehicleType;



     ObservableList<String> obVehicleNumList= FXCollections.observableArrayList();
    ObservableList<String> obDriverNameList= FXCollections.observableArrayList();


    static Slots[] slot = new Slots[14];

    static boolean modify=false;

    public  static void slotNumbers() {

        if(!modify) {
            slot[0] = new Slots(1, "Van", true);
            slot[1] = new Slots(2, "Van", true);
            slot[2] = new Slots(3, "Van", true);
            slot[3] = new Slots(4, "Van", true);
            slot[4] = new Slots(5, "Cargo Lorry", true);
            slot[5] = new Slots(6, "Cargo Lorry", true);
            slot[6] = new Slots(7, "Cargo Lorry", true);
            slot[7] = new Slots(8, "Cargo Lorry", true);
            slot[8] = new Slots(9, "Cargo Lorry", true);
            slot[9] = new Slots(10, "Cargo Lorry", true);
            slot[10] = new Slots(11, "Cargo Lorry", true);
            slot[11] = new Slots(12, "Van", true);
            slot[12] = new Slots(13, "Van", true);
            slot[13] = new Slots(14, "Bus", true);
            modify=true;
        }

    }

    public void initialize(){
        for(String tempNum:AddVehicleFormController.vNum){
            obVehicleNumList.add(tempNum);
        }
        cmbVehicleNum.setItems(obVehicleNumList);

        for(String tempName:AddDriverFormController.dName){
            obDriverNameList.add(tempName);
        }
        cmbDriverName.setItems(obDriverNameList);

        initClock();
    }


    public void initClock(){
        Timeline clock=new Timeline(new KeyFrame(Duration.ZERO, e->{
            DateTimeFormatter formatter= DateTimeFormatter.ofPattern("\tyyyy-MM-dd\th:mm:ss a");
            lblDateAndTime.setText(LocalDateTime.now().format(formatter));
            lblDateAndTime.setFont(new Font("Arial",25));
        }),new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void openLogInWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LogInForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) firstWindowContext.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void selectNumber(ActionEvent actionEvent) {
        for (Vehicle v:AddVehicleFormController.vehicleList) {
                if(((String)cmbVehicleNum.getValue()).equals(v.getVehicleNumber())) {
                    txtVehicleType.setText(v.getVehicleType());
                }
        }
    }

    static String[][] Details=new String[2][14];
    static int count=0;
    public void getType(ActionEvent actionEvent) {
        for (Slots s : slot) {
            if (txtVehicleType.getText().equals(s.getVehicleType()) && s.isAvailable() == true) {
                lblSlotNumber.setText("      " + String.valueOf(s.getSlotId()));
                lblSlotNumber.setFont(new Font("Gothic Bold", 80));
                lblSlotNumber.setStyle("-fx-text-fill: Blue");

                Details[0][count] = (String) cmbVehicleNum.getValue();

                Details[1][count] = String.valueOf(s.getSlotId());
                count++;
                break;

            }
        }
    }

    public void parkOnAction(ActionEvent actionEvent)  {
        int index=-1;
        for(int i=0;i<14;i++) {
            if (Details[0][i] == cmbVehicleNum.getValue()) {
                index = i;
            }
        }
        for(int j=0;j<14;j++){
            if(j==index){
                for (Slots s1:slot) {
                    if(Details[1][j].equals(String.valueOf(s1.getSlotId()))&& s1.isAvailable()==true){
                        s1.setAvailable(false);
                        String vNum=(String)cmbVehicleNum.getValue();
                        String vType=txtVehicleType.getText();
                        String slotNum= lblSlotNumber.getText();
                        String parkedTime=lblDateAndTime.getText();

                        loadDetail(vNum,vType,slotNum,parkedTime);
                        new Alert(Alert.AlertType.CONFIRMATION,"This vehicle has parked successfully",ButtonType.CLOSE).show();
                        break;
                    }else if(Details[1][j].equals(String.valueOf(s1.getSlotId())) && s1.isAvailable()==false){
                        new Alert(Alert.AlertType.WARNING,"This vehicle is already parked", ButtonType.CLOSE).show();
                        break;
                    }
                }
            }
        }
    }

    public void deliveryOnAction(ActionEvent actionEvent) {
        int index=-1;
        for(int i=0;i<14;i++) {
            if (Details[0][i] == cmbVehicleNum.getValue()) {
                index = i;
            }
        }
        for(int j=0;j<14;j++){
            if(j==index){
                for (Slots s1:slot) {
                    if(Details[1][j].equals(String.valueOf(s1.getSlotId()))&& s1.isAvailable()==false){
                        s1.setAvailable(true);
                        String vNum=(String)cmbVehicleNum.getValue();
                        String vType=txtVehicleType.getText();
                        String name= (String) cmbDriverName.getValue();
                        String leftTime=lblDateAndTime.getText();

                        loadDetails(vNum,vType,name,leftTime);
                        new Alert(Alert.AlertType.CONFIRMATION,"This vehicle is On Delivery",ButtonType.CLOSE).show();
                        break;
                    }else if(Details[1][j].equals(String.valueOf(s1.getSlotId()))&& s1.isAvailable()==true){
                        new Alert(Alert.AlertType.WARNING,"This vehicle already On Delivery",ButtonType.CLOSE).show();
                        break;
                    }
                }
            }
        }
    }
 }
