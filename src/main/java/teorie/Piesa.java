package teorie;

import java.util.ArrayList;

public class Piesa {
    private int idPiesa;
    private int costPiesa;
    private ArrayList<Integer> piesePrecedente = new ArrayList<Integer>();

    public ArrayList<Integer> getPiesePrecedente() {
        return piesePrecedente;
    }

    public int getIdPiesa() {
        return idPiesa;
    }

    public void setIdPiesa(int idPiesa) {
        this.idPiesa = idPiesa;
    }

    public int getCostPiesa() {
        return costPiesa;
    }

    public void setCostPiesa(int costPiesa) {
        this.costPiesa = costPiesa;
    }

    @Override
    public String toString() {
        return "Piesa{" +
                "idPiesa=" + idPiesa +
                ", costPiesa=" + costPiesa +
                ", piesePrecedente=" + piesePrecedente +
                '}';
    }
}
