package planettrade;

import planettrade.Classes.*;
import project.gameengine.BasicConsolRenderer;
import project.gameengine.TurnBasedGameEngine;
import project.gameengine.base.Game;
import project.gameengine.base.GameEngine;
import project.gameengine.base.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static List<Spaceship> spaceships;
    public static List<Planet> planetList;

    private static int pickSpaceship(List<Spaceship> spaceships)
    {
        for (int i = 0; i < spaceships.size(); i++) {
            System.out.println("Number-" + i + " " + spaceships.get(i));
        }
        Scanner pick = new Scanner(System.in);
        System.out.println("Enter The Number Of Your Spaceship\nEnter A Number Between 0-" + (spaceships.size()-1));
        int myShip;

        do {
            myShip = pick.nextInt();
            if (myShip >= spaceships.size())
            {
                System.out.println("You Picked An Unknown Ship!");
                System.exit(0);
            }
            return myShip;
        }
        while (myShip >= 0 && myShip < spaceships.size());
    }
    private static int initialMoney()
    {
        return 3000000;
    }
    private static Gamers createGamers(List<Spaceship> spaceshipList, List<Planet> listOfPlanets)
    {
        Choose choose = new Choose();
        String name = choose.pickName();
        int ss = pickSpaceship(spaceshipList);
        Spaceship spaceship = spaceshipList.get(ss);
        System.out.println("Selected Spaceship: " + spaceship.getName());
        spaceshipList.remove(ss);

        return new Gamers(name,initialMoney()-(spaceship.getBuyPrice()),
                spaceship,
                listOfPlanets.get(planetRandom()));
    }
    private static int planetRandom()
    {
        Random r = new Random();
        int a = r.nextInt(10);
        return a;
    }
    public static void main(String[] args) {

        Game planetTradeGame = new PlanetTradeGame(50);
        GameEngine gameEngine = new TurnBasedGameEngine(planetTradeGame, new BasicConsolRenderer());
        planetList = Factories.planetFactory();

        Choose choose = new Choose();

        int playerCount = choose.playerCount();

        spaceships = Factories.spaceshipFactory(playerCount);


        for (int i = 0; i < playerCount; i++) {
            Gamers g = createGamers(spaceships,planetList);
            gameEngine.addPlayer(g);
        }
        System.out.println("\n");
        gameEngine.playARound();



    }
}
