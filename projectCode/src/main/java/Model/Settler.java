package Model;

import Controller.SettlerController;
import View.SettlerView;

import java.util.ArrayList;

public class Settler extends Unit{





    public Settler(Coordinates coordinates, Colors color, Player player)
    {
        super("Settler" , 5, 2, 2, 89, 0, 100);
        /* health = 5
        visibilityRange =2
        maxMovements = 2
        price = 89
        maintenancePricePerTurn = 0
        productionNeededForBeingMade = 100 */

        super.setCoordinates(coordinates);
        super.setBelongsToPlayer(true);
        super.setColor(color);
        super.setOwner(player);

        //TODO:
    }



    public Settler(Coordinates coordinates, NonPlayerColors color){

        super("Settler", 5, 2, 2, 89, 0, 100);
        /* health = 5
        visibilityRange =2
        maxMovements = 2
        price = 89
        maintenancePricePerTurn = 0
        productionNeededForBeingMade = 100 */

        super.setCoordinates(coordinates);
        super.setBelongsToPlayer(false);
        super.setNonPlayerColor(color);


        //TODO:
    }



    public boolean createCity(SettlerView view, SettlerController controller)
    {
        if (getOwner().getMap().getTerrainFromCoordinates(getCoordinates()).getIsTerritory()){
            view.showCanNotBuildCity();
            return false;
        }

         String cityName = controller.getCityName();

        if (cityName == null){
            return false;
        }

        PlayerCity newCity = new PlayerCity(getOwner().getCities().size() == 0,
                getOwner().getMap().getTerrainFromCoordinates(getCoordinates()), getOwner(), cityName);
        getOwner().addCity(newCity);
        getOwner().getMap().addPlayerCity(newCity);
        getOwner().getMap().getOriginalMap().addPlayerCity(newCity);

        getOwner().getPlayerUnits().getSettlers().remove(this);
        getOwner().getMap().getUnits().getSettlers().remove(this);
        getOwner().getMap().getOriginalMap().getUnits().getSettlers().remove(this);

        return true;
    }



    public void moveUnit(ArrayList<Terrain> terrains, ArrayList<Settler> settlers, ArrayList<Worker> workers, SettlerView view)
    {
        ArrayList<Coordinates> remainingPath = new ArrayList<>();

        int i = 0;

        while(!getPath().get(i).equals(getCoordinates())){
            i++;
        }

        i++;

        while (i < getPath().size()){
            remainingPath.add(getPath().get(i));
            i++;
        }

        i = 0;

        while (!getCoordinates().equals(getDestinationCoordinates()) &&
                getRemainingMovements() >= getTerrainFromCoordinates(terrains, remainingPath.get(i)).getMovementPrice()){
            for (int k = 0; k < settlers.size(); k++){
                if (settlers.get(k).getCoordinates().equals(remainingPath.get(i))){
                    view.showOccupiedCoordinates(false, remainingPath.get(i));
                    resetDestinationCoordinates();
                    setMoving(false);
                    return;
                }
            }

            for (int k = 0; k < workers.size(); k++){
                if (workers.get(k).getCoordinates().equals(remainingPath.get(i))){
                    view.showOccupiedCoordinates(false, remainingPath.get(i));
                    resetDestinationCoordinates();
                    setMoving(false);
                    return;
                }
            }

            setRemainingMovements(getRemainingMovements() - getTerrainFromCoordinates(terrains, remainingPath.get(i)).getMovementPrice());
            setCoordinates(remainingPath.get(i));
            i++;
        }


        if (getCoordinates().equals(getDestinationCoordinates())){
            setMoving(false);
        }
    }



    public void removeUnit()
    {
        getOwner().addGold(getPrice() * getHealth() / 10);

        getOwner().getPlayerUnits().getSettlers().remove(this);
        getOwner().getMap().getUnits().getSettlers().remove(this);
        getOwner().getMap().getOriginalMap().getUnits().getSettlers().remove(this);
    }
}
