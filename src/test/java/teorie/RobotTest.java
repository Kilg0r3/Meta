package teorie;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RobotTest {

    private ArrayList<Piesa> solutieIntermed1;
    private Robot robot;

    @Before
    public void setUp() throws Exception {
        solutieIntermed1 = new ArrayList<>();
        robot = new Robot();
        robot.setSolutieIntermed1(solutieIntermed1);
    }

    @Test
    public void givenEmptyListForCreareSolutie_ExpectListSize11() {
        robot.creareSolutie();
        assertTrue(solutieIntermed1.size()==10);
    }

    @Test
    public void givenPieceListForCalculeazaCost_ExpectCostTotal10(){
        ArrayList<Piesa> model = new ArrayList<>();
        Piesa piesa = new Piesa();
        piesa.setIdPiesa(3);
        piesa.adaugaPiesePrecedente(1);
        solutieIntermed1.add(piesa);
        Masinarie masina = new Masinarie();
        model.add(piesa);
        masina.setModel(model);
        robot.setMasina(masina);
        //masina.defaultCost();
        robot.calculeazaCost();
        assertEquals(5, robot.getCostTotal());
    }

    @Test
    public void givenEmptyPieceListForCalculeazaCost_ExpectCostTotal0(){

        robot.calculeazaCost();
        assertEquals(0, robot.getCostTotal());
    }


}