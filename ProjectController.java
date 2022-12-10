import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;


import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProjectController {
    myFile mf = new myFile();
    private String word;
    private ArrayList <Label> labels = new ArrayList<Label>();
    private ArrayList<Node> shapes = new ArrayList<Node>();

    @FXML
    private AnchorPane anch2;

    @FXML
    private HBox boxLettersUsed;

    @FXML
    private HBox boxList;

    @FXML
    private HBox boxList2;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnNew;

    @FXML
    private TextField letter;

    @FXML
    private AnchorPane letterField;

    @FXML
    void btnNewPressed(ActionEvent event) throws FileNotFoundException
    {
        labels.clear();
        while (boxList2.getChildren().size() >0)
            boxList2.getChildren().remove(0);
        while (boxLettersUsed.getChildren().size() >0)
            boxLettersUsed.getChildren().remove(0);
        initialize();
    }

    @FXML
    void btnPressed(ActionEvent event) throws FileNotFoundException
    {
        String s = letter.getText();
        int i = 0, index;
        //boolean flag = false;
        if(word.indexOf(s,i) != -1)
        {
            while (word.indexOf(s,i) != -1)
            {
                //flag = true;
                index = word.indexOf(s,i);
                labels.get(index).setText(s);
                i = index + 1;
            }
        }
        else
        {
            letterField.getChildren().add(shapes.remove(0));
        }
        Label l = new Label(letter.getText()+" ");
        boxLettersUsed.getChildren().add(l);
        letter.clear();
    }

    public void initialize() throws FileNotFoundException
    {
        while (letterField.getChildren().size() >0)
            shapes.add(letterField.getChildren().remove(0));
        String [] s;
        s = mf.myReader();
        word = mf.wordRand(s);
        //System.out.println(word);
        for (int i = 0; i < word.length(); i++)
        {
            Label lbl = new Label();
            lbl.setText("  _  ");
            labels.add(lbl);
        }
        for (Label l : labels)
        {
            boxList2.getChildren().add(l);
            boxList2.setAlignment(Pos.CENTER);
        }
    }

}
