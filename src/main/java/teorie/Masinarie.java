package teorie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Masinarie {
    private ArrayList<Piesa> model = new ArrayList<>();
    private int costTotal;

    public int getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(int costTotal) {
        this.costTotal = costTotal;
    }

    public ArrayList<Piesa> getModel() {
        return model;
    }

    public void setModel(ArrayList<Piesa> model) {
        this.model = model;
    }

    public void constructModel() {
        construiestePiesa(1, Arrays.asList(3));
        construiestePiesa(2, Arrays.asList(4));
        construiestePiesa(3, new ArrayList<Integer>());
        construiestePiesa(4, Arrays.asList(1, 6, 8));
        construiestePiesa(5, Arrays.asList(4, 6));
        construiestePiesa(6, Arrays.asList(3));
        construiestePiesa(7, Arrays.asList(2, 4, 5));
        construiestePiesa(8, Arrays.asList(3));
        construiestePiesa(9, Arrays.asList(2, 5));
        construiestePiesa(10, Arrays.asList(5, 7, 9));
        defaultCost();
    }

    public void calcCostTotal(Piesa z) {
        for (Piesa x : model) {
            if (x.getIdPiesa() == z.getIdPiesa()) {
                z.setCostPiesa(x.getCostPiesa());
                costTotal += x.getCostPiesa();
            } else if (x.getPiesePrecedente().contains(z.getIdPiesa())) {
                int i = x.getPiesePrecedente().indexOf(z.getIdPiesa());
                ArrayList<Integer> piesePrecedente = x.getPiesePrecedente();
                piesePrecedente.remove(i);
                x.setPiesePrecedente(piesePrecedente);
                x.setCostPiesa(x.getCostPiesa() - 5);
            }
        }
    }

    public void afisareModelInitial(ArrayList<Piesa> a) {
        for (Piesa p : a) {
            System.out.println("ID: " + p.getIdPiesa() +
                    "; Comp prec: " + p.getPiesePrecedente() +
                    "; Cost: " + p.getCostPiesa());
        }
    }


    private void construiestePiesa(int idPiesa, List<Integer> precedente) {
        Piesa piesa = new Piesa();
        piesa.setIdPiesa(idPiesa);
        for (Integer str : precedente) {
            piesa.adaugaPiesePrecedente(str);
        }
        model.add(piesa);
    }

    private void defaultCost() {
        for (Piesa p : model) {
            p.setCostPiesa(p.getPiesePrecedente().size() * 5);
        }
    }
}
