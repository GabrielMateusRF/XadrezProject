public class Torre extends Peca{
    public int movValido(Posicao[][] mapa,int xdado, int ydado, int xin, int yin){
    	int zx, zy, i;
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
        
        if(zx==zy){
        	return 0;
        }
        
        if(xdado>=xin && ydado>=yin) {
	        if(zx==0 && zy!=0){
	        	for(i=0;i<zy-1;i++) {
	        		//Caminho ocupado.
					yin++;
	                if(mapa[xdado][yin].getOcupado() == 1){
	                	return 0;
	                }
	        	}
	        }else if(zx!=0 && zy==0) {
	
	        	for(i=0;i<zx-1;i++) {
					xin++;
	        		//Caminho ocupado.
	                if(mapa[xin][ydado].getOcupado() == 1){
	                	return 0;
	                }
	        	}
	        }
        }else if(xdado<=xin && ydado<=yin) {
        	if(zx==0 && zy!=0){
	        	for(i=0;i<zy-1;i++) {
	        		//Caminho ocupado.
					yin--;
	                if(mapa[xdado][yin].getOcupado() == 1){
	                	return 0;
	                }
	        	}
	        }else if(zx!=0 && zy==0) {
	
	        	for(i=0;i<zx-1;i++) {
					xin--;
	        		//Caminho ocupado.
	                if(mapa[xin][ydado].getOcupado() == 1){
	                	return 0;
	                }
	        	}
	        }
        }
        
        if(mapa[xdado][ydado].getOcupado() == 1){
        	//Ocupado pela mesma cor.
        	if(mapa[xdado][ydado].getPeca().getCor()==this.cor) {
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
