import java.io.*;
import java.util.Scanner;
import java.io.IOException;

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
    int xequet, matet;
    int contp;
    int contmov;
    int rodada;
    int contagem;


    public Posicao mesmapecaxeque0 = new Posicao();
    public Posicao mesmapecaxeque1 = new Posicao();
    //public Registrador dadosreg = new Registrador();
    int msmpxequecont0;
    int msmpxequecont1;
    public String nome0;
    public String nome1;
    String coluna;
    String coluna1;
    int linha;


    public XequeTeste testadordeXeque= new XequeTeste();

    public void setNomes(String N1, String N0) {
        nome1 = N1;
        nome0 = N0;
    }

    public void Simulacao() throws Exception{
        File file = new File("loginst.txt");

        BufferedReader brr = new BufferedReader(new FileReader(file));

        String stt;
        // Consition holds true till
        // there is character in a string
        int aa;
        stt = brr.readLine();
        for (aa=1; aa<contagem; aa++){
            stt = brr.readLine();
        }

        int xina =Integer.parseInt(stt.substring(0,1));
        int yina =Integer.parseInt(stt.substring(2,3));
        int xouta =Integer.parseInt(stt.substring(4,5));
        int youta =Integer.parseInt(stt.substring(6,7));
        
        contagem++;
        mover(xina,yina,xouta,youta);

    }


    public void resetSim(){
        contagem=0;
        try {
            PrintWriter mii = new PrintWriter("log.txt");
            mii.print("");
            mii.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            PrintWriter mii2 = new PrintWriter("loginst.txt");
            mii2.print("");
            mii2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void reset(){
        ///Reset turno
        turno=0;
        xequet=0;
        matet=0;
        contmov=0;
        rodada=1;
        msmpxequecont0=0;
        msmpxequecont1=0;
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
        ///dadosreg.criarRegistro();
        ///




        for(i=0; i<8;i++){
            for(j=0;j<8;j++){
                mapa[i][j]=new Posicao();
                switch (i){//switch coluna
                    case 0://Torres
                        if (j==0){///Torre preta em 01
                            mapa[i][j].setPeca(torre1);
                        }else{
                            if(j==1){///Pe??o preto em 02
                                mapa[i][j].setPeca(peao1);

                            }else{
                                if(j==6){///Peao branca em 06
                                    mapa[i][j].setPeca(peao0);
                                }else{///Torre branca em 07
                                    if (j==7){
                                        mapa[i][j].setPeca(torre0);
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

                                    if (j==7) {
                                        mapa[i][j].setPeca(rainha0);
                                    }

                                    break;
                                }
                            }
                        }
                        break;
                    case 4:
                        if (j==0){
                            mapa[i][j].setPeca(rei1);

                        }else{
                            if(j==1){
                                mapa[i][j].setPeca(peao1);

                            }else{
                                if(j==6){
                                    mapa[i][j].setPeca(peao0);

                                }else{

                                    if (j==7){
                                        mapa[i][j].setPeca(rei0);
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
                                    }
                                }
                            }
                        }
                        break;
                    case 7:
                        if (j==0){///Torre preta em 01
                            mapa[i][j].setPeca(torre1);
                        }else{
                            if(j==1){///Pe??o preto em 02
                                mapa[i][j].setPeca(peao1);

                            }else{
                                if(j==6){///Peao branca em 06
                                    mapa[i][j].setPeca(peao0);
                                }else{///Torre branca em 07
                                    if (j==7){
                                        mapa[i][j].setPeca(torre0);
                                    }
                                }
                            }
                        }
                        break;
                }
            }
        }
    }


    public void mover(int xi, int yi, int xo, int yo){
        int xin=xi, yin=yi, xout=xo, yout=yo;
        int mov=0;
        contp=0;


        if(mapa[xin][yin].getOcupado()==1 && mapa[xin][yin].getPeca().getCor()==turno){

            if (mapa[xin][yin].getPeca() instanceof Peao) {
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
                                mov = ((Rei) mapa[xin][yin].getPeca()).movValido(mapa, xout, yout, xin, yin);
                            }
                        }
                    }
                }
            }

            ///testar cheque proprio, dps vamo ter que mudar e n??o enviar direto pro mov;


            if(mov==2) {

                mov = testadordeXeque.testeXequeproprio(mapa, turno, mov, xin, yin, xout, yout);
                if(mov>0){
                    mov=2;
                }
            }else {
                if (mov == 1) {
                    mov = testadordeXeque.testeXequeproprio(mapa, turno, mov, xin, yin, xout, yout);
                }else{
                    if(mov==3) {

                        mov = testadordeXeque.testeXequeproprio(mapa, turno, mov, xin, yin, xout, yout);
                        if(mov>0){
                            mov=3;
                        }
                    }
                }
            }

            xequet=0;


            ///A partir daqui h?? elementos de imprimir o arquivo em norma de Xadrez, encontrado com o nome "log.txt"
            switch (xout){
                case 0:
                    coluna="a";
                    break;
                case 1:
                    coluna="b";
                    break;
                case 2:
                    coluna="c";
                    break;
                case 3:
                    coluna="d";
                    break;
                case 4:
                    coluna="e";
                    break;
                case 5:
                    coluna="f";
                    break;
                case 6:
                    coluna="g";
                    break;
                case 7:
                    coluna="h";
                    break;
            }

            switch (xin){
                case 0:
                    coluna1="a";
                    break;
                case 1:
                    coluna1="b";
                    break;
                case 2:
                    coluna1="c";
                    break;
                case 3:
                    coluna1="d";
                    break;
                case 4:
                    coluna1="e";
                    break;
                case 5:
                    coluna1="f";
                    break;
                case 6:
                    coluna1="g";
                    break;
                case 7:
                    coluna1="h";
                    break;
            }

            switch (yout){
                case 0:
                    linha=8;
                    break;
                case 1:
                    linha=7;
                    break;
                case 2:
                    linha=6;
                    break;
                case 3:
                    linha=5;
                    break;
                case 4:
                    linha=4;
                    break;
                case 5:
                    linha=3;
                    break;
                case 6:
                    linha=2;
                    break;
                case 7:
                    linha=1;
                    break;
            }

            if(mov>0){
                try {
                    FileWriter escritoa = new FileWriter("loginst.txt", true);
                    BufferedWriter bwa = new BufferedWriter(escritoa);
                    PrintWriter escritora = new PrintWriter(bwa);
                        if(turno==0){
                            escritora.println(xin +" "+ yin + " "+  xout +" "+ yout);
                            escritora.close();

                        }else{
                            escritora.println(xin +" "+ yin + " "+  xout +" "+ yout);
                            escritora.close();
                        }

                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }

            }


            switch (mov){
                case 0:
                    break;
                case 1:

                    if(mapa[xin][yin].getPeca() instanceof Peao){
                        contmov=0;
                    }else{
                        contmov++;

                    }
	                    mapa[xout][yout].setPeca(mapa[xin][yin].getPeca());
	                    mapa[xin][yin].setOcupado(0);
	                    mapa[xout][yout].setOcupado(1);
                        ///PROMO DO PE??O PRA RAINHA
                        //promocao();
                        xequet=testadordeXeque.testeXeque(mapa, turno);
                        if(xequet==1){
                            matet=testadordeXeque.testeMate(mapa, turno);
                        }

                    if(mapa[xin][yin].getPeca() instanceof Peao){
                        try {
                            FileWriter escrito = new FileWriter("log.txt", true);
                            BufferedWriter bw = new BufferedWriter(escrito);
                            PrintWriter escritor = new PrintWriter(bw);
                            if(turno==0){
                                escritor.printf(rodada+". " + coluna+linha);

                                if(xequet==1){
                                    if(matet==1){
                                        escritor.printf("#");
                                        escritor.close();
                                    }else {
                                        escritor.printf("+");
                                        escritor.close();
                                    }
                                }else{
                                    escritor.close();
                                }
                            }else{
                                escritor.printf(" "+coluna+linha);

                                if(xequet==1){
                                    if(matet==1){
                                        escritor.printf("#");
                                        escritor.printf("\n");
                                        escritor.close();
                                    }else {
                                        escritor.printf("+");
                                        escritor.printf("\n");
                                        escritor.close();
                                    }
                                }else{
                                    escritor.printf("\n");
                                    escritor.close();
                                }
                            }

                        } catch (IOException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                        contmov=0;
                    }else{
                        contmov++;
                        if(mapa[xin][yin].getPeca() instanceof Torre){
                            try {
                                FileWriter escrito = new FileWriter("log.txt", true);
                                BufferedWriter bw = new BufferedWriter(escrito);
                                PrintWriter escritor = new PrintWriter(bw);
                                if(turno==0){
                                    escritor.printf(rodada+". R" + coluna+linha);

                                    if(xequet==1){
                                        if(matet==1){
                                            escritor.printf("#");
                                            escritor.close();
                                        }else {
                                            escritor.printf("+");
                                            escritor.close();
                                        }
                                    }else{
                                        escritor.close();
                                    }
                                }else{
                                    escritor.printf(" R"+coluna+linha);

                                    if(xequet==1){
                                        if(matet==1){
                                            escritor.printf("#");
                                            escritor.printf("\n");
                                            escritor.close();
                                        }else {
                                            escritor.printf("+");
                                            escritor.printf("\n");
                                            escritor.close();
                                        }
                                    }else{
                                        escritor.printf("\n");
                                        escritor.close();
                                    }
                                }

                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        }else{
                            if(mapa[xin][yin].getPeca() instanceof Cavalo){
                                try {
                                    FileWriter escrito = new FileWriter("log.txt", true);
                                    BufferedWriter bw = new BufferedWriter(escrito);
                                    PrintWriter escritor = new PrintWriter(bw);
                                    if(turno==0){
                                        escritor.printf(rodada+". N" + coluna+linha);

                                        if(xequet==1){
                                            if(matet==1){
                                                escritor.printf("#");
                                                escritor.close();
                                            }else {
                                                escritor.printf("+");
                                                escritor.close();
                                            }
                                        }else{
                                            escritor.close();
                                        }
                                    }else{
                                        escritor.printf(" N"+coluna+linha);

                                        if(xequet==1){
                                            if(matet==1){
                                                escritor.printf("#");
                                                escritor.printf("\n");
                                                escritor.close();
                                            }else {
                                                escritor.printf("+");
                                                escritor.printf("\n");
                                                escritor.close();
                                            }
                                        }else{
                                            escritor.printf("\n");
                                            escritor.close();
                                        }
                                    }

                                } catch (IOException e) {
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }
                            }else{
                                if(mapa[xin][yin].getPeca() instanceof Bispo){
                                    try {
                                        FileWriter escrito = new FileWriter("log.txt", true);
                                        BufferedWriter bw = new BufferedWriter(escrito);
                                        PrintWriter escritor = new PrintWriter(bw);
                                        if(turno==0){
                                            escritor.printf(rodada+". B" + coluna+linha);

                                            if(xequet==1){
                                                if(matet==1){
                                                    escritor.printf("#");
                                                    escritor.close();
                                                }else {
                                                    escritor.printf("+");
                                                    escritor.close();
                                                }
                                            }else{
                                                escritor.close();
                                            }
                                        }else{
                                            escritor.printf(" B"+coluna+linha);

                                            if(xequet==1){
                                                if(matet==1){
                                                    escritor.printf("#");
                                                    escritor.printf("\n");
                                                    escritor.close();
                                                }else {
                                                    escritor.printf("+");
                                                    escritor.printf("\n");
                                                    escritor.close();
                                                }
                                            }else{
                                                escritor.printf("\n");
                                                escritor.close();
                                            }
                                        }

                                    } catch (IOException e) {
                                        System.out.println("An error occurred.");
                                        e.printStackTrace();
                                    }
                                }else{
                                    if(mapa[xin][yin].getPeca() instanceof Rainha){
                                        try {
                                            FileWriter escrito = new FileWriter("log.txt", true);
                                            BufferedWriter bw = new BufferedWriter(escrito);
                                            PrintWriter escritor = new PrintWriter(bw);

                                            if(turno==0){
                                                escritor.printf(rodada+". Q" + coluna+linha);

                                                if(xequet==1){
                                                    if(matet==1){
                                                        escritor.printf("#");
                                                        escritor.close();
                                                    }else {
                                                        escritor.printf("+");
                                                        escritor.close();
                                                    }
                                                }else{
                                                    escritor.close();
                                                }
                                            }else{
                                                escritor.printf(" Q"+coluna+linha);

                                                if(xequet==1){
                                                    if(matet==1){
                                                        escritor.printf("#");
                                                        escritor.printf("\n");
                                                        escritor.close();
                                                    }else {
                                                        escritor.printf("+");
                                                        escritor.printf("\n");
                                                        escritor.close();
                                                    }
                                                }else{
                                                    escritor.printf("\n");
                                                    escritor.close();
                                                }
                                            }

                                        } catch (IOException e) {
                                            System.out.println("An error occurred.");
                                            e.printStackTrace();
                                        }
                                    }else{
                                        if(mapa[xin][yin].getPeca() instanceof Rei){
                                            try {
                                                FileWriter escrito = new FileWriter("log.txt", true);
                                                BufferedWriter bw = new BufferedWriter(escrito);
                                                PrintWriter escritor = new PrintWriter(bw);
                                                if(turno==0){
                                                    escritor.printf(rodada+". K" + coluna+linha);

                                                    if(xequet==1){
                                                        if(matet==1){
                                                            escritor.printf("#");
                                                            escritor.close();
                                                        }else {
                                                            escritor.printf("+");
                                                            escritor.close();
                                                        }
                                                    }else{
                                                        escritor.close();
                                                    }
                                                }else{
                                                    escritor.printf(" K"+coluna+linha);

                                                    if(xequet==1){
                                                        if(matet==1){
                                                            escritor.printf("#");
                                                            escritor.printf("\n");
                                                            escritor.close();
                                                        }else {
                                                            escritor.printf("+");
                                                            escritor.printf("\n");
                                                            escritor.close();
                                                        }
                                                    }else{
                                                        escritor.printf("\n");
                                                        escritor.close();
                                                    }
                                                }

                                            } catch (IOException e) {
                                                System.out.println("An error occurred.");
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
	                    ///Colocar troca de turno
	                    break;
	                case 2:
	                	mapa[xin][yin].setOcupado(0);
	                    mapa[xout][yout].setPeca(mapa[xin][yin].getPeca());
	                    mapa[xout][yout].setOcupado(1);
                        ///PROMO DO PE??O PRA RAINHA

                        //promocao();
                        xequet=testadordeXeque.testeXeque(mapa, turno);
                        contmov=0;
                        if(xequet==1){
                            matet=testadordeXeque.testeMate(mapa, turno);
                        }
                        if(mapa[xin][yin].getPeca() instanceof Peao){
                            try {
                                FileWriter escrito = new FileWriter("log.txt", true);
                                BufferedWriter bw = new BufferedWriter(escrito);
                                PrintWriter escritor = new PrintWriter(bw);
                                if(turno==0){
                                    escritor.printf(rodada+". " + coluna1+ "x" + coluna+linha);

                                    if(xequet==1){
                                        if(matet==1){
                                            escritor.printf("#");
                                            escritor.close();
                                        }else {
                                            escritor.printf("+");
                                            escritor.close();
                                        }
                                    }else{
                                        escritor.close();
                                    }
                                }else{
                                    escritor.printf(" "+ coluna1+ "x" +coluna+linha);

                                    if(xequet==1){
                                        if(matet==1){
                                            escritor.printf("#");
                                            escritor.printf("\n");
                                            escritor.close();
                                        }else {
                                            escritor.printf("+");
                                            escritor.printf("\n");
                                            escritor.close();
                                        }
                                    }else{
                                        escritor.printf("\n");
                                        escritor.close();
                                    }
                                }

                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        }else{
                            if(mapa[xin][yin].getPeca() instanceof Torre){
                                try {
                                    FileWriter escrito = new FileWriter("log.txt", true);
                                    BufferedWriter bw = new BufferedWriter(escrito);
                                    PrintWriter escritor = new PrintWriter(bw);
                                    if(turno==0){
                                        escritor.printf(rodada+". R" + "x"+ coluna+linha);

                                        if(xequet==1){
                                            if(matet==1){
                                                escritor.printf("#");
                                                escritor.close();
                                            }else {
                                                escritor.printf("+");
                                                escritor.close();
                                            }
                                        }else{
                                            escritor.close();
                                        }
                                    }else{
                                        escritor.printf(" R"+"x"+coluna+linha);

                                        if(xequet==1){
                                            if(matet==1){
                                                escritor.printf("#");
                                                escritor.printf("\n");
                                                escritor.close();
                                            }else {
                                                escritor.printf("+");
                                                escritor.printf("\n");
                                                escritor.close();
                                            }
                                        }else{
                                            escritor.printf("\n");
                                            escritor.close();
                                        }
                                    }

                                } catch (IOException e) {
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }
                            }else{
                                if(mapa[xin][yin].getPeca() instanceof Cavalo){
                                    try {
                                        FileWriter escrito = new FileWriter("log.txt", true);
                                        BufferedWriter bw = new BufferedWriter(escrito);
                                        PrintWriter escritor = new PrintWriter(bw);
                                        if(turno==0){
                                            escritor.printf(rodada+". N" +"x"+ coluna+linha);

                                            if(xequet==1){
                                                if(matet==1){
                                                    escritor.printf("#");
                                                    escritor.close();
                                                }else {
                                                    escritor.printf("+");
                                                    escritor.close();
                                                }
                                            }else{
                                                escritor.close();
                                            }
                                        }else{
                                            escritor.printf(" N"+"x"+coluna+linha);

                                            if(xequet==1){
                                                if(matet==1){
                                                    escritor.printf("#");
                                                    escritor.printf("\n");
                                                    escritor.close();
                                                }else {
                                                    escritor.printf("+");
                                                    escritor.printf("\n");
                                                    escritor.close();
                                                }
                                            }else{
                                                escritor.printf("\n");
                                                escritor.close();
                                            }
                                        }

                                    } catch (IOException e) {
                                        System.out.println("An error occurred.");
                                        e.printStackTrace();
                                    }
                                }else{
                                    if(mapa[xin][yin].getPeca() instanceof Bispo){
                                        try {
                                            FileWriter escrito = new FileWriter("log.txt", true);
                                            BufferedWriter bw = new BufferedWriter(escrito);
                                            PrintWriter escritor = new PrintWriter(bw);

                                            if(turno==0){
                                                escritor.printf(rodada+". B" +"x"+ coluna+linha);

                                                if(xequet==1){
                                                    if(matet==1){
                                                        escritor.printf("#");
                                                        escritor.close();
                                                    }else {
                                                        escritor.printf("+");
                                                        escritor.close();
                                                    }
                                                }else{
                                                    escritor.close();
                                                }
                                            }else{
                                                escritor.printf(" B"+"x"+coluna+linha);

                                                if(xequet==1){
                                                    if(matet==1){
                                                        escritor.printf("#");
                                                        escritor.printf("\n");
                                                        escritor.close();
                                                    }else {
                                                        escritor.printf("+");
                                                        escritor.printf("\n");
                                                        escritor.close();
                                                    }
                                                }else{
                                                    escritor.printf("\n");
                                                    escritor.close();
                                                }
                                            }

                                        } catch (IOException e) {
                                            System.out.println("An error occurred.");
                                            e.printStackTrace();
                                        }
                                    }else{
                                        if(mapa[xin][yin].getPeca() instanceof Rainha){
                                            try {
                                                FileWriter escrito = new FileWriter("log.txt", true);
                                                BufferedWriter bw = new BufferedWriter(escrito);
                                                PrintWriter escritor = new PrintWriter(bw);
                                                if(turno==0){
                                                    escritor.printf(rodada+". Q" +"x"+ coluna+linha);

                                                    if(xequet==1){
                                                        if(matet==1){
                                                            escritor.printf("#");
                                                            escritor.close();
                                                        }else {
                                                            escritor.printf("+");
                                                            escritor.close();
                                                        }
                                                    }else{
                                                        escritor.close();
                                                    }
                                                }else{
                                                    escritor.printf(" Q"+"x"+coluna+linha);

                                                    if(xequet==1){
                                                        if(matet==1){
                                                            escritor.printf("#");
                                                            escritor.printf("\n");
                                                            escritor.close();
                                                        }else {
                                                            escritor.printf("+");
                                                            escritor.printf("\n");
                                                            escritor.close();
                                                        }
                                                    }else{
                                                        escritor.printf("\n");
                                                        escritor.close();
                                                    }
                                                }

                                            } catch (IOException e) {
                                                System.out.println("An error occurred.");
                                                e.printStackTrace();
                                            }
                                        }else{
                                            if(mapa[xin][yin].getPeca() instanceof Rei){
                                                try {
                                                    FileWriter escrito = new FileWriter("log.txt", true);
                                                    BufferedWriter bw = new BufferedWriter(escrito);
                                                    PrintWriter escritor = new PrintWriter(bw);
                                                    if(turno==0){
                                                        escritor.printf(rodada+". K" +"x"+ coluna+linha);

                                                        if(xequet==1){
                                                            if(matet==1){
                                                                escritor.printf("#");
                                                                escritor.close();
                                                            }else {
                                                                escritor.printf("+");
                                                                escritor.close();
                                                            }
                                                        }else{
                                                            escritor.close();
                                                        }
                                                    }else{
                                                        escritor.printf(" K"+"x"+coluna+linha);

                                                        if(xequet==1){
                                                            if(matet==1){
                                                                escritor.printf("#");
                                                                escritor.printf("\n");
                                                                escritor.close();
                                                            }else {
                                                                escritor.printf("+");
                                                                escritor.printf("\n");
                                                                escritor.close();
                                                            }
                                                        }else{
                                                            escritor.printf("\n");
                                                            escritor.close();
                                                        }
                                                    }

                                                } catch (IOException e) {
                                                    System.out.println("An error occurred.");
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
	                    break;
                    case 3:
                        mapa[xout][yout].setPeca(mapa[xin][yin].getPeca());
                        mapa[xout][yout].setOcupado(1);
                        mapa[xin][yin].setOcupado(0);
                        mapa[xin+1][yin].setPeca(mapa[xin+3][yin].getPeca());
                        mapa[xin+1][yin].setOcupado(1);
                        mapa[xin+3][yin].setOcupado(0);

                        xequet=testadordeXeque.testeXeque(mapa, turno);
                        if(xequet==1){
                            matet=testadordeXeque.testeMate(mapa, turno);
                        }

                        try {
                            FileWriter escrito = new FileWriter("log.txt", true);
                            BufferedWriter bw = new BufferedWriter(escrito);
                            PrintWriter escritor = new PrintWriter(bw);
                            if(turno==0){
                                escritor.printf(rodada+". " + "O-O");

                                if(xequet==1){
                                    if(matet==1){
                                        escritor.printf("#");
                                        escritor.close();
                                    }else {
                                        escritor.printf("+");
                                        escritor.close();
                                    }
                                }else{
                                    escritor.close();
                                }
                            }else{
                                escritor.printf(" "+  "O-O");

                                if(xequet==1){
                                    if(matet==1){
                                        escritor.printf("#");
                                        escritor.printf("\n");
                                        escritor.close();
                                    }else {
                                        escritor.printf("+");
                                        escritor.printf("\n");
                                        escritor.close();
                                    }
                                }else{
                                    escritor.printf("\n");
                                    escritor.close();
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }

                        break;
	            }


                if(matet==1){
                }
	            if(mov>0) {

	            	if(turno==0) {
	            		turno=1;
	            	}else {
                        rodada++;
	            		turno=0;
	            	}
	            }
        }else{

        }
            
            ///Checar se s?? tem os dois reis e + uma pe??a na regra de Falta de pe??as
        contp=0;
        for (j = 0; j < 8; j++) {
            for (i = 0; i < 8; i++) {
                if (mapa[i][j].getOcupado() == 1) {
                    contp++;
                }
            }
            System.out.printf("\n");
        }

        /*A partida pode terminar no empate, se ambos os
        jogadores completarem 50 lances consecutivos sem
        a movimenta????o de qualquer pe??o e sem a captura
        de qualquer pe??a.*/

        /*Regra do xeque perp??tuo, ?? colocar indefinidas vezes o rei do oponente
        * em xeque, sem prop??sito de mudan??as, isto ser?? registrado colocando o rei em xeque
        * movendo a mesma pe??a que o colocou 10 vezes*/
        if(mov==1) {
            if (xequet == 1) {
                if (mesmapecaxeque0.getPeca() ==  mapa[xout][yout].getPeca() && turno==0) {
                    msmpxequecont0++;
                }else{
                    if(mesmapecaxeque1.getPeca() ==  mapa[xout][yout].getPeca()){
                        msmpxequecont1++;
                    }else{
                        if(turno==0){
                            mesmapecaxeque0.setPeca(mapa[xout][yout].getPeca());
                            msmpxequecont0=0;
                        }else{
                            mesmapecaxeque1.setPeca(mapa[xout][yout].getPeca());
                            msmpxequecont1=0;
                        }
                    }
                }
            }else{
                if(turno==0){
                    msmpxequecont0=0;
                }else{
                    msmpxequecont1=0;
                }
            }
        }else{
            if(turno==0){
                msmpxequecont0=0;
            }else{
                msmpxequecont1=0;
            }
        }

        if(msmpxequecont0>=10 || msmpxequecont1>=10){
        }

    }

    

    public void transin(int tx, int ty, int transinto){
        ///0=torre, 1= cavalo, 2 = bispo, 3= rainha
        switch (transinto){
            case 0:
                if(ty==1) {
                    mapa[tx][0].setPeca(torre0);
                }else{
                    mapa[tx][7].setPeca(torre1);
                }
                break;
            case 1:
                if(ty==1) {
                    mapa[tx][0].setPeca(cavalo0);
                }else{
                    mapa[tx][7].setPeca(cavalo1);
                }
                break;
            case 2:
                if(ty==1) {
                    mapa[tx][0].setPeca(bispo0);
                }else{
                    mapa[tx][7].setPeca(bispo1);
                }
                break;
            case 3:
                if(ty==1) {
                    mapa[tx][0].setPeca(rainha0);
                }else{
                    mapa[tx][7].setPeca(rainha1);
                }
                break;
        }

    }








}


