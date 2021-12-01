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
	ImageIcon selectionP1 = new ImageIcon(getClass().getResource("/data/SelecaoP1.png"));
	ImageIcon selectionP2 = new ImageIcon(getClass().getResource("/data/SelecaoP2.png"));
	
   ///Criar menu
    JLabel tabuleiro = new JLabel(tabuleiroImagem);
    JLabel[] Pecas = new JLabel[32];
    JLabel SelectionP1 = new JLabel(selectionP1);
    JLabel SelectionP2 = new JLabel(selectionP2);
    
	int xi, yi, xo, yo, scan=0, x, y;
	
	ImageIcon peao1 = new ImageIcon(getClass().getResource("/data/pecas/Peao1.png"));
	ImageIcon peao0 = new ImageIcon(getClass().getResource("/data/pecas/Peao0.png"));
	ImageIcon torre1 = new ImageIcon(getClass().getResource("/data/pecas/Torre1.png"));
	ImageIcon torre0 = new ImageIcon(getClass().getResource("/data/pecas/Torre0.png"));
	ImageIcon bispo1 = new ImageIcon(getClass().getResource("/data/pecas/Bispo1.png"));
	ImageIcon bispo0 = new ImageIcon(getClass().getResource("/data/pecas/Bispo0.png"));
	ImageIcon cavalo1 = new ImageIcon(getClass().getResource("/data/pecas/Cavalo1.png"));
	ImageIcon cavalo0 = new ImageIcon(getClass().getResource("/data/pecas/Cavalo0.png"));
	ImageIcon rainha1 = new ImageIcon(getClass().getResource("/data/pecas/Rainha1.png"));
	ImageIcon rainha0 = new ImageIcon(getClass().getResource("/data/pecas/Rainha0.png"));
	ImageIcon rei1 = new ImageIcon(getClass().getResource("/data/pecas/Rei1.png"));
	ImageIcon rei0 = new ImageIcon(getClass().getResource("/data/pecas/Rei0.png"));

    public Jogo() {
    	tabu.reset();
        tabu.tabuleiroTest();
        
        int cpb=8, cpp=0, ctp=16, ctb=18, cbb=20, cbp=22, ccb=26, ccp=24, crb=29, crp=28, cRb=30, cRp=31;
        
        for(int i=0; i<=31;i++) {
        	Pecas[i] = new JLabel();
        }
        
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (tabu.mapa[i][j].getOcupado() == 1) {
                    if (tabu.mapa[i][j].getPeca() instanceof Peao) {
                        //Peoes pretos = 0 a 7.
                        //Peoes brancos = 8 a 15.
                    	if(tabu.mapa[i][j].getPeca().getCor()==0){
                    		//remove(Pecas[cpp]);
                    		x = (int) (45+(i*62.5));
                    		y = (int) (47+(j*62.5));
                    		
                    		(Pecas[cpp]).setIcon(peao1);
                            add(Pecas[cpp]);
                            (Pecas[cpp]).setBounds(x,y,62,62); 
                            cpp++;
                    	}else {
                    		//remove(Pecas[cpb]);
                    		x = (int) (45+(i*62.5));
                    		y = (int) (47+(j*62.5));
                    		
                    		(Pecas[cpb]).setIcon(peao0);
                            add(Pecas[cpb]);
                            (Pecas[cpb]).setBounds(x,y,62,62);
                            cpb++;
                    	}
                        
                    } else {
                        //Torres pretas = 16 a 17.
                        //Torres brancas = 18 a 19.
                        if (tabu.mapa[i][j].getPeca() instanceof Torre) {
                        	if(tabu.mapa[i][j].getPeca().getCor()==0){
                        		x = (int) (45+(i*62.5));
                        		y = (int) (47+(j*62.5));
                        		
                        		(Pecas[ctp]).setIcon(torre1);
                                add(Pecas[ctp]);
                                (Pecas[ctp]).setBounds(x,y,62,62); 
                                ctp++;
                        	}else {
                        		x = (int) (45+(i*62.5));
                        		y = (int) (47+(j*62.5));
                        		
                        		(Pecas[ctb]).setIcon(torre0);
                                add(Pecas[ctb]);
                                (Pecas[ctb]).setBounds(x,y,62,62); 
                                ctb++;
                        	}
                           
                        } else {
                            //Cavalos pretos = 24 a 25.
                            //Cavalos brancos = 26 a 27.
                            if (tabu.mapa[i][j].getPeca() instanceof Cavalo) {
                            	if(tabu.mapa[i][j].getPeca().getCor()==0){
                            		x = (int) (45+(i*62.5));
                            		y = (int) (47+(j*62.5));
                            		
                            		(Pecas[ccp]).setIcon(cavalo1);
                                    add(Pecas[ccp]);
                                    (Pecas[ccp]).setBounds(x,y,62,62); 
                                    ccp++;
                            	}else {
                            		x = (int) (45+(i*62.5));
                            		y = (int) (47+(j*62.5));
                            		
                            		(Pecas[ccb]).setIcon(cavalo0);
                                    add(Pecas[ccb]);
                                    (Pecas[ccb]).setBounds(x,y,62,62); 
                                    ccb++;
                            	}
                               
                            } else {
                                //Bispos pretos = 20 a 21.
                                //Bispos brancos = 22 a 23.
                                if (tabu.mapa[i][j].getPeca() instanceof Bispo) {
                                	if(tabu.mapa[i][j].getPeca().getCor()==0){
                                		x = (int) (45+(i*62.5));
                                		y = (int) (47+(j*62.5));
                                		
                                		(Pecas[cbp]).setIcon(bispo1);
                                        add(Pecas[cbp]);
                                        (Pecas[cbp]).setBounds(x,y,62,62); 
                                        cbp++;
                                	}else {
                                		x = (int) (45+(i*62.5));
                                		y = (int) (47+(j*62.5));
                                		
                                		(Pecas[cbb]).setIcon(bispo0);
                                        add(Pecas[cbb]);
                                        (Pecas[cbb]).setBounds(x,y,62,62); 
                                        cbb++;
                                	}
                                    
                                } else {
                                    //Rainha preta = 28.
                                    //Rainha branca = 29.
                                    if (tabu.mapa[i][j].getPeca() instanceof Rainha) {
                                    	if(tabu.mapa[i][j].getPeca().getCor()==0){
                                    		x = (int) (45+(i*62.5));
                                    		y = (int) (47+(j*62.5));
                                    		
                                    		(Pecas[crp]).setIcon(rainha1);
                                            add(Pecas[crp]);
                                            (Pecas[crp]).setBounds(x,y,62,62); 
                                    	}else {
                                    		x = (int) (45+(i*62.5));
                                    		y = (int) (47+(j*62.5));
                                    		
                                    		(Pecas[crb]).setIcon(rainha0);
                                            add(Pecas[crb]);
                                            (Pecas[crb]).setBounds(x,y,62,62); 
                                    	}
                                        
                                    } else {
                                        //Rei preto = 30.
                                        //Rei branco = 31.
                                    	if(tabu.mapa[i][j].getPeca().getCor()==0){
                                    		x = (int) (45+(i*62.5));
                                    		y = (int) (47+(j*62.5));
                                    		
                                    		(Pecas[cRp]).setIcon(rei1);
                                            add(Pecas[cRp]);
                                            (Pecas[cRp]).setBounds(x,y,62,62); 
                                    	}else {
                                    		x = (int) (45+(i*62.5));
                                    		y = (int) (47+(j*62.5));
                                    		
                                    		(Pecas[cRb]).setIcon(rei0);
                                            add(Pecas[cRb]);
                                            (Pecas[cRb]).setBounds(x,y,62,62); 
                                    	} 
                                    }
                                }
                            }
                        }
                    }
                } else {
                   
                }
            }
        }
        
        add(tabuleiro);

        addMouseListener (new MouseAdapter() {
            public void mousePressed (MouseEvent a) {//Checa clique do mouse
            	int cpb=8, cpp=0, ctp=16, ctb=18, cbb=20, cbp=22, ccb=26, ccp=24, crb=29, crp=28, cRb=30, cRp=31;
            	//Pega posicao.
                x = a.getX();
                y = a.getY();
                
                System.out.println(x + "," + y);
                
            	if(scan == 0) {
            		scan=1;
            		//Pega posicoes iniciais.
            		xi = x;
            		yi = y;
            		
                	xi=(int) ((xi-54)/62.5);
                	yi=(int) ((yi-80)/62.5);
            	}else {
            		scan=0;
            		//Pega posicoes finais.
            		xo = x;
            		yo = y;
            		
                	xo=(int) ((xo-54)/62.5);
                	yo=(int) ((yo-80)/62.5);
            	}
            	
                if(x>54 && y>80 && x<554 && y<580) {
                	//Movimento finalizado.
                    if(scan == 0) {
                        tabu.tabuleiroTest();
                        tabu.mover(xi, yi, xo, yo);
                        tabu.tabuleiroTest();
                        
                        //Quadrado de selecao.
                        x = (int) (45+(xo*62.5));
                        y = (int) (45+(yo*62.5));
                    	add(SelectionP2);
                        SelectionP2.setBounds(x,y,66,70);
                        remove(SelectionP1);
                    }else{
                    	//Quadrado de selecao.
                    	x = (int) (45+(xi*62.5));
                        y = (int) (45+(yi*62.5));
                    	add(SelectionP1);
                        SelectionP1.setBounds(x,y,66,70);
                        remove(SelectionP2);
                       
                    }
                }
                
                //Apaga as peças e o tabuleiro para coloca-las novamente nos lugares corretos.
                for(int i=0; i<=31;i++) {
                	remove(Pecas[i]);
                }
                remove(tabuleiro);
                
                //Atualiza a posicao das pecas no tabuleiro de acordo com a matriz de posicoes. Tambem atualiza o tabuleiro para as pecas ficarem sobrepostas a ele.
                for (int j = 0; j < 8; j++) {
                    for (int i = 0; i < 8; i++) {
                        if (tabu.mapa[i][j].getOcupado() == 1) {
                            if (tabu.mapa[i][j].getPeca() instanceof Peao) {
                                //Peoes pretos = 0 a 7.
                                //Peoes brancos = 8 a 15.
                            	if(tabu.mapa[i][j].getPeca().getCor()==0){
                            		//remove(Pecas[cpp]);
                            		x = (int) (45+(i*62.5));
                            		y = (int) (47+(j*62.5));
                            		
                            		(Pecas[cpp]).setIcon(peao1);
                                    add(Pecas[cpp]);
                                    (Pecas[cpp]).setBounds(x,y,62,62); 
                                    cpp++;
                            	}else {
                            		//remove(Pecas[cpb]);
                            		x = (int) (45+(i*62.5));
                            		y = (int) (47+(j*62.5));
                            		
                            		(Pecas[cpb]).setIcon(peao0);
                                    add(Pecas[cpb]);
                                    (Pecas[cpb]).setBounds(x,y,62,62);
                                    cpb++;
                            	}
                                
                            } else {
                                //Torres pretas = 16 a 17.
                                //Torres brancas = 18 a 19.
                                if (tabu.mapa[i][j].getPeca() instanceof Torre) {
                                	if(tabu.mapa[i][j].getPeca().getCor()==0){
                                		x = (int) (45+(i*62.5));
                                		y = (int) (47+(j*62.5));
                                		
                                		(Pecas[ctp]).setIcon(torre1);
                                        add(Pecas[ctp]);
                                        (Pecas[ctp]).setBounds(x,y,62,62); 
                                        ctp++;
                                	}else {
                                		x = (int) (45+(i*62.5));
                                		y = (int) (47+(j*62.5));
                                		
                                		(Pecas[ctb]).setIcon(torre0);
                                        add(Pecas[ctb]);
                                        (Pecas[ctb]).setBounds(x,y,62,62); 
                                        ctb++;
                                	}
                                   
                                } else {
                                    //Cavalos pretos = 24 a 25.
                                    //Cavalos brancos = 26 a 27.
                                    if (tabu.mapa[i][j].getPeca() instanceof Cavalo) {
                                    	if(tabu.mapa[i][j].getPeca().getCor()==0){
                                    		x = (int) (45+(i*62.5));
                                    		y = (int) (47+(j*62.5));
                                    		
                                    		(Pecas[ccp]).setIcon(cavalo1);
                                            add(Pecas[ccp]);
                                            (Pecas[ccp]).setBounds(x,y,62,62); 
                                            ccp++;
                                    	}else {
                                    		x = (int) (45+(i*62.5));
                                    		y = (int) (47+(j*62.5));
                                    		
                                    		(Pecas[ccb]).setIcon(cavalo0);
                                            add(Pecas[ccb]);
                                            (Pecas[ccb]).setBounds(x,y,62,62); 
                                            ccb++;
                                    	}
                                       
                                    } else {
                                        //Bispos pretos = 20 a 21.
                                        //Bispos brancos = 22 a 23.
                                        if (tabu.mapa[i][j].getPeca() instanceof Bispo) {
                                        	if(tabu.mapa[i][j].getPeca().getCor()==0){
                                        		x = (int) (45+(i*62.5));
                                        		y = (int) (47+(j*62.5));
                                        		
                                        		(Pecas[cbp]).setIcon(bispo1);
                                                add(Pecas[cbp]);
                                                (Pecas[cbp]).setBounds(x,y,62,62); 
                                                cbp++;
                                        	}else {
                                        		x = (int) (45+(i*62.5));
                                        		y = (int) (47+(j*62.5));
                                        		
                                        		(Pecas[cbb]).setIcon(bispo0);
                                                add(Pecas[cbb]);
                                                (Pecas[cbb]).setBounds(x,y,62,62); 
                                                cbb++;
                                        	}
                                            
                                        } else {
                                            //Rainha preta = 28.
                                            //Rainha branca = 29.
                                            if (tabu.mapa[i][j].getPeca() instanceof Rainha) {
                                            	if(tabu.mapa[i][j].getPeca().getCor()==0){
                                            		x = (int) (45+(i*62.5));
                                            		y = (int) (47+(j*62.5));
                                            		
                                            		(Pecas[crp]).setIcon(rainha1);
                                                    add(Pecas[crp]);
                                                    (Pecas[crp]).setBounds(x,y,62,62); 
                                            	}else {
                                            		x = (int) (45+(i*62.5));
                                            		y = (int) (47+(j*62.5));
                                            		
                                            		(Pecas[crb]).setIcon(rainha0);
                                                    add(Pecas[crb]);
                                                    (Pecas[crb]).setBounds(x,y,62,62); 
                                            	}
                                                
                                            } else {
                                                //Rei preto = 30.
                                                //Rei branco = 31.
                                            	if(tabu.mapa[i][j].getPeca().getCor()==0){
                                            		x = (int) (45+(i*62.5));
                                            		y = (int) (47+(j*62.5));
                                            		
                                            		(Pecas[cRp]).setIcon(rei1);
                                                    add(Pecas[cRp]);
                                                    (Pecas[cRp]).setBounds(x,y,62,62); 
                                            	}else {
                                            		x = (int) (45+(i*62.5));
                                            		y = (int) (47+(j*62.5));
                                            		
                                            		(Pecas[cRb]).setIcon(rei0);
                                                    add(Pecas[cRb]);
                                                    (Pecas[cRb]).setBounds(x,y,62,62); 
                                            	} 
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                           
                        }
                    }
                }
                add(tabuleiro);
            }
        });
    }
}
