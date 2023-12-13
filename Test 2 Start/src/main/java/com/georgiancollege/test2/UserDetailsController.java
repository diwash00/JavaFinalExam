package com.georgiancollege.test2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.converter.NumberStringConverter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class UserDetailsController implements Initializable {

    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, Number> idColumn;

    @FXML
    private TableColumn<User, String> firstNameColumn;

    @FXML
    private TableColumn<User, String> lastNameColumn;

    @FXML
    private TableColumn<User, Number> ageColumn;

    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    private TableColumn<User, String> phoneColumn;

    @FXML
    private TableColumn<User, String> birthDateColumn;

    @FXML
    private TableColumn<User, String> universityColumn;

    @FXML
    private Label noOfUsersLabel;

    @FXML
    private ListView<String> addressListView;

    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set up PropertyValueFactory for each TableColumn
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        birthDateColumn.setCellValueFactory(cellData -> cellData.getValue().birthDateProperty());
        universityColumn.setCellValueFactory(cellData -> cellData.getValue().universityProperty());

        // Load data from the JSON file and populate the TableView
        loadUsersData();

        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
            @Override
            public void changed(ObservableValue<? extends User> observableValue, User oldValue, User newValue) {
                if (newValue != null) {
                    // Display the selected user's address in the addressListView
                    displayUserAddress(newValue.addressProperty().get());
                }
            }
        });
    }

    private void loadUsersData() {
        // Call the JsonParser.parseJsonFile method to get the array of User objects
        User[] users = JsonParse.jsonFileParser("users.json");

        // Check if the parsing was successful
        if (users != null) {
            // Create an ObservableList from the array of User objects
            ObservableList<User> usersList = FXCollections.observableArrayList(users);

            // Set the data in the TableView
            tableView.setItems(usersList);

            // Update the label with the number of users
            noOfUsersLabel.setText("No. of Users: " + usersList.size());

        }
    }

    private void displayUserAddress(Address address) {
        if (address != null) {
            // Display the selected user's address in the addressListView
            ObservableList<String> addressDetails = FXCollections.observableArrayList(
                    "Address: " + address.getAddress(),
                    "City: " + address.getCity(),
                    "Postal Code: " + address.getPostalCode(),
                    "State: " + address.getState()
            );

            addressListView.setItems(addressDetails);
        }
    }

    private void displayUserDetails(User user) {
        if (user != null) {
            // Display the selected user's address in the addressListView
            displayUserAddress(user.addressProperty().get());

            // Change the image in the imageView
            displayUserImage(user.getImage());
        }
    }

    private void displayUserImage(String imageUrl) {
        if (imageUrl != null && !imageUrl.isEmpty()) {
            // Load the image and set it in the imageView
            Image image = new Image(imageUrl);
            imageView.setImage(image);
        }
    }

    @FXML
    void allUsersButton_onClick(ActionEvent event) {

    }

    @FXML
    void usersLessThan30Button_onClick(ActionEvent event) {
        // Get all users from the table
        ObservableList<User> allUsers = tableView.getItems();

        // Filter users with age less than 30
        List<User> usersLessThan30 = allUsers.stream()
                .filter(user -> user.getAge() < 30)
                .collect(Collectors.toList());

        // Update the TableView with filtered users
        tableView.setItems(FXCollections.observableArrayList(usersLessThan30));

        // Update the label to dynamically show the number of rows in the table
        noOfUsersLabel.setText("No. of Users: " + usersLessThan30.size());
    }

}
