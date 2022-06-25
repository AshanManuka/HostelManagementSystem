package lk.ijse.HostelManagementSystem.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AvailableRoomFormController {
    public AnchorPane context;
    public TableView roomTable;
    public TableColumn roomId;
    public TableColumn roomType;
    public TableColumn keyMoney;
    public TableColumn qty;
    public ImageView homeBtn;
    public ImageView backBtn;

    //Navigation Part
    public void goHome(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/dashboardForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeBtn.getScene().getWindow();
        stage2.close();
    }

    //Navigation Part
    public void goBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/reservationForm.fxml"));
        context.getChildren().add(parent);
    }


    public void loadEmptyRooms(){
        //Load Empty rooms
        // call dependency
    }

}
