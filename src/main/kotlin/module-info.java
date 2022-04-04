module de.ostfale.obsidianhawk {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens de.ostfale.obsidianhawk to javafx.fxml;
    exports de.ostfale.obsidianhawk;
}