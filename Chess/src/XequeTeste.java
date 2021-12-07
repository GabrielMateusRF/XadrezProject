public class XequeTeste {
    int i, j, i2, j2, i3, i4, j4, val, val2, inimigo, escape;
    public Posicao pecasalva = new Posicao();
    public Posicao pecasalva2 = new Posicao();
    int imate, jmate;
    public int testeXequeproprio(Posicao[][] mapa, int turno, int mov, int xin, int yin, int xout, int yout) {
        val = 0;

        switch (mov) {
            case 1:
                mapa[xout][yout].setPeca(mapa[xin][yin].getPeca());
                mapa[xin][yin].setOcupado(0);
                mapa[xout][yout].setOcupado(1);
                ///Colocar troca de turno
                break;
            case 2:
                mapa[xin][yin].setOcupado(0);
                pecasalva.setPeca(mapa[xout][yout].getPeca());
                mapa[xout][yout].setPeca(mapa[xin][yin].getPeca());
                mapa[xout][yout].setOcupado(1);
                ///Adicionar score
                ///Colocar troca de turno
                break;

            case 3:
                mapa[xout][yout].setPeca(mapa[xin][yin].getPeca());
                mapa[xout][yout].setOcupado(1);
                mapa[xin][yin].setOcupado(0);
                mapa[xin+1][yin].setPeca(mapa[xin+3][yin].getPeca());
                mapa[xin+1][yin].setOcupado(1);
                mapa[xin+3][yin].setOcupado(0);
                break;
        }

        if (turno == 0) {
            inimigo = 1;
        } else {
            inimigo = 0;
        }
        ///xequecheck
        ///Caso um movimento que tu fizer te coloca em xeque;
        for (i = 0; i < 8; i++) {
            for (j=0; j<8; j++){
            if (mapa[i][j].getPeca() instanceof Rei && mapa[i][j].getOcupado() == 1 && mapa[i][j].getPeca().getCor() == turno) {
                for (i2 = 0; i2 < 8; i2++) {
                    for (j2 = 0; j2 < 8; j2++) {
                        if (mapa[i2][j2].getOcupado() == 1 && mapa[i2][j2].getPeca().getCor() == inimigo) {
                            if (mapa[i2][j2].getPeca() instanceof Peao) {
                                val = ((Peao) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                            } else {
                                if (mapa[i2][j2].getPeca() instanceof Torre) {
                                    val = ((Torre) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                } else {
                                    if (mapa[i2][j2].getPeca() instanceof Cavalo) {
                                        val = ((Cavalo) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                    } else {
                                        if (mapa[i2][j2].getPeca() instanceof Bispo) {
                                            val = ((Bispo) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                        } else {
                                            if (mapa[i2][j2].getPeca() instanceof Rainha) {
                                                val = ((Rainha) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                            } else {
                                                if (mapa[i2][j2].getPeca() instanceof Rei) {
                                                    val = 0;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (val > 0) {
                                System.out.println("\n Tu se colocou em xeque  :v");
                                switch (mov) {
                                    case 1:
                                        mapa[xin][yin].setPeca(mapa[xout][yout].getPeca());

                                        mapa[xin][yin].setOcupado(1);
                                        mapa[xout][yout].setOcupado(0);
                                        ///Colocar troca de turno
                                        break;
                                    case 2:

                                        mapa[xin][yin].setOcupado(0);
                                        mapa[xin][yin].setPeca(mapa[xout][yout].getPeca());
                                        mapa[xout][yout].setOcupado(0);
                                        mapa[xout][yout].setPeca(pecasalva.getPeca());

                                        mapa[xin][yin].setOcupado(1);
                                        mapa[xout][yout].setOcupado(1);
                                        ///Adicionar score
                                        ///Colocar troca de turno
                                        break;
                                    case 3:
                                        mapa[xin+3][yin].setPeca(mapa[xin+1][yin].getPeca());
                                        mapa[xin+1][yin].setOcupado(0);
                                        mapa[xin+3][yin].setOcupado(1);
                                        mapa[xin][yin].setPeca(mapa[xout][yout].getPeca());
                                        mapa[xout][yout].setOcupado(0);
                                        mapa[xin][yin].setOcupado(1);
                                        break;
                                }
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

    public int testeXeque(Posicao[][] mapa, int turno) {
        val = 0;


        if (turno == 0) {
            inimigo = 1;
        } else {
            inimigo = 0;
        }
        ;
        ///xequecheck
        ///Caso um movimento que tu fizer te coloca em xeque;
        for (i = 0; i < 8; i++) {
            for (j=0; j<8; j++){
                if (mapa[i][j].getPeca() instanceof Rei && mapa[i][j].getOcupado() == 1 && mapa[i][j].getPeca().getCor() == inimigo) {
                    for (i2 = 0; i2 < 8; i2++) {
                        for (j2 = 0; j2 < 8; j2++) {
                            if (mapa[i2][j2].getOcupado() == 1 && mapa[i2][j2].getPeca().getCor() == turno) {
                                if (mapa[i2][j2].getPeca() instanceof Peao) {
                                    val = ((Peao) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                } else {
                                    if (mapa[i2][j2].getPeca() instanceof Torre) {
                                        val = ((Torre) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                    } else {
                                        if (mapa[i2][j2].getPeca() instanceof Cavalo) {
                                            System.out.printf("\n K3 \n");
                                            val = ((Cavalo) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);

                                        } else {
                                            if (mapa[i2][j2].getPeca() instanceof Bispo) {
                                                val = ((Bispo) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                            } else {
                                                if (mapa[i2][j2].getPeca() instanceof Rainha) {
                                                    val = ((Rainha) mapa[i2][j2].getPeca()).movValido(mapa, i, j, i2, j2);
                                                } else {
                                                    if (mapa[i2][j2].getPeca() instanceof Rei) {
                                                        val = 0;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (val > 0) {
                                    System.out.println("\n XEQUE!  !w!");

                                    return 1;
                                }

                            }

                        }
                    }
                }
            }
        }

        return 0;
    }


    public int testeMate(Posicao[][] mapa, int turno){
        val2 = 0;
        escape=0;

        if (turno == 0) {
            inimigo = 1;
        } else {
            inimigo = 0;
        }
        ;
        ///xequecheck
        ///Caso um movimento que tu fizer te coloca em xeque;
        for (i4 = 0; i4 < 8; i4++) {
            for (j4=0; j4<8; j4++){
                ///achar rei inimigo
                if (mapa[i4][j4].getPeca() instanceof Rei && mapa[i4][j4].getOcupado() == 1 && mapa[i4][j4].getPeca().getCor() == inimigo) {
                        ///i e j tem posição do rei
                    for(i3=0; i3<8; i3++) {
                        switch (i3){
                            case 0:
                                imate=i-1;
                                jmate=j-1;
                                break;
                            case 1:
                                imate=i;
                                jmate=j-1;
                                break;
                            case 2:
                                imate=i+1;
                                jmate=j-1;
                                break;
                            case 3:
                                imate=i-1;
                                jmate=j;
                                break;
                            case 4:
                                imate=i+1;
                                jmate=j;
                                break;
                            case 5:
                                imate=i-1;
                                jmate=j+1;
                                break;
                            case 6:
                                imate=i;
                                jmate=j+1;
                                break;
                            case 7:
                                imate=i+1;
                                jmate=j+1;
                                break;

                        }
                       ///Evitar verificações desnecessárias
                        if((imate<0)||(imate>7)||(jmate<0)||(jmate>7)){
                            val2=0;
                        }else{
                            val2 = ((Rei) mapa[i4][j4].getPeca()).movValido(mapa, imate, jmate, i4, j4);
                        }

                        if(val2==0){
                            escape++;
                        }
                        if (val2 > 0) {
                            switch (val2) {
                                case 1:
                                    mapa[imate][jmate].setPeca(mapa[i4][j4].getPeca());
                                    mapa[i4][j4].setOcupado(0);
                                    mapa[imate][jmate].setOcupado(1);
                                    ///Colocar troca de turno
                                    break;
                                case 2:
                                    mapa[i4][j4].setOcupado(0);
                                    pecasalva2.setPeca(mapa[imate][jmate].getPeca());
                                    mapa[imate][jmate].setPeca(mapa[i4][j4].getPeca());
                                    mapa[imate][jmate].setOcupado(1);
                                    ///Adicionar score
                                    ///Colocar troca de turno
                                    break;
                                case 3:
                                    mapa[imate][jmate].setPeca(mapa[i4][j4].getPeca());
                                    mapa[imate][jmate].setOcupado(1);
                                    mapa[i4][j4].setOcupado(0);
                                    mapa[i4+1][j4].setPeca(mapa[i4+3][j4].getPeca());
                                    mapa[i4+1][j4].setOcupado(1);
                                    mapa[i4+3][j4].setOcupado(0);
                                    break;
                            }
                            ///aumenta em 1 se for cheque
                            escape += testeXeque(mapa, turno);

                            switch (val2) {
                                case 1:
                                    mapa[i4][j4].setPeca(mapa[imate][jmate].getPeca());

                                    mapa[i4][j4].setOcupado(1);
                                    mapa[imate][jmate].setOcupado(0);
                                    ///Colocar troca de turno
                                    break;
                                case 2:

                                    mapa[i4][j4].setOcupado(0);
                                    mapa[i4][j4].setPeca(mapa[imate][jmate].getPeca());
                                    mapa[imate][jmate].setOcupado(0);
                                    mapa[imate][jmate].setPeca(pecasalva2.getPeca());

                                    mapa[i4][j4].setOcupado(1);
                                    mapa[imate][jmate].setOcupado(1);
                                    ///Adicionar score
                                    ///Colocar troca de turno
                                    break;
                                case 3:

                                    mapa[i4+3][j4].setPeca(mapa[i4+1][j4].getPeca());
                                    mapa[i4+1][j4].setOcupado(0);
                                    mapa[i4+3][j4].setOcupado(1);
                                    mapa[i4][j4].setPeca(mapa[imate][jmate].getPeca());
                                    mapa[imate][jmate].setOcupado(0);
                                    mapa[i4][j4].setOcupado(1);
                                    break;
                            }


                        }
                    }
                }
                if(escape==8){
                    for (i2 = 0; i2 < 8; i2++) {
                        for (j2 = 0; j2 < 8; j2++) {
                            if (mapa[i2][j2].getOcupado() == 1 && mapa[i2][j2].getPeca().getCor() == turno) {
                                if (mapa[i2][j2].getPeca() instanceof Peao) {
                                    val = ((Peao) mapa[i2][j2].getPeca()).movValido(mapa, i4, j4, i2, j2);
                                } else {
                                    if (mapa[i2][j2].getPeca() instanceof Torre) {
                                        val = ((Torre) mapa[i2][j2].getPeca()).movValido(mapa,i4, j4, i2, j2);
                                    } else {
                                        if (mapa[i2][j2].getPeca() instanceof Cavalo) {
                                            val = ((Cavalo) mapa[i2][j2].getPeca()).movValido(mapa,i4, j4, i2, j2);
                                        } else {
                                            if (mapa[i2][j2].getPeca() instanceof Bispo) {
                                                val = ((Bispo) mapa[i2][j2].getPeca()).movValido(mapa, i4, j4, i2, j2);
                                            } else {
                                                if (mapa[i2][j2].getPeca() instanceof Rainha) {
                                                    val = ((Rainha) mapa[i2][j2].getPeca()).movValido(mapa, i4, j4, i2, j2);
                                                } else {
                                                    if (mapa[i2][j2].getPeca() instanceof Rei) {
                                                        val = 0;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (val > 0) {

                                    for (i = 0; i < 8; i++) {
                                        for (j = 0; j < 8; j++) {
                                            if (mapa[i][j].getOcupado() == 1 && mapa[i][j].getPeca().getCor() != turno) {
                                                if (mapa[i][j].getPeca() instanceof Peao) {
                                                    val = ((Peao) mapa[i][j].getPeca()).movValido(mapa, i2, j2, i, j);

                                                } else {
                                                    if (mapa[i][j].getPeca() instanceof Torre) {
                                                        val = ((Torre) mapa[i][j].getPeca()).movValido(mapa, i2, j2, i, j);
                                                    } else {
                                                        if (mapa[i][j].getPeca() instanceof Cavalo) {
                                                            val = ((Cavalo) mapa[i][j].getPeca()).movValido(mapa,i2, j2, i, j);
                                                        } else {
                                                            if (mapa[i][j].getPeca() instanceof Bispo) {
                                                                val = ((Bispo) mapa[i][j].getPeca()).movValido(mapa, i2, j2, i, j);

                                                            } else {
                                                                if (mapa[i][j].getPeca() instanceof Rainha) {
                                                                    val = ((Rainha) mapa[i][j].getPeca()).movValido(mapa, i2, j2, i, j);
                                                                } else {
                                                                    if (mapa[i][j].getPeca() instanceof Rei) {
                                                                        val = ((Rei) mapa[i][j].getPeca()).movValido(mapa, i2, j2, i, j);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (val > 0) {
                                                    return 0;
                                                }

                                            }

                                        }
                                    }


                                }

                            }

                        }
                    }



                    System.out.printf("\n MAATEEEEEE \n");
                    return 1;
                }
            }
        }


        return 0;
    }







}
