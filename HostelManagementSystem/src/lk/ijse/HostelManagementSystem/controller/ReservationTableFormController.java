package lk.ijse.HostelManagementSystem.controller;

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
import lk.ijse.HostelManagementSystem.dto.ReservationDto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReservationTableFormController implements Initializable {

    public AnchorPane context;
    public ImageView homeBtn;
    public ImageView backBtn;
    public TableView<ReservationDto> resTable;
    public TableColumn resId;
    public TableColumn resDate;
    public TableColumn studentId;
    public TableColumn roomId;
    public TableColumn status;
    public Label selectedLbl;
    String selectedSId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        resTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("resId"));
        resTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("resDate"));
        resTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        resTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("roomId"));
        resTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("status"));

        resTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

               if (newValue != null) {
                selectedLbl.setText(newValue.getReservationId());
                selectedSId = newValue.getStudentId();
            }
        });



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

    public void deleteRes(ActionEvent actionEvent) {
        System.out.println(selectedSId);
        // set delete function
    }

}
