package teorie;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        /*System.out.println( "Hello World!" );
        try{
            Trial t = new Trial();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }*/
        //GenNrAleator n = new GenNrAleator();

        //porneste cronometru

        Masinarie masina = new Masinarie();
        //masina.constructModel();
        masina.afisareModelInitial(masina.getModel());

        Robot r = new Robot();
        r.setMasina(masina);
        r.creareSolutie();

        r.hillClimbCuPornireAleatoare();
        //System.out.println("\n" + masina.getCostTotal());




        //masina.defaultCost();
        //r.calculeazaCost2();

        //r.asambleaza();




        //Anduranta aand = new Anduranta();
        //aand.aranjeaza();

        //opreste cronometru

        //afiseaza cronometru



    }



    /*public void aranjeaza() {
        //masina.coonstruct();
        masina.constructModel();
        //Coonstruct();

        //creareSolutie();
        //defaultCost();
        masina.defaultCost();
        Show(masina.getModel());
        //calculeazaCost();
        //afisareModelInitial(solutieIntermed1);
        //
        Show(masina.getModel());
    }*/
}
