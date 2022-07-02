package lk.ijse.HostelManagementSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.impl.ReservationBoImpl;
import lk.ijse.HostelManagementSystem.bo.custom.impl.RoomBoImpl;
import lk.ijse.HostelManagementSystem.dto.ReservationDto;
import lk.ijse.HostelManagementSystem.entity.Reservation;
import lk.ijse.HostelManagementSystem.entity.Room;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationTableFormController implements Initializable {

    public AnchorPane context;
    public ImageView homeBtn;
    public ImageView backBtn;
    public TableView<Reservation> resTable;
    public TableColumn resId;
    public TableColumn resDate;
    public TableColumn studentId;
    public TableColumn roomId;
    public TableColumn status;
    public Label selectedLbl;
    public TableColumn roomType;
    public TableColumn date;
    String selectedSId;
    ReservationBoImpl reservationBo = (ReservationBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);
    RoomBoImpl roomBoImpl = (RoomBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);


    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        resTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("resId"));
        resTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        resTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        resTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("date"));
        resTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("status"));

        loadReservations();

        resTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

               if (newValue != null) {
                selectedSId = newValue.getRoomTypeId();
                String s = newValue.getResId();
                selectedLbl.setText(s);
               }
        });
}

    private void loadReservations() throws Exception {
        List<Reservation> reservationList = reservationBo.getAllReservation();
        ObservableList<Reservation> list = FXCollections.observableArrayList();
        list.addAll(reservationList);
        resTable.setItems(list);
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
    public void goBack(MouseEvent mouseEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/reservationForm.fxml"));
        context.getChildren().add(parent);
    }

    public void deleteRes(ActionEvent actionEvent) throws Exception {
        boolean b = reservationBo.deleteReservation(selectedLbl.getText());
        Room room = roomBoImpl.searchType(selectedSId);
        int newQty = roomBoImpl.searchRoomQtyDel(selectedSId,"increase");
        Room room2 = new Room(room.getRoomId(),selectedSId,room.getKeyMoney(),newQty);
        boolean c = roomBoImpl.updateRoom(room2);

    }

}
