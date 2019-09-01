package main.animal.wolf;

import main.animal.sheep.SheepHandler;

public class WolfService {
    private WolfHandler wolfHandler;
    private SheepHandler sheepHandler;

    public WolfService(WolfHandler wolfHandler, SheepHandler sheepHandler) {
        this.wolfHandler = wolfHandler;
        this.sheepHandler = sheepHandler;
    }

    public void update() {
        Wolf wolf = wolfHandler.getFirst();
        wolfHandler.eat(wolf, sheepHandler.getLastAdded());
    }
}
