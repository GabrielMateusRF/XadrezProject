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
        if(zx >1 || zy>1){
            return 0;
        }
        //Lugar ocupado
        if(tabuleiro.mapa[xdado][ydado].getOcupado() == 1){
        	//Ocupado pela mesma cor
        	if(tabuleiro.mapa[xdado][ydado].getPeca().getCor()==cor) {
        		return 0;
        	}
        	//Ocupado por outra cor(comeu a peca).
        	else {
        		return 2;
        	}
        }


        //Caso ele clique em casa certa vazia.
        return 1;
    }
}
