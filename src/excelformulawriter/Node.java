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
public class Node {

    private int a;
    private int b;
    private Node child1;
    private Node child2;
    private Integer[] tables;
    private boolean forCalc = false;

    public Node(int a, int b, Integer[] tables) {
        this.a = a;
        this.b = b;
        this.tables = tables;
    }

    public void makeChilds(int depth) {
        if (depth > 2) {
            child1 = new Node(a, b + 1, tables);
            if (forCalc) {
                child1.isForCalc();
            }
            child1.makeChilds(depth - 1);
            child2 = new Node(b, b + 1, tables);
            if (forCalc) {
                child2.isForCalc();
            }
            child2.makeChilds(depth - 1);
        }
    }

    public String formulaPart() {
        if (!forCalc) {
            if (child1 != null) {
                return "IF(IF(MAX(G" + (b + 2) + ", 0)<>0, MAX(G" + (a + 2) + ", 0)/MAX(G" + (b + 2) + ", 0), 1000000) > IF(SUM(Table" + tables[(b - 1)] + "[USD spend])<>0, SUM(Table" + tables[(a - 1)] + "[USD spend])/SUM(Table" + tables[(b - 1)] + "[USD spend]), 1000000), " + child1.formulaPart() + ", " + child2.formulaPart() + ")";
            } else { //IF(MAX(F4, 0)<>0, MAX(F3, 0)/MAX(F4, 0), 1000000)
                return "IF(IF(MAX(G" + (b + 2) + ", 0)<>0, MAX(G" + (a + 2) + ", 0)/MAX(G" + (b + 2) + ", 0), 1000000) > IF(SUM(Table" + tables[(b - 1)] + "[USD spend])<>0, SUM(Table" + tables[(a - 1)] + "[USD spend])/SUM(Table" + tables[(b - 1)] + "[USD spend]), 1000000), A" + (a + 2) + ", A" + (b + 2) + ")";
            }
        } else {
            if (child1 != null) {
                return "IF(IF(MAX(G" + (b + 2) + ", 0)<>0, MAX(G" + (a + 2) + ", 0)/MAX(G" + (b + 2) + ", 0), 1000000) > IF((SUM(Table" + tables[(b - 1)] + "[USD spend]) + L" + (b + 24) + "*E" + (b + 2) + ")<>0, (SUM(Table" + tables[(a - 1)] + "[USD spend]) + L" + (a + 24) + "*E" + (a + 2) + ")/(SUM(Table" + tables[(b - 1)] + "[USD spend]) + L" + (b + 24) + "*E" + (b + 2) + "), 1000000), " + child1.formulaPart() + ", " + child2.formulaPart() + ")";
            } else { //IF(MAX(F4, 0)<>0, MAX(F3, 0)/MAX(F4, 0), 1000000)
                return "IF(IF(MAX(G" + (b + 2) + ", 0)<>0, MAX(G" + (a + 2) + ", 0)/MAX(G" + (b + 2) + ", 0), 1000000) > IF((SUM(Table" + tables[(b - 1)] + "[USD spend]) + L" + (b + 24) + "*E" + (b + 2) + ")<>0, (SUM(Table" + tables[(a - 1)] + "[USD spend]) + L" + (a + 24) + "*E" + (a + 2) + ")/(SUM(Table" + tables[(b - 1)] + "[USD spend]) + L" + (b + 24) + "*E" + (b + 2) + "), 1000000), A" + (a + 2) + ", A" + (b + 2) + ")";
            }
        }
    }

    public void isForCalc() {
        forCalc = true;
    }

    public Node getChild1() {
        return child1;
    }

    public void setChild1(Node child1) {
        this.child1 = child1;
    }

    public Node getChild2() {
        return child2;
    }

    public void setChild2(Node child2) {
        this.child2 = child2;
    }

}
