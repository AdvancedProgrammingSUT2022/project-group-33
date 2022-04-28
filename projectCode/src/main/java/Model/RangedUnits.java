package Model;

public enum RangedUnits {
    ;
    //TODO:


    final RangedMilitaryUnit unit;

    RangedUnits(int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
               int attackDamage, boolean isCavalry, int attackRange, Technologies technologyRequired, ResourceTypes resourceRequired, Eras era)
    {
        unit = new RangedMilitaryUnit(health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn,
                attackDamage, isCavalry, attackRange, technologyRequired, resourceRequired, era);
    }
}