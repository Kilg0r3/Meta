package teorie;

import java.util.ArrayList;
import java.util.Comparator;

public class RezultatCostCalcul /*implements Comparator<RezultatCostCalcul>*/ {
    private Integer costTotal;
    private ArrayList<Piesa> solutiiIntermediare;


    public Integer getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(Integer costTotal) {
        this.costTotal = costTotal;
    }

    public RezultatCostCalcul costTotal(Integer costTotal) {
        this.costTotal = costTotal;
        return this;
    }

    public ArrayList<Piesa> getSolutiiIntermediare() {
        return solutiiIntermediare;
    }

    public void setSolutiiIntermediare(ArrayList<Piesa> solutiiIntermediare) {
        this.solutiiIntermediare = solutiiIntermediare;
    }

    public RezultatCostCalcul solutiiIntermediare(ArrayList<Piesa> solutiiIntermediare) {
        this.solutiiIntermediare = solutiiIntermediare;
        return this;
    }

    @Override
    public String toString() {
        return "RezultatCostCalcul{" +
                "costTotal=" + costTotal +
                ", solutiiIntermediare=" + solutiiIntermediare +
                '}';
    }

/*
    @Override
    public int compare(RezultatCostCalcul o1, RezultatCostCalcul o2) {
        return o1.getCostTotal().compareTo(o2.getCostTotal());

    }*/
}
