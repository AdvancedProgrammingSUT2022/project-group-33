package Controller;

import Model.MatchingStrings;
import Model.Player;
import Model.UserInput;
import View.MiniMapView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;

public class MiniMapController {
    Player player;
    MiniMapView view;





    ////methods////
    public MiniMapController(Player player)
    {
        this.player = player;
        this.view = new MiniMapView();
        view.showMiniMap(player.getMap());

        run();
    }



    private void run()
    {
        while (true){
            String input = UserInput.getInput();
            input = UserInput.removeSpaces(input);

            if (UserInput.doesMatch(input, MatchingStrings.MinimapControllerStrings.SHOW_MAP)){
                view.showMiniMap(player.getMap());
            }
            else if (UserInput.doesMatch(input, MatchingStrings.MinimapControllerStrings.SHOW_MAP_ZOOMED1) ||
                    UserInput.doesMatch(input, MatchingStrings.MinimapControllerStrings.SHOW_MAP_ZOOMED2)){
                showZoomedMap(input);
            }
            else if (UserInput.doesMatchMultipleRegex(input, MatchingStrings.MinimapControllerStrings.SHOW_UNITS.toString(),
                    new ArrayList<>(Arrays.asList(MatchingStrings.MinimapControllerStrings.HEALTH, MatchingStrings.MinimapControllerStrings.MOVE_POINT,
                            MatchingStrings.MinimapControllerStrings.ATTACK_DAMAGE, MatchingStrings.MinimapControllerStrings.DEFENCE)))){
                showUnits(input);
            }
            else if (UserInput.doesMatch(input, MatchingStrings.MinimapControllerStrings.BACK)){
                return;
            }
            else {
                view.showInvalidCommand();
            }
            //TODO:
        }
    }



    private void showZoomedMap(String input)
    {
        String startingPointString = UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.MinimapControllerStrings.STARTING_POINT);
        String endingPointString = UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.MinimapControllerStrings.ENDING_POINT);
        int startingPoint = Integer.parseInt(startingPointString.split(" ")[1]);
        int endingPoint = Integer.parseInt(endingPointString.split(" ")[1]);

        if (startingPoint > player.getMap().getMapSize()){
            view.showValueOutOfBoundaries(startingPoint, player.getMap().getMapSize(), "Starting Point");
        }
        else if (endingPoint > player.getMap().getMapSize()){
            view.showValueOutOfBoundaries(endingPoint, player.getMap().getMapSize(), "Ending Point");
        }
        else {
            if (startingPoint % 2 != 0){
                startingPoint--;
            }

            view.showMiniMapZoomed(player.getMap(), startingPoint, endingPoint);
        }
    }



    private void showUnits(String input)
    {
        String unitType = UserInput.getMatchingStringGroupFromInput(input, MatchingStrings.MinimapControllerStrings.UNIT_TYPE);
        unitType = unitType.split(" ")[1];

        boolean healthFlag = MatchingStrings.MinimapControllerStrings.HEALTH.matcher(input).find();
        boolean movePointFlag = MatchingStrings.MinimapControllerStrings.MOVE_POINT.matcher(input).find();
        boolean attackDamageFlag = MatchingStrings.MinimapControllerStrings.ATTACK_DAMAGE.matcher(input).find();
        boolean defenceFlag = MatchingStrings.MinimapControllerStrings.DEFENCE.matcher(input).find();

        if ((defenceFlag || attackDamageFlag) && (unitType.equals("worker") || unitType.equals("settler"))){
            view.showInvalidUnitFlag(unitType);
            return;
        }

        if (unitType.equals("worker")) {
            view.showNormalUnits(player.getPlayerUnits().getWorkers(), healthFlag, movePointFlag);
        }
        else if (unitType.equals("settler")){
            view.showNormalUnits(player.getPlayerUnits().getSettlers(), healthFlag, movePointFlag);
        }
        else {
            view.showMilitaryUnits(player.getPlayerUnits().getMeleeMilitaryUnits(), healthFlag, movePointFlag, attackDamageFlag, defenceFlag);
            view.showMilitaryUnits(player.getPlayerUnits().getRangedMilitaryUnits(), healthFlag, movePointFlag, attackDamageFlag, defenceFlag);
            view.showMilitaryUnits(player.getPlayerUnits().getHeavyRangedUnits(), healthFlag, movePointFlag, attackDamageFlag, defenceFlag);
        }
    }

}
