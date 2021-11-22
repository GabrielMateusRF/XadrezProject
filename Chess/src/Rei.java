public class Rei extends Peca{

    public int movValido(Tabuleiro tabuleiro,int xdado, int ydado){
    	int zx, zy;
    	zx = x-xdado;
    	zy = y-ydado;
    	if(zx < 0) {
    		zx = zx*(-1);
    	}
    	if(zy < 0) {
    		zy = zy*(-1);
    	}

        ///Caso ele tenha clicado na mesma casa
        if(zx==0 && zy==0){
            return 0;
        }
        ///Caso tenha clicado em uma casa além do tam maximo que rei pode andar
        ///TODO NOTA, TBM TEM QUE FUNCIONAR COM O VALOR DE -1
        if(zx >1 || zy>1){
            return 0;
        }
        ///Caso clique numa casa ocupada POR UMA PECA SUA
        if(tabuleiro.mapa[xdado][ydado].getOcupado() == 1 && tabuleiro.mapa[xdado][ydado].getPeca().cor==this.cor){
            return 0;
        }


        ///TODO NOTA, talvez colocar tipo return 1 caso a casa esteja vazia a casa e 2 Caso tenha um oponente nela
        return 1;
    }



}
