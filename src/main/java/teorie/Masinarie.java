package teorie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Masinarie {

    private ArrayList<Piesa> model = new ArrayList<>();
    private ArrayList<Piesa> modelCopy = new ArrayList<>();

    public ArrayList<Piesa> getModelCopy() {
        return modelCopy;
    }

    public void setModelCopy(ArrayList<Piesa> modelCopy) {
        this.modelCopy = modelCopy;
    }

    public ArrayList<Piesa> getModel() {
        return model;
    }

    public void setModel(ArrayList<Piesa> model) {
        this.model = model;
    }



    public void citeste() {
        File file =
                new File("C:\\Users\\pankaj\\Desktop\\test.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);


        while (sc.hasNextLine()) {
            String linie = sc.nextLine();
            String[] split = linie.split(":");
            int idPiesa = Integer.getInteger(split[0]);
            String[] split1 = split[1].split(",");
            List<String> precedente = Arrays.asList(split1);

            construiestePiesaDinFisier(idPiesa, precedente);

        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void construiestePiesaDinFisier(int idPiesa, List<String> precedente) {
        Piesa piesa = new Piesa();
        piesa.setIdPiesa(idPiesa);
        for (String str : precedente) {
            piesa.adaugaPiesePrecedente(Integer.getInteger(str));
        }
        model.add(piesa);
    }

    private void construiestePiesa(int idPiesa, List<Integer> precedente) {
        Piesa piesa = new Piesa();
        piesa.setIdPiesa(idPiesa);
        for (Integer str : precedente) {
            piesa.adaugaPiesePrecedente(str);
        }
        model.add(piesa);
    }


    public void constructModel() {
        construiestePiesa(1, Arrays.asList(3));
        construiestePiesa(2, Arrays.asList(4));
        construiestePiesa(3, new ArrayList<Integer>());
        construiestePiesa(4, Arrays.asList(1,6,8));
        construiestePiesa(5, Arrays.asList(4,6));
        construiestePiesa(6, Arrays.asList(3));
        construiestePiesa(7, Arrays.asList(2,4,5));
        construiestePiesa(8, Arrays.asList(3));
        construiestePiesa(9, Arrays.asList(2,5));
        construiestePiesa(10, Arrays.asList(5,7,9));
        defaultCost();

    }



    public Piesa getCost(Piesa z) {
        for (Piesa x : model) {
            if (x.getIdPiesa() == z.getIdPiesa()) {
                z.setCostPiesa(x.getCostPiesa());
            } else if (x.getPiesePrecedente().contains(z.getIdPiesa())) {
                int i = x.getPiesePrecedente().indexOf(z.getIdPiesa());
                ArrayList<Integer> piesePrecedente = x.getPiesePrecedente();
                piesePrecedente.remove(i);
                x.setPiesePrecedente(piesePrecedente);
                x.setCostPiesa(x.getCostPiesa() - 5);
                //x.setCostPiesa(x.getPiesePrecedente().size() * 5);
                //z.setCostPiesa(x.getCostPiesa());
            }
            System.out.println();
        }

        return z;
    }

    private void defaultCost() {
        for (Piesa p : model) {
            p.setCostPiesa(p.getPiesePrecedente().size() * 5);
        }
    }

    public void show(ArrayList<Piesa> a) {
        for (Piesa p : a) {
            System.out.println("ID: " + p.getIdPiesa() +
                    "; Comp prec: " + p.getPiesePrecedente() +
                    "; Cost: " + p.getCostPiesa());
        }
    }

    private void cloneModel(){
        for (Piesa piesa : model) {
            modelCopy.add(piesa);
        }
    }
}
