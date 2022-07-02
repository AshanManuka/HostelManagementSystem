package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.RoomBo;
import lk.ijse.HostelManagementSystem.bo.custom.StudentBo;
import lk.ijse.HostelManagementSystem.bo.custom.impl.ReservationBoImpl;
import lk.ijse.HostelManagementSystem.bo.custom.impl.RoomBoImpl;
import lk.ijse.HostelManagementSystem.bo.custom.impl.StudentBoImpl;
import lk.ijse.HostelManagementSystem.dto.StudentDto;
import lk.ijse.HostelManagementSystem.entity.Reservation;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.entity.Student;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    public JFXTextField roomType;
    StudentBoImpl studentBoImpl = (StudentBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    RoomBoImpl roomBoImpl = (RoomBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    ReservationBoImpl reservationBo = (ReservationBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);
    String gender;
    String status;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String sId = generateStudentId();
        studentId.setText(sId);

        try {
            loadAllId();
        } catch (Exception e) {
            e.printStackTrace();
        }

        roomIdBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String nwValue = (String) newValue;
            try {
                Room room = roomBoImpl.searchRoom(nwValue);
                roomType.setText(room.getRoomType());
                keyMoney.setText(room.getKeyMoney());
                String newResId = generateRoomId();
                roomId.setText(newResId);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    private String generateRoomId() throws Exception {
        String rId =reservationBo.generateNewId();
        if (rId != null) {
            int newId = Integer.parseInt(rId.replace("RES-", "")) + 1;
            return String.format("RES-%03d", newId);
        } else {
            return "RES-001";
        }
    }

    private void loadAllId() throws Exception {
        ArrayList<String> room = roomBoImpl.searchRoomCode();
        ObservableList oList= FXCollections.observableArrayList(room);
        roomIdBox.setItems(oList);
    }

    @SneakyThrows
    private String generateStudentId() {
        String stId = studentBoImpl.generateNewStudentId();
        if (stId != null) {
            int newId = Integer.parseInt(stId.replace("S00-", "")) + 1;
            return String.format("S00-%03d", newId);
        } else {
            return "S00-001";
        }
    }


    public void comfirmReservation(ActionEvent actionEvent) throws Exception {
        addStudent();
    }

    private void addStudent() throws Exception {
        String sId = studentId.getText();
        String sName = studentName.getText();
        String sAddress = studentAddress.getText();
        String sContact = studentContact.getText();
        String dob = String.valueOf(DatePicker.getValue());
        String gd = gender;

        boolean s = studentBoImpl.saveStudent(new Student(sId,sName,sAddress,Integer.parseInt(sContact),dob,gd));
        selectRoom(sId);
    }

    private void selectRoom(String sId) throws Exception {
     String resId = roomId.getText();
     String roomT = roomType.getText();
     String resDate = today();
     String rmId = roomId.getText();

     Reservation res = new Reservation(resId,roomT,sId,resDate,status);
     boolean r = reservationBo.saveReservation(res);
     if (r){
         System.out.println("done");
     }
     manageRoom();
    }

    private void manageRoom() throws Exception {
        String selectedRoom = roomType.getText();

        boolean d = roomBoImpl.updateQty(selectedRoom);
    }

    private String today() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dte = dtf.format(now);
        return dte;
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

}
