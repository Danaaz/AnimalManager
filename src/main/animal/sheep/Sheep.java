package main.animal.sheep;

import java.time.LocalDateTime;
import java.util.UUID;

public class Sheep {
    public String id;
    public String name;
    public int age;
    public int children;
    public LocalDateTime born;

    public Sheep partner;
    public boolean hasPartner;

    public Sheep(String name) {
        this.name = name;
        this.age = 1;
        this.children = 0;
        this.hasPartner = false;
        this.born = LocalDateTime.now();
        this.id = UUID.randomUUID().toString();
    }
}
