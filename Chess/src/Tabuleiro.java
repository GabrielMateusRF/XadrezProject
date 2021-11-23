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
                switch (i){//switch coluna
                    case 0://Torres
                        if (j==0){///Torre preta em 01
                            torre.setPeca(1);///NOTA: TALVEZ ESTEJA AO CONTRÁRIO, CULPA DO LUCCA
                            mapa[i][j].setPeca(torre);
                        }else{
                            if(j==1){///Peão preto em 02
                                peao.setPeca(1);
                                mapa[i][j].setPeca(peao);

                            }else{
                                if(j==6){///Peao branca em 06
                                    peao.setPeca(0);
                                    mapa[i][j].setPeca(peao);

                                }else{///Torre branca em 07
                                    if (j==7){
                                        torre.setPeca(0);
                                        mapa[i][j].setPeca(torre);
                                    }else{

                                    }
                                }
                            }
                        }
                        break;
                    case 1://Cavalos 1
                        if (j==0){
                            cavalo.setPeca(1);
                            mapa[i][j].setPeca(cavalo);
                        }else{
                            if(j==1){

                                peao.setPeca(1);
                                mapa[i][j].setPeca(peao);

                            }else{
                                if(j==6){
                                    peao.setPeca(0);
                                    mapa[i][j].setPeca(peao);

                                }else{
                                    if (j==7){
                                        cavalo.setPeca(0);
                                        mapa[i][j].setPeca(cavalo);
                                    }else{

                                    }
                                }
                            }
                        }
                        break;
                    case 2:///Bispo
                        if (j==0){
                            bispo.setPeca(1);
                            mapa[i][j].setPeca(bispo);
                        }else{
                            if(j==1){
                                peao.setPeca(1);
                                mapa[i][j].setPeca(peao);

                            }else{
                                if(j==6){
                                    peao.setPeca(0);
                                    mapa[i][j].setPeca(peao);

                                }else{

                                    if (j==7){
                                        bispo.setPeca(0);
                                        mapa[i][j].setPeca(bispo);
                                    }else{

                                    }

                                }
                            }
                        }
                        break;
                    case 3:///Rainha
                        if (j==0){
                            rainha.setPeca(1);
                            mapa[i][j].setPeca(rainha);
                        }else{
                            if(j==1){
                                peao.setPeca(1);
                                mapa[i][j].setPeca(peao);

                            }else{
                                if(j==6){
                                    peao.setPeca(0);
                                    mapa[i][j].setPeca(peao);

                                }else{

                                    if (j==7){
                                        rainha.setPeca(0);
                                        mapa[i][j].setPeca(rainha);
                                    }else{

                                    }

                                    break;
                                }
                            }
                        }
                        break;
                    case 4:
                        if (j==0){
                            rei.setPeca(1);
                            mapa[i][j].setPeca(rei);
                        }else{
                            if(j==1){
                                peao.setPeca(1);
                                mapa[i][j].setPeca(peao);

                            }else{
                                if(j==6){///Peao branca em 06
                                    peao.setPeca(0);
                                    mapa[i][j].setPeca(peao);

                                }else{

                                    if (j==7){
                                        rei.setPeca(0);
                                        mapa[i][j].setPeca(rei);
                                    }else{

                                    }

                                }
                            }
                        }
                        break;
                    case 5:
                        if (j==0){
                            bispo.setPeca(1);
                            mapa[i][j].setPeca(bispo);
                        }else{
                            if(j==1){
                                peao.setPeca(1);
                                mapa[i][j].setPeca(peao);

                            }else{
                                if(j==6){
                                    peao.setPeca(0);
                                    mapa[i][j].setPeca(peao);

                                }else{

                                    if (j==7){
                                        bispo.setPeca(0);
                                        mapa[i][j].setPeca(bispo);
                                    }else{

                                    }

                                }
                            }
                        }
                        break;
                    case 6:
                        if (j==0){
                            cavalo.setPeca(1);
                            mapa[i][j].setPeca(cavalo);
                        }else{
                            if(j==1){
                                peao.setPeca(1);
                                mapa[i][j].setPeca(peao);

                            }else{
                                if(j==6){
                                    peao.setPeca(0);
                                    mapa[i][j].setPeca(peao);

                                }else{

                                    if (j==7){
                                        cavalo.setPeca(0);
                                        mapa[i][j].setPeca(cavalo);
                                    }else{

                                    }

                                }
                            }
                        }
                        break;
                    case 7:
                        if (j==0){///Torre preta
                            torre.setPeca(1);
                            mapa[i][j].setPeca(torre);
                        }else{
                            if(j==1){///Peão preto
                                peao.setPeca(1);
                                mapa[i][j].setPeca(peao);

                            }else{
                                if(j==6){///Peao branca
                                    peao.setPeca(0);
                                    mapa[i][j].setPeca(peao);

                                }else{///Torre branca

                                    if (j==7){
                                        torre.setPeca(0);
                                        mapa[i][j].setPeca(torre);
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
                mov=((Peao) mapa[xin][yin].getPeca()).movValido(mapa, xout, yout, xin, yin);
            } else {
                if (mapa[xin][yin].getPeca() instanceof Torre) {
                    mov=((Torre) mapa[xin][yin].getPeca()).movValido(mapa, xout, yout, xin, yin);
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
                                mov=((Rei) mapa[xin][yin].getPeca()).movValido(mapa, xout, yout, xin, yin);
                            }
                        }
                    }
                }
            }
            System.out.printf("\n" + mov + "\n");

            if(mov==1) {

            }
            switch (mov){
                case 0:
                    break;
                case 1:
                    mapa[xout][yout].setPeca(mapa[xin][yin].getPeca());
                    mapa[xin][yin].setOcupado(0);
                    mapa[xout][yout].setOcupado(1);
                    ///Colocar troca de turno
                    break;
                case 2:
                    mapa[xout][yout].setPeca(mapa[xin][yin].getPeca());
                    mapa[xin][yin].setOcupado(0);
                    mapa[xout][yout].setOcupado(1);
                    ///Adicionar score
                    ///Colocar troca de turno
                    break;
            }



        }else{
            System.out.printf("\n Peca invalida");
        }
    }

}

