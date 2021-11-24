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
	int xi, yi, xo, yo, scan=0;

    public Jogo() {
    	Tabuleiro tabu= new Tabuleiro();
    	tabu.reset();
        tabu.tabuleiroTest();
        
        add(tabuleiro);
        
        addMouseListener (new MouseAdapter() {
            public void mousePressed (MouseEvent a) {//Checa clique do mouse
            	//Pega posicao.
                int x = a.getX();
                int y = a.getY();
                
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
