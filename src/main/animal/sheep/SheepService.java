package main.animal.sheep;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SheepService {
    private SheepHandler sheepHandler;

    public SheepService(SheepHandler sheepHandler) {
        this.sheepHandler = sheepHandler;
    }

    public void update() {
        List<Sheep> withPartners = getPartners(sheepHandler.getSheeps());
        List<Sheep> withoutPartners = getSingles(sheepHandler.getSheeps());

        partnersMakeLamb(withPartners);
        singlesFindPartners(withoutPartners);
    }

    public void partnersMakeLamb(List<Sheep> sheeps) {
        List<Sheep> toBeUpdated = new ArrayList<>(sheeps);
        while (!toBeUpdated.isEmpty()) {
            Sheep current = toBeUpdated.get(0);

            sheepHandler.increaseAge(current);
            sheepHandler.increaseAge(current.partner);

            toBeUpdated.remove(current.partner);
            toBeUpdated.remove(current);
            sheepHandler.createSheep();
        }
    }

    public void singlesFindPartners(List<Sheep> sheeps) {
        List<Sheep> toBeUpdated = new ArrayList<>(sheeps);
        while (toBeUpdated.size() > 1) {
            Sheep sheep1 = toBeUpdated.get(0);
            Sheep sheep2 = toBeUpdated.get(1);

            sheepHandler.becomePartners(sheep1, sheep2);

            toBeUpdated.remove(sheep1);
            toBeUpdated.remove(sheep2);
        }
    }

    public List<Sheep> getPartners(List<Sheep> sheeps) {
        return sheeps
                .stream()
                .filter(sheep -> sheep.hasPartner && sheep.partner != null)
                .collect(Collectors.toList());
    }

    public List<Sheep> getSingles(List<Sheep> sheeps) {
        return sheeps
                .stream()
                .filter(sheep -> !sheep.hasPartner)
                .collect(Collectors.toList());
    }
}
