import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;


public class Instrucoes {

}

class MenuInstrucoes extends JFrame{
    ImageIcon regrasImagens = new ImageIcon(getClass().getResource("regraaas.png"));
    JLabel regrasImagem = new JLabel(regrasImagens);

    public MenuInstrucoes() {
        addMouseListener (new MouseAdapter() {
            public void mousePressed (MouseEvent a) {
                int x = a.getX();
                int y = a.getY();
                System.out.println(x + "," + y);
                if(x>167 && x<434 && y>515 && y<585){
                    System.out.println("SAIR");
                    java.lang.System.exit(0);
                }
            }
        });


        add(regrasImagem);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
