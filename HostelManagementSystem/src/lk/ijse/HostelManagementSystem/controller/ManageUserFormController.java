package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.StudentBo;
import lk.ijse.HostelManagementSystem.bo.custom.UserBo;

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
    private UserBo userBo = (UserBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    // Navigation
    public void goHome(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/dashboardForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeBtn.getScene().getWindow();
        stage2.close();
    }


    public void updateUser(ActionEvent actionEvent) {
        String p1 = uPassword.getText();
        String p2 = comfirmPassword.getText();

        if (p2.equals(p1)){
            update();
        }else{
        // Show alert about passwords are not match
        }
    }

    private void update() {
        String uId = userId.getText();
        String Name = userName.getText();
        String uAddress = userAddress.getText();
        int uContact = Integer.parseInt(userContact.getText());
        String usName = uName.getText();
        String newPassword = comfirmPassword.getText();

        // update function

    }

    public void deleteUser(ActionEvent actionEvent) {
        String uId = userId.getText();
        // delete function
    }
}
