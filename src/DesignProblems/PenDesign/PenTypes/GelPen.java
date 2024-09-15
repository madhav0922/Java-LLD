package DesignProblems.PenDesign.PenTypes;

import DesignProblems.PenDesign.Model.Pen;
import DesignProblems.PenDesign.Model.Refill;
import DesignProblems.PenDesign.Model.Refillable;

public class GelPen extends Pen implements Refillable {
    Refill refill;
    @Override
    public void refill() {
        System.out.println("Gel Pen refilled");
    }
}
