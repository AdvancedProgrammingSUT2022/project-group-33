package Model;

public class Building {
    String gameName;
    int cost;
    int productionNeeded;
    int maintenance;
    int foodPerTurn;
    int productionPurTurn;
    int happinessPurTurn;
    int goldPurTurn;
    int sciencePurTwoCitizen;
    int scienceEffect;
    int defenceEffect;
    int unitsXpBonus;
    Technologies technologyNeeded;
    BuildingTypes RequiredBuildings;
    boolean needsRiver;
    boolean needsHorse;
    Eras era;





    ////methods////

    public Building(String gameName, int cost, int productionNeeded, int maintenance, int foodPerTurn, int productionPurTurn,
                    int happinessPurTurn, int goldPurTurn, int sciencePurTwoCitizen, int scienceEffect, int defenceEffect, int unitsXpBonus,
                    Technologies technologyNeeded, BuildingTypes requiredBuildings, boolean needsRiver, boolean needsHorse, Eras era) {
        this.gameName = gameName;
        this.cost = cost;
        this.productionNeeded  = productionNeeded;
        this.maintenance = maintenance;
        this.foodPerTurn = foodPerTurn;
        this.productionPurTurn = productionPurTurn;
        this.happinessPurTurn = happinessPurTurn;
        this.goldPurTurn = goldPurTurn;
        this.sciencePurTwoCitizen = sciencePurTwoCitizen;
        this.scienceEffect = scienceEffect;
        this.defenceEffect = defenceEffect;
        this.unitsXpBonus = unitsXpBonus;
        this.technologyNeeded = technologyNeeded;
        this.RequiredBuildings = requiredBuildings;
        this.needsRiver = needsRiver;
        this.needsHorse = needsHorse;
        this.era = era;
    }
}
