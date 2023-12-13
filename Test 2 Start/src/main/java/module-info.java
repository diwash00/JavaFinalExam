module com.georgiancollege.test2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires tmc.junit.runner;


    opens com.georgiancollege.test2 to javafx.fxml;
//    opens com.google.gson.annotations to tmc.junit.runner;
    exports com.georgiancollege.test2;
}