/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo_secante;

import com.sun.glass.ui.Cursor;

/**
 *
 * @author Carlos
 */
public class MetodoDeLaSecante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//       frmPrincipal ventana=new frmPrincipal();
//       ventana.setLocationRelativeTo(null);
//       ventana.show();
        Secante s = new Secante();
        s.setLocationRelativeTo(null);
        s.setVisible(true);
    }

}
