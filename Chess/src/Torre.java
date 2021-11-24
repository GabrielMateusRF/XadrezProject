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
        	System.out.print("\n K1 \n");
            return 0;
        }
        
        if(xdado>=xin && ydado>=yin) {
	        if(zx==0 && zy!=0){
	        	for(i=0;i<zy;i++) {
	        		//Caminho ocupado.
					yin++;
	                if(mapa[xdado][yin].getOcupado() == 1){
	                	System.out.print("\n K2 \n");
	                	return 0;
	                }
	        	}
	        }else if(zx!=0 && zy==0) {
	
	        	for(i=0;i<zx;i++) {
					xin++;
	        		//Caminho ocupado.
	                if(mapa[xin][ydado].getOcupado() == 1){
	                	System.out.print("\n K3 \n");
	                	return 0;
	                }
	        	}
	        }
        }else if(xdado<=xin && ydado<=yin) {
        	if(zx==0 && zy!=0){
	        	for(i=0;i<zy;i++) {
	        		//Caminho ocupado.
					yin--;
	                if(mapa[xdado][yin].getOcupado() == 1){
	                	System.out.print("\n K4 \n");
	                	return 0;
	                }
	        	}
	        }else if(zx!=0 && zy==0) {
	
	        	for(i=0;i<zx;i++) {
					xin--;
	        		//Caminho ocupado.
	                if(mapa[xin][ydado].getOcupado() == 1){
	                	System.out.print("\n K5 \n");
	                	return 0;
	                }
	        	}
	        }
        }
        
        if(mapa[xdado][ydado].getOcupado() == 1){
        	//Ocupado pela mesma cor.
        	if(mapa[xdado][ydado].getPeca().getCor()==this.cor) {
        		System.out.print("\n K6 \n");
        		return 0;
        	}
        	//Ocupado por outra cor(comeu a peca).
        	else {
        		System.out.print("\n K7 \n");
        		return 2;
        	}
        }
        //Caso ele clique em casa certa vazia.
        System.out.print("\n K8 \n");
        return 1;
    }
}
