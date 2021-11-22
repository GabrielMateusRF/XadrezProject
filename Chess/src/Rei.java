public class Rei extends Peca{

    public int movValido(Tabuleiro tabuleiro,int xdado, int ydado){

        ///Caso ele tenha clicado na mesma casa
        if((x-xdado)==0 && (y-ydado)==0){
            return 0;
        }
        ///Caso tenha clicado em uma casa além do tam maximo que rei pode andar
        ///TODO NOTA, TBM TEM QUE FUNCIONAR COM O VALOR DE -1
        if((x-xdado) >1 || (y-ydado)>1){
            return 0;
        }
        ///Caso clique numa casa ocupada
        if(tabuleiro.mapa[xdado][ydado].getOcupado() == 1){
            return 0;
        }



        return 1;
    }




}
