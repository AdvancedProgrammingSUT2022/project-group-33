package Model;

import java.util.ArrayList;

public class MiniMap extends Map{
    ArrayList<HiddenTile> hiddenTiles;
    ArrayList<Terrain> visibleTiles;
    ArrayList<Coordinates> visibleCoordinates;





    ////methods////
    public MiniMap(Map map)
    {
        super(map);
    }



    public void updateMap()
    {
        updateVisibility();
        //TODO:
    }



    public void updateVisibility()
    {
        visibleCoordinates = new ArrayList<>();

        updateUnitVisibility(super.getUnits().getWorkers());
        updateUnitVisibility(super.getUnits().getSettlers());
        updateUnitVisibility(super.getUnits().getMeleeMilitaryUnits());
        updateUnitVisibility(super.getUnits().getRangedMilitaryUnits());
        updateUnitVisibility();
    }



    public void updateUnitVisibility(ArrayList<? extends Unit> checkingUnits)
    {
        for (int i = 0; i < checkingUnits.size(); i++){
            ArrayList<Coordinates> visibleWorkerCoordinates = new ArrayList<>(findVisibleCoordinates(checkingUnits.get(i).getCoordinates(), checkingUnits.get(i).getVisibilityRange()));

            for (int k = 0; k < visibleWorkerCoordinates.size(); k++){
                if (!visibleCoordinates.contains(visibleWorkerCoordinates.get(k))){
                    visibleCoordinates.add(visibleWorkerCoordinates.get(k));
                }
            }
        }
    }



    public void sayName(Unit unit)
    {
        System.out.println(unit.getColor());
    }



    public void updateHiddenTiles()
    {
        //TODO:
    }



    public void updateFog()
    {
        //TODO:
    }



    public ArrayList<Coordinates> findVisibleCoordinates(Coordinates coordinates, int range)
    {
        ArrayList<Coordinates> availableCoordinates = new ArrayList<>();
        ArrayList<Coordinates> blockCoordinates = new ArrayList<>();

        for (int j = -range; j <= range; j++){
            for (int i = Math.abs(j) - range; i <= range - Math.abs(j); i++){
                Coordinates checkingCoordinates = new Coordinates(coordinates.getX() + i, coordinates.getY() + j, 0);
                availableCoordinates.add(checkingCoordinates);

                if (getTerrainFromCoordinates(checkingCoordinates).getType().equals("HILLS") || getTerrainFromCoordinates(checkingCoordinates).getType().equals("MOUNTAIN")){
                    blockCoordinates.add(checkingCoordinates);
                }
            }
        }

        ArrayList<Coordinates> visibleCoordinates = new ArrayList<>();

        for (int i = 0; i < availableCoordinates.size(); i++){
            if (isInLineOfSight(availableCoordinates.get(i), blockCoordinates, coordinates)){
                visibleCoordinates.add(availableCoordinates.get(i));
            }
        }

        return visibleCoordinates;
    }



    private boolean isInLineOfSight(Coordinates checkingCoordinates, ArrayList<Coordinates> blockCoordinates, Coordinates centerCoordinates)
    {
        for (int i = 0; i < blockCoordinates.size(); i++){
            if (!checkingCoordinates.equals(blockCoordinates.get(i))){
                NormalCoordinates normalCheckingCoordinates = new NormalCoordinates(checkingCoordinates);
                NormalCoordinates normalBlockCoordinates = new NormalCoordinates(blockCoordinates.get(i));
                NormalCoordinates normalCenterCoordinates = new NormalCoordinates(centerCoordinates);

                for (int r = 0; r < normalCenterCoordinates.calculateDistance(normalCheckingCoordinates); r++){
                    double lineX = normalCenterCoordinates.getX() + r *
                            (normalCheckingCoordinates.getX() - normalCenterCoordinates.getX()) / normalCenterCoordinates.calculateDistance(normalCheckingCoordinates);
                    double lineY = normalCenterCoordinates.getY() +  r *
                            (normalCheckingCoordinates.getY() - normalCenterCoordinates.getY()) / normalCenterCoordinates.calculateDistance(normalCheckingCoordinates);

                    NormalCoordinates lineCoordinates = new NormalCoordinates(lineX, lineY);
                    double lineDistanceFromBlockCoordinates = normalBlockCoordinates.calculateDistance(lineCoordinates);

                    if (lineDistanceFromBlockCoordinates < Math.sqrt(3) / 2 * 0.8 && getTerrainFromCoordinates(blockCoordinates.get(i)).getType().equals("MOUNTAIN")){
                        return false;
                    }
                    else if (lineDistanceFromBlockCoordinates < Math.sqrt(3) / 2 * 0.65 && getTerrainFromCoordinates(blockCoordinates.get(i)).getType().equals("HILLS")){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
