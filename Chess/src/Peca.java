public abstract class Peca {
    /*Peca tem 3 elementos nela:
    * Sua cor, Sua posicao e seu status de capturada
    * Ela também será responsável para realizar a função de se mover, mas não será quem verifica
    * a verificação de um movimento válido será feita pela heranca*/

    public int cor, x, y, tipo, status=0;
    ///COR=  0 branca, 1 Preta
    ///Status= 0 Viva, 1 Capturada
    ///Caso Existe estiver em 0, o lugar é vazio
    /*Tipos:
    0 Peao
    1 Torre
    2 Cavalo
    3 Bispo
    4 Rainha
    5 Rei
     * */

    ///Arrumar especificacoes iniciais da peca
    public void setPeca(int scor, int sx, int sy, int tipo){
        cor=scor;
        x=sx;
        y=sy;
        status=0;
        this.tipo=tipo;//FUNFAAA

    }

    ///melhor deixar eles separados pois tme peças que só movem uma ou outra, como a torre
    public void setX (int sx){
        x=sx;
    }

    public void setY (int sy){
        y=sy;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public void setStatus(int Sstatus){
        status=Sstatus;
    }

    public int getStatus() {
        return status;
    }

}
