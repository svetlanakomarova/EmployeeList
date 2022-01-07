/*
    Name: Svetlana Komarova
    Assignment: assignment6/JavaFX/Activity
    Program: Computer Programmer
    Date: April 24, 2021

    Description:
    This GUI program is created by using JavaFX 
    displays how to write data to the file and 
    how to display data to the user by adding and sorting
 */
package prog24178.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Svetlana Komarova
 */
public class EmployeeList extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root
                = FXMLLoader.load(this.getClass().getResource("FXMLEmpList.fxml"));

        stage.setScene(new Scene(root));
        stage.setTitle("Employee List");
        stage.setResizable(false);
        stage.show();
    }

}
