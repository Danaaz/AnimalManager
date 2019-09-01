package main.animal.wolf;

import java.util.UUID;

public class Wolf {
    public String id;
    public String name;
    public int sheepsEaten;

    public Wolf(String name) {
        this.name = name;
        this.sheepsEaten = 0;
        this.id = UUID.randomUUID().toString();
    }
}
