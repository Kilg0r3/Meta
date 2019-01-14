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
        masina.constructModel();
        masina.show(masina.getModel());

        Robot r = new Robot();
        r.setMasina(masina);
        r.creareSolutie();
        //r.show(r.getSolutieIntermed1());
        r.hillClimbCuPornireAleatoare();


        //r.show((r.getSolutieIntermed1()));
        //r.show(masina.getModelInProcesare());
        //masina.defaultCost();
        //r.calculeazaCost2();
        //r.show(r.getSolIntermed2());



        //r.show(masina.getModel());
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
        //show(solutieIntermed1);
        //
        Show(masina.getModel());
    }*/
}
