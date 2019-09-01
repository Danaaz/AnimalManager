package test.animal.sheep;

import main.animal.sheep.Sheep;
import main.animal.sheep.SheepHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertNotNull;

public class SheepHandlerTest {
    private SheepHandler sheepHandler;

    @Before
    public void setup() {
        List<Sheep> sheeps = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sheeps.add(new Sheep("sheep_"+sheeps.size()));
        }

        sheepHandler = new SheepHandler(sheeps);
    }

    @Test
    public void createSheepTest() {
        int firstSheepCount = sheepHandler.getSheeps().size();
        sheepHandler.createSheep();
        int secondSheepCount = sheepHandler.getSheeps().size();

        assertEquals(5, firstSheepCount);
        assertEquals(6, secondSheepCount);
    }

    @Test
    public void increaseAgeTest() {
        Sheep sheep = sheepHandler.getLastAdded();

        int firstAge = sheep.age;
        sheepHandler.increaseAge(sheep);
        int secondAge = sheep.age;

        assertEquals(1, firstAge);
        assertEquals(2, secondAge);
    }

    @Test
    public void killSheepTest() {
        Sheep sheep = sheepHandler.getLastAdded();

        int firstSheepCount = sheepHandler.getSheeps().size();
        sheepHandler.killSheep(sheep);
        int secondSheepCount = sheepHandler.getSheeps().size();

        assertEquals(5, firstSheepCount);
        assertEquals(4, secondSheepCount);
    }

    @Test
    public void isSingleTest() {
        Sheep sheep = sheepHandler.getLastAdded();

        boolean sheepSingle = sheepHandler.isSingle(sheep);

        assertTrue(sheepSingle);
    }

    @Test
    public void becomePartnersTest() {
        Sheep sheep1 = sheepHandler.getSheeps().get(0);
        Sheep sheep2 = sheepHandler.getSheeps().get(1);

        boolean sheep1_Single = sheepHandler.isSingle(sheep1);
        boolean sheep2_Single = sheepHandler.isSingle(sheep2);

        assertTrue(sheep1_Single);
        assertTrue(sheep2_Single);

        sheepHandler.becomePartners(sheep1, sheep2);

        sheep1_Single = sheepHandler.isSingle(sheep1);
        sheep2_Single = sheepHandler.isSingle(sheep2);

        assertFalse(sheep1_Single);
        assertFalse(sheep2_Single);
    }

    @Test
    public void isOldTest() {
        Sheep sheep = sheepHandler.getFirst();

        for (int i = 0; i < 4; i++) {
            assertNotNull(sheepHandler.getById(sheep.id));
            sheepHandler.increaseAge(sheep);
        }

        assertFalse(sheepHandler.getById(sheep.id).isPresent());
    }
}
