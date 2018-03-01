package newton;

import java.util.ArrayList;
public class Metodos {

    public long fact(int x) {
        long prod = 1;
        for (int i = 1; i < x; i++) {
            prod = prod * i;

        }
        return prod;
    }

    public double euler() {
        double e = 0;
        for (int i = 1; i < 50; i++) {
            e = e + 1 / (double) (fact(i));
        }
        return e;
    }

 
    public ArrayList getCalculos(double numeros, int interacciones) {
        double dNum = numeros;
        int numI = interacciones;
        int numIter = 0;
        ArrayList<getters> listab = new ArrayList<>();
     
        while (numIter < numI) {
            if (numIter != 0) {
                dNum = listab.get(numIter - 1).getNuevaRaiz();
            }
            numIter++;
            
            getters a = new getters();
            
            a.setInteracciones(numIter);
            a.setX(dNum);
            a.setNormalx((Math.pow(euler(), -dNum)) - dNum);
            double deri= (Math.pow(euler(), -dNum));
            a.setDerivadaX((-deri)-1);    
            double raiz = (a.getNormalx() / a.getDerivadaX()) - a.getX();
          if(raiz < 0)
                raiz=raiz*-1;
            a.setNuevaRaiz(raiz);
            double error = (a.getNuevaRaiz() - a.getX()) / a.getNuevaRaiz();
            a.setError(error);
            listab.add(a);

        }
        return listab;
    }

}
