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
                if(x>167 && x<434 && y>315 && y<385){
                	//Jogo.
                	Jogo jogo = new Jogo();
                	jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                	jogo.setSize(607,635);
                	jogo.setVisible(true);

                }else{
                    if(x>167 && x<434 && y>415 && y<485){
                        ///Instrucoes.
                        MenuInstrucoes instruco = new MenuInstrucoes();
                        instruco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        instruco.setSize(607,635);
                        instruco.setVisible(true);
                    }else{
                        if(x>167 && x<434 && y>515 && y<585){
                            ///Sair.
                            System.out.println("SAIR");
                            java.lang.System.exit(0);
                        }
                    }
                }
            }
        });
    }

}
