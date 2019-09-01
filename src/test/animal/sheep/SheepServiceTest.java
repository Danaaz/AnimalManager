package test.animal.sheep;

import main.animal.sheep.Sheep;
import main.animal.sheep.SheepHandler;
import main.animal.sheep.SheepService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class SheepServiceTest {
    private SheepService sheepService;
    private SheepHandler sheepHandler;

    @Before
    public void setup() {
        List<Sheep> sheeps = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sheeps.add(new Sheep("sheep_"+sheeps.size()));
        }

        sheepHandler = new SheepHandler(sheeps);
        sheepService = new SheepService(sheepHandler);
    }

    @Test
    public void updateTest() {
        List<Sheep> allSheeps = sheepHandler.getSheeps();
        List<Sheep> singles = sheepService.getSingles(allSheeps);
        List<Sheep> parterns = sheepService.getPartners(allSheeps);

        assertEquals(5, allSheeps.size());
        assertEquals(5, singles.size());
        assertEquals(0, parterns.size());

        sheepService.update();
        singles = sheepService.getSingles(allSheeps);
        parterns = sheepService.getPartners(allSheeps);

        assertEquals(5, allSheeps.size());
        assertEquals(1, singles.size());
        assertEquals(4, parterns.size());

        sheepService.update();
        singles = sheepService.getSingles(allSheeps);
        parterns = sheepService.getPartners(allSheeps);

        assertEquals(7, allSheeps.size());
        assertEquals(3, singles.size());
        assertEquals(4, parterns.size());

        sheepService.update();
        singles = sheepService.getSingles(allSheeps);
        parterns = sheepService.getPartners(allSheeps);

        assertEquals(9, allSheeps.size());
        assertEquals(3, singles.size());
        assertEquals(6, parterns.size());
    }

    @Test
    public void partnersMakeLambTest() {
        List<Sheep> allSheeps = sheepHandler.getSheeps();
        sheepService.singlesFindPartners(allSheeps);

        List<Sheep> parterns = sheepService.getPartners(allSheeps);
        assertEquals(5, allSheeps.size());
        assertEquals(4, parterns.size());

        sheepService.partnersMakeLamb(parterns);
        assertEquals(7, allSheeps.size());
    }

    @Test
    public void singlesFindPartnersTest() {
        List<Sheep> allSheeps = sheepHandler.getSheeps();
        List<Sheep> singles = sheepService.getSingles(allSheeps);
        List<Sheep> parterns = sheepService.getPartners(allSheeps);

        assertEquals(5, singles.size());
        assertEquals(0, parterns.size());

        sheepService.singlesFindPartners(singles);
        singles = sheepService.getSingles(allSheeps);
        parterns = sheepService.getPartners(allSheeps);

        assertEquals(1, singles.size());
        assertEquals(4, parterns.size());
        assertEquals(5, allSheeps.size());
    }

    @Test
    public void getPartnersTest() {
        List<Sheep> allSheeps = sheepHandler.getSheeps();
        sheepHandler.becomePartners(allSheeps.get(0), allSheeps.get(1));

        List<Sheep> parterns = sheepService.getPartners(allSheeps);

        assertEquals(5, allSheeps.size());
        assertEquals(2, parterns.size());
    }

    @Test
    public void getSingles() {
        List<Sheep> allSheeps = sheepHandler.getSheeps();
        List<Sheep> singles = sheepService.getSingles(allSheeps);

        assertTrue(allSheeps.size() == singles.size());
        allSheeps.get(0).hasPartner = true;

        singles = sheepService.getSingles(allSheeps);
        assertFalse(allSheeps.size() == singles.size());
        assertTrue(allSheeps.size()-1 == singles.size());
    }
}
