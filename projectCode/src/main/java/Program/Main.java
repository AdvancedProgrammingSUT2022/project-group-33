package Program;

import Program.View.LoginMenuView;
import Program.View.MainMenuView;
import Program.View.MenuSoundPlayer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args)
    {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setResizable(false);
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        MenuSoundPlayer menuSoundPlayer = new MenuSoundPlayer();
        LoginMenuView loginMenuView = new LoginMenuView(stage);
    }
}
