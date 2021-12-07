import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;



public class JogoSimulado extends JFrame{
	Tabuleiro tabu = new Tabuleiro();
	
	///imagem tabuleiro
    ImageIcon tabuleiroImagem = new ImageIcon(getClass().getResource("Tabuleiro SIMULACAO.png"));
	ImageIcon selectionP1 = new ImageIcon(getClass().getResource("/data/SelecaoP1.png"));
	ImageIcon selectionP2 = new ImageIcon(getClass().getResource("/data/SelecaoP2.png"));
	
    ///Criar menu
    JLabel tabuleiro = new JLabel(tabuleiroImagem);
    JLabel[] Pecas = new JLabel[32];
    JLabel[] Selection = new JLabel[32];
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
	
	
	
	JPanel Aviso = new JPanel();
	JLabel xeque = new JLabel("Cheque!");
	JLabel xequeMate = new JLabel("Cheque mate! O jogo acabou!");
	JLabel empate = new JLabel("solicitou um empate.");
	JLabel vitoria = new JLabel("O vencedor é");
	JLabel pecas = new JLabel("Escolha sua peça de promoção:");
	String[] opcoes = new String[]{"OK", "Cancelar"};
	String[] opcoesEmpate = new String[]{"Aceitar", "Recusar"};
	String[] opcoesPecas = new String[]{"Torre", "Cavalo", "Bispo", "Rainha"};
	
	int escolha;

    public JogoSimulado() { //Charlie Brown Jr me ajudou nisso, dedico essa vitoria a ele e sua banda.
    	
    	String nome1 = "Brancas", nome0 = "Pretas";
    	//MONTAGEM DO TABULEIRO ---------------------------------------------------------------------------------------
    	tabu.reset();
        tabu.tabuleiroTest();
        
        //Cor preta.
    	JLabel N1 = new JLabel(nome1);
    	JLabel N0 = new JLabel(nome0);
    	
    	//Cor branca.
    	JLabel N1tabu = new JLabel(nome1);
    	JLabel N0tabu = new JLabel(nome0);
    	
        
        int cpb=8, cpp=0, ctp=16, ctb=18, cbb=20, cbp=22, ccb=26, ccp=24, crb=29, crp=28, cRb=30, cRp=31;
        
        for(int i=0; i<=31;i++) {
        	Pecas[i] = new JLabel();
        	Selection[i] = new JLabel();
        	Selection[i].setIcon(selectionP2);
        }
        
        //Monta o tabuleiro pela primeira vez.
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (tabu.mapa[i][j].getOcupado() == 1) {
                    if (tabu.mapa[i][j].getPeca() instanceof Peao) {
                        //Peoes pretos = 0 a 7.
                        //Peoes brancos = 8 a 15.
                    	if(tabu.mapa[i][j].getPeca().getCor()==0){

                    		x = (int) (45+(i*62.5));
                    		y = (int) (47+(j*62.5));
                    		
                    		(Pecas[cpp]).setIcon(peao1);
                            add(Pecas[cpp]);
                            (Pecas[cpp]).setBounds(x,y,62,62); 
                            cpp++;
                    	}else {

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
                }
            }
        }
        //Nomes dos jogadores.
        add(N0tabu);
        N0tabu.setForeground(Color.decode("#FFFFFF"));
        N0tabu.setBounds(50, -25, 100, 100);
        
        add(N1tabu);
        N1tabu.setForeground(Color.decode("#FFFFFF"));
        N1tabu.setBounds(237, 520, 100, 100);
        
        add(tabuleiro);
        
        //---------------------------------------------------------------------------------------------------------------------

        addMouseListener (new MouseAdapter() {
            public void mousePressed (MouseEvent a) {//Checa clique do mouse
            	int cpb=8, cpp=0, ctp=16, ctb=18, cbb=20, cbp=22, ccb=26, ccp=24, crb=29, crp=28, cRb=30, cRp=31, mov, k=0;
            	//Pega posicao.
                x = a.getX();
                y = a.getY();
                
                repaint();
                System.out.println(x + "," + y);
                	
                	//Final da simulacao.
                if(x>11 && y>237 && x<46 && y<511){
                	
                	MenuClick menuClick = new MenuClick();
                	
                	menuClick.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                	menuClick.setSize(600,600);
                	menuClick.setVisible(true);
                	
                	dispose();
                	//Jogada seguinte.
                }else if(x>559 && y>205 && x<595 && y<511){
                	try {
						tabu.Simulacao();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                
                //Apaga as peças e o tabuleiro para coloca-las novamente nos lugares corretos.
                for(int i=0; i<=31;i++) {
                	remove(Pecas[i]);
                }
                for(int i=0; i<=31;i++) {
                	remove(Selection[i]);
                }
                
                remove(tabuleiro);
                
                //Atualiza a posicao das pecas no tabuleiro de acordo com a matriz de posicoes. Tambem atualiza o tabuleiro para as pecas ficarem sobrepostas a ele.
                for (int j = 0; j < 8; j++) {
                    for (int i = 0; i < 8; i++) {
                    	
                    	if (tabu.mapa[xi][yi].getOcupado() == 1) {
	                    	if(tabu.mapa[xi][yi].getPeca().getCor() == tabu.turno) {
		                    	if (tabu.mapa[xi][yi].getPeca() instanceof Peao) {
		        	                mov=((Peao) tabu.mapa[xi][yi].getPeca()).movValido(tabu.mapa, i, j, xi, yi);
		        	            } else {
		        	                if (tabu.mapa[xi][yi].getPeca() instanceof Torre) {
		        	                    mov=((Torre) tabu.mapa[xi][yi].getPeca()).movValido(tabu.mapa, i, j, xi, yi);
		        	                } else {
		        	                    if (tabu.mapa[xi][yi].getPeca() instanceof Cavalo) {
		        	                    	mov=((Cavalo) tabu.mapa[xi][yi].getPeca()).movValido(tabu.mapa, i, j, xi, yi);
		        	                    } else {
		        	                        if (tabu.mapa[xi][yi].getPeca() instanceof Bispo) {
		        	                        	mov=((Bispo) tabu.mapa[xi][yi].getPeca()).movValido(tabu.mapa, i, j, xi, yi);
		        	                        } else {
		        	                            if (tabu.mapa[xi][yi].getPeca() instanceof Rainha) {
		        	                            	mov=((Rainha) tabu.mapa[xi][yi].getPeca()).movValido(tabu.mapa, i, j, xi, yi);
		        	                            } else {
		        	                                mov=((Rei) tabu.mapa[xi][yi].getPeca()).movValido(tabu.mapa, i, j, xi, yi);
		        	                            }
		        	                        }
		        	                    }
		        	                }
		        	            }
		                    	
		                    	if(mov > 0) {
			                    	int xaux = (int) (44+(i*62.5));
			                        int yaux = (int) (43+(j*62.5));
			                        if(scan==1) {
				                    	add(Selection[k]);
				                        Selection[k].setBounds(xaux,yaux,66,70);
			                        }
			                        k++;
		                    	}
	                    	}
                    	}
	                    
                        if (tabu.mapa[i][j].getOcupado() == 1) {
                            if (tabu.mapa[i][j].getPeca() instanceof Peao) {
                                //Peoes pretos = 0 a 7.
                                //Peoes brancos = 8 a 15.
                            	if(tabu.mapa[i][j].getPeca().getCor()==0){

                            		x = (int) (45+(i*62.5));
                            		y = (int) (47+(j*62.5));
                            		
                            		(Pecas[cpp]).setIcon(peao1);
                                    add(Pecas[cpp]);
                                    (Pecas[cpp]).setBounds(x,y,62,62); 
                                    cpp++;
                            	}else {

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
                                		
                                		if(ctp <= 17) {
	                                		(Pecas[ctp]).setIcon(torre1);
	                                        add(Pecas[ctp]);
	                                        (Pecas[ctp]).setBounds(x,y,62,62); 
	                                        ctp++;
                                		}else {
                                			(Pecas[cpp]).setIcon(torre1);
                                        	add(Pecas[cpp]);
                                        	(Pecas[cpp]).setBounds(x,y,62,62); 
                                        	cpp++;
                                		}
                                	}else {
                                		x = (int) (45+(i*62.5));
                                		y = (int) (47+(j*62.5));
                                		
                                		if(ctb <= 19) {
	                                		(Pecas[ctb]).setIcon(torre0);
	                                        add(Pecas[ctb]);
	                                        (Pecas[ctb]).setBounds(x,y,62,62); 
	                                        ctb++;
                                		}else {
                                			(Pecas[cpb]).setIcon(torre0);
                                        	add(Pecas[cpb]);
                                        	(Pecas[cpb]).setBounds(x,y,62,62); 
                                        	cpb++;
                                		}
                                	}
                                   
                                } else {
                                    //Cavalos pretos = 24 a 25.
                                    //Cavalos brancos = 26 a 27.
                                    if (tabu.mapa[i][j].getPeca() instanceof Cavalo) {
                                    	if(tabu.mapa[i][j].getPeca().getCor()==0){
                                    		x = (int) (45+(i*62.5));
                                    		y = (int) (47+(j*62.5));
                                    		
                                    		if(ccp <= 25) {
	                                    		(Pecas[ccp]).setIcon(cavalo1);
	                                            add(Pecas[ccp]);
	                                            (Pecas[ccp]).setBounds(x,y,62,62); 
	                                            ccp++;
                                    		}else {
                                    			(Pecas[cpp]).setIcon(cavalo1);
                                            	add(Pecas[cpp]);
                                            	(Pecas[cpp]).setBounds(x,y,62,62); 
                                            	cpp++;
                                    		}
                                    	}else {
                                    		x = (int) (45+(i*62.5));
                                    		y = (int) (47+(j*62.5));
                                    		
                                    		if(ccb <= 27) {
	                                    		(Pecas[ccb]).setIcon(cavalo0);
	                                            add(Pecas[ccb]);
	                                            (Pecas[ccb]).setBounds(x,y,62,62); 
	                                            ccb++;
                                    		}else {
                                    			(Pecas[cpb]).setIcon(cavalo0);
                                            	add(Pecas[cpb]);
                                            	(Pecas[cpb]).setBounds(x,y,62,62); 
                                            	cpb++;
                                    		}
                                    	}
                                       
                                    } else {
                                        //Bispos pretos = 20 a 21.
                                        //Bispos brancos = 22 a 23.
                                        if (tabu.mapa[i][j].getPeca() instanceof Bispo) {
                                        	if(tabu.mapa[i][j].getPeca().getCor()==0){
                                        		x = (int) (45+(i*62.5));
                                        		y = (int) (47+(j*62.5));
                                        		
                                        		if(cbp <= 23) {
	                                        		(Pecas[cbp]).setIcon(bispo1);
	                                                add(Pecas[cbp]);
	                                                (Pecas[cbp]).setBounds(x,y,62,62); 
	                                                cbp++;
                                        		}else {
                                        			(Pecas[cpp]).setIcon(bispo1);
                                                	add(Pecas[cpp]);
                                                	(Pecas[cpp]).setBounds(x,y,62,62); 
                                                	cpp++;
                                        		}
                                        	}else {
                                        		x = (int) (45+(i*62.5));
                                        		y = (int) (47+(j*62.5));
                                        		
                                        		if(cbb <= 21) {
	                                        		(Pecas[cbb]).setIcon(bispo0);
	                                                add(Pecas[cbb]);
	                                                (Pecas[cbb]).setBounds(x,y,62,62); 
	                                                cbb++;
                                        		}else {
                                        			(Pecas[cpb]).setIcon(bispo0);
                                                	add(Pecas[cpb]);
                                                	(Pecas[cpb]).setBounds(x,y,62,62); 
                                                	cpb++;
                                        		}
                                        	}
                                            
                                        } else {
                                            //Rainha preta = 28.
                                            //Rainha branca = 29.
                                            if (tabu.mapa[i][j].getPeca() instanceof Rainha) {
                                            	if(tabu.mapa[i][j].getPeca().getCor()==0){
                                            		x = (int) (45+(i*62.5));
                                            		y = (int) (47+(j*62.5));
                                            		
                                            		if(crp == 28) {
                                            			(Pecas[crp]).setIcon(rainha1);
                                                    	add(Pecas[crp]);
                                                    	(Pecas[crp]).setBounds(x,y,62,62); 
                                                    	crp++;
                                            		}else{
                                            			(Pecas[cpp]).setIcon(rainha1);
                                                    	add(Pecas[cpp]);
                                                    	(Pecas[cpp]).setBounds(x,y,62,62); 
                                                    	cpp++;
                                            		}
                                                    
                                            	}else {
                                            		x = (int) (45+(i*62.5));
                                            		y = (int) (47+(j*62.5));
                                            		
                                            		if(crb == 29) {
	                                            		(Pecas[crb]).setIcon(rainha0);
	                                                    add(Pecas[crb]);
	                                                    (Pecas[crb]).setBounds(x,y,62,62); 
	                                                    crb++; 
                                            		}else{
                                            			(Pecas[cpb]).setIcon(rainha0);
                                                    	add(Pecas[cpb]);
                                                    	(Pecas[cpb]).setBounds(x,y,62,62); 
                                                    	cpb++;
                                            		}
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
                        }
                    }
                }
                
                //Nomes dos jogadores.
                add(N0tabu);
                N0tabu.setForeground(Color.decode("#FFFFFF"));
                N0tabu.setBounds(50, -25, 100, 100);
                
                add(N1tabu);
                N1tabu.setForeground(Color.decode("#FFFFFF"));
                N1tabu.setBounds(237, 520, 100, 100);
                
                add(tabuleiro);
                
                //Promocao do peao.
                for(int i=0; i<8; i++){
                    if(tabu.mapa[i][0].getOcupado()==1 && tabu.mapa[i][0].getPeca() instanceof Peao && tabu.mapa[i][0].getPeca().getCor()==0){
                    	Aviso.add(pecas);
                    	Aviso.setPreferredSize(new Dimension(200,100));
                    	
                    	escolha = JOptionPane.showOptionDialog(null, Aviso, "Aviso", JOptionPane.WARNING_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, opcoesPecas, opcoesPecas[3]);
                    	Aviso.remove(pecas);
                    	
                    	tabu.transin(xo, tabu.turno, escolha);
                    	
                    }else {
                        if (tabu.mapa[i][7].getOcupado() == 1 && tabu.mapa[i][7].getPeca() instanceof Peao && tabu.mapa[i][0].getPeca().getCor() == 1) {
                        	Aviso.add(pecas);
                        	Aviso.setPreferredSize(new Dimension(200,100));
                        	
                        	escolha = JOptionPane.showOptionDialog(null, Aviso, "Aviso", JOptionPane.WARNING_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, opcoesPecas, opcoesPecas[3]);
                        	Aviso.remove(pecas);
                        	
                        	tabu.transin(xo, tabu.turno, escolha);
                        }
                    }
                }
               
                //Verifica xeque e imprime.
                if(tabu.xequet == 1 && tabu.matet != 1) {
                	Aviso.add(xeque);
                	Aviso.setPreferredSize(new Dimension(200,100));
                	
                	JOptionPane.showOptionDialog(null, Aviso, "Aviso", JOptionPane.WARNING_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
                	tabu.xequet = 0;
                	Aviso.remove(xeque);
                //Verifica xeque mate e imprime.
                }else if(tabu.matet == 1) {
                	Aviso.add(xequeMate);
                	Aviso.setPreferredSize(new Dimension(200,100));
                	
                	JOptionPane.showOptionDialog(null, Aviso, "Aviso", JOptionPane.WARNING_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
                	Aviso.remove(xequeMate);
                	
                	Aviso.add(vitoria);
                	if(tabu.turno == 1) {
                		Aviso.add(N1);
                		Aviso.remove(N0);
                	}else {
                		Aviso.add(N0);
                		Aviso.remove(N1);
                	}
                	
                	Aviso.setPreferredSize(new Dimension(200,100));
                	
                	JOptionPane.showOptionDialog(null, Aviso, "Aviso", JOptionPane.WARNING_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
                }
                
    
            }
        });
    }
}
