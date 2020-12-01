package edu.wit.comp1050;


import java.util.ArrayList;

public class mastermind {

    static ArrayList<String> arr = new ArrayList<>();
    static final boolean allowRepeat = true;
    static final boolean allowBlanks = false;
    static final int maxCode = 4;
    static final int maxGuess = 10;


    public static void main(String[] args) {
        initList();
        String generatedCode = genCode(maxCode);
        System.out.println("Solution: " + generatedCode);
    }

    private static String genCode(int codeLength){
        String code = "";
        for(int j = 0;j< codeLength;j++){
            int randNum = (int)(Math.random() * (arr.size()));
            code+= arr.get(randNum);
            if(allowRepeat == false)arr.remove(randNum);
        }
        return code;
    }

    private static void initList(){
        arr.add("R");
        arr.add("G");
        arr.add("B");
        arr.add("Y");
        arr.add("O");
        arr.add("P");
        if(allowBlanks == true)
            arr.add("N");
    }

    public static void gameLoop(String gameCode, String userCode){
        String feedback = "";
        char[] gameCodeArr = codeToArray(gameCode);
        for(int j = 0;j < maxGuess;j++){
            for(int i = 0;i< gameCode.length();i++){
                if(userCode.charAt(i) == gameCodeArr[i]){
                    feedback+= "1";
                    gameCodeArr[i] = 'A';
                }
                else{
                    for(int k = 0; k < gameCode.length();k++){
                        if(userCode.charAt(i) == gameCodeArr[k]){
                            feedback += "0";
                            break;
                        }
                    }
                }
            }
            System.out.println("Feedback: " + feedback);
            if(feedback.compareTo("1111") == 0){
                break;
            }
            feedback = "";
            gameCodeArr = codeToArray(gameCode);
        }
        if(feedback.compareTo("1111") == 0){
            System.out.println("You won!");
        }
        else{
            System.out.println("You did not win!");
        }
    }

    private static char[] codeToArray(String code){
        char[] codeArray = new char[code.length()];
        for(int j = 0;j < code.length();j++){
            codeArray[j] = code.charAt(j);
        }
        return codeArray;
    }
}
