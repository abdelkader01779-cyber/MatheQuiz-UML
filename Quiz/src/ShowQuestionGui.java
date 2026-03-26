import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Collections;

public class ShowQuestionGui extends JFrame {
    private JPanel mainPanel;
    private JLabel questionLabel;
    private JLabel pictureLabel;
    private JButton[] awnserButton = new JButton[3];
    private QuestionList questionList;
    private int aktuellerIndex = 0;
    private QuizManager manager;



    public ShowQuestionGui() {
        setTitle("Anzeige Quiz");
        setSize(1000, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        manager = new QuizManager();

        Collections.shuffle(manager.getFragenListe());


        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(0, 150, 255));
        add(mainPanel);

        crateLook();
        actualQuestion();
        setVisible(true);


    }

    private void crateLook() {
        questionLabel = new JLabel("", SwingConstants.LEFT);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 22));
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setBounds(50, 50, 500, 200);

        questionLabel.setBounds(50,50,500,200);
        questionLabel.setText("<html><div style='width:450px;text-align:left;'>Hier steht die Frage?</div></html>");
        questionLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
        mainPanel.add(questionLabel);

        String picturePfad = "C:\\Users\\khaldi\\IdeaProjects\\MatheQuiz-UML\\Quiz\\ressource\\startbildschirm.png";
        try {
            ImageIcon originIcon = new ImageIcon(picturePfad);
            //Bild Skallieren
            Image optimiedPicture = originIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon finishedIcon = new ImageIcon(optimiedPicture);

            pictureLabel = new JLabel(finishedIcon);
            pictureLabel.setBounds(750, 40, 200, 200);

            mainPanel.add(pictureLabel);
        } catch (Exception e) {
            System.out.println("Fehler" + picturePfad + "Nicht gefunden");

            pictureLabel = new JLabel("Bild Fehlt");
            pictureLabel.setBounds(750, 40, 200, 200);
            mainPanel.add(pictureLabel);
        }
        for (int i = 0; i < 3; i++) {
            awnserButton[i] = new JButton();
            awnserButton[i].setBounds(300, 320 + (i * 80), 400, 60);
            awnserButton[i].setFont(new Font("Arial", Font.PLAIN, 18));
            awnserButton[i].setBackground(Color.YELLOW);

            int buttonIndex = i;
            awnserButton[i].addActionListener(e -> checkAwnser(buttonIndex));
            mainPanel.add(awnserButton[i]);
        }


    }

    private void actualQuestion(){
        var q=manager.getFragenListe().get(manager.getFortschritt());
        questionLabel.setText("<html><center>"+q.getQuestionText()+"</center></html>");
        awnserButton[0].setText(q.getAntworten()[0]);
        awnserButton[1].setText(q.getAntworten()[1]);
        awnserButton[2].setText(q.getAntworten()[2]);

    }
    private void checkAwnser(int chosenIndex){
        if(manager.checkAnswer(chosenIndex)) {
        }
        manager.setFortschritt(manager.getFortschritt()+1);
        if(manager.getFortschritt()<manager.getFragenListe().size()){
            aktualissierteFrage();
        }else{
            new ResultGui(this.manager);
            this.dispose();
        }

        }

    private void aktualissierteFrage() {
        Questions q =manager.getFragenListe().get(manager.getFortschritt());

        questionLabel.setText("<html><center>"+q.getQuestionText()+"<center><html>");

        String[] antwortenArray =q.getAntworten();

        awnserButton[0].setText(antwortenArray[0]);
        awnserButton[1].setText(antwortenArray[1]);
        awnserButton[2].setText(antwortenArray[2]);
    }




}