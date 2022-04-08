module de.ostfale.obsidianhawk {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.google.gson;

    opens de.ostfale.obsidianhawk to javafx.fxml;
    opens de.ostfale.obsidianhawk.model to com.google.gson;
    exports de.ostfale.obsidianhawk;
}