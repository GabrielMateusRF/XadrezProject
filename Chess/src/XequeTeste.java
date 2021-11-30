public class XequeTeste {
    int i, j, i2, j2, val, inimigo;

    public int testeXequeproprio(Posicao[][] mapa, int turno){
        val=0;
        if(turno==0){
            inimigo=1;
        }else{
            inimigo=0;
        };
        ///xequecheck
        for(i=0; i<8;i++){
            for(j=0;j<8;j++) {
                ///Caso um movimento que tu fizer te coloca em xeque;
                if (mapa[i][j].getPeca() instanceof Rei && mapa[i][j].getPeca().getCor()==turno){
                    for(i2=0; i2<8;i2++){
                        for(j2=0;j2<8;j2++) {
                            if(mapa[i2][j2].getOcupado()==1 && mapa[i2][j2].getPeca().getCor()==inimigo){

                                if (mapa[i2][j2].getPeca() instanceof Peao) {
                                    System.out.printf("\n P \n");
                                    System.out.printf("\n K1 \n");
                                    val=((Peao) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                    System.out.printf("\n"+ val +"Cor: "+ mapa[i2][j2].getPeca().getCor()  +"\n");
                                } else {
                                    if (mapa[i2][j2].getPeca() instanceof Torre) {
                                        System.out.printf("\n K2 \n");
                                        if(mapa[i][j].getPeca() instanceof Rei){
                                            if(mapa[i][j].getPeca().getCor()==0){
                                                System.out.printf("\n REI BRANCO\n");
                                            }
                                        }
                                        if(mapa[i2][j2].getPeca() instanceof Torre){
                                            if(mapa[i2][j2].getPeca().getCor()==1){
                                                System.out.printf("\n TORRE PRETA\n");
                                            }
                                        }
                                        val=((Torre) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                        System.out.printf("\n"+ val +"Cor: "+ mapa[i2][j2].getPeca().getCor() +"\n");
                                    } else {
                                        if (mapa[i2][j2].getPeca() instanceof Cavalo) {
                                            System.out.printf("\n K3 \n");
                                            val=((Cavalo) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                        } else {
                                            if (mapa[i2][j2].getPeca() instanceof Bispo) {
                                                System.out.printf("\n K4 \n");
                                                val=((Bispo) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                            } else {
                                                if (mapa[i2][j2].getPeca() instanceof Rainha) {
                                                    System.out.printf("\n K5 \n");
                                                    val=((Rainha) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                                } else {
                                                    System.out.printf("\n K6 \n");
                                                    val=((Rei) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                                }
                                            }
                                        }
                                    }
                                }
                                if(val>0){
                                    System.out.println("\n Tu se colocou em xeque  :v");
                                    return 0;
                                }

                            }

                        }
                    }
                }

            }
        }
        return 1;
    }

}