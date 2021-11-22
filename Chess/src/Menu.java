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
        // TODO Auto-generated method stub
        MenuClick menu = new MenuClick();


    }

}

class MenuClick extends JFrame{
    ///imagem menu
    ImageIcon menuImagem = new ImageIcon(getClass().getResource("open.gif"));
   ///Criar menu
    JLabel menuInicial = new JLabel(menuImagem);

    public MenuClick() {
        addMouseListener (new MouseAdapter() {
            public void mousePressed (MouseEvent a) {//checa clique do mouse
                int x = a.getX();
                int y = a.getY();
                System.out.println(x + "," + y);
                if(x>167 && x<434 && y>315 && y<385){
                    ///Comecar jogo
                    System.out.println("START CHESS");
                }else{
                    if(x>167 && x<434 && y>415 && y<485){
                        MenuInstrucoes instruco = new MenuInstrucoes();
                        instruco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        instruco.setSize(600,600);
                        instruco.setVisible(true);

                        ///Instrucoes;



                    }else{
                        if(x>167 && x<434 && y>515 && y<585){
                            ///Sair
                            System.out.println("SAIR");
                            java.lang.System.exit(0);

                        }
                    }
                }

            }
        });


        add(menuInicial);
        ///Compila tela
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
