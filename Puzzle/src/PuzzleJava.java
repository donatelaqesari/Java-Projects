import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls (){
        Random random = new Random();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i <= 10; i++){
            numbers.add( random.nextInt(20) + 1 ); //add 1 in the limitation because computers always start with 0
        }
        return numbers;
    }

    public String getRandomLetter(){
        String [] alphabetArray = new String[26];
        String alphabetLetters = "abcdefghijklmnopqrstuvwxyz";

        Random rand = new Random();
        for(int i = 0; i<alphabetLetters.length(); i++){
            alphabetArray[i] = String.valueOf(alphabetLetters.charAt(rand.nextInt(alphabetLetters.length())));
        }
        return alphabetArray[rand.nextInt(26)];
    }

    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += getRandomLetter();
        }
        return password;
    }
        public ArrayList<String> getPassword ( int length){
        ArrayList<String> numbers = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            numbers.add(generatePassword());
        }
        return numbers;
    }
    }

