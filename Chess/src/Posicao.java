public class Posicao {
    public Peca peca;
    public int ocupado=0;///0 não, 1 sim

    public void setPeca(Peca tpeca){
        peca=tpeca;
        ocupado=1;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setOcupado(int n){
        ocupado=n;
    }

    public int getOcupado() {
        return ocupado;
    }
}
