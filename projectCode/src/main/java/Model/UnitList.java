package Model;

import java.util.ArrayList;

public class UnitList {
    private ArrayList<Worker> workers;
    private ArrayList<Settler> settlers;
    private ArrayList<MeleeMilitaryUnit> meleeMilitaryUnits;
    private ArrayList<RangedMilitaryUnit> rangedMilitaryUnits;
    ArrayList<HeavyRangedMilitaryUnits> heavyRangedMilitaryUnits;
    private int numberOfAllUnits;





    ////methods////
    public UnitList()
    {
        workers = new ArrayList<>();
        settlers = new ArrayList<>();
        meleeMilitaryUnits = new ArrayList<>();
        rangedMilitaryUnits = new ArrayList<>();
        heavyRangedMilitaryUnits = new ArrayList<>();

        //TODO:
    }



    public void addWorker(Worker worker)
    {
        workers.add(worker);
        this.numberOfAllUnits++;
    }



    public void addSettler(Settler settler)
    {
        settlers.add(settler);
        this.numberOfAllUnits++;
    }



    public void addMilitaryUnit(MeleeMilitaryUnit militaryUnit)
    {
        meleeMilitaryUnits.add(militaryUnit);
        this.numberOfAllUnits++;
    }



    //getters
    public ArrayList<Worker> getWorkers() {
        return workers;
    }


    public ArrayList<Settler> getSettlers() {
        return settlers;
    }


    public ArrayList<MeleeMilitaryUnit> getMeleeMilitaryUnits() {
        return meleeMilitaryUnits;
    }



    public ArrayList<RangedMilitaryUnit> getRangedMilitaryUnits()
    {
        return rangedMilitaryUnits;
    }


    public ArrayList<HeavyRangedMilitaryUnits> getHeavyRangedUnits() {
        return heavyRangedMilitaryUnits;
    }



    public Worker getWorkerFromCoordinates(Coordinates coordinates){
        for (int i = 0; i < workers.size(); i++){
            if (workers.get(i).getCoordinates().equals(coordinates)){
                return workers.get(i);
            }
        }

        return null;
    }


    public Settler getSettlerFromCoordinates(Coordinates coordinates){
        for (int i = 0; i < settlers.size(); i++){
            if (settlers.get(i).getCoordinates().equals(coordinates)){
                return settlers.get(i);
            }
        }

        return null;
    }


    public MeleeMilitaryUnit getMeleeMilitaryUnitFromCoordinates(Coordinates coordinates){
        for (int i = 0; i < meleeMilitaryUnits.size(); i++){
            if (meleeMilitaryUnits.get(i).getCoordinates().equals(coordinates)){
                return meleeMilitaryUnits.get(i);
            }
        }

        return null;
    }


    public RangedMilitaryUnit getRangedMilitaryUnitFromCoordinates(Coordinates coordinates){
        for (int i = 0; i < rangedMilitaryUnits.size(); i++){
            if (rangedMilitaryUnits.get(i).getCoordinates().equals(coordinates)){
                return rangedMilitaryUnits.get(i);
            }
        }

        return null;
    }



    public HeavyRangedMilitaryUnits getHeavyRangedMilitaryUnitFromCoordinates(Coordinates coordinates)
    {
        for (int i = 0; i < heavyRangedMilitaryUnits.size(); i++){
            if (heavyRangedMilitaryUnits.get(i).getCoordinates().equals(coordinates)){
                return heavyRangedMilitaryUnits.get(i);
            }
        }

        return null;
    }
}