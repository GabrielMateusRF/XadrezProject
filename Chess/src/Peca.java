public abstract class Peca {
    /*Peca tem 3 elementos nela:
    * Sua cor, Sua posicao e seu status de capturada
    * Ela também será responsável para realizar a função de se mover, mas não será quem verifica
    * a verificação de um movimento válido será feita pela heranca*/

    public int cor, x, y, status;
    ///COR=  0 branca, 1 Preta
    ///Status= 0 Viva, 1 Capturada

    ///Arrumar especificacoes iniciais da peca
    public void setPeca(int scor, int sx, int sy){
        cor=scor;
        x=sx;
        y=sy;
        status=0;
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
