package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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


    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadAllId();

        roomIdBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String nwValue = (String) newValue;
            roomId.setText(nwValue);


            try {
                Room room = roomBoImpl.searchRoom(nwValue);
                roomType.setText(room.getRoomType());
                keyMoney.setText(room.getKeyMoney());
                qty.setText(String.valueOf(room.getQty()));


            } catch (Exception e) {
                e.printStackTrace();
            }

        });


    }

    private void loadAllId() throws Exception {
        ArrayList<String> room = roomBoImpl.searchRoomCode();
        ObservableList oList= FXCollections.observableArrayList(room);
        roomIdBox.setItems(oList);

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

    
    public void addRoom(ActionEvent actionEvent) throws Exception {
       String methName = "add";
       addAndUpdate(methName);
    }

    public void updateRoom(ActionEvent actionEvent) throws Exception {
        String methName = "update";
        addAndUpdate(methName);
    }

    public void deleteRoom(ActionEvent actionEvent) throws Exception {
        String rId = roomId.getText();
        boolean ok = roomBoImpl.deleteRoom(rId);
        if (ok){
            new Alert(Alert.AlertType.CONFIRMATION,"Room Deleted !").showAndWait();
        }
    }


    public void addAndUpdate(String methName) throws Exception {

        String roomTypeId = roomId.getText();
        String rType = roomType.getText();
        String kMoney = keyMoney.getText();
        int qt = Integer.parseInt(qty.getText());

        if (methName.equals("add")){

            Room room = new Room(roomTypeId,rType,kMoney,qt);
            boolean add = roomBoImpl.saveRoom(room);
            if (add){
                new Alert(Alert.AlertType.CONFIRMATION,"Room Added !").showAndWait();
            }

        }else if(methName.equals("update")){
            Room room = new Room(roomTypeId,rType,kMoney,qt);
            boolean updated = roomBoImpl.updateRoom(room);
            if (updated){
                new Alert(Alert.AlertType.CONFIRMATION,"Room Updated !").showAndWait();
            }
        }
    }

    public void clearData(ActionEvent actionEvent) {
        roomId.clear();
        roomType.clear();
        keyMoney.clear();
        qty.clear();
    }




}
