import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

/**
 *
 */
public class View {



    @FXML
    protected ListView listView= new ListView();

    @FXML
    protected ObservableList<String>items = FXCollections.observableArrayList ();
            //"Single", "Double", "Suite", "Family App");

    @FXML
    protected Button addButton;

    @FXML
    protected TextArea textAreaDetail;

    @FXML
    protected TextField textFieldDate;

    @FXML
    protected  TextField textFieldTime;
    @FXML
    protected TableView tableView;
    Controller controller = new Controller();


    @FXML
    public void ActionButtomAdd(ActionEvent event) throws SQLException {
       // System.out.println("Save Success!!");

        controller.addEvent(controller.getEvent(1,""+textFieldDate.getText(),""+textFieldTime.getText(),
                ""+textAreaDetail.getText()));
        controller.loadDataFromDB(items, listView);

        /*
        System.out.print("s"+textAreaDetail.getText()+textFieldDate.getText()+textFieldTime.getText());
        String t=textFieldDate.getText()+" | "+textFieldTime.getText()+" | "+textAreaDetail.getText();
        items.add(t);
        listView.setItems(items);
        textAreaDetail.clear();
        textFieldDate.clear();
        textFieldTime.clear(); */

        //controller.getEvent(1,textFieldDate.getText(),textFieldTime.getText(),textAreaDetail.getText());
       // controller.loadDataFromDB(items,listView);
        /*
        try {
       //     if (hourBox.getSelectionModel().isEmpty() || minBox.getSelectionModel().isEmpty() || textArea.getText().equals("")) {
         //       controller.alertBox(AlertType.INFORMATION, "Empty Field", "Found empty field", "Please, check again");
        //    }
            // else {
                controller.addEvent(controller.getEvent(1,textFieldDate.getText(),textFieldTime.getText(),textAreaDetail.getText()));
                //setCellTable();
                controller.loadDataFromDB(items, listView);
                //clearForm();
                System.out.println("Save Success!!");
         //   }
        } catch (Exception e) {
           // controller.alertBox(AlertType.ERROR, "Date Picker Error", "Something wrong", "Please, select date again.");
            System.out.println("fuck off!!");
        }*/

    }







}
