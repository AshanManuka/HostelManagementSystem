package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXPasswordField;
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

public class ManageUserFormController {
    public AnchorPane context;
    public ImageView homeBtn;
    public Text idText;
    public JFXTextField userId;
    public Text nameText;
    public JFXTextField userName;
    public Text addressText;
    public JFXTextField userAddress;
    public Text contactText;
    public Text userNameText;
    public JFXTextField userContact;
    public JFXTextField uName;
    public Text passwordText1;
    public Text passwordText2;
    public JFXPasswordField uPassword;
    public JFXPasswordField comfirmPassword;

    public void goHome(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/dashboardForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeBtn.getScene().getWindow();
        stage2.close();
    }

    public void updateUser(ActionEvent actionEvent) {
        System.out.println("update user");
    }

    public void deleteUser(ActionEvent actionEvent) {
        System.out.println("delete user");
    }
}
