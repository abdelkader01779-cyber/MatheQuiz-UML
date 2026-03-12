import java.util.List;

public class QuizManager {
    private List<Questions> fragenListe;
    private int aktuellerIndex;
    private int punktestand;

    public QuizManager() {
        this.fragenListe = QuestionList.getAlleFragen();
        this.aktuellerIndex = 0;
        this.punktestand = 0;
    }

    public Questions getCurrentQuestion() {
        if (aktuellerIndex >= 0 && aktuellerIndex < fragenListe.size()) {
            return fragenListe.get(aktuellerIndex);
        }
        return null;
    }

    public void nextQuestion() {
        if (aktuellerIndex < fragenListe.size()) {
            aktuellerIndex++;
        }
    }

    public boolean checkAnswer(int gewaehlterIndex) {
        Questions aktuelleFrage = getCurrentQuestion();

        if (aktuelleFrage != null && aktuelleFrage.istRichtig(gewaehlterIndex)) {
            punktestand++;
            return true;
        }
        return false;
    }
    public int getPunktestand() {
        return punktestand;
    }

    public boolean istAmEnde() {
        return aktuellerIndex >= fragenListe.size();
    }

    public int getFortschritt() {
        return aktuellerIndex;
    }
}