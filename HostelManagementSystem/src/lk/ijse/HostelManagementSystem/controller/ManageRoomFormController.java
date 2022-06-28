package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.RoomBo;
import lk.ijse.HostelManagementSystem.bo.custom.impl.RoomBoImpl;
import lk.ijse.HostelManagementSystem.dto.RoomDto;
import lk.ijse.HostelManagementSystem.dto.StudentDto;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    RoomBoImpl roomBoImpl = (RoomBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);


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

    
    public void addRoom(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       String methName = "add";
       addAndUpdate(methName);
    }

    public void updateRoom(ActionEvent actionEvent) {
        String methName = "update";
    }

    public void deleteRoom(ActionEvent actionEvent) {
        // set Dependency injection with roomBo and continue delete room
    }


    public void addAndUpdate(String methName) throws SQLException, ClassNotFoundException {

        String roomTypeId = roomId.getText();
        String rType = roomType.getText();
        String kMoney = keyMoney.getText();
        int qt = Integer.parseInt(qty.getText());

        if (methName.equals("add")){

            Room room = new Room(roomTypeId,rType,kMoney,qt);
            roomBoImpl.saveRoom(room);

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
