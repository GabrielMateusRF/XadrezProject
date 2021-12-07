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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;


public class Menu {

    public static void main(String[] args) {
       MenuClick menu = new MenuClick();
    }

}

class MenuClick extends JFrame{
    ///Imagem menu.
    ImageIcon menuImagem = new ImageIcon(getClass().getResource("open.gif"));
   ///Criar menu.
    JLabel menuInicial = new JLabel(menuImagem);

    public MenuClick() {
    	
        ///Compila tela.
        add(menuInicial);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addMouseListener (new MouseAdapter() {
        	
            public void mousePressed (MouseEvent a) {//Checa clique do mouse.
                int x = a.getX();
                int y = a.getY();
                System.out.println(x + "," + y);
                if(x>207 && x<402 && y>225 && y<289){
                	//Jogo.

                	Nomes nomes = new Nomes();
                	nomes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                	nomes.setSize(607,635);
                	nomes.setVisible(true);
                	
                	dispose();
                }else{
                    if(x>192 && x<427 && y>320 && y<397){
                        ///Instrucoes.
                        MenuInstrucoes instruco = new MenuInstrucoes();
                        instruco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        instruco.setSize(607,635);
                        instruco.setVisible(true);
                        
                        dispose();
                    }else{
                        if(x>145 && x<446 && y>412 && y<492){
                            ///Simulacao.
                        	JogoSimulado jogoSimulado = new JogoSimulado();

                        	jogoSimulado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        	jogoSimulado.setSize(607,635);
                        	jogoSimulado.setVisible(true);
                        	
                        	dispose();

                        }else{
                            if(x>200 && x<387 && y>514 && y<588){
                                ///Sair.
                                System.out.println("SAIR");
                                java.lang.System.exit(0);
                            }
                        }
                    }
                }
            }
        });
    }

}
