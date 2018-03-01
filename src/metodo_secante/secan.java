/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo_secante;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class secan {

    double Xi1, Xi;
    double fxi_1, fXi, fXi_1_fxi, fXi_fXi_1_xi, Raiz, Error;
    double e = 2.718281828;
    int n;

    public double getXi() {
        return Xi;
    }

    public void setXi(double Xi) {
        this.Xi = Xi;
    }

    public double getXi1() {
        return Xi1;
    }

    public void setXi1(double Xi1) {
        this.Xi1 = Xi1;
    }

    public int[][] Operacion(JTable x, int n) {
        int arreglo[][] = new int[n][n];
        String cabecera[] = {"i", "Xi-i", "Xi", "f(xi-1)", "f(Xi)", "f(Xi-1)-f(xi)", "f(Xi)*f(Xi-1-xi)", "Raix", "Error"};

        DefaultTableModel T = new DefaultTableModel(null, cabecera);
        for (int i = 0; i < n + 1; i++) {
            String Fila[] = {"" + i, "" + Xi1, "" + Xi, "" + fxi_1, "" + fXi, "" + fXi_1_fxi, "" + fXi_fXi_1_xi, "" + Raiz, "" + Error};
            if (i == 0) {

                fxi_1 = Math.pow(e, -getXi1()) - getXi1();
                fXi = Math.pow(e, -getXi()) - getXi();
                fXi_1_fxi = fxi_1 - fXi;
                fXi_fXi_1_xi = (fXi * (fxi_1 - getXi()));
                Raiz = ((fXi_fXi_1_xi / fXi_1_fxi) + getXi());
                Error = -1;
            } else {
                if (i == 1 || i != 1) {
                    Xi1 = Xi;
                    Xi = fxi_1;
                    fxi_1 = Math.pow(e, -Xi1) - Xi1;
                    fXi = Math.pow(e, -Xi) - Xi;
                    fXi_1_fxi = fxi_1 - fXi;
                    fXi_fXi_1_xi = (fXi * (fxi_1 - Xi));
                    Raiz = ((fXi_fXi_1_xi / fXi_1_fxi) + Xi);
                    Error = 0;
                }
                T.addRow(Fila);
            }
            x.setModel(T);
        }

        return arreglo;
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
