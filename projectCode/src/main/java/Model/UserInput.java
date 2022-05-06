package Model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);




    ////methods////
    public static String getInput()
    {
        return scanner.nextLine();
    }



    public static String removeSpaces(String input)
    {
        Matcher spaceMatcher = Pattern.compile("\\s(\\s+)").matcher(input);

        while (spaceMatcher.find()){
            input = input.substring(0, spaceMatcher.start()) + " " + input.substring(spaceMatcher.end());
            spaceMatcher = Pattern.compile("\\s(\\s+)").matcher(input);
        }

        return input;
    }



    public static boolean doesMatch(String input, Pattern pattern)
    {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }



    public static String getMatchingStringGroupFromInput(String input, Pattern searchingPattern)
    {
        Matcher matcher = searchingPattern.matcher(input);

        if (matcher.find()){
            return matcher.group();
        }

        return "";
    }
}
