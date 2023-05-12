package com.example.contactappmodification;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.example.contactappmodification.Contact;

public class ContactsController {

    private final ObservableList<Contact> contacts = FXCollections.observableArrayList();
    private Contact contactCurrent;
    @FXML
    private ListView<Contact> booksListView;
    @FXML
    private ImageView coverImageView;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNumberTextField;


    @FXML
    void addContactButtonPressed(ActionEvent event) {
        Contact obj1 = new Contact();
        obj1.setFirstName(firstNameTextField.getText().trim());
        obj1.setLastName(lastNameTextField.getText().trim());
        obj1.setEmail(emailTextField.getText().trim());
        obj1.setPhoneNumber(phoneNumberTextField.getText().trim());
        obj1.setImage("C:\\Users\\dastan.akatov\\IdeaProjects\\JavaFXProblems\\ModifiedContacts\\src\\main\\java\\Images\\2023-05-06-203834.jpg");
        contacts.add(obj1);

    }

    @FXML
    void deleteContactButtonPressed(ActionEvent event) {
        contacts.remove(contactCurrent);
    }

    @FXML
    void updateContactButtonPressed(ActionEvent event) {
        Contact obj1 = new Contact();
        contactCurrent.setFirstName(firstNameTextField.getText().trim());
        contactCurrent.setLastName(lastNameTextField.getText().trim());
        contactCurrent.setEmail(emailTextField.getText().trim());
        contactCurrent.setPhoneNumber(phoneNumberTextField.getText().trim());
    }



    public void initialize(){
        contacts.add(new Contact("Dastan", "Akatov", "dastan.akatov@gmail.com", "+996000000000", "D:\\Coding\\Java\\JavaFX\\contactsmod\\src\\main\\java\\com\\example\\contactsmod\\img\\img.png"));
        booksListView.setItems(contacts);

        booksListView.getSelectionModel().selectedItemProperty().addListener((arg0, oldValue, newValue) -> {
            contactCurrent = newValue;
            coverImageView.setImage(new Image(newValue.getImage()));
            firstNameTextField.setText(newValue.getFirstName());
            lastNameTextField.setText(newValue.getLastName());
            emailTextField.setText(newValue.getEmail());
            phoneNumberTextField.setText(newValue.getPhoneNumber());
        });

    }


}