package lk.ijse.HostelManagementSystem.controller;

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

public class ManageStudentFormController {
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

    public void goHome(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/dashboardForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeBtn.getScene().getWindow();
        stage2.close();
    }

    public void addStudent(ActionEvent actionEvent) {
        System.out.println("add student");
    }

    public void updateStudent(ActionEvent actionEvent) {
        System.out.println("update student");
    }

    public void deleteStudent(ActionEvent actionEvent) {
        System.out.println("delete student");
    }

    public void clearData(ActionEvent actionEvent) {
        System.out.println("clear");
    }
}
