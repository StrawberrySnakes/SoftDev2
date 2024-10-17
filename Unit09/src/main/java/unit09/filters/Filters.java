// Dessa Shapiro
package unit09.filters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Displays data in a table format allowing the user to sort the table by the
 * data in any column by clicking on the column header.
 */
public class Filters extends Application {

    private List<String[]> data;
    private List<List<Label>> lables;

    @Override
    /**
     * @param stage
     */
    public void start (Stage stage) throws Exception {
        // The filename will be passed through as a command line parameter
        List<String> args = getParameters ().getRaw ();
        FileReader file = new FileReader (args.get (0));
        BufferedReader fin = new BufferedReader (file);
        int row = 0;
        int col = 0;

        // If the data is too big, add scroll bars
        ScrollPane scroller = new ScrollPane ();
        scroller.setMaxWidth(Double.MAX_VALUE);

        scroller.setMaxHeight(600);
        
        GridPane pane = new GridPane ();
        data = new ArrayList<> ();
        lables = new ArrayList<> ();

        // Use the header to create the first row as buttons.
        String[] header = fin.readLine ().strip ().split (","); 
        for (String value : header) {
            Button button = new Button (value);
            int finalCol = col; 
            button.setOnAction(e -> sortColumn(finalCol)); // lambda for sorting
            button.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
            pane.add (button, col, row);
            col++;
        }
        row++;

        // The rest of the data in the fill will be rows of labels
        // containing the actual data.
        String line = fin.readLine (); 
        while (line != null) {
            String[] record = line.strip ().split (",");
            // Store all the data in a list so it can be easily sorted
            // later on (List.sort)
            data.add (record);
            col = 0;
            lables.add (new ArrayList<>());
            for (String value : record) {
                Label label = new Label (value);
                // Keep track of all the labels so they can be adjusted without
                // haveing to find them in the Grid which can be a pain.
                label.setFont(Font.font("Arial", 14));

                label.setTextFill(Color.web("#34495e"));
                label.setStyle("-fx-border-color: #bdc3c7; -fx-padding: 5px; -fx-border-radius:none;");
                lables.get (row - 1).add (label);
                pane.add (label, col, row);
                col++;    
            }
            row++;
            line = fin.readLine (); 
        }
        fin.close ();

        scroller.setContent (pane);
        Scene scene = new Scene (scroller);
        stage.setScene (scene);
        stage.show ();
        
    }

    /**
     * Helper funciton used to update all the labels based on the 
     * data. It should be called whenever the data changes.
     */
    private void update() {
        int row = 0;
        for (List<Label> label_row : lables) {
            int col = 0;
            for (Label label : label_row) {
                label.setText (data.get (row) [col]);
                col++;
            }
            row++;
        } 
    }

    /**
     * sorts the columns 
     * @param col
     */
    private void sortColumn(int col) {
        data.sort(Comparator.comparing(record -> record[col]));
        update();
    }

    public static void main (String[] args) {
        // Example of hard coding the args, useful for debugging but
        // should be removed to test using command line arguments.
        args = new String[] {"data/grades_363.csv"};
        launch (args);
    }
    
}
