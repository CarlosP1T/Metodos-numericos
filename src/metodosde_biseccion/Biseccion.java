package metodosde_biseccion;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Biseccion {

    double Xi,Xs,Xr, fxr, fxi, fxr_fxi, Error;

    public double getXr() {
        return Xr;
    }

    public void setXr(double Xr) {
        this.Xr = Xr;
    }

    public double getFxr() {
        return fxr;
    }

    public void setFxr(double fxr) {
        this.fxr = fxr;
    }

    public double getFxi() {
        return fxi;
    }

    public void setFxi(double fxi) {
        this.fxi = fxi;
    }

    public double getFxr_fxi() {
        return fxr_fxi;
    }

    public void setFxr_fxi(double fxr_fxi) {
        this.fxr_fxi = fxr_fxi;
    }

    public double getError() {
        return Error;
    }

    public void setError(double Error) {
        this.Error = Error;
    }

    public double getXi() {
        return Xi;
    }

    public void setXi(double Xi) {
        this.Xi = Xi;
    }

    public double getXs() {
        return Xs;
    }

    public void setXs(double Xs) {
        this.Xs = Xs;
    }

    public void XrCalculo(double Xi, double Xs, int ite) {
        double arreglo[][] = new double[ite][8];
        int i, j;
        for (i = 0; i < ite; i++) {

            if (i == 0) {
                Xr = (Xi + Xs) / 2;
                fxr = ((Math.pow(Xr, 3)) + (4 * Math.pow(Xr, 2))) - 10;
                fxi = ((Math.pow(Xi, 3)) + (4 * Math.pow(Xi, 2))) - 10;
                fxr_fxi = fxr * fxi;
                System.out.println("xr = " + Xr + "\t" + "fxr= " + fxr + "\t" + "fxi= " + fxi + "\t" + "fxr=" + fxr_fxi);

                if (fxr_fxi < 0) {
                    Xr = (Xi + Xr) / 2;
                    fxr = ((Math.pow(Xr, 3)) + (4 * Math.pow(Xr, 2))) - 10;
                    fxi = ((Math.pow(Xi, 3)) + (4 * Math.pow(Xi, 2))) - 10;
                    fxr_fxi = fxr * fxi;
                    System.out.println("xr = " + Xr + "\t" + "fxr= " + fxr + "\t" + "fxi= " + fxi + "\t" + "fxr_fxi=" + fxr_fxi);

                } else {
                    Xr = (Xi+ Xr) / 2;
                    fxr = ((Math.pow(Xr, 3)) + (4 * Math.pow(Xr, 2))) - 10;
                    fxi = ((Math.pow(Xi, 3)) + (4 * Math.pow(Xi, 2))) - 10;
                    fxr_fxi = fxr * fxi;
                    System.out.println("xr = " + Xr + "\t" + "fxr= " + fxr + "\t" + "fxi= " + fxi + "\t" + "fxr_fxi=" + fxr_fxi);

                }
            }

        }
//        for (j = 0; j < arreglo.length; j++) {
//            for (int k = 0; k < arreglo.length; k++) {
//                System.out.print(arreglo[j][k]);
//            }
//            System.out.println("");
//        }

    }
}
