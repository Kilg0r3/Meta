package teorie;

import java.sql.Ref;
import java.util.ArrayList;

public class Anduranta {

    ArrayList<Piesa> Referinta = new ArrayList<Piesa>();

    ArrayList<Piesa> solutieIntermed1 = new ArrayList<Piesa>();

    int costTotal = 0;

    Anduranta(){
        Coonstruct();
        Init();
        defaultCost();
        Show(Referinta);
        for(Piesa p:solutieIntermed1){
            getCost(p);
            costTotal += p.getCostPiesa();
        }
        Show(solutieIntermed1);
        System.out.println("Cost total: " + costTotal);
        Show(Referinta);
    }

    void Coonstruct(){
        Piesa p1 = new Piesa();
        p1.setIdPiesa(1);
        p1.getPiesePrecedente().add(3);

        Piesa p2 = new Piesa();
        p2.setIdPiesa(2);
        p2.getPiesePrecedente().add(4);

        Piesa p3 = new Piesa();
        p3.setIdPiesa(3);

        Piesa p4 = new Piesa();
        p4.setIdPiesa(4);
        p4.getPiesePrecedente().add(1);
        p4.getPiesePrecedente().add(6);
        p4.getPiesePrecedente().add(8);

        Piesa p5 = new Piesa();
        p5.setIdPiesa(5);
        p5.getPiesePrecedente().add(4);
        p5.getPiesePrecedente().add(6);

        Piesa p6 = new Piesa();
        p6.setIdPiesa(6);
        p6.getPiesePrecedente().add(3);

        Piesa p7 = new Piesa();
        p7.setIdPiesa(7);
        p7.getPiesePrecedente().add(2);
        p7.getPiesePrecedente().add(4);
        p7.getPiesePrecedente().add(5);

        Piesa p8 = new Piesa();
        p8.setIdPiesa(8);
        p8.getPiesePrecedente().add(3);

        Piesa p9 = new Piesa();
        p9.setIdPiesa(9);
        p9.getPiesePrecedente().add(2);
        p9.getPiesePrecedente().add(5);

        Piesa p10 = new Piesa();
        p10.setIdPiesa(10);
        p10.getPiesePrecedente().add(5);
        p10.getPiesePrecedente().add(7);
        p10.getPiesePrecedente().add(9);

        Referinta.add(p1);
        Referinta.add(p2);
        Referinta.add(p3);
        Referinta.add(p4);
        Referinta.add(p5);
        Referinta.add(p6);
        Referinta.add(p7);
        Referinta.add(p8);
        Referinta.add(p9);
        Referinta.add(p10);
    }

    void Init(){
        for(int i=1;i<11;i++){
            Piesa p = new Piesa();
            p.setIdPiesa(new Integer(i));
            solutieIntermed1.add(p);
        }
    }

    void Show(ArrayList<Piesa> a){
        for(Piesa p:a){
            System.out.println("ID: " + p.getIdPiesa() +
                    "; Comp prec: " + p.getPiesePrecedente() +
                    "; Cost: " + p.getCostPiesa());
        }
    }

    void Show2(){
        for (Piesa z :solutieIntermed1
        ) {
            System.out.println("ID: " + z.getIdPiesa() +
                    "; Comp prec: " + z.getPiesePrecedente() +
                    "; Cost: " + z.getCostPiesa());
        }
    }

    void defaultCost(){
        for (Piesa p:Referinta
        ) {
            p.setCostPiesa(p.getPiesePrecedente().size()*5);
        }
    }

    void getCost(Piesa z){
        for (Piesa x:Referinta
        ) {
            if(x.getIdPiesa() == z.getIdPiesa())
            {
                z.setCostPiesa(x.getCostPiesa());
            }
            else
            if(x.getPiesePrecedente().contains(z.getIdPiesa())){
                x.setCostPiesa(x.getCostPiesa()-5);
            }
        }
    }


}
