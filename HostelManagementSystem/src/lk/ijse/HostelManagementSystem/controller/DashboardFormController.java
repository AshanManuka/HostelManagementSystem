package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane halfContext;
    public Label date;
    public Label loggedUser;
    public ImageView studentBtn;
    public ImageView roomBtn;
    public ImageView userBtn;
    public JFXButton logOutBtn;
    public ImageView newReservationBtn;

    //Navigation Part
    public void createReservation(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/reservationForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) newReservationBtn.getScene().getWindow();
        stage2.close();
    }

    //Navigation Part
    public void manageStudent(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/manageStudentForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) studentBtn.getScene().getWindow();
        stage2.close();
    }

    //Navigation Part
    public void manageRooms(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/manageRoomForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) roomBtn.getScene().getWindow();
        stage2.close();
    }

    //Navigation Part
    public void manageUser(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/manageUserForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) userBtn.getScene().getWindow();
        stage2.close();
    }

    //Navigation Part
    public void logOut(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/homeForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) logOutBtn.getScene().getWindow();
        stage2.close();
    }

    public void fillDate(){
        //set Date
    }

    public void fillLabel(){
        // set user label
    }
}
