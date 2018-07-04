/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelformulawriter;

/**
 *
 * @author wouth
 */
public class ExcelFormulaWriter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FormulaWriter fw = new FormulaWriter();
        Integer[] tnames = {6, 7};
        boolean forCalc = false;
        fw.makeFormula(2, tnames, forCalc);
    }
}
