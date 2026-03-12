public class Quiztest {
    public static void main(String[] args) {
        System.out.println("=== QUIZ LOGIK TEST START ===");

        QuizManager manager = new QuizManager();

        System.out.println("Start-Index: " + manager.getFortschritt()); // Sollte 0 sein
        System.out.println("Start-Score: " + manager.getPunktestand());   // Sollte 0 sein

        Questions q1 = manager.getCurrentQuestion();
        if (q1 != null) {
            System.out.println("Erste Frage geladen: " + q1.getFragestellung());
        }

        boolean korrekt = manager.checkAnswer(1);
        System.out.println("Antwort auf Frage 1 korrekt? " + korrekt);
        System.out.println("Neuer Score: " + manager.getPunktestand()); // Sollte 1 sein

        manager.nextQuestion();
        System.out.println("Index nach nextQuestion(): " + manager.getFortschritt()); // Sollte 1 sein
        System.out.println("Zweite Frage: " + manager.getCurrentQuestion().getFragestellung());


        System.out.println("\n--- Härtetest: Ende der Liste ---");
        //Springen zum Ende der Liste
        for (int i = 0; i < 15; i++) {
            manager.nextQuestion();
        }

        if (manager.istAmEnde()) {
            System.out.println("Ergebnis: Spiel erkennt das Ende korrekt!");
        } else {
            System.out.println("Fehler: Spiel merkt nicht, dass die Fragen aus sind.");
        }

        try {
            manager.getCurrentQuestion();
            System.out.println("Check: Kein Absturz bei getCurrentQuestion() am Ende. Gut!");
        } catch (Exception e) {
            System.out.println("ABSTURZ: " + e.getMessage());
        }

        System.out.println("\n=== TEST BEENDET ===");
    }
}