package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
import java.util.regex.Pattern;

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
    public JFXButton updateBtn;
    public JFXButton deleteBtn;
    public JFXButton addBtn;
    public Rectangle rectangleId;
    RoomBoImpl roomBoImpl = (RoomBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    int i =0;

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateBtn.setDisable(true);
        deleteBtn.setDisable(true);
        loadAllId();

        roomIdBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String nwValue = (String) newValue;
            roomId.setText(nwValue);
            updateBtn.setDisable(false);
            deleteBtn.setDisable(false);

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
        ObservableList oList = FXCollections.observableArrayList(room);
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
        if (ok) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted Room !").showAndWait();
            clearFields();
        }else{
            new Alert(Alert.AlertType.WARNING, "Something Went Wrong !").showAndWait();
        }
    }


    public void addAndUpdate(String methName) throws Exception {

        String roomTypeId = roomId.getText();
        String rType = roomType.getText();
        String kMoney = keyMoney.getText();
        int qt = Integer.parseInt(qty.getText());

        if (methName.equals("add")) {

            Room room = new Room(roomTypeId, rType, kMoney, qt);
            boolean add = roomBoImpl.saveRoom(room);
            if (add) {
                new Alert(Alert.AlertType.CONFIRMATION, "Added Room !").showAndWait();
                clearFields();
            }else{
                new Alert(Alert.AlertType.WARNING, "Something went Wrong !").showAndWait();
            }

        } else if (methName.equals("update")) {
            Room room = new Room(roomTypeId, rType, kMoney, qt);
            boolean updated = roomBoImpl.updateRoom(room);
            if (updated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated Room  !").showAndWait();
                clearFields();
            }else{
                new Alert(Alert.AlertType.WARNING, "Something went Wrong !").showAndWait();
            }
        }
    }

    public void clearData(ActionEvent actionEvent) {
      clearFields();
    }

    private void clearFields() {
        roomId.setStyle(null);
        roomType.setStyle(null);
        keyMoney.setStyle(null);
        addBtn.setDisable(true);
        roomId.clear();
        roomType.clear();
        keyMoney.clear();
        qty.clear();
    }


    public void keyRelease(KeyEvent keyEvent) {
        /*String rId = roomId.getText();
        String rType = roomType.getText();
        String rKeyMoney = keyMoney.getText();
        String q = qty.getText();

        Pattern comRoomId = Pattern.compile("^[A-z0-9 ,/]{4,25}$");
        Pattern comRoomType = Pattern.compile("^[A-z0-9 ,/]{4,25}$");
        Pattern comRoomKey = Pattern.compile("^[A-z0-9 ,/]{4,25}$");
        Pattern comRoomQty = Pattern.compile("^[0-9]{1,3}$");

        boolean matchesId = comRoomId.matcher(rId).matches();
        boolean matchesType = comRoomType.matcher(rType).matches();
        boolean matchesKey = comRoomKey.matcher(rKeyMoney).matches();
        boolean matchesQty = comRoomQty.matcher(q).matches();

        if (matchesId) {
            roomId.setStyle("-fx-border-style: solid");
            roomId.setStyle("-fx-border-color: #70ff5f");
            if (keyEvent.getCode() == KeyCode.ENTER) {
                roomType.requestFocus();
            }
        } else {
            System.out.println("");
        }
        if (matchesType) {
            roomType.setStyle("-fx-border-style: solid");
            roomType.setStyle("-fx-border-color: #70ff5f");
            if (keyEvent.getCode() == KeyCode.ENTER) {
                keyMoney.requestFocus();
            } else {
                System.out.println("");
            }
        }if (matchesKey) {
            keyMoney.setStyle("-fx-border-style: solid");
            keyMoney.setStyle("-fx-border-color: #70ff5f");
            if (keyEvent.getCode() == KeyCode.ENTER) {
                qty.requestFocus();
            } else {
                System.out.println("");
            }
        }if (matchesQty) {
            qty.setStyle("-fx-border-style: solid");
            qty.setStyle("-fx-border-color: #70ff5f");
            if (keyEvent.getCode() == KeyCode.ENTER) {
            addBtn.requestFocus();
            } else {
            System.out.println("");
             }
                }
*/

        if (keyEvent.getCode() == KeyCode.ENTER){
            i++;
            if (i == 1){
                roomType.requestFocus();
            }if (i == 2){
                keyMoney.requestFocus();
            }if(i == 3){
                qty.requestFocus();
            }
        }



    }

}

