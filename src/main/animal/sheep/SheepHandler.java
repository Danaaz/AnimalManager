package main.animal.sheep;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SheepHandler {
    private List<Sheep> sheeps;
    private List<Sheep> deadSheeps;

    public SheepHandler(List<Sheep> sheeps) {
        this.sheeps = sheeps;
        this.deadSheeps = new ArrayList<>();
    }

    public Sheep getFirst() {
        return !sheeps.isEmpty() ? sheeps.get(0) : null;
    }

    public Sheep getLastAdded() {
        return !sheeps.isEmpty() ? sheeps.get(sheeps.size()-1) : null;
    }

    public Optional<Sheep> getById(String id) {
        if (!sheeps.isEmpty()) {
            return sheeps.stream().filter(sheep -> sheep.id == id).findFirst();
        }
        return Optional.empty();
    }

    public List<Sheep> getSheeps() {
        return sheeps;
    }

    public List<Sheep> getDeadSheeps() {
        return deadSheeps;
    }

    public void createSheep() {
        sheeps.add(new Sheep("sheep_"+sheeps.size()));
    }

    public void increaseAge(Sheep sheep) {
        sheep.age = sheep.age + 1;
        isOld(sheep);
    }

    public void killSheep(Sheep sheep) {
        deadSheeps.add(sheep);
        sheeps.remove(sheep);
    }

    public boolean isSingle(Sheep sheep) {
        return !sheep.hasPartner;
    }

    public void becomePartners(Sheep sheep1, Sheep sheep2) {
        sheep1.partner = sheep2;
        sheep2.partner = sheep1;

        sheep1.hasPartner = true;
        sheep2.hasPartner = true;
    }

    private void isOld(Sheep sheep) {
        if (sheep.age > 4) {
            killSheep(sheep);
        }
    }
}
