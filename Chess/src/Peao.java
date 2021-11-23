public class Peao extends Peca{
    public int movValido(Posicao[][] mapa, int xdado, int ydado){
    	int zx, zy;
    	zx = x-xdado;
    	zy = y-ydado;
    	if(zx < 0) {
    		zx = zx*(-1);
    	}
    	
    	
    	//Caso ele tente andar para trás.
    	if(zy < 0 && cor==0) {
			System.out.printf("\n K1 \n");
    		return 0;
    	}
    	else if(zy > 0 && cor==1) {
			System.out.printf("\n K2 \n");
    		return 0;
    	}
    	
    	//Deixa zy positivo.
    	if(zy < 0) {
			System.out.printf("\n K3 \n");
    		zy = zy*(-1);
    	}

        ///Caso ele tenha clicado na mesma casa.
        if(zx==0 && zy==0){
			System.out.printf("\n K4 \n");
            return 0;
        }
        //Lugar ocupado
        if(mapa[xdado][ydado].getOcupado() == 1){
        	//Ocupado pela mesma cor.
        	if(mapa[xdado][ydado].getPeca().getCor()==cor) {
				System.out.printf("\n K5 \n");
        		return 0;
        	}
        	//Ocupado por outra cor(comeu a peca).
        	else {
        		if(zx==1 && zy==1) {
					System.out.printf("\n K6 \n");
        			return 2;
        		}
        		else {
					System.out.printf("\n K7 \n");
        			return 0;
        		}
        	}
        }

        //Caso ele clique em casa na diagonal vazia.
		///TODO erro aqui
        if(zx>=1) {
			System.out.printf("\n K8 \n");
        	return 0;
        }
        //Caso ele tente andar mais de uma casa para frente.
        if(zy>1) {
			System.out.printf("\n K9 \n");
        	return 0;
        }
        //Caso ele clique em casa certa(para frente) vazia.
		System.out.printf("\n K10 \n");
		return 1;
    }
}
