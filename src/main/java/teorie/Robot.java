package teorie;

import java.security.SecureRandom;
import java.util.*;

public class Robot {
    private static final int EXECUTION_TIME = 3000;
    private ArrayList<Piesa> pieseDeAsamblat = new ArrayList<>();
    private ArrayList<Piesa> solutieIntermed1 = new ArrayList<Piesa>();
    private ArrayList<Piesa> solIntermed2 = new ArrayList<>();
    private ArrayList<Piesa> solutieBest = new ArrayList<>();
    private ArrayList<RezultatCostCalcul> rezultate = new ArrayList<>();
    private Masinarie masina;
    private int costTotal = 0;

    public ArrayList<RezultatCostCalcul> getRezultate() {
        return rezultate;
    }

    public void setRezultate(ArrayList<RezultatCostCalcul> rezultate) {
        this.rezultate = rezultate;
    }

    public ArrayList<Piesa> getSolutieIntermed1() {
        return solutieIntermed1;
    }

    public void setSolutieIntermed1(ArrayList<Piesa> solutieIntermed1) {
        this.solutieIntermed1 = solutieIntermed1;
    }

    public void calculeazaCost() {
        costTotal = 0;
        masina.constructModel();
        for (Piesa p : solutieIntermed1) {
            //getCost(p);
            p = masina.getCost(p);

            costTotal += p.getCostPiesa();
        }

        rezultate.add(new RezultatCostCalcul()
                .costTotal(costTotal)
                .solutiiIntermediare(solutieIntermed1));
    }

    public void show(ArrayList<Piesa> a) {
        for (Piesa p : a) {
            System.out.println("ID: " + p.getIdPiesa() +
                    "; Comp prec: " + p.getPiesePrecedente() +
                    "; Cost: " + p.getCostPiesa());
        }
        System.out.println("Cost total: " + costTotal);
    }

    public void showRezultate(ArrayList<RezultatCostCalcul> rezultatCostCalculs) {
        for (RezultatCostCalcul r : rezultatCostCalculs) {
            System.out.println("Cost Total: " + r.getCostTotal() +
                    "\n Solutii intermediare: " + r.getSolutiiIntermediare());
        }
        //System.out.println("Cost total: " + costTotal);
    }

    public void showRezultatItem(RezultatCostCalcul rezultatCostCalculs) {

            System.out.println("Cost Total: " + rezultatCostCalculs.getCostTotal() );
            showSolutiiIntermediare(rezultatCostCalculs.getSolutiiIntermediare());

        //System.out.println("Cost total: " + costTotal);
    }
    public void showSolutiiIntermediare(ArrayList<Piesa> p) {
        System.out.println("\n Solutii intermediare: ");
        for (Piesa piesa : p) {
            System.out.println(piesa);
        }
    }
    public void hillClimbCuPornireAleatoare() {


        long startTime = System.currentTimeMillis();
        long endTime = startTime + EXECUTION_TIME;

        while (System.currentTimeMillis() <= endTime) {

            calculeazaCost();
            if(rezultate.get(rezultate.size()-1).getCostTotal() == 0) {
                showRezultatItem(rezultate.get(rezultate.size()-1));
                break;
            }
            Random rand = new Random();
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);

            Collections.swap(solutieIntermed1, x, y);


        }

        if(rezultate.get(rezultate.size()-1).getCostTotal() != 0) {
            RezultatCostCalcul min = Collections.min(rezultate, new RezultatCostCalcul());
            showRezultatItem(min);
        }

        long stoptime = System.currentTimeMillis();

        System.out.println("Timp total: " + (stoptime - startTime));
        System.out.println("Numar total de slutii: " + rezultate.size());
        int items = rezultate.size() <= 100 ? rezultate.size() : 100;
        for(int i=0;i<items;i++)
        {
            System.out.print(rezultate.get(i));
        }
    }

    public void creareSolutie() {
        for (int i = 1; i < 11; i++) {
            Piesa p = new Piesa();
            p.setIdPiesa(new Integer(i));
            solutieIntermed1.add(p);

        }
        Collections.shuffle(solutieIntermed1);
    }

    /*public int calculeazaCost2() {

        Random r = new Random();

        int x = r.nextInt(10);
        int y = r.nextInt(10);

        solIntermed2 = solutieIntermed1;
        costTotal = 0;
        Collections.swap(solIntermed2, x, y);
        for (Piesa p : solIntermed2) {
            p = masina.getCost(p);

            costTotal += p.getCostPiesa();
        }
        //masina.defaultCost();
        return costTotal;
    }*/


    public ArrayList<Piesa> getSolutieBest() {
        return solutieBest;
    }

    public void setSolutieBest(ArrayList<Piesa> solutieBest) {
        this.solutieBest = solutieBest;
    }

    public int getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(int costTotal) {
        this.costTotal = costTotal;
    }

    public ArrayList<Piesa> getSolIntermed2() {
        return solIntermed2;
    }

    public void setSolIntermed2(ArrayList<Piesa> solIntermed2) {
        this.solIntermed2 = solIntermed2;
    }

    public Masinarie getMasina() {
        return masina;
    }

    public void setMasina(Masinarie masina) {
        this.masina = masina;
    }

    public ArrayList<Piesa> getPieseDeAsamblat() {
        return pieseDeAsamblat;
    }

    public void setPieseDeAsamblat(ArrayList<Piesa> pieseDeAsamblat) {
        this.pieseDeAsamblat = pieseDeAsamblat;
    }


    public void Show2() {
        for (Piesa z : solutieIntermed1
        ) {
            System.out.println("ID: " + z.getIdPiesa() +
                    "; Comp prec: " + z.getPiesePrecedente() +
                    "; Cost: " + z.getCostPiesa());
        }
    }


    public void Calc() {


    }
}
