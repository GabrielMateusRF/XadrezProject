public abstract class Peca {
    /*Peca tem 3 elementos nela:
    * Sua cor, Sua posicao e seu status de capturada
    * Ela também será responsável para realizar a função de se mover, mas não será quem verifica
    * a verificação de um movimento válido será feita pela heranca*/

    public int cor,  status=0;
    ///COR=  0 branca, 1 Preta
    ///Status= 0 Viva, 1 Capturada
    ///Caso Existe estiver em 0, o lugar é vazio


    ///Arrumar especificacoes iniciais da peca
    public void setPeca(int scor){
        cor=scor;
        status=0;

    }

    
    public int getCor() {
    	return cor;
    }

    public void setStatus(int Sstatus){
        status=Sstatus;
    }

    public int getStatus() {
        return status;
    }

}
