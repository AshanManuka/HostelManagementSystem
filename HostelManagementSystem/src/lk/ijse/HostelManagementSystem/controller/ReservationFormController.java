package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ReservationFormController {
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

    public void goHome(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/dashboardForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeBtn.getScene().getWindow();
        stage2.close();
    }

    public void checkRooms(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/reservationTableForm.fxml"));
        context.getChildren().add(parent);
    }

    public void comfirmReservation(ActionEvent actionEvent) {
        System.out.println("confirm booking");
    }

    public void checkAvailableRooms(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/availableRoomForm.fxml"));
        context.getChildren().add(parent);
    }
}
