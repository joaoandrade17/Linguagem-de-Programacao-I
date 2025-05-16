module atividadedois {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens atividadedois to javafx.fxml;
    opens atividadedois.controllers to javafx.fxml;
    opens atividadedois.classes to javafx.fxml;
    exports atividadedois;
}
