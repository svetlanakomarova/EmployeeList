package prog24178.fx;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import komarovs.models.Employee;

/**
 * FXML Controller class
 *
 * @author skomarova
 */
public class FXMLEmpListController implements Initializable {

    @FXML
    private TextField txtName, txtRate, txtHours;
    @FXML
    private TextArea txtDisplay;

    private PrintWriter fileOut = null;
    private ArrayList<String> eList;

    @FXML
    private void save(ActionEvent event) {

        // read the data from the text fields
        String name = txtName.getText();

        double rate = Double.parseDouble(txtRate.getText());
        double hours = Double.parseDouble(txtHours.getText());

        // data validation
        try {
            Employee e = new Employee(name, rate, hours);

            // write the record to the file
            fileOut.printf("%s|%f|%f%n", e.getName(), e.getHourlyRate(), e.getHours());
            // test - just display an employee - toString
            System.out.println(e.toString());
            // build the record
            String record = name + ", " + rate + ", " + hours;
            // add the record to the list
            eList.add(record);
            // show the record
            txtDisplay.appendText("\n" + record);
        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, ex.getMessage());
            a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            a.show();
        }

        //clear the fields for feedback
        txtName.clear();
        txtRate.clear();
        txtHours.clear();

        // ready to type another one
        txtName.requestFocus();
    }

    @FXML
    private void sort(ActionEvent event) {
        // clear display
        txtDisplay.clear();
        // sort the data
        Collections.sort(eList);
        // display each record on the new line
        for (int i = 0; i < eList.size(); i++) {
            txtDisplay.appendText("\n" + eList.get(i));
        }
    }

    @FXML
    private void exit(ActionEvent event) {

        // close the stream
        if (fileOut != null) {
            fileOut.close();
        }

        // close the stage
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fileOut = new PrintWriter(new BufferedWriter(new FileWriter("data/list.txt", true)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // create the list to add every record
        eList = new ArrayList<>();
    }

}
