package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageRoomFormController {
    public AnchorPane context;
    public ImageView homeBtn;
    public JFXComboBox roomIdBox;
    public Text idText;
    public Text typeText;
    public Text keyMoneyText;
    public Text qtyText;
    public JFXTextField roomId;
    public JFXTextField keyMoney;
    public JFXTextField roomType;
    public JFXTextField qty;
    public JFXComboBox roomTypeBox;

    // navigation
    public void goHome(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/dashboardForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeBtn.getScene().getWindow();
        stage2.close();
    }

    
    public void addRoom(ActionEvent actionEvent) {
        System.out.println("add room function");
    }

    public void updateRoom(ActionEvent actionEvent) {
        System.out.println("update room function");
    }

    public void deleteRoom(ActionEvent actionEvent) {
        System.out.println("Delete room function");
    }

    public void clearData(ActionEvent actionEvent) {
        System.out.println("clear data");
    }

}
