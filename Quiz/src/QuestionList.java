import java.util.ArrayList;
import java.util.List;

public class QuestionList {
    public static List<Questions>getAlleFragen(){
        ArrayList<Questions> liste =new ArrayList<>();
        //Fragen in die liste hinzufügen
        liste.add(new Questions("Was ist der Wert von 5! laut Defnition",new String[]{"24","120","720"},1));
        liste.add(new Questions("Was ergibt i*i in den komplexen Zahlen",new String[]{"1","0","-1"},2));
        liste.add(new Questions("Ergebnis von (a+b)*(a-b) ?",new String[]{"a^2-b^2","a^2+b^2","a^2-2ab+b^2"},0));
        liste.add(new Questions("Welcher Wert hat log_a(1)?",new String[]{"1","a","0"},2));
        liste.add(new Questions("Matrix mit nur 1en in der Hauptdiagonale ?",new String[]{"Nullmatrix","Einheitsmatrix","Diagonalmatrix"},1));
        liste.add(new Questions("Was ist das Ergebnis von a^m*a^n ?",new String[]{"a^(m*n)","a^(m-n)","a^(m+n)"},2));
        liste.add(new Questions("Reallteil Re(z) von z=x+y*i?",new String[]{"x","y","i"},0));
        liste.add(new Questions("Determinante einer 2x2 Matrix (ad-bc)?",new String[]{"ac - bd", "ad - bc", "ab - cd"},1));
        liste.add(new Questions("Neutrales Element der Addition im Körper?",new String[]{"1", "0", "-1"},1));
        liste.add(new Questions("Welchen Wert hat sin(90 Grad)?",new String[]{"0", "0.5", "1"},2));
        return liste;
    }





}
