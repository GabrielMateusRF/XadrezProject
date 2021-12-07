import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Nomes extends JFrame{
    public Nomes() {
    	
    	ImageIcon nomesIMG = new ImageIcon(getClass().getResource("Nomes.png"));
    	JLabel nomes = new JLabel(nomesIMG);
    	JTextField nome0 = new JTextField(10);
    	JTextField nome1 = new JTextField(10);
    	
    	add(nome0);
    	add(nome1);
    	add(nomes);
        
        
        nome1.setBounds(200, 70, 200, 30);
        nome0.setBounds(200, 335, 200, 30);
        addMouseListener (new MouseAdapter() {
        	
        	
            public void mousePressed (MouseEvent a) {//Checa clique do mouse.
                int x = a.getX();
                int y = a.getY();
                System.out.println(x + "," + y);
                if(x>473 && x<591 && y>585 && y<622){
                	//Jogo.
                	Jogo jogo = new Jogo(String.valueOf(nome0.getText()),String.valueOf(nome1.getText()));

                	jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                	jogo.setSize(607,635);
                	jogo.setVisible(true);
                	
                	dispose();

                }
            }
        });
    }
}
