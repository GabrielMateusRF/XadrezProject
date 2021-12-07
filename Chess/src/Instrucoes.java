import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;


public class Instrucoes {

}

class MenuInstrucoes extends JFrame{
    ImageIcon regrasImagens = new ImageIcon(getClass().getResource("Instrucoes.png"));
    JLabel regrasImagem = new JLabel(regrasImagens);

    public MenuInstrucoes() {
        addMouseListener (new MouseAdapter() {
            public void mousePressed (MouseEvent a) {
                int x = a.getX();
                int y = a.getY();
                if(x>406 && x<561 && y>202 && y<275){
                	//Jogo.

                	Nomes nomes = new Nomes();
                	nomes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                	nomes.setSize(607,635);
                	nomes.setVisible(true);
                	
                	dispose();
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
