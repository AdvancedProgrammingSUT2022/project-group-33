package Model;

import java.util.ArrayList;

public class PlayerCity extends City{
    private Player owner;
    private ArrayList<Wonder> wonders;
    //TODO:





    ////methods////
    public PlayerCity(boolean isCapital, Terrain terrain, Player owner)
    {
        super(isCapital, terrain);
        this.owner = owner;
        wonders = new ArrayList<>();

        initializeBorders();

        //TODO:
    }



    private void initializeBorders()
    {
        int x = getCoordinates().getX();
        int y = getCoordinates().getY();

        if (y > 0){
            tryAddingBorder(x, y - 1);
        }

        if (y < owner.getMap().getMapSize()){
            tryAddingBorder(x, y + 1);
        }

        if (x % 2 == 0){
            if (x > 0){
                tryAddingBorder(x - 1, y);

                if (y > 0) {
                    tryAddingBorder(x - 1, y - 1);
                }
            }

            if (x < owner.getMap().getMapSize() - 1){
                tryAddingBorder(x + 1, y);

                if (y > 0){
                    tryAddingBorder(x + 1, y - 1);
                }
            }
        }
        else {
            if (x > 0){
                tryAddingBorder(x - 1, y);

                if (y < owner.getMap().getMapSize()) {
                    tryAddingBorder(x - 1, y + 1);
                }
            }

            if (x < owner.getMap().getMapSize() - 1){
                tryAddingBorder(x + 1, y);

                if (y < owner.getMap().getMapSize()){
                    tryAddingBorder(x + 1, y + 1);
                }
            }
        }
    }



    private void tryAddingBorder(int x, int y)
    {
        Coordinates coordinates = new Coordinates(x, y, 0);

        if (!owner.getMap().getTerrainFromCoordinates(coordinates).getIsTerritory()){
            Terrain terrain = owner.getMap().getTerrainFromCoordinates(coordinates);
            addLand(terrain);
            terrain.setTerritory(true);
        }
    }
}
