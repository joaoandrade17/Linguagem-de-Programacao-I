module atividadedois {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    opens atividadedois to javafx.fxml;
    opens atividadedois.controllers to javafx.fxml;
    opens atividadedois.classes to javafx.fxml, javafx.base;

    exports atividadedois;
}
