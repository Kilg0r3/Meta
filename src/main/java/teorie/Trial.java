package teorie;

import java.util.ArrayList;
import java.util.Collections;

public class Trial {
    ArrayList<Piesa>Referinta = new ArrayList<Piesa>();

    ArrayList<Piesa>solutieIntermed1 = new ArrayList<Piesa>();
    ArrayList<Piesa>solutieIntermed2 = new ArrayList<Piesa>();

    ArrayList<Piesa>solutieBest = new ArrayList<Piesa>();
    int costTotal = 0;
    Trial(){
        Coonstruct();
        Init();
        defCost();
        show();
        for (Piesa p:solutieIntermed1
             ) {
            getCost(p);
            costTotal += p.getCostPiesa();
        }
        show2();

        test();
        System.out.println("Cost total:" + costTotal + "\n\n\n");
        show();
    }

    void Coonstruct(){
        Piesa p1 = new Piesa();
        p1.setIdPiesa(1);
        p1.getPiesePrecedente().add(2);
        p1.getPiesePrecedente().add(3);

        Piesa p2 = new Piesa();
        p2.setIdPiesa(2);
        p2.getPiesePrecedente().add(3);

        Piesa p3 = new Piesa();
        p3.setIdPiesa(3);

        Referinta.add(p1);
        Referinta.add(p2);
        Referinta.add(p3);
    }

    void Init(){
        for(int i=1; i<4;i++){
            Piesa p = new Piesa();
            p.setIdPiesa(new Integer(i));
            solutieIntermed1.add(p);
        }

        //Collections.shuffle(solutieIntermed);
    }

    void show(){
        for (Piesa p :Referinta
             ) {
            System.out.println("ID: " + p.getIdPiesa() + " Comp prec: " + p.getPiesePrecedente() + " Cost: " + p.getCostPiesa());
        }

    }

    void show2(){
        for (Piesa z :solutieIntermed1
        ) {
            System.out.println("ID: " + z.getIdPiesa() + " Comp prec: " + z.getPiesePrecedente() + " Cost: " + z.getCostPiesa());
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

    void defCost(){
        for (Piesa p:Referinta
             ) {
            p.setCostPiesa(p.getPiesePrecedente().size()*5);
        }
    }

    void test(){
        for (Piesa p:Referinta
             ) {
            if(p.getPiesePrecedente().contains(2))
            {
                System.out.println("Here");
            }
        }
    }


}
