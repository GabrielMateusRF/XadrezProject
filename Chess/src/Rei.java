public class Rei extends Peca{

    public int movValido(Posicao[][] mapa,int xdado, int ydado,int xin, int yin){
    	int zx, zy;
    	zx = xin-xdado;
    	zy = yin-ydado;
    	if(zx < 0) {
    		zx = zx*(-1);
    	}
    	if(zy < 0) {
    		zy = zy*(-1);
    	}

		if(xin==4 && yin==0 && xdado==6 && ydado==0 && mapa[5][0].getOcupado()==0 && mapa[6][0].getOcupado()==0){
			System.out.printf("JOJO");
			return 3;
		}else{
			if(xin==4 && yin==7 && xdado==6 && ydado==7 && mapa[5][7].getOcupado()==0 && mapa[6][7].getOcupado()==0){
				System.out.printf("DIO");
				return 3;
			}
			System.out.printf("JOoosuke");
		}
		System.out.printf("Joseph Joestar");


        ///Caso ele tenha clicado na mesma casa
        if(zx==0 && zy==0){
            return 0;
        }
        ///Caso tenha clicado em uma casa além do tam maximo que rei pode andar
        if(zx >1 || zy>1){
            return 0;
        }
        //Lugar ocupado
        if(mapa[xdado][ydado].getOcupado() == 1){
        	//Ocupado pela mesma cor
        	if(mapa[xdado][ydado].getPeca().getCor()==cor) {
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
