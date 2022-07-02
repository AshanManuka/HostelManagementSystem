package lk.ijse.HostelManagementSystem.controller;

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
    StudentBoImpl studentBoImpl = (StudentBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadAllId();

        studentIdBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String nwValue = String.valueOf(newValue);
            studentId.setText(nwValue);
            try {
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
    }

    public void deleteStudent(ActionEvent actionEvent) throws Exception {
        String sId = studentId.getText();
        boolean d = studentBoImpl.deleteStudent(sId);
    }

    public void clearData(ActionEvent actionEvent) {
        studentId.clear();
        studentName.clear();
        studentAddress.clear();
        studentContact.clear();
        dobField.clear();
        genderField.clear();
    }

}
