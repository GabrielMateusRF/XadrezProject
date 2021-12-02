import java.util.Scanner;

public class Tabuleiro {
    ///bora usar uma classe e declarar ela
    public Posicao[][] mapa= new Posicao[8][8];
    public Peao peao0 = new Peao();
    public Peao peao1 = new Peao();
    public Torre torre0 = new Torre();
    public Torre torre1 = new Torre();
    public Cavalo cavalo0 = new Cavalo();
    public Cavalo cavalo1 = new Cavalo();
    public Bispo bispo0 = new Bispo();
    public Bispo bispo1 = new Bispo();
    public Rainha rainha0 = new Rainha();
    public Rainha rainha1 = new Rainha();
    public Rei rei0 = new Rei();
    public Rei rei1 = new Rei();
    public int turno; //0 branco, 1 preto
    int i, j;
    int rbx, rby, rpx, rpy;
    public XequeTeste testadordeXeque= new XequeTeste();

    public void reset(){
        ///Reset turno
    	turno=0;
    	
        ///Pecas ganhando cor
        peao0.setPeca(0);
        peao1.setPeca(1);
        torre0.setPeca(0);
        torre1.setPeca(1);
        cavalo0.setPeca(0);
        cavalo1.setPeca(1);
        bispo0.setPeca(0);
        bispo1.setPeca(1);
        rainha0.setPeca(0);
        rainha1.setPeca(1);
        rei0.setPeca(0);
        rei1.setPeca(1);
        ///
        
        for(i=0; i<8;i++){
            for(j=0;j<8;j++){
                mapa[i][j]=new Posicao();
                switch (i){//switch coluna
                    case 0://Torres
                        if (j==0){///Torre preta em 01
                            mapa[i][j].setPeca(torre1);
                        }else{
                            if(j==1){///Peão preto em 02  
                            	mapa[i][j].setPeca(peao1);

                            }else{
                                if(j==6){///Peao branca em 06
                                	mapa[i][j].setPeca(peao0);
                                }else{///Torre branca em 07
                                    if (j==7){
                                        mapa[i][j].setPeca(torre0);
                                    }else{

                                    }
                                }
                            }
                        }
                        break;
                    case 1://Cavalos 1
                        if (j==0){
                            mapa[i][j].setPeca(cavalo1);
                        }else{
                            if(j==1){
                                mapa[i][j].setPeca(peao1);

                            }else{
                                if(j==6){
                                    mapa[i][j].setPeca(peao0);

                                }else{
                                    if (j==7){
                                        mapa[i][j].setPeca(cavalo0);
                                    }else{

                                    }
                                }
                            }
                        }
                        break;
                    case 2:///Bispo
                        if (j==0){
                            mapa[i][j].setPeca(bispo1);
                        }else{
                            if(j==1){
                                mapa[i][j].setPeca(peao1);

                            }else{
                                if(j==6){
                                    mapa[i][j].setPeca(peao0);

                                }else{

                                    if (j==7){
                                        mapa[i][j].setPeca(bispo0);
                                    }else{

                                    }

                                }
                            }
                        }
                        break;
                    case 3:///Rainha
                        if (j==0){
                            mapa[i][j].setPeca(rainha1);
                        }else{
                            if(j==1){
                                mapa[i][j].setPeca(peao1);

                            }else{
                                if(j==6){
                                    mapa[i][j].setPeca(peao0);

                                }else{

                                    if (j==7){
                                        mapa[i][j].setPeca(rainha0);
                                    }else{

                                    }

                                    break;
                                }
                            }
                        }
                        break;
                    case 4:
                        if (j==0){
                            mapa[i][j].setPeca(rei1);
                            rpx=i;
                            rpy=j;
                        }else{
                            if(j==1){
                                mapa[i][j].setPeca(peao1);

                            }else{
                                if(j==6){
                                    mapa[i][j].setPeca(peao0);

                                }else{

                                    if (j==7){
                                        mapa[i][j].setPeca(rei0);
                                        rbx=i;
                                        rby=j;
                                    }else{

                                    }

                                }
                            }
                        }
                        break;
                    case 5:
                    	 if (j==0){
                             mapa[i][j].setPeca(bispo1);
                         }else{
                             if(j==1){
                                 mapa[i][j].setPeca(peao1);

                             }else{
                                 if(j==6){
                                     mapa[i][j].setPeca(peao0);

                                 }else{

                                     if (j==7){
                                         mapa[i][j].setPeca(bispo0);
                                     }else{

                                     }

                                 }
                             }
                         }
                         break;
                    case 6:
                    	if (j==0){
                            mapa[i][j].setPeca(cavalo1);
                        }else{
                            if(j==1){
                                mapa[i][j].setPeca(peao1);

                            }else{
                                if(j==6){
                                    mapa[i][j].setPeca(peao0);

                                }else{
                                    if (j==7){
                                        mapa[i][j].setPeca(cavalo0);
                                    }else{

                                    }
                                }
                            }
                        }
                        break;
                    case 7:
                    	if (j==0){///Torre preta em 01
                            mapa[i][j].setPeca(torre1);
                        }else{
                            if(j==1){///Peão preto em 02  
                            	mapa[i][j].setPeca(peao1);

                            }else{
                                if(j==6){///Peao branca em 06
                                	mapa[i][j].setPeca(peao0);
                                }else{///Torre branca em 07
                                    if (j==7){
                                        mapa[i][j].setPeca(torre0);
                                    }else{

                                    }
                                }
                            }
                        }
                        break;
                }
            }
        }
    }

    ///Tabuleiro
    public void tabuleiroTest() {
        for (j = 0; j < 8; j++) {
            for (i = 0; i < 8; i++) {
                if (mapa[i][j].getOcupado() == 1) {
                    if (mapa[i][j].getPeca() instanceof Peao) {
                    	if(mapa[i][j].getPeca().getCor()==0){
                    		System.out.printf("|P0|");
                    	}else {
                    		System.out.printf("|P1|");
                    	}
                        
                    } else {
                        if (mapa[i][j].getPeca() instanceof Torre) {
                        	if(mapa[i][j].getPeca().getCor()==0){
                        		 System.out.printf("|T0|");
                        	}else {
                        		 System.out.printf("|T1|");
                        	}
                           
                        } else {
                            if (mapa[i][j].getPeca() instanceof Cavalo) {
                            	if(mapa[i][j].getPeca().getCor()==0){
                            		 System.out.printf("|C0|");
                            	}else {
                            		 System.out.printf("|C1|");
                            	}
                               
                            } else {
                                if (mapa[i][j].getPeca() instanceof Bispo) {
                                	if(mapa[i][j].getPeca().getCor()==0){
                                		System.out.printf("|B0|");
                                	}else {
                                		System.out.printf("|B1|");
                                	}
                                    
                                } else {
                                    if (mapa[i][j].getPeca() instanceof Rainha) {
                                    	if(mapa[i][j].getPeca().getCor()==0){
                                    		System.out.printf("|r0|");
                                    	}else {
                                    		System.out.printf("|r1|");
                                    	}
                                        
                                    } else {
                                    	if(mapa[i][j].getPeca().getCor()==0){
                                    		System.out.printf("|R0|");
                                    	}else {
                                    		System.out.printf("|R1|");
                                    	}
                                        
                                    }
                                }
                            }
                        }
                    }
                } else {
                    System.out.printf("|  |");
                }
            }
            System.out.printf("\n");
        }
    }

    public void mover(int xi, int yi, int xo, int yo){
        Scanner input = new Scanner(System.in);
        int xin=xi, yin=yi, xout=xo, yout=yo;
        int mov=0;
            
            if(mapa[xin][yin].getOcupado()==1 && mapa[xin][yin].getPeca().getCor()==turno){
	
	            if (mapa[xin][yin].getPeca() instanceof Peao) {
	                System.out.printf("\n P \n");
	                mov=((Peao) mapa[xin][yin].getPeca()).movValido(mapa, xout, yout, xin, yin);
	            } else {
	                if (mapa[xin][yin].getPeca() instanceof Torre) {
	                    mov=((Torre) mapa[xin][yin].getPeca()).movValido(mapa, xout, yout, xin, yin);
	                } else {
	                    if (mapa[xin][yin].getPeca() instanceof Cavalo) {
	                    	mov=((Cavalo) mapa[xin][yin].getPeca()).movValido(mapa, xout, yout, xin, yin);
	                    } else {
	                        if (mapa[xin][yin].getPeca() instanceof Bispo) {
	                        	mov=((Bispo) mapa[xin][yin].getPeca()).movValido(mapa, xout, yout, xin, yin);
	                        } else {
	                            if (mapa[xin][yin].getPeca() instanceof Rainha) {
	                            	mov=((Rainha) mapa[xin][yin].getPeca()).movValido(mapa, xout, yout, xin, yin);
	                            } else {
	                                mov=((Rei) mapa[xin][yin].getPeca()).movValido(mapa, xout, yout, xin, yin);
	                            }
	                        }
	                    }
	                }
	            }
	            System.out.printf("\n" + mov + "\n");

	            ///testar cheque proprio, dps vamo ter que mudar e não enviar direto pro mov;


                if(mov>0) {
                    mov = testadordeXeque.testeXequeproprio(mapa, turno, mov, xin, yin, xout, yout);
                }


	            switch (mov){
	                case 0:
	                    break;
	                case 1:
                        if(mapa[xin][yin].getPeca() instanceof Rei){
                            if(mapa[xin][yin].getPeca().getCor()==0){
                                rbx=xin;
                                rby=yin;
                            }else{

                                rpx=xin;
                                rpy=yin;
                            }
                        }
	                    mapa[xout][yout].setPeca(mapa[xin][yin].getPeca());
	                    mapa[xin][yin].setOcupado(0);
	                    mapa[xout][yout].setOcupado(1);

	                    ///Colocar troca de turno
	                    break;
	                case 2:
                        if(mapa[xin][yin].getPeca() instanceof Rei){
                            if(mapa[xin][yin].getPeca().getCor()==0){
                                rbx=xin;
                                rby=yin;

                            }else{
                                rpx=xin;
                                rpy=yin;
                            }
                        }
	                	mapa[xin][yin].setOcupado(0);
	                    mapa[xout][yout].setPeca(mapa[xin][yin].getPeca());
	                    mapa[xout][yout].setOcupado(1);
	                    ///Adicionar score
	                    ///Colocar troca de turno
	                    break;
	            }
	            if(mov>0) {
	            	if(turno==0) {
	            		turno=1;
	            	}else {
	            		turno=0;
	            	}
	            }
        }else{
            System.out.println("\n Peca invalida");
        }
    }

}

