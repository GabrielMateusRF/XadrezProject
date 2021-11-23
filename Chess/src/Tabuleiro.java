import java.util.Scanner;

public class Tabuleiro {
    ///bora usar uma classe e declarar ela
    public Posicao[][] mapa= new Posicao[8][8];
    public Peao peao = new Peao();
    public Torre torre = new Torre();
    public Cavalo cavalo = new Cavalo();
    public Bispo bispo = new Bispo();
    public Rainha rainha = new Rainha();
    public Rei rei = new Rei();
    public int turno; //0 branco, 1 preto
    int i, j;

    public void reset(){
        turno=0;
        for(i=0; i<8;i++){
            for(j=0;j<8;j++){
                mapa[i][j]=new Posicao();
                if(i==0){
                    switch (j){///Preta Pecas
                        case 0:
                            torre.setPeca(1,j,i,1);///NOTA: TALVEZ ESTEJA AO CONTRÁRIO, CULPA DO LUCCA
                            mapa[i][j].setPeca(torre);
                            break;
                        case 1:
                            cavalo.setPeca(1,j,i,2);
                            mapa[i][j].setPeca(cavalo);
                            break;
                        case 2:
                            bispo.setPeca(1,j,i,3);
                            mapa[i][j].setPeca(bispo);
                            break;
                        case 3:
                            rainha.setPeca(1,j,i,4);
                            mapa[i][j].setPeca(rainha);
                            break;
                        case 4:
                            rei.setPeca(1,j,i,5);
                            mapa[i][j].setPeca(rei);
                            break;
                        case 5:
                            bispo.setPeca(1,j,i,3);
                            mapa[i][j].setPeca(bispo);
                            break;
                        case 6:
                            cavalo.setPeca(1,j,i,2);
                            mapa[i][j].setPeca(cavalo);
                            break;
                        case 7:
                            torre.setPeca(1,j,i,1);
                            mapa[i][j].setPeca(torre);
                            break;

                    }
                }
                if(i==1){///Pretas Peoes
                    peao.setPeca(1,j,i,0);
                    mapa[i][j].setPeca(peao);
                }
                if(i==6){///Brancas Peoes
                    peao.setPeca(0,j,i,0);
                    mapa[i][j].setPeca(peao);
                }
                if(i==7){///Brancas Pecas
                    switch (j){
                        case 0:
                            torre.setPeca(0,i,j,1);///NOTA: TALVEZ ESTEJA AO CONTRÁRIO, CULPA DO LUCCA
                            mapa[i][j].setPeca(torre);
                            break;
                        case 1:
                            cavalo.setPeca(0,i,j,2);
                            mapa[i][j].setPeca(cavalo);
                            break;
                        case 2:
                            bispo.setPeca(0,i,j,3);
                            mapa[i][j].setPeca(bispo);
                            break;
                        case 3:
                            rainha.setPeca(0,i,j,4);
                            mapa[i][j].setPeca(rainha);
                            break;
                        case 4:
                            rei.setPeca(0,i,j,5);
                            mapa[i][j].setPeca(rei);
                            break;
                        case 5:
                            bispo.setPeca(0,i,j,3);
                            mapa[i][j].setPeca(bispo);
                            break;
                        case 6:
                            cavalo.setPeca(0,i,j,2);
                            mapa[i][j].setPeca(cavalo);
                            break;
                        case 7:
                            torre.setPeca(0,i,j,1);
                            mapa[i][j].setPeca(torre);
                            break;

                    }
                }
            }
        }
    }

    ///Tabuleiro
    public void tabuleiroTest() {
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                if (mapa[i][j].getOcupado() == 1) {
                    if (mapa[i][j].getPeca() instanceof Peao) {
                        System.out.printf("|P|");
                    } else {
                        if (mapa[i][j].getPeca() instanceof Torre) {
                            System.out.printf("|T|");
                        } else {
                            if (mapa[i][j].getPeca() instanceof Cavalo) {
                                System.out.printf("|C|");
                            } else {
                                if (mapa[i][j].getPeca() instanceof Bispo) {
                                    System.out.printf("|B|");
                                } else {
                                    if (mapa[i][j].getPeca() instanceof Rainha) {
                                        System.out.printf("|r|");
                                    } else {
                                        System.out.printf("|R|");
                                    }
                                }
                            }
                        }
                    }
                } else {
                    System.out.printf("| |");
                }
            }
            System.out.printf("\n");
        }
    }

    public void mover(){
        Scanner input = new Scanner(System.in);
        int xin, yin, xout, yout;
        int mov=0;
        System.out.printf("\n Coloque o X inicial: ");
        xin=input.nextInt();
        System.out.printf("\n Coloque o Y inicial: ");
        yin=input.nextInt();

        if(mapa[xin][yin].getOcupado()==1 && mapa[xin][yin].getPeca().getCor()==turno){
            System.out.printf("\n Coloque o X destino: ");
            xout=input.nextInt();
            System.out.printf("\n Coloque o Y destino: ");
            yout=input.nextInt();

            if (mapa[xin][yin].getPeca() instanceof Peao) {
                System.out.printf("\n P \n");
                mov=((Peao) mapa[xin][yin].getPeca()).movValido(mapa, xout, yout);
            } else {
                if (mapa[xin][yin].getPeca() instanceof Torre) {
                    System.out.printf("|T|");
                } else {
                    if (mapa[xin][yin].getPeca() instanceof Cavalo) {
                        System.out.printf("|C|");
                    } else {
                        if (mapa[xin][yin].getPeca() instanceof Bispo) {
                            System.out.printf("|B|");
                        } else {
                            if (mapa[xin][yin].getPeca() instanceof Rainha) {
                                System.out.printf("|r|");
                            } else {
                                mov=((Rei) mapa[xin][yin].getPeca()).movValido(mapa, xout, yout);
                            }
                        }
                    }
                }
            }
            System.out.printf("\n" + mov + "\n");

            if(mov==1){
                mapa[xout][yout].setPeca(mapa[xin][yin].getPeca());
                mapa[xin][yin].setOcupado(0);
                mapa[xout][yout].setOcupado(1);
                mapa[xout][yout].getPeca().setX(xout);
                mapa[xout][yout].getPeca().setY(yout);
            }else{
                mapa[xout][yout].setPeca(rei);
            }



        }else{
            System.out.printf("\n Peça invalida");
        }
    }

}

