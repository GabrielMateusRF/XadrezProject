public class Tabuleiro {
    ///bora usar uma classe e declarar ela
    public Posicao[][] mapa= new Posicao[8][8];
    public Peao peao;
    public Torre torre;
    public Cavalo cavalo;
    public Bispo bispo;
    public Rainha rainha;
    public Rei rei;
    public int turno; //0 branco, 1 preto
    int i, j;

    public void reset(){
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
                            torre.setPeca(0,j,i,1);///NOTA: TALVEZ ESTEJA AO CONTRÁRIO, CULPA DO LUCCA
                            mapa[i][j].setPeca(torre);
                            break;
                        case 1:
                            cavalo.setPeca(0,j,i,2);
                            mapa[i][j].setPeca(cavalo);
                            break;
                        case 2:
                            bispo.setPeca(0,j,i,3);
                            mapa[i][j].setPeca(bispo);
                            break;
                        case 3:
                            rainha.setPeca(0,j,i,4);
                            mapa[i][j].setPeca(rainha);
                            break;
                        case 4:
                            rei.setPeca(0,j,i,5);
                            mapa[i][j].setPeca(rei);
                            break;
                        case 5:
                            bispo.setPeca(0,j,i,3);
                            mapa[i][j].setPeca(bispo);
                            break;
                        case 6:
                            cavalo.setPeca(0,j,i,2);
                            mapa[i][j].setPeca(cavalo);
                            break;
                        case 7:
                            torre.setPeca(0,j,i,1);
                            mapa[i][j].setPeca(torre);
                            break;

                    }
                }
            }
        }
    }
}

