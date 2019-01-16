package teorie;

import java.util.ArrayList;

public class RezultatCostCalcul {
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


}
