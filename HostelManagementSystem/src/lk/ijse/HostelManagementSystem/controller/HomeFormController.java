package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.UserBo;
import lk.ijse.HostelManagementSystem.bo.custom.impl.UserBoImpl;

import java.io.IOException;
import java.sql.SQLException;

public class HomeFormController {
    public JFXTextField userName;
    public JFXPasswordField password;
    public JFXButton loginBtl;
    public JFXButton cancelBtn;
    UserBoImpl userBoImpl = (UserBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);
    public static String loggedUser;

    //Check database & do login
    public void userLogin(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        String uNameId = userBoImpl.checkUserName(userName.getText());
        String passwordId = userBoImpl.checkPassword(password.getText());

        if (uNameId.equals(passwordId)){
            Parent parent = FXMLLoader.load(getClass().getResource("../view/dashboardForm.fxml"));
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(parent));
            stage1.show();

            Stage stage2 = (Stage) loginBtl.getScene().getWindow();
            stage2.close();
        }else{
            new Alert(Alert.AlertType.WARNING,"Doesn't match Username or Password !").showAndWait();
        }

    }

    // show password function
    public void showPassword(MouseEvent mouseEvent) {
        System.out.println("Show password function");
    }

    // close form
    public void cancelLogin(ActionEvent actionEvent) {
        System.out.println("Cancel function");
    }

    public void searchUser(){
        //  search user's name from userName
        // set loggedUser by the result
    }

}
