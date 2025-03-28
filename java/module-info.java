module javafxtest.tp_poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.zaxxer.hikari;
    requires java.sql;


    opens javafxtest.tp_poo to javafx.fxml;
    exports javafxtest.tp_poo;
}