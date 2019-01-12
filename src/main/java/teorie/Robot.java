package teorie;

import java.util.ArrayList;

public class Robot {
    private ArrayList<Piesa> pieseDeAsamblat = new ArrayList<>();
    private ArrayList<Piesa> solutieIntermed1 = new ArrayList<Piesa>();
    private Masinarie masina;
    private int costTotal = 0;

    public int getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(int costTotal) {
        this.costTotal = costTotal;
    }

    public Masinarie getMasina() {
        return masina;
    }

    public void setMasina(Masinarie masina) {
        this.masina = masina;
    }

    public ArrayList<Piesa> getSolutieIntermed1() {
        return solutieIntermed1;
    }

    public void setSolutieIntermed1(ArrayList<Piesa> solutieIntermed1) {
        this.solutieIntermed1 = solutieIntermed1;
    }

    public ArrayList<Piesa> getPieseDeAsamblat() {
        return pieseDeAsamblat;
    }

    public void setPieseDeAsamblat(ArrayList<Piesa> pieseDeAsamblat) {
        this.pieseDeAsamblat = pieseDeAsamblat;
    }

    /*public void asambleaza(Piesa piesa){
        masina.asamblarePiesa(piesa);
    }*/

    public void creareSolutie() {
        for (int i = 1; i < 11; i++) {
            Piesa p = new Piesa();
            p.setIdPiesa(new Integer(i));
            solutieIntermed1.add(p);
        }
    }

    public void calculeazaCost() {
        for (Piesa p : solutieIntermed1) {
            //getCost(p);
            p = masina.getCost(p);

            costTotal += p.getCostPiesa();
        }

    }

    public void Show2() {
        for (Piesa z : solutieIntermed1
        ) {
            System.out.println("ID: " + z.getIdPiesa() +
                    "; Comp prec: " + z.getPiesePrecedente() +
                    "; Cost: " + z.getCostPiesa());
        }
    }

    public void show(ArrayList<Piesa> a) {
        for (Piesa p : a) {
            System.out.println("ID: " + p.getIdPiesa() +
                    "; Comp prec: " + p.getPiesePrecedente() +
                    "; Cost: " + p.getCostPiesa());
        }
        System.out.println("Cost total: " + costTotal);
    }
}
