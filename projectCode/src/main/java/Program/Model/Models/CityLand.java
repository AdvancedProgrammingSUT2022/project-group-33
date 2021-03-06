package Program.Model.Models;

import Program.Model.Enums.ResourceCategories;

public class CityLand {
    private Terrain terrain;
    private boolean hasImprovement;
    private Improvement improvement;






    ////methods////
    public CityLand (Terrain terrain)
    {
        this.terrain = terrain;
        hasImprovement = false;
    }



    //getters
    public Terrain getTerrain() {
        return terrain;
    }


    public boolean isHasImprovement() {
        return hasImprovement;
    }


    public Improvement getImprovement() {
        return improvement;
    }


    public int getLandGold()
    {
        int gold = terrain.getGold();

        if (hasImprovement){
            gold += improvement.goldEffect;
        }

        return gold;
    }


    public int getLandFood()
    {
        int food = terrain.getFood();

        if (hasImprovement){
            food += improvement.foodEffect;
        }

        return food;
    }


    public int getLandProduction()
    {
        int production = terrain.getProduction();

        if (hasImprovement){
            production += improvement.productionEffect;
        }

        return production;
    }


    public boolean hasStrategicResourceProduction()
    {
        return terrain.isHasResource() && terrain.getResourceCategory().equals(ResourceCategories.STRATEGIC) &&
                hasImprovement && improvement.toString().equals(terrain.getResource().getConstructionNeeded());
    }


    public boolean hasLuxuryResource()
    {
        return terrain.isHasResource() && terrain.getResourceCategory().equals(ResourceCategories.LUXURY) &&
                hasImprovement && improvement.toString().equals(terrain.getResource().getConstructionNeeded());
    }
}
