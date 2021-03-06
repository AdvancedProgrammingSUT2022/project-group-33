package Program.Model.Models;

import Program.Model.Enums.*;

import java.util.ArrayList;
import java.util.Random;

public class Terrain extends MapLandElement{
    private ArrayList<String> availableProperties;
    private boolean hasProperty;
    private MapProperty property;
    private boolean hasResource;
    private ResourceCategories resourceCategory;
    private Resource resource;
    private StrategicResource strategicResource;
    private LuxuryResource luxuryResource;
    private boolean isTerritory;
    private boolean hasRiver;
    private boolean hasRoad;
    private String territoryColor;
    private Player Owner;






    ////methods////
    public Terrain(int food, int production, int gold, int fightChangePercentage, int movementPrice, boolean canBeCrossed, ArrayList<String> availableProperties)
    {
        super(food, production, gold, fightChangePercentage, movementPrice, canBeCrossed);
        this.availableProperties = availableProperties;
        this.hasRoad = false;
    }



    public Terrain(String type, Terrain terrain)
    {
        super(terrain.getFood(), terrain.getProduction(), terrain.getGold(), terrain.getFightChangePercentage(), terrain.getMovementPrice(), terrain.isCanBeCrossed());
        super.setType(type);
        this.availableProperties = terrain.availableProperties;
        this.isTerritory = false;


        chooseAndPlaceProperty();
        chooseAndPlaceResource();
    }



    private void chooseAndPlaceProperty()
    {
        Random rand = new Random();

        if (rand.nextInt(100) >= 45)
        {
            hasProperty = false;
            return;
        }

        if (availableProperties.size() == 0){
            hasProperty = false;
            return;
        }

        int propertyTypeIndex = rand.nextInt(availableProperties.size());

        for (MapPropertyTypes mapProperty: MapPropertyTypes.values()){
            if (availableProperties.contains(mapProperty.toString())) {
                 if (propertyTypeIndex == 0) {
                    property = new MapProperty(mapProperty.toString(), mapProperty.property);
                    hasProperty = true;
                    this.hasRiver = property.getType().equals("FLOOD_PAIN");
                    return;
                }

                propertyTypeIndex--;
            }
        }
    }



    private void chooseAndPlaceResource()
    {
        Random rand = new Random();
        hasResource = false;

        if (rand.nextInt(100) >= 35)
        {
            return;
        }

        int resourceTypeNumber = rand.nextInt(3);

        if (resourceTypeNumber == 0){
            ArrayList<ResourceTypes> availableResources = getAvailableResources();

            if (availableResources.size() == 0){
                return;
            }

            int resourceIndex = rand.nextInt(availableResources.size());
            Resource temporarilyResource = new Resource(availableResources.get(resourceIndex).toString() , availableResources.get(resourceIndex).resource);

            if (temporarilyResource.getLandsThatCanBeFound() != null && temporarilyResource.getLandsThatCanBeFound().contains(Terrain.super.getType())){
                hasResource = true;
                resourceCategory = ResourceCategories.NORMAL;
                resource = temporarilyResource;
            }
        }
        else if (resourceTypeNumber == 1){
            ArrayList<StrategicResourceTypes> availableResources = getAvailableStrategicResources();

            if (availableResources.size() == 0){
                return;
            }

            int resourceIndex = rand.nextInt(availableResources.size());
            StrategicResource temporarilyResource = new StrategicResource(availableResources.get(resourceIndex).toString() , availableResources.get(resourceIndex).resource);

            if (temporarilyResource.getLandsThatCanBeFound() != null && temporarilyResource.getLandsThatCanBeFound().contains(Terrain.super.getType())){
                hasResource = true;
                resourceCategory = ResourceCategories.STRATEGIC;
                strategicResource = temporarilyResource;
            }
        }
        else {
            ArrayList<LuxuryResourceTypes> availableResources = getAvailableLuxuryResources();

            if (availableResources.size() == 0){
                return;
            }

            int resourceIndex = rand.nextInt(availableResources.size());
            LuxuryResource temporarilyResource = new LuxuryResource(availableResources.get(resourceIndex).toString() , availableResources.get(resourceIndex).resource);

            hasResource = true;
            resourceCategory = ResourceCategories.LUXURY;
            luxuryResource = temporarilyResource;
        }
    }



    public ArrayList<ResourceTypes> getAvailableResources()
    {
        ArrayList<ResourceTypes> resources = new ArrayList<>();

        for (int i = 0; i < ResourceTypes.values().length; i++){
            if ((hasProperty && ResourceTypes.values()[i].resource.getLandsThatCanBeFound().contains(property.getType()))
                    || ResourceTypes.values()[i].resource.getLandsThatCanBeFound().contains(this.getType())){
                resources.add(ResourceTypes.values()[i]);
            }
        }

        return resources;
    }



    public ArrayList<StrategicResourceTypes> getAvailableStrategicResources()
    {
        ArrayList<StrategicResourceTypes> resources = new ArrayList<>();

        for (int i = 0; i < StrategicResourceTypes.values().length; i++){
            if ((hasProperty && StrategicResourceTypes.values()[i].resource.getLandsThatCanBeFound().contains(property.getType()))
                    || StrategicResourceTypes.values()[i].resource.getLandsThatCanBeFound().contains(this.getType())){
                resources.add(StrategicResourceTypes.values()[i]);
            }
        }

        return resources;
    }



    public ArrayList<LuxuryResourceTypes> getAvailableLuxuryResources()
    {
        ArrayList<LuxuryResourceTypes> resources = new ArrayList<>();

        for (int i = 0; i < LuxuryResourceTypes.values().length; i++){
            if ((hasProperty && LuxuryResourceTypes.values()[i].resource.getLandsThatCanBeFound().contains(property.getType()))
                    || LuxuryResourceTypes.values()[i].resource.getLandsThatCanBeFound().contains(this.getType())){
                resources.add(LuxuryResourceTypes.values()[i]);
            }
        }

        return resources;
    }



    //getters
    public boolean isHasRiver()
    {
        return hasRiver;
    }


    public ArrayList<String> getAvailableProperties() {
        return availableProperties;
    }


    public boolean isHasProperty() {
        return hasProperty;
    }


    public MapProperty getProperty() {
        return property;
    }


    public boolean isHasResource() {
        return hasResource;
    }


    public ResourceCategories getResourceCategory() {
        return resourceCategory;
    }


    public Resource getResource() {
        return resource;
    }


    public StrategicResource getStrategicResource() {
        return strategicResource;
    }


    public LuxuryResource getLuxuryResource() {
        return luxuryResource;
    }


    public boolean getIsTerritory()
    {
        return isTerritory;
    }


    public boolean isTerritory() {
        return isTerritory;
    }


    public boolean isHasRoad() {
        return hasRoad;
    }


    public String getResourceTypeString()
    {
        if(resourceCategory.equals(ResourceCategories.STRATEGIC)){
            return strategicResource.getGameName();
        }
        else if (resourceCategory.equals(ResourceCategories.LUXURY)){
            return luxuryResource.getGameName();
        }
        else {
            return resource.getGameName();
        }
    }


    public Player getOwner() {
        return Owner;
    }


    public String getTerritoryColor() {
        return territoryColor;
    }



    //setters
    public void setTerritory(boolean isTerritory, String color)
    {
        this.isTerritory = isTerritory;
        this.territoryColor = color;
    }


    public void setCoordinates(Coordinates coordinates)
    {
        super.setCenterCoordinates(coordinates);
    }



    public void addRiver()
    {
        hasRiver = true;
    }
}
