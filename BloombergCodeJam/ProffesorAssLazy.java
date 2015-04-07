//Problem        : Mug Color
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_65
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

//Your submission should *ONLY* use the following class name
public class Problem {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        String s;
        //s = "A common ratio of [ 2 + 3 ] : [ 16-9 ] was [ 2 x 3 ] discovered";
         s = stdin.nextLine();

        stdin.close();
        System.out.println();

        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(s);
        while (m.find()) {
            allMatches.add(m.group());
        }
        for (String ma : allMatches) {
            String sub = ma.substring(1, ma.length() - 1).trim();
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            String repl;
            try {
                repl = (engine.eval(sub.replaceAll("x", "*")).toString()
                        .replace(".0", ""));
                s = s.replace(sub, repl);
            } catch (ScriptException e) {
            }
        }
        System.out.println(s);
    }
}
