package com.georgiancollege.test2;

import com.google.gson.annotations.SerializedName;
import javafx.beans.property.*;

public class User {
    @SerializedName("id")
    private final IntegerProperty id = new SimpleIntegerProperty();

    @SerializedName("FirstName")
    private final StringProperty firstName = new SimpleStringProperty();

    @SerializedName("LastName")
    private final StringProperty lastName = new SimpleStringProperty();

    @SerializedName("age")
    private final IntegerProperty age = new SimpleIntegerProperty();

    @SerializedName("email")
    private final StringProperty email = new SimpleStringProperty();

    @SerializedName("phone")
    private final StringProperty phone = new SimpleStringProperty();

    @SerializedName("birthDate")
    private final StringProperty birthDate = new SimpleStringProperty();

    @SerializedName("uNiVersity")
    private final StringProperty university = new SimpleStringProperty();

    @SerializedName("image")
    private final StringProperty image = new SimpleStringProperty();

    @SerializedName("address")
    private final ObjectProperty<Address> address = new SimpleObjectProperty<>();

    // Getters for JavaFX properties
    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public StringProperty birthDateProperty() {
        return birthDate;
    }

    public StringProperty universityProperty() {
        return university;
    }

    public StringProperty imageProperty() {
        return image;
    }

    public ObjectProperty<Address> addressProperty() {
        return address;
    }

    // Other methods remain unchanged
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getImage() {
        return image.get();
    }


    public int getAge() {
        return age.get();
    }
}
