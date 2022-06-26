package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ReservationFormController implements Initializable {
    public AnchorPane context;
    public ImageView homeBtn;
    public Text stIdTxt;
    public JFXTextField studentId;
    public Text stNameTxt;
    public Text stAddressTxt;
    public Text stContactTxt;
    public Text dobTxt;
    public Text genderTxt;
    public JFXTextField studentName;
    public JFXTextField studentAddress;
    public JFXTextField studentContact;
    public JFXRadioButton maleBtn;
    public javafx.scene.control.DatePicker DatePicker;
    public JFXRadioButton femaleBtn;
    public JFXComboBox roomIdBox;
    public Text idText;
    public Text typeText;
    public Text keyMoneyText;
    public JFXTextField keyMoney;
    public JFXTextField roomId;
    public JFXComboBox roomTypeBox;
    public JFXRadioButton payNow;
    public JFXButton checkRoomBtn;
    public JFXRadioButton payLater;
    public JFXButton checkAvailable;
    String gender;
    String status;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    // load room id to combo Box
    }

    // Navigation
    public void goHome(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/dashboardForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeBtn.getScene().getWindow();
        stage2.close();
    }

    // Navigation
    public void checkRooms(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/reservationTableForm.fxml"));
        context.getChildren().add(parent);
    }

    // Navigation
    public void checkAvailableRooms(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/availableRoomForm.fxml"));
        context.getChildren().add(parent);
    }

    public void comfirmReservation(ActionEvent actionEvent) {
        addStudent();
    }

    private void addStudent() {
        String sId = studentId.getText();
        String sName = studentName.getText();
        String sAddress = studentAddress.getText();
        String sContact = studentContact.getText();
        String dob = String.valueOf(DatePicker.getValue());
        // grab gender
        // add student

        selectRoom(sId);


    }

    private void selectRoom(String sId) {
     String resId = generateResId();
     String resDate = today();
     //grab sId
     String rmId = roomId.getText();
     // grab status


     // add to reservation table
     // decrease one room from room qty

    }

    private String today() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dte = dtf.format(now);
        return dte;
    }

    private String generateResId() {
    // generate reservation id
        return null;
    }


    public void genderAction(ActionEvent actionEvent) {
        if (maleBtn.isSelected()){
            gender = "Male";
            femaleBtn.setSelected(false);
        }
        if (femaleBtn.isSelected()){
            gender = "Female";
            maleBtn.setSelected(false);
        }
    }

    public void payAction(ActionEvent actionEvent) {
        if (payNow.isSelected()){
            status = "Key Money is Done";
            payLater.setSelected(false);
        }
        if (payLater.isSelected()){
            status = "Key Money is not Payed";
            payNow.setSelected(false);
        }
    }
}
