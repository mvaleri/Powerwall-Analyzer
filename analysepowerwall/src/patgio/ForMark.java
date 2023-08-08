/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patgio;

/**
 *
 * @author PATGI
 */
public class ForMark {

    double d;
    Double D = Double.valueOf(0);

    public void MarkFunction(Double din) {
        d = 1;
        D = din;
        din = 0.0;
    }

    public void dump(Double DIN) {
        System.out.format("D = %f, d = %f DIN = %f\n", D, d, DIN);
        System.out.println("Note the Double did not change value when passed as a parameter.");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ForMark mark = new ForMark();
        Double DIN = 1.23;
        mark.MarkFunction(DIN);
        mark.dump(DIN);
    }

}
