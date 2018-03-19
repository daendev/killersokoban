package sokoban;

import java.util.HashMap;

public class Logger {

    private static HashMap<Object, String> names = new HashMap<>();
    private static int indent = 0;
    private static String indentString = "  ";


    public static void createObject(Object obj, String name){
        names.put(obj, name);
        indentation();
        System.out.println(
            "Created " + obj.toString() + " object with the name \"" + name + "\"."
        );
    }


    public static void begin(Object obj, String methodName){
        indentation();
        System.out.println(
                "=> Method " + methodName + "() called on object \"" + names.get(obj) + "\"."
        );
        ++indent;
    }


    public static void end(Object obj, String methodName, String returnValue){
        indentation();
        if(returnValue.equals("void"))
            System.out.println("Method " + methodName + "() ended.");
        else
            System.out.println(
                "<= Method " + methodName + " ended with return value " + returnValue + "."
            );
        --indent;
    }


    private static void indentation(){
        for ( int i = 0; i < indent; ++i ) {
            System.out.printf(indentString);
        }
    }
}
