/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelformulawriter;

import java.util.ArrayList;

/**
 *
 * @author wouth
 */
public class FormulaWriter {

    public void makeFormula(int algos, Integer[] tables, boolean forCalc) {
        Node firstnode = new Node(1, 2, tables);
        if (forCalc) {
            firstnode.isForCalc();
        }
        firstnode.makeChilds(algos);
        String res = "=" + firstnode.formulaPart();
        System.out.println(res);
    }
}
