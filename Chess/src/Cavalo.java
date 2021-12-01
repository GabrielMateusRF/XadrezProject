public class Cavalo extends Peca{
    public int movValido(Posicao[][] mapa,int xdado, int ydado, int xin, int yin){
    	int zx, zy;
    	zx = xin-xdado;
    	zy = yin-ydado;
    	if(zx < 0) {
    		zx = zx*(-1);
    	}
    	if(zy < 0) {
    		zy = zy*(-1);
    	}

        ///Caso ele tenha clicado na mesma casa.
        if(zx==0 && zy==0){
            return 0;
        }
        //Lugar ocupado.
        if(mapa[xdado][ydado].getOcupado() == 1){
        	//Ocupado pela mesma cor.
        	if(mapa[xdado][ydado].getPeca().getCor()==cor) {
        		return 0;
        	}
        	//Ocupado por outra cor(comeu a peca).
        	else {
				if(zx==1 && zy==2){
					return 2;
				}else if(zx==2 && zy==1) {
					return 2;
				}
				return 0;
        	}
        }
        
        //Caso ele clique na casa certa vazia.
        if(zx==1 && zy==2){
            return 1;
        }else if(zx==2 && zy==1) {
        	return 1;
        }
        
        //Caso ele clique em casa errada.
        return 0;
    }
}
