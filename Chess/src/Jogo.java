import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;

public class Jogo extends JFrame{
	Tabuleiro tabu= new Tabuleiro();
	///imagem tabuleiro
    ImageIcon tabuleiroImagem = new ImageIcon(getClass().getResource("Tabuleiro.png"));
   ///Criar menu
    JLabel tabuleiro = new JLabel(tabuleiroImagem);
	int xi, yi, xo, yo, scan=0, x, y;
	
	Graphics g;


    public Jogo() {
    	tabu.reset();
        tabu.tabuleiroTest();


        add(tabuleiro);

        addMouseListener (new MouseAdapter() {
            public void mousePressed (MouseEvent a) {//Checa clique do mouse
            	//Pega posicao.
                x = a.getX();
                y = a.getY();
                
                
                
                
                JLabel tabule = new JLabel();

                ImageIcon img = new ImageIcon(getClass().getResource("Torrezinha.png"));

                tabule.setIcon(img);
                remove(tabuleiro);
                add(tabule);
                tabule.setBounds(50,30,100,100);
                add(tabuleiro);
                
            	if(scan == 0) {
            		scan=1;
            		//Pega posicoes iniciais.
            		xi = x;
            		yi = y;
            		
                	xi=(int) ((xi-54)/62.5);
                	yi=(int) ((yi-86)/62.5);
            	}else {
            		scan=0;
            		//Pega posicoes finais.
            		xo = x;
            		yo = y;
            		
                	xo=(int) ((xo-54)/62.5);
                	yo=(int) ((yo-86)/62.5);
            	}
            	
                if(x>54 && y>86 && x<554 && y<586) {
                	//Movimento finalizado.
                    if(scan == 0) {
                        tabu.tabuleiroTest();
                        tabu.mover(xi, yi, xo, yo);
                        tabu.tabuleiroTest();
                    }
                }
           
            }
        });
    }
}
