/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntofijo;

import java.util.ArrayList;

public class metodos {

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
                dNum = listab.get(numIter - 1).getX_g();
            }
            numIter++;
            getters a = new getters();

            a.setInterraciones(numIter);
            a.setX(dNum);
            a.setX_g(Math.pow(euler(), -dNum));
            double error = (a.getX_g() - a.getX()) / a.getX_g();
            if (error < 0) {
                error = error * -1;
            }
            a.setError(error);
            listab.add(a);

        }
        return listab;
    }
}
