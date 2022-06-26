package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.HostelManagementSystem.dto.StudentDto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageRoomFormController implements Initializable {
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
    // create dependency Injection

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // set Room Ids to combo box
    }

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
       String methName = "add";
    }

    public void updateRoom(ActionEvent actionEvent) {
        String methName = "update";
    }

    public void deleteRoom(ActionEvent actionEvent) {
        // set Dependency injection with roomBo and continue delete room
    }


    public void addAndUpdate(String methName){

        String roomTypeId = roomId.getText();
        String rType = roomType.getText();
        String kMoney = keyMoney.getText();
        int qt = Integer.parseInt(qty.getText());

        if (methName.equals("add")){
            // set Dependency injection with roomBo and continue adding room
        }else if(methName.equals("update")){
            // set Dependency injection with roomBo and continue update room
        }
    }

    public void clearData(ActionEvent actionEvent) {
        roomId.clear();
        roomType.clear();
        keyMoney.clear();
        qty.clear();
    }


}
