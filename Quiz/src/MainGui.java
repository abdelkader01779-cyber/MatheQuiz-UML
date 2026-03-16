import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.ScatteringByteChannel;
import javax.imageio.ImageIO;

public class MainGui extends JFrame {
    public static void main (String[]args) {
        new MainGui();} {
            // 1. Fenster-Grundlagen
            setTitle("Mein Quiz");
            setSize(1000, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null); // Wir bestimmen die Pixel selbst!
            setResizable(false);
            getContentPane().setBackground(Color.yellow); // Dunkler Hintergrund

            // --- BILD-BEREICH MIT TRY-CATCH ---
            try {
                String pfad = "C:\\Users\\khaldi\\IdeaProjects\\MatheQuiz-UML\\Quiz\\ressource\\Spongebob.jpg";
                ImageIcon icon = new ImageIcon(pfad);

                if (icon.getIconWidth() > 0) {
                    System.out.println("Spongebob wurde gefunden ");

                    Image img = icon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
                    JLabel bildLabel = new JLabel(new ImageIcon(img));
                    bildLabel.setBounds(250, 05, 500, 500);
                    this.add(bildLabel);
                } else {
                    System.out.println("Fehler");
                }
            }catch(Exception e ){
                System.out.println("Tot "+ e.getMessage());
            }



            // --- BUTTON-BEREICH ---
            JButton startButton = new JButton("Quiz Starten");
            startButton.setBackground(Color.magenta);
            startButton.setForeground(Color.white);
            startButton.setFocusPainted(false);
            startButton.setFont(new Font("Arial", Font.BOLD, 20));

            // Den Button unten zentrieren
            // (Fensterbreite 500 - Buttonbreite 300) / 2 = 100
            startButton.setBounds(250, 485, 500, 80);

            add(startButton);

            // Fenster sichtbar machen (immer am Ende!)

            setVisible(true);
        }


    }


