public class Peao extends Peca{
    public int movValido(Posicao[][] mapa, int xdado, int ydado, int xin, int yin){

		int zx, zy;
    	zx = xin-xdado;
    	zy = yin-ydado;

    	if(zx < 0) {
    		zx = zx*(-1);
    	}

    	//Caso ele tente andar para tr?s.
    	if(zy > 0 && cor==1) {
    		return 0;
    	}
    	else if(zy < 0 && cor==0) {

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
        if(mapa[xdado][ydado].getOcupado() == 1){
        	//Ocupado pela mesma cor.
        	if(mapa[xdado][ydado].getPeca().getCor()==cor) {

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
        
        //Caso seja a primeira jogada do peao (pode andar 2 casas).
		if(yin==1 && zy<=2 && cor==1) {
			if(mapa[xin][yin+1].getOcupado() == 1) {
				return 0;
			}
			return 1;
		}else if(yin==6 && zy<=2 && cor==0) {
			if(mapa[xin][yin-1].getOcupado() == 1) {
				return 0;
			}
			return 1;
		}
        
        //Caso ele tente andar mais de uma casa para frente.
        if(zy>1) {
        	return 0;
        }
        //Caso ele clique em casa certa(para frente) vazia.
        

		return 1;
    }
}
