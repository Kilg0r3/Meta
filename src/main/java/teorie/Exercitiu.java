package teorie;

import java.util.ArrayList;
import java.util.Collections;

public class Exercitiu {

    public Operanzi suma(int a, int b){
        Operanzi operanzi = new Operanzi();
        operanzi.setA(a);
        operanzi.setB(b);
        operanzi.setRezultat(a+b);
        return operanzi;
    }

    public static void main(String[] args) {
        Exercitiu exercitiu = new Exercitiu();
        Operanzi rezultat = exercitiu.suma(2,3);
        System.out.print("Rezultatul este: " + rezultat.getRezultat());
        ArrayList<Integer> ex = new ArrayList<>();
        ex.add(1);
        ex.add(2);
        ex.add(3);
        ex.add(4);
        System.out.println(ex);
        Collections.swap(ex,1,2);
        System.out.println(ex);
    }

}
