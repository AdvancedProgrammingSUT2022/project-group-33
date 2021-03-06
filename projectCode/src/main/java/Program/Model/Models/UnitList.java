package Program.Model.Models;

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



    public void updateUnits(ArrayList<Terrain> terrains)
    {
        for (int i = 0; i < workers.size(); i++){
            workers.get(i).updateUnit(terrains);
        }

        for (int i = 0; i < settlers.size(); i++){
            settlers.get(i).updateUnit(terrains);
        }

        for (int i = 0; i < meleeMilitaryUnits.size(); i++){
            meleeMilitaryUnits.get(i).updateUnit(terrains);
        }

        for (int i = 0; i < rangedMilitaryUnits.size(); i++){
            rangedMilitaryUnits.get(i).updateUnit(terrains);
        }

        for (int i = 0; i < heavyRangedMilitaryUnits.size(); i++){
            heavyRangedMilitaryUnits.get(i).updateUnit(terrains);
        }
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



    public void addMeleeMilitaryUnit(MeleeMilitaryUnit militaryUnit)
    {
        meleeMilitaryUnits.add(militaryUnit);
        this.numberOfAllUnits++;
    }



    public void addRangedMilitaryUnit(RangedMilitaryUnit rangedMilitaryUnit)
    {
        rangedMilitaryUnits.add(rangedMilitaryUnit);
        this.numberOfAllUnits++;
    }



    public void addHeavyRangedMilitaryUnit(HeavyRangedMilitaryUnits heavyRangedMilitaryUnit)
    {
        heavyRangedMilitaryUnits.add(heavyRangedMilitaryUnit);
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



    public int getGoldNeeded()
    {
        int gold = 0;

        for (int i = 0; i < meleeMilitaryUnits.size(); i++){
            gold += meleeMilitaryUnits.get(i).getMaintenancePricePerTurn();
        }

        for (int i = 0; i < rangedMilitaryUnits.size(); i++){
            gold += rangedMilitaryUnits.get(i).getMaintenancePricePerTurn();
        }

        for (int i = 0; i < heavyRangedMilitaryUnits.size(); i++){
            gold += heavyRangedMilitaryUnits.get(i).getMaintenancePricePerTurn();
        }

        for (int i = 0; i < settlers.size(); i++){
            gold += settlers.get(i).getMaintenancePricePerTurn();
        }

        for (int i = 0; i < workers.size(); i++){
            gold += workers.get(i).getMaintenancePricePerTurn();
        }

        return gold;
    }



    public boolean isUnitInCoordinates(Coordinates coordinates)
    {
        for (int i = 0; i < meleeMilitaryUnits.size(); i++){
            if (meleeMilitaryUnits.get(i).getCoordinates().equals(coordinates)){
                return true;
            }
        }

        for (int i = 0; i < rangedMilitaryUnits.size(); i++){
            if (rangedMilitaryUnits.get(i).getCoordinates().equals(coordinates)){
                return true;
            }
        }

        for (int i = 0; i < heavyRangedMilitaryUnits.size(); i++){
            if (heavyRangedMilitaryUnits.get(i).getCoordinates().equals(coordinates)){
                return true;
            }
        }

        for (int i = 0; i < workers.size(); i++){
            if (workers.get(i).getCoordinates().equals(coordinates)){
                return true;
            }
        }

        for (int i = 0; i < settlers.size(); i++){
            if (settlers.get(i).getCoordinates().equals(coordinates)){
                return true;
            }
        }

        return false;
    }



    public String getNormalUnitNameFromCoordinates(Coordinates coordinates)
    {
        for (Worker worker : workers) {
            if (worker.getCoordinates().equals(coordinates)) {
                return worker.getGameName();
            }
        }

        for (Settler settler : settlers) {
            if (settler.getCoordinates().equals(coordinates)) {
                return settler.getGameName();
            }
        }

        return null;
    }



    public String getMilitaryUnitNameFromCoordinates(Coordinates coordinates)
    {
        for (MeleeMilitaryUnit meleeMilitaryUnit : meleeMilitaryUnits) {
            if (meleeMilitaryUnit.getCoordinates().equals(coordinates)) {
                return meleeMilitaryUnit.getGameName();
            }
        }

        for (RangedMilitaryUnit rangedMilitaryUnit : rangedMilitaryUnits) {
            if (rangedMilitaryUnit.getCoordinates().equals(coordinates)) {
                return rangedMilitaryUnit.getGameName();
            }
        }

        for (HeavyRangedMilitaryUnits heavyRangedMilitaryUnit : heavyRangedMilitaryUnits) {
            if (heavyRangedMilitaryUnit.getCoordinates().equals(coordinates)) {
                return heavyRangedMilitaryUnit.getGameName();
            }
        }

        return null;
    }
}
