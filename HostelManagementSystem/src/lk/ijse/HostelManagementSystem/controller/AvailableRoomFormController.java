package lk.ijse.HostelManagementSystem.controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.RoomBo;
import lk.ijse.HostelManagementSystem.dto.RoomDto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AvailableRoomFormController implements Initializable {
    public AnchorPane context;
    public TableView<RoomDto> roomTable;
    public TableColumn roomId;
    public TableColumn roomType;
    public TableColumn keyMoney;
    public TableColumn qty;
    public ImageView homeBtn;
    public ImageView backBtn;
    private RoomBo roomBo = (RoomBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        roomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        roomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        keyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        qty.setCellValueFactory(new PropertyValueFactory<>("qty"));

    }

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

    }

}
