package edu.wit.comp1050;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class gameCode{

    static ArrayList<String> arr = new ArrayList<>();

    public static String genCode(int codeLength, boolean allowRepeat, boolean allowBlanks){
        String code = "";
        initList(allowBlanks);
        for(int j = 0;j< codeLength;j++) {
            int randNum = (int) (Math.random() * (arr.size()));
            code += arr.get(randNum);
            if (allowRepeat == false) arr.remove(randNum);
        }
        return code;
    }

    private static void initList(boolean allowBlanks){
        arr.removeAll(arr);
        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");
        arr.add("5");
        arr.add("6");
        if(allowBlanks == true)
            arr.add("7");
    }

    public int[] checkCombo(String gameCode, String userCode){
        System.out.println("Input: " + userCode);
        int[] feedback = {-1,-1,-1,-1};
        char[] gameCodeArr = codeToArray(gameCode);
        for(int i = 0;i< gameCode.length();i++) {
            for (int k = 0; k < gameCode.length(); k++) {
                if (userCode.charAt(i) == gameCodeArr[k]) {
                    feedback[i] = 0;
                    //gameCodeArr[k] = 'a';
                    continue;
                }
            }
        }
        for(int i = 0;i< gameCode.length();i++){
            if(userCode.charAt(i) == gameCodeArr[i]){
                feedback[i] = 1;
                gameCodeArr[i] = 'a';
            }
            else{
            }
        }
        for (int i = 0; i < feedback.length; i++) {
            for (int j = i + 1; j < feedback.length; j++) {
                int tmp = -2;
                if (feedback[i] < feedback[j]) {
                    tmp = feedback[i];
                    feedback[i] = feedback[j];
                    feedback[j] = tmp;
                }
            }
        }
        return feedback;
    }

    private static char[] codeToArray(String code){
        char[] codeArray = new char[code.length()];
        for(int j = 0;j < code.length();j++){
            codeArray[j] = code.charAt(j);
        }
        return codeArray;
    }

}
