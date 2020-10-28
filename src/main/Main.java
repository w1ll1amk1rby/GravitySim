/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import panes.SolarSystemPane;
import solarSystem.SolarSystem;
import solarSystemCreators.SolarSystemCreator;
import threads.SolarSystemThread;


// @author William Kirby
public class Main extends Application
{
    public static void main(String[] args) 
    {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage)
    {
        SolarSystem ss = SolarSystemCreator.generateSolarSystem(987654321);
        SolarSystemPane pane = new SolarSystemPane(ss);
        SolarSystemThread thread = new SolarSystemThread(ss);
        Scene scene = new Scene(pane,1000,1000);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        thread.start();
    }
}
