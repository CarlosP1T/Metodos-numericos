package puntofijo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class PuntoFijo extends JFrame {

    JLabel txtTitu = new JLabel("Metodo de punto fijo-- Segundo Metodo");
    JLabel txtNum = new JLabel("Numeros de XI");
    JTextField ParaNum = new JTextField(6);
    JLabel txtInter = new JLabel("Numero de interacciones");
    JTextField ParaInter = new JTextField(6);
    JButton lblCalcular = new JButton("Calcular");
    JScrollPane rr;
    JTable tabla = new JTable();
    String[] cabeza = {"Interacciones", "Xi-1", "X=g(x)", "Error"};
    metodos cal = new metodos();

    public PuntoFijo() {
        super("Metodo de punto fijo");
        lblCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                if (!ParaNum.getText().equals("") & !ParaInter.getText().equals("")) {
                    double nD = Double.parseDouble(ParaNum.getText());
                    int nI = Integer.parseInt(ParaInter.getText());
                    if (nD < 0 || nI < 0) {
                        JOptionPane.showMessageDialog(null, "Ingrese un numero positivo");
                    } else {

                        double numeros = Double.parseDouble(ParaNum.getText());
                        int interacciones = Integer.parseInt(ParaInter.getText());
                        tabla.setModel(new Abstraco(cal.getCalculos(numeros, interacciones)));
                        rr.setViewportView(tabla);
                    }
                }
            }
        }
        );
        rr = new JScrollPane(tabla);
        rr.setPreferredSize(new Dimension(500, 250));

        JPanel t = new JPanel();
        t.setLayout(new FlowLayout());
        t.add(txtTitu);

        JPanel tb = new JPanel();
        tb.setLayout(new FlowLayout());
        tb.add(rr);

        JPanel boton = new JPanel();
        boton.setLayout(new BorderLayout());
        boton.add(lblCalcular, BorderLayout.NORTH);
        boton.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
        JPanel borde = new JPanel();
        GridLayout g = new GridLayout(4, 2);
        g.setVgap(-4);
        borde.setLayout(g);

        borde.add(txtNum);
        borde.add(ParaNum);
        borde.add(txtInter);
        borde.add(ParaInter);
        borde.setBorder(BorderFactory.createEmptyBorder(20, 20, 50, 20));

        JPanel gene = new JPanel();
        BorderLayout bord = new BorderLayout();
        gene.setLayout(bord);
        gene.add(t, BorderLayout.NORTH);
        gene.add(borde, BorderLayout.CENTER);
        gene.add(boton, BorderLayout.EAST);
        gene.add(rr, BorderLayout.SOUTH);
        gene.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        Container cont = getContentPane();
        cont.add(gene);
        setLayout(new FlowLayout());
        setSize(600, 600);
    }

    public class Abstraco extends AbstractTableModel {

        String[] cabeza = {"Interacciones", "Xi-1", "X=g(x)", "Error"};
        private ArrayList<getters> datosTabla = new ArrayList<>();

        public Abstraco(ArrayList dato) {
            datosTabla = dato;
        }

        public int getRowCount() {
            return datosTabla.size();
        }

        public int getColumnCount() {
            return cabeza.length;
        }

        public Object getValueAt(int filas, int columnas) {
            switch (columnas) {
                case 0:
                    return datosTabla.get(filas).getInterraciones();
                case 1:
                    return datosTabla.get(filas).getX();
                case 2:
                    return datosTabla.get(filas).getX_g();
                case 3:
                    return datosTabla.get(filas).getError();
            }
            return null;
        }

        public String getColumnName(int colm) {
            return cabeza[colm];
        }
    }

    public static void main(String[] args) {
        PuntoFijo a = new PuntoFijo();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        a.show();
    }

}
