package teorie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Robot {
    private static final int EXECUTION_TIME = 3000;
    private ArrayList<Piesa> pieseDeAsamblat = new ArrayList<>();
    private ArrayList<Piesa> solutieIntermed1 = new ArrayList<Piesa>();
    private ArrayList<Piesa> solutieIntermediara3 = new ArrayList<>();
    private ArrayList<RezultatCostCalcul> rezultate = new ArrayList<>();
    private Masinarie masina;
    private ArrayList<Integer> listaCosturiTotale = new ArrayList<>();
    private ArrayList<Piesa> solIntermed2;
    private int solutie3CostTotal = 85;
    private int indexRezultate = 0;


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

    public void creareSolutie() {
        for (int i = 1; i < 11; i++) {
            Piesa p = new Piesa();
            p.setIdPiesa(new Integer(i));
            solutieIntermed1.add(p);
        }
        //Collections.shuffle(solutieIntermed1);
    }

    public void hillClimbCuPornireAleatoare() {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + EXECUTION_TIME;
        int costTotal = 0;
        int count = 0;
        int count2 = 0;
        ArrayList<Piesa> solIntermed2 = new ArrayList<>();
        while (System.currentTimeMillis() <= endTime) {
            masina.constructModel();
            masina.setCostTotal(0);
            count++;
            solIntermed2 = new ArrayList<>();
            solIntermed2.addAll(solutieIntermed1);
            for (Piesa p : solIntermed2) {
                masina.calcCostTotal(p);
            }
            costTotal = masina.getCostTotal();

            if (costTotal <= solutie3CostTotal) {
                solutie3CostTotal = costTotal;
                solutieIntermediara3 = new ArrayList<>();
                solutieIntermediara3.addAll(solIntermed2);
                System.out.println("Cost: " + costTotal + "\nSolutie: " + solutieIntermediara3);
                count2++;
            }
            Random rand = new Random();
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            //int y = x+1;
            //if(y == 10){
              //  y = 0;
            //}
            Collections.swap(solutieIntermed1, x, y);
        }
        if (costTotal != 0) {
            System.out.println("Cost total: " + solutie3CostTotal);
            System.out.println("Best solution: " + solutieIntermediara3);
        }
        long stoptime = System.currentTimeMillis();
        afisareRezumatSolutie(startTime, stoptime, count, count2);
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

    private void calculeazaCost() {

        masina.constructModel();
        masina.setCostTotal(0);
        ArrayList<Piesa> solIntermed2 = new ArrayList<>();
        for (Piesa piesa : solutieIntermed1) {
            solIntermed2.add(piesa);
        }
        for (Piesa p : solIntermed2) {
            masina.calcCostTotal(p);
        }
        int costTotal = masina.getCostTotal();
        //if(indexRezultate <=10) {
        indexRezultate++;
        //System.out.println("Cost total: " + costTotal);
        //System.out.println("SOLUTIE: " + solIntermed2);

        listaCosturiTotale.add(costTotal);


        System.out.println("Cost total: " + costTotal);
        System.out.println("Solutie intermediara: " + solIntermed2);


            /*RezultatCostCalcul rezultatCostCalcul = new RezultatCostCalcul();
            rezultatCostCalcul.setCostTotal(costTotal);
            rezultatCostCalcul.setSolutiiIntermediare(solIntermed2);
            rezultate.add(rezultatCostCalcul);*/
        //}
    }

    private void showRezultatItem(RezultatCostCalcul rezultatCostCalculs) {
        System.out.println();
        System.out.println("Cost Total: " + rezultatCostCalculs.getCostTotal());
        showSolutiiIntermediare(rezultatCostCalculs.getSolutiiIntermediare());

    }

    private void showSolutiiIntermediare(ArrayList<Piesa> p) {
        System.out.println("Solutii intermediare: ");
        for (Piesa piesa : p) {
            System.out.println(piesa);
        }
    }

    private void afisareRezumatSolutie(long startTime, long stoptime, int count, int count2) {
        System.out.println("Timp total: " + (stoptime - startTime));
        System.out.println("Numar total de solutii: " + count + "\n Numar solutii valide: " + count2);
    }

    private void afisareZeceRezultate() {
        int items = rezultate.size() <= 10 ? rezultate.size() : 10;
        //System.out.println();
        for (int i = 0; i < items; i++) {
            showRezultatItem(rezultate.get(i));
        }
    }

}
