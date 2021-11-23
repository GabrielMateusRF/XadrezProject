public class Peao extends Peca{
    public int movValido(Tabuleiro tabuleiro,int xdado, int ydado){
    	int zx, zy;
    	zx = x-xdado;
    	zy = y-ydado;
    	if(zx < 0) {
    		zx = zx*(-1);
    	}
    	
    	
    	//Caso ele tente andar para trás.
    	if(zy < 0 && cor==0) {
    		return 0;
    	}
    	else if(zy > 0 && cor==1) {
    		return 0;
    	}
    	
    	//Deixa zy positivo.
    	if(zy < 0) {
    		zy = zy*(-1);
    	}

        ///Caso ele tenha clicado na mesma casa.
        if(zx==0 && zy==0){
            return 0;
        }
        //Lugar ocupado
        if(tabuleiro.mapa[xdado][ydado].getOcupado() == 1){
        	//Ocupado pela mesma cor.
        	if(tabuleiro.mapa[xdado][ydado].getPeca().getCor()==cor) {
        		return 0;
        	}
        	//Ocupado por outra cor(comeu a peca).
        	else {
        		if(zx==1 && zy==1) {
        			return 2;
        		}
        		else {
        			return 0;
        		}
        	}
        }

        //Caso ele clique em casa na diagonal vazia.
        if(zx>=1) {
        	return 0;
        }
        //Caso ele tente andar mais de uma casa para frente.
        if(zy>1) {
        	return 0;
        }
        //Caso ele clique em casa certa(para frente) vazia.
        return 1;
    }
}
