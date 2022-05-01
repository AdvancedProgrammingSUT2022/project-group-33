package Model;

public enum MeleeUnits {
    //Ancient units
    WARRIOR("Warrior", 10, 2, 2, 40, 40,
            1, 6, false, null, null, Eras.ANCIENT),
    SCOUT("Scout", 8, 3, 3, 25, 25,
            0, 4, false, null, null, Eras.ANCIENT),
    SPEARMAN("Spearman" , 10, 2, 2, 50, 60,
            1, 7, false, Technologies.BRONZE_WORKING, null, Eras.ANCIENT),

    //Classical units
    HORSEMAN("Horseman", 10, 2, 4, 80, 70,
            1, 12, true, Technologies.HORSEBACK_RIDING, StrategicResourceTypes.HORSE, Eras.CLASSICAL),
    SWORDSMAN("Swordsman", 11, 2, 2, 80, 70,
            1, 11, false, Technologies.IRON_WORKING, StrategicResourceTypes.IRON, Eras.CLASSICAL),

    //Medieval units
    KNIGHT("Knight", 13, 2, 4, 150, 145,
            3, 18, true, Technologies.CHIVALRY, StrategicResourceTypes.HORSE, Eras.MEDIEVAL),
    LONG_SWORDSMAN(" Long Swordsman", 16, 2, 2, 150, 140,
            3, 18, false, Technologies.STEEL, StrategicResourceTypes.IRON, Eras.MEDIEVAL),
    PIKEMAN("Pikeman", 11, 2, 2, 100, 90,
            1, 10, false, Technologies.CIVIL_SERVICE, null, Eras.MEDIEVAL),

    //Renaissance units
    CAVALRY("Cavalry", 14, 2, 3, 260, 250,
            2, 26, true, Technologies.MILITARY_SCIENCE, StrategicResourceTypes.HORSE, Eras.RENAISSANCE),
    LANCER("Lancer", 12, 2, 4, 220, 200,
            2, 22, true, Technologies.METALLURGY, StrategicResourceTypes.HORSE, Eras.RENAISSANCE),
     MUSKETMAN("Musketman", 11, 2, 2, 120, 110,
             1, 16, false, Technologies.GUNPOWDER, null, Eras.RENAISSANCE),
    RIFLEMAN("Rifleman", 11, 2, 2, 200, 200,
            1, 25, false, Technologies.RIFLING, null, Eras.RENAISSANCE),

    //Industrial units
    ANTI_TANK_GUN("Anti-Tank Gun", 14, 2, 2, 300, 320,
            2, 32, false, Technologies.REPLACEABLE_PARTS, null, Eras.INDUSTRIAL),
    INFANTRY("Infantry", 12, 2, 2, 300, 280,
            1, 36, false, Technologies.REPLACEABLE_PARTS, null, Eras.INDUSTRIAL),
    PANZER("Panzer", 15, 2, 5, 450, 475,
            2, 60, false, Technologies.COMBUSTION, null, Eras.INDUSTRIAL),
    TANK("Tank", 22, 2, 4, 450, 475,
            3, 50, false, Technologies.COMBUSTION, null, Eras.INDUSTRIAL);


    final MeleeMilitaryUnit unit;

    MeleeUnits(String gameName, int health, int visibilityRange, int maxMovements, int price, int productionRequiredForBeingMade, int maintenancePricePerTurn,
                      int attackDamage, boolean isCavalry, Technologies technologyRequired, StrategicResourceTypes resourceRequired, Eras era)
    {
        unit = new MeleeMilitaryUnit(gameName, health, visibilityRange, maxMovements, price, productionRequiredForBeingMade, maintenancePricePerTurn,
                attackDamage, isCavalry, technologyRequired, resourceRequired, era);
    }
}
