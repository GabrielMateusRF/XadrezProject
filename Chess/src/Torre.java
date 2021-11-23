public class Torre extends Peca{
    public int movValido(Tabuleiro tabuleiro,int xdado, int ydado){
    	int zx, zy, i;
    	zx = x-xdado;
    	zy = y-ydado;
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
        
        if(zx==0 && zy!=0){
        	for(i=0;i<zy;i++) {
        		//Caminho ocupado.
                if(tabuleiro.mapa[xdado][y].getOcupado() == 1){
                	
                	return 0;
                }
                y++;
        	}
        }else if(zx!=0 && zy==0) {
        	for(i=0;i<zx;i++) {
        		//Caminho ocupado.
                if(tabuleiro.mapa[x][ydado].getOcupado() == 1){
                	
                	return 0;
                }
                x++;
        	}
        }
        
        if(tabuleiro.mapa[xdado][ydado].getOcupado() == 1){
        	//Ocupado pela mesma cor.
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
