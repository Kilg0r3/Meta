package teorie;
import java.util.Random;
public class GenNrAleator {
    GenNrAleator(){
        Random rand = new Random();
        int nr1 = rand.nextInt(10)+1;
        int nr2 = rand.nextInt(10)+1;
        System.out.println(nr1);
        System.out.println(nr2);
    }

}
