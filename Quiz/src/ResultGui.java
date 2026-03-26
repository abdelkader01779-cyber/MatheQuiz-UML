import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.List;

public class ResultGui extends JFrame {
    public ResultGui(QuizManager manager2){




        setTitle("Result");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(0,162,255));



        int points=manager2.getPunktestand();
        java.util.List<Questions> gesamt=manager2.getFragenListe();
        int anzahlFragen=gesamt.size();


        //Überschrift
        JLabel titel= new JLabel("Quiz Beendet ! ",SwingConstants.CENTER);
        titel.setFont(new Font("Arial" , Font.BOLD,40));
        titel.setForeground(Color.YELLOW);
        titel.setBounds(0,50,1000,60);
        add(titel);

        //Ergebnis
        if(points<5) {

            JLabel scoreLabel = new JLabel("Du  hast " + points + "   richtige Anwtorten   Erreicht  (Nicht Gut) ");
            scoreLabel.setFont(new Font("Arial", Font.BOLD, 25));
            scoreLabel.setForeground(Color.WHITE);
            scoreLabel.setBounds(0, 130, 1000, 40);
            add(scoreLabel);
        }else{ JLabel scoreLabel = new JLabel("Du  hast " + points + "   richtige Anwtorten   Erreicht  (Sehr Gut  ) ");
            scoreLabel.setFont(new Font("Arial", Font.BOLD, 25));
            scoreLabel.setForeground(Color.WHITE);
            scoreLabel.setBounds(0, 130, 1000, 40);
            add(scoreLabel);

        }
           //Bild
        String gewaehlterPfad;
        int hälfte = gesamt.size() / 2;

        if (points >= hälfte) {
            gewaehlterPfad ="C:\\Users\\khaldi\\IdeaProjects\\MatheQuiz-UML\\Quiz\\ressource\\msedge_EGWe7iLMFP.png";
        } else {
            gewaehlterPfad = "C:\\Users\\khaldi\\IdeaProjects\\MatheQuiz-UML\\Quiz\\ressource\\traurig2.jpg";
        }
        try {
            ImageIcon  Icon = new ImageIcon(gewaehlterPfad);
            if(Icon.getIconWidth()==-1){
                throw new Exception("Bild konnte ncht gefunden werden " + gewaehlterPfad);
            }
            Image img = Icon.getImage().getScaledInstance(300,300,Image.SCALE_SMOOTH);
            JLabel bildLabel = new JLabel(new ImageIcon(img));
            bildLabel.setBounds(350,200,300,300);
            add(bildLabel);


        }catch (Exception e){
            System.err.println("Kritischer Fehler " + e.getMessage());

            JLabel ersatzText = new JLabel("Bild konnte nicht geladen werden ", SwingConstants.CENTER);
            ersatzText.setBounds(350,300,300,30);
            ersatzText.setForeground(Color.red);
            add(ersatzText);
        }


        JButton restartBtn= new JButton("Nochmal Spielen");
        restartBtn.setFont(new Font("Arial",Font.BOLD,18));
        restartBtn.setBackground(Color.YELLOW);
        restartBtn.setBounds(400,500,200,50);

        restartBtn.addActionListener(e->{
            new MainGui();
            this.dispose();
        });
        add(restartBtn);
        setVisible(true);



    }




}
