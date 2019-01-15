package refurbish;

import teorie.Piesa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MasinarieCitireFisier {

    private ArrayList<Piesa> model = new ArrayList<>();

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
}
