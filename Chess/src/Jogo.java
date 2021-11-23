import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;

public class Jogo extends JFrame{
	///imagem tabuleiro
    ImageIcon tabuleiroImagem = new ImageIcon(getClass().getResource("Tabuleiro.png"));
   ///Criar menu
    JLabel tabuleiro = new JLabel(tabuleiroImagem);

    public Jogo() {
        addMouseListener (new MouseAdapter() {
            public void mousePressed (MouseEvent a) {//checa clique do mouse
                int x = a.getX();
                int y = a.getY();
                System.out.println(x + "," + y);
                if(x<50 && y<50 || x>550 && y>550) {
                	x=(int) ((x-50)/62.5)-1;
                	y=(int) ((y-50)/62.5)-1;
                	
                	System.out.println(x + "," + y);
                }
            }
        });


        add(tabuleiro);
        ///Compila tela
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
