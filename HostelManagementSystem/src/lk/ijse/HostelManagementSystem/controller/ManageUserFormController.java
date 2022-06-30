package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import lk.ijse.HostelManagementSystem.bo.custom.impl.RoomBoImpl;
import lk.ijse.HostelManagementSystem.bo.custom.impl.UserBoImpl;
import lk.ijse.HostelManagementSystem.entity.User;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManageUserFormController implements Initializable {
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
    public JFXButton updateb;
    public JFXButton delete;
    public JFXButton add;
    public JFXButton clear;
    UserBoImpl userBoImpl = (UserBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String newId = generateNewId();
        userId.setText(newId);
    }

    private String generateNewId() throws SQLException, ClassNotFoundException {
    String lastId = userBoImpl.generateNewUserId();
        if (lastId != null) {
            int newId = Integer.parseInt(lastId.replace("U00-", "")) + 1;
            return String.format("U00-%03d", newId);
        } else {
            return "U00-001";
        }
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


    public void updateUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String p1 = uPassword.getText();
        String p2 = comfirmPassword.getText();

        if (p2.equals(p1)){
            String s = "update";
            addAndUpdate(s);
        }else{
            new Alert(Alert.AlertType.WARNING,"Passwords are Doesn't Match !..").showAndWait();
        }
    }

    private void addAndUpdate(String s) throws SQLException, ClassNotFoundException {
        String uId = userId.getText();
        String Name = userName.getText();
        String uAddress = userAddress.getText();
        int uContact = Integer.parseInt(userContact.getText());
        String usName = uName.getText();
        String newPassword = comfirmPassword.getText();

        if(s.equals("add")){
            User user = new User(uId,Name,uAddress,uContact,usName,newPassword);
            boolean add = userBoImpl.saveUser(user);
        }else if(s.equals("update")){
            User user = new User(uId,Name,uAddress,uContact,usName,newPassword);
            boolean updated = userBoImpl.updateUser(user);
        }

    }

    public void deleteUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String uId = userId.getText();
        boolean deleted = userBoImpl.deleteUser(uId);
    }

    public void addRoom(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String s = "add";
        addAndUpdate(s);
    }

    public void clearData(ActionEvent actionEvent) {
    userId.clear();
    uName.clear();
    userAddress.clear();
    userContact.clear();
    userName.clear();
    uPassword.clear();
    comfirmPassword.clear();

    }

    public void searchUser(ActionEvent actionEvent) {
        // find me using static variable from loggin
        // button must be large
    }

}
