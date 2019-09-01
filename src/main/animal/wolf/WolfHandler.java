package main.animal.wolf;

import main.animal.sheep.Sheep;
import main.animal.sheep.SheepHandler;

import java.util.List;

public class WolfHandler {
    private List<Wolf> wolfs;
    private SheepHandler sheepHandler;

    public WolfHandler(List<Wolf> wolfs, SheepHandler sheepHandler) {
        this.wolfs = wolfs;
        this.sheepHandler = sheepHandler;
    }

    public List<Wolf> getWolfs() {
        return wolfs;
    }

    public Wolf getFirst() {
        return !wolfs.isEmpty() ? wolfs.get(0) : null;
    }

    public void eat(Wolf wolf, Sheep sheep) {
        sheepHandler.killSheep(sheep);
        wolf.sheepsEaten++;
    }
}
