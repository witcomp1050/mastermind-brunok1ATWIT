package edu.wit.comp1050;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.IOException;

public class Controller1 extends Application {
    int i = 0;
    int j = 0;
    int k = 0;
    int l = 0;
    int xCount = -35;
    static int guessLength = 4;
    static boolean allowRepeat = true;
    static boolean allowBlanks = false;
    static final String winTest = "YOU WON!";
    static final String loseTest = "YOU LOST";
    static int c = 10;
    int counter = 0;
    int count = 0;
    static gameCode game = new gameCode();
    gameCode game2 = new gameCode();
    static getConfig config = new getConfig();
    static String codeBreak;
    String[] clr = {"RED", "BLUE", "GREEN", "YELLOW", "ORANGE", "MAGENTA"};
    String[] clrb = {"RED", "BLUE", "GREEN", "YELLOW", "ORANGE", "MAGENTA", "BLACK"};

    @FXML
    private VBox mainWindow;

    @FXML
    private Button eightGuess;

    @FXML
    private Button tenGuess;

    @FXML
    private Button twelveGuess;

    @FXML
    private Button trueDupe;

    @FXML
    private Button falseDupe;

    @FXML
    private Button trueBlank;

    @FXML
    private Button falseBlank;

    @FXML
    private Circle c11;

    @FXML
    private Circle c21;

    @FXML
    private Circle c31;

    @FXML
    private Circle c41;

    @FXML
    private Circle c1;

    @FXML
    private Circle c2;

    @FXML
    private Circle c3;

    @FXML
    private Circle c4;

    @FXML
    private Rectangle f1;

    @FXML
    private Rectangle f2;

    @FXML
    private Rectangle f3;

    @FXML
    private Rectangle f4;

    @FXML
    private Button newGameButton;

    @FXML
    private Label numGuess;

    @FXML
    private Text winLostText;

    @FXML
    private Button checkButton;

    @FXML
    private HBox fBox;

    @FXML
    private HBox cBox;

    @FXML
    private Menu fileButton;

    public void cChange(MouseEvent mouseEvent) {
        if(allowBlanks == true){
            if(i > 6)i = 0;
            Circle circle = (Circle) mouseEvent.getSource();
            circle.setFill(Paint.valueOf(clrb[i]));
        }
        else {
            if(i > 5)i = 0;
            Circle circle = (Circle) mouseEvent.getSource();
            circle.setFill(Paint.valueOf(clr[i]));
        }
        i++;


    }

    public void cChange2(MouseEvent mouseEvent) {
        if(allowBlanks == true){
            if(j > 6)j = 0;
            Circle circle = (Circle) mouseEvent.getSource();
            circle.setFill(Paint.valueOf(clrb[j]));
        }
        else {
            if(j > 5)j = 0;
            Circle circle = (Circle) mouseEvent.getSource();
            circle.setFill(Paint.valueOf(clr[j]));
        }
        j++;

    }
    public void cChange3(MouseEvent mouseEvent) {
        if(allowBlanks == true){
            if(k > 6)k = 0;
            Circle circle = (Circle) mouseEvent.getSource();
            circle.setFill(Paint.valueOf(clrb[k]));
        }
        else {
            if(k > 5)k = 0;
            Circle circle = (Circle) mouseEvent.getSource();
            circle.setFill(Paint.valueOf(clr[k]));
        }
        k++;

    }
    public void cChange4(MouseEvent mouseEvent) {
        if (allowBlanks == true) {
            if (l > 6) l = 0;
            Circle circle = (Circle) mouseEvent.getSource();
            circle.setFill(Paint.valueOf(clrb[l]));
        } else {
            if (l > 5) l = 0;
            Circle circle = (Circle) mouseEvent.getSource();
            circle.setFill(Paint.valueOf(clr[l]));
        }
        l++;
    }

    public void checkCombo(ActionEvent actionEvent) {
        c11.setFill(c1.getFill());
        c21.setFill(c2.getFill());
        c31.setFill(c3.getFill());
        c41.setFill(c4.getFill());
        fBox.setOpacity(1);
        cBox.setOpacity(1);
        c = c - 1;
        numGuess.setText(String.valueOf(c));
        if(c == 0){
            System.out.println("Lose");
            newGameButton.setDisable(false);
            newGameButton.setOpacity(1);
            winLostText.setText(loseTest);
            checkButton.setDisable(true);
            c1.setDisable(true);
            c2.setDisable(true);
            c3.setDisable(true);
            c4.setDisable(true);
        }
            String guess = "";
            if(allowBlanks == true && c1.getFill() == Paint.valueOf("BLACK")){
                guess += 7;
            }
            else guess += i;
            if(allowBlanks == true && c2.getFill() == Paint.valueOf("BLACK")){
                guess += 7;
            }
            else guess += j;
            if(allowBlanks == true && c3.getFill() == Paint.valueOf("BLACK")){
                guess += 7;
            }
            else guess += k;
            if(allowBlanks == true && c4.getFill() == Paint.valueOf("BLACK")){
                guess += 7;
            }
            else guess += l;
            System.out.println(guess);
            int[] feedback = game.checkCombo(codeBreak, guess);
                if (feedback[0] == 0) {
                    f1.setFill(Paint.valueOf("WHITE"));
                    f1.setOpacity(1);
                } else if (feedback[0] == 1) {
                    f1.setFill(Paint.valueOf("BLACK"));
                    f1.setOpacity(1);
                } else if (feedback[0] < 0) {
                    f1.setOpacity(0);
                }
                if (feedback[1] == 0) {
                    f2.setFill(Paint.valueOf("WHITE"));
                    f2.setOpacity(1);
                } else if (feedback[1] == 1) {
                    f2.setFill(Paint.valueOf("BLACK"));
                    f2.setOpacity(1);
                } else if (feedback[1] < 0) {
                    f2.setOpacity(0);
                }
                if (feedback[2] == 0) {
                    f3.setFill(Paint.valueOf("WHITE"));
                    f3.setOpacity(1);
                } else if (feedback[2] == 1) {
                    f3.setFill(Paint.valueOf("BLACK"));
                    f3.setOpacity(1);
                } else if (feedback[2] < 0) {
                    f3.setOpacity(0);
                }
                if (feedback[3] == 0) {
                    f4.setFill(Paint.valueOf("WHITE"));
                    f4.setOpacity(1);
                } else if (feedback[3] == 1) {
                    f4.setFill(Paint.valueOf("BLACK"));
                    f4.setOpacity(1);
                } else if (feedback[3] < 0) {
                    f4.setOpacity(0);
                }
            AnchorPane aPane = (AnchorPane) fBox.getParent();
            cloneChildren(aPane);
            fBox.setLayoutY(fBox.getLayoutY() - xCount);
            cBox.setLayoutY(cBox.getLayoutY() - xCount);
            fBox.setOpacity(0);
            cBox.setOpacity(0);
            if (feedback[0] == 1 && feedback[1] == 1 && feedback[2] == 1 && feedback[3] == 1) {
                System.out.println("Win");
                newGameButton.setDisable(false);
                newGameButton.setOpacity(1);
                winLostText.setText(winTest);
                checkButton.setDisable(true);
                c1.setDisable(true);
                c2.setDisable(true);
                c3.setDisable(true);
                c4.setDisable(true);
        }
    }
    public void cloneChildren(AnchorPane aPane){
        Circle[] circles = {c11,c21,c31,c41};
        Rectangle[] rectangles = {f1,f2,f3,f4};
        HBox cNextBox = new HBox();
        for(int j = 0;j < 4; j++) {
            Circle circle = new Circle(circles[j].getCenterX(),circles[j].getCenterY(),circles[j].getRadius(),circles[j].getFill());
            circle.setStroke(circles[j].getStroke());
            circle.setOpacity(1);
            circle.setId(String.valueOf(count) + "count");
            cNextBox.getChildren().add(circle);
            count++;
        }
        for(int j = 0;j < 4;j++){
            Rectangle rectangle = new Rectangle(rectangles[j].getX(),rectangles[j].getY(),rectangles[j].getHeight(),rectangles[j].getWidth());
            rectangle.setFill(rectangles[j].getFill());
            rectangle.setStroke(rectangles[j].getStroke());
            rectangle.setOpacity(rectangles[j].getOpacity());
            rectangle.setId(String.valueOf(count) + "counts");
            cNextBox.getChildren().add(rectangle);
        }
        System.out.println(cNextBox.getChildren());
        cNextBox.setSpacing(3.5);
        cNextBox.setLayoutX(cBox.getLayoutX());
        cNextBox.setLayoutY(cBox.getLayoutY() + 10);
        cNextBox.setAlignment(Pos.CENTER);
        aPane.getChildren().add(cNextBox);

    }
    public void playAgain(ActionEvent actionEvent) throws Exception {
        Button button = (Button) actionEvent.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("mmindv2.fxml"));
        Stage game = new Stage();
        game.setTitle("MasterMind");
        game.setScene(new Scene(root, 640, 640));
        game.show();
        c = config.codePegRows();
        codeBreak = game2.genCode(guessLength, allowRepeat, allowBlanks);
        System.out.println("Generated Code: " + codeBreak);
    }

    public void openPref(ActionEvent actionEvent) throws IOException, ConfigurationException {
        Stage stage = (Stage) newGameButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("properties.fxml"));
        Stage pref = new Stage();
        pref.setTitle("Preferences");
        pref.setScene(new Scene(root,600,400));
        pref.show();

    }

    public void setNumGuess(ActionEvent actionEvent) throws ConfigurationException {
        Button button = (Button) actionEvent.getSource();
        if(button.getText().equals("10")){
            config.setRows(10);
            button.setDisable(true);
            twelveGuess.setDisable(false);
            eightGuess.setDisable(false);
        }
        else if(button.getText().equals("8")){
            config.setRows(8);
            button.setDisable(true);
            twelveGuess.setDisable(false);
            tenGuess.setDisable(false);
        }
        if(button.getText().equals("12")){
            config.setRows(12);
            button.setDisable(true);
            eightGuess.setDisable(false);
            tenGuess.setDisable(false);
        }
    }

    public void setDupeColor(ActionEvent actionEvent) throws ConfigurationException {
        Button button = (Button) actionEvent.getSource();
        if(button.getText().equals("True")){
            config.setDupe(true);
            trueDupe.setDisable(true);
            falseDupe.setDisable(false);
        }
        else if(button.getText().equals("False")){
            config.setDupe(false);
            trueDupe.setDisable(false);
            falseDupe.setDisable(true);
        }
    }

    public void setBlank(ActionEvent actionEvent) throws ConfigurationException {
        Button button = (Button) actionEvent.getSource();
        if(button.getText().equals("True")){
            config.setDupe(true);
            trueBlank.setDisable(true);
            falseBlank.setDisable(false);
        }
        else if(button.getText().equals("False")){
            config.setDupe(false);
            trueBlank.setDisable(false);
            falseBlank.setDisable(true);
        }
    }

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mmindv2.fxml"));
        primaryStage.setTitle("MasterMind");
        primaryStage.setScene(new Scene(root, 640, 640));
        primaryStage.show();
    }

    public static void main(String[] args) throws ConfigurationException {
        c = config.codePegRows();
        guessLength = config.codeSize();
        allowRepeat = config.dupsAllowedInCode();
        allowBlanks = config.blanksAllowedInCode();
        codeBreak = game.genCode(guessLength, allowRepeat, allowBlanks);
        System.out.println("Generated Code: " + codeBreak);
        launch(args);
    }



}
