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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.StudentBo;
import lk.ijse.HostelManagementSystem.bo.custom.impl.StudentBoImpl;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.entity.Student;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ManageStudentFormController implements Initializable {
    public AnchorPane context;
    public ImageView homeBtn;
    public JFXComboBox studentIdBox;
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
    public JFXRadioButton femaleBtn;
    public javafx.scene.control.DatePicker DatePicker;
    public JFXTextField dobField;
    public JFXTextField genderField;
    public JFXButton updateBtn;
    public JFXButton deleteBtn;
    StudentBoImpl studentBoImpl = (StudentBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    int i = 0;

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateBtn.setDisable(true);
        deleteBtn.setDisable(true);
        loadAllId();

        studentIdBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String nwValue = String.valueOf(newValue);
            studentId.setText(nwValue);
            try {
                updateBtn.setDisable(false);
                deleteBtn.setDisable(false);
                Student student = studentBoImpl.searchStudent(String.valueOf(newValue));
                studentName.setText(student.getStudentName());
                studentAddress.setText(student.getStudentAddress());
                studentContact.setText(String.valueOf(student.getContact()));
                dobField.setText(student.getDob());
                genderField.setText(student.getGender());

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }

    private void loadAllId() throws Exception {
        ArrayList<String> student = studentBoImpl.searchStudentCode();
        ObservableList oList= FXCollections.observableArrayList(student);
        studentIdBox.setItems(oList);
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


    public void updateStudent(ActionEvent actionEvent) throws Exception {
        String sId = studentId.getText();
        String sName = studentName.getText();
        String sAddress = studentAddress.getText();
        String sContact = studentContact.getText();
        String sDob = dobField.getText();
        String gender = genderField.getText();
        boolean b = studentBoImpl.updateStudent(new Student(sId,sName,sAddress,Integer.parseInt(sContact),sDob,gender));
        if (b) {
            new Alert(Alert.AlertType.CONFIRMATION, "Updated Student !").showAndWait();
            clearFields();
        }else{
            new Alert(Alert.AlertType.WARNING, "Something Went Wrong !").showAndWait();
        }
    }

    public void deleteStudent(ActionEvent actionEvent) throws Exception {
        String sId = studentId.getText();
        boolean d = studentBoImpl.deleteStudent(sId);
        if (d) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted Student !").showAndWait();
            clearFields();
        }else{
            new Alert(Alert.AlertType.WARNING, "Something Went Wrong !").showAndWait();
        }
    }

    public void clearData(ActionEvent actionEvent) {
       clearFields();
    }

    private void clearFields() {
        studentId.clear();
        studentName.clear();
        studentAddress.clear();
        studentContact.clear();
        dobField.clear();
        genderField.clear();
    }

    public void keyRelease(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            i++;
            if (i == 1){
                studentName.requestFocus();
            }if (i == 2){
                studentAddress.requestFocus();
            }if(i == 3){
                studentContact.requestFocus();
            }if (i == 4){
                dobField.requestFocus();
            }if (i == 5){
                genderField.requestFocus();
            }
        }
    }


    /*public void keyRelease(KeyEvent keyEvent) {
        String sId = roomId.getText();
        String sName = roomType.getText();
        String sAddress = keyMoney.getText();
        String sContact = qty.getText();

        Pattern comId = Pattern.compile("^[A-z0-9 ,/]{4,25}$");
        Pattern comType = Pattern.compile("^[A-z0-9 ,/]{4,25}$");
        Pattern comKey = Pattern.compile("^[A-z0-9 ,/]{4,25}$");
        Pattern comQty = Pattern.compile("^[0-9]{1,3}$");

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
        if (matchesName) {
            roomType.setStyle("-fx-border-style: solid");
            roomType.setStyle("-fx-border-color: #70ff5f");
            if (keyEvent.getCode() == KeyCode.ENTER) {
                keyMoney.requestFocus();
            } else {
                System.out.println("");
            }
        }if (matchesAddress) {
            keyMoney.setStyle("-fx-border-style: solid");
            keyMoney.setStyle("-fx-border-color: #70ff5f");
            if (keyEvent.getCode() == KeyCode.ENTER) {
                qty.requestFocus();
            } else {
                System.out.println("");
            }
        }if (matchesContact) {
            qty.setStyle("-fx-border-style: solid");
            qty.setStyle("-fx-border-color: #70ff5f");
            if (keyEvent.getCode() == KeyCode.ENTER) {
                addBtn.requestFocus();
            } else {
                System.out.println("");
            }
        }*/



}
