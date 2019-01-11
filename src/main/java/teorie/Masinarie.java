package teorie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Masinarie {
    //model de asamblare a pieselor
    private ArrayList<Piesa> pieseAsamblate = new ArrayList<>();
    private ArrayList<Piesa> model = new ArrayList<>();


    public ArrayList<Piesa> getModel() {
        return model;
    }

    public void setModel(ArrayList<Piesa> model) {
        this.model = model;
    }

    public ArrayList<Piesa> getPieseAsamblate() {
        return pieseAsamblate;
    }

    public void setPieseAsamblate(ArrayList<Piesa> pieseAsamblate) {
        this.pieseAsamblate = pieseAsamblate;
    }

   /* public void asamblarePiesa(Piesa piesa) {

    }*/

    public void citeste() {
        File file =
                new File("C:\\Users\\pankaj\\Desktop\\test.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            String linie = sc.nextLine();
            String[] split = linie.split(":");
            int idPiesa = Integer.getInteger(split[0]);
            String[] split1 = split[1].split(",");
            List<String> precedente = Arrays.asList(split1);

            construiestePiesaDinFisier(idPiesa, precedente);

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

    private Piesa construieste(int idPiesa) {
        Piesa piesa = new Piesa();
        piesa.setIdPiesa(idPiesa);
        return piesa;
    }

    public void coonstruct() {
        //Piesa p;
        //Piesa p1 = new Piesa();
        //p1.setIdPiesa(1);
        //p1.getPiesePrecedente().add(3);
        //p1.adaugaPiesePrecedente(3);
        construiestePiesa(1, Arrays.asList(3));
        //p = construieste(1);
        //p.adaugaPiesePrecedente(3);
        //model.add(p);

        //Piesa p2 = new Piesa();
        //p2.setIdPiesa(2);
        //p2.getPiesePrecedente().add(4);
        //p2.adaugaPiesePrecedente(4);
        construiestePiesa(2, Arrays.asList(4));
        //p = construieste(2);
        //p.adaugaPiesePrecedente(4);
        //model.add(p);

        //Piesa p3 = new Piesa();
        //p3.setIdPiesa(3);
        construiestePiesa(3, new ArrayList<Integer>());
        //p = construieste(3);
        //model.add(p);

        //Piesa p4 = new Piesa();
        //p4.setIdPiesa(4);
        /*p4.getPiesePrecedente().add(1);
        //p4.getPiesePrecedente().add(6);
        //p4.getPiesePrecedente().add(8);*/
        //p4.adaugaPiesePrecedente(1);
        //p4.adaugaPiesePrecedente(6);
        //p4.adaugaPiesePrecedente(8);
        construiestePiesa(4, Arrays.asList(1,6,8));
        //p = construieste(4);
        //p.adaugaPiesePrecedente(1);
        //p.adaugaPiesePrecedente(6);
        //p.adaugaPiesePrecedente(8);
        //model.add(p);


        //Piesa p5 = new Piesa();
        //p5.setIdPiesa(5);
        /*p5.getPiesePrecedente().add(4);
        //p5.getPiesePrecedente().add(6);*/
        //p5.adaugaPiesePrecedente(4);
        //p5.adaugaPiesePrecedente(6);
        construiestePiesa(5, Arrays.asList(4,6));
        //p = construieste(5);
        //p.adaugaPiesePrecedente(4);
        //p.adaugaPiesePrecedente(6);
       //model.add(p);

        //Piesa p6 = new Piesa();
        //p6.setIdPiesa(6);
        //p6.getPiesePrecedente().add(3);
        //p6.adaugaPiesePrecedente(3);
        construiestePiesa(6, Arrays.asList(3));
        //p = construieste(6);
        //p.adaugaPiesePrecedente(3);
        //model.add(p);

        //Piesa p7 = new Piesa();
        //p7.setIdPiesa(7);
        /*p7.getPiesePrecedente().add(2);
        //p7.getPiesePrecedente().add(4);
        //p7.getPiesePrecedente().add(5);*/
        //.adaugaPiesePrecedente(2);
        //p7.adaugaPiesePrecedente(4);
        //p7.adaugaPiesePrecedente(5);
        construiestePiesa(7, Arrays.asList(2,4,5));
        //p = construieste(7);
        //p.adaugaPiesePrecedente(2);
        //p.adaugaPiesePrecedente(4);
        //p.adaugaPiesePrecedente(5);
        //model.add(p);


        //Piesa p8 = new Piesa();
        //p8.setIdPiesa(8);
        //p8.getPiesePrecedente().add(3);
        //p8.adaugaPiesePrecedente(3);
        construiestePiesa(8, Arrays.asList(3));
        //p = construieste(8);
        //p.adaugaPiesePrecedente(3);
        //model.add(p);

        /*Piesa p9 = new Piesa();
        p9.setIdPiesa(9);
        p9.getPiesePrecedente().add(2);
        p9.getPiesePrecedente().add(5);
        p9.adaugaPiesePrecedente(2);
        p9.adaugaPiesePrecedente(5);*/
        construiestePiesa(9, Arrays.asList(2,5));
        //p = construieste(9);
        //p.adaugaPiesePrecedente(2);
        //p.adaugaPiesePrecedente(5);
        //model.add(p);

        /*Piesa p10 = new Piesa();
        p10.setIdPiesa(10);
        /*p10.getPiesePrecedente().add(5);
        p10.getPiesePrecedente().add(7);
        p10.getPiesePrecedente().add(9);
        p10.adaugaPiesePrecedente(5);
        p10.adaugaPiesePrecedente(7);
        p10.adaugaPiesePrecedente(9);*/
        construiestePiesa(10, Arrays.asList(5,7,9));
        //p = construieste(10);
        //p.adaugaPiesePrecedente(5);
        //p.adaugaPiesePrecedente(7);
        //p.adaugaPiesePrecedente(9);
        //model.add(p);

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
    }



    public void getCost(Piesa z) {
        for (Piesa x : model) {
            if (x.getIdPiesa() == z.getIdPiesa()) {
                z.setCostPiesa(x.getCostPiesa());
            } else if (x.getPiesePrecedente().contains(z.getIdPiesa())) {
                x.setCostPiesa(x.getCostPiesa() - 5);
            }
        }
    }

    public void defaultCost() {
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
}
