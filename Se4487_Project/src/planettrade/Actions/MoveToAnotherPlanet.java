package planettrade.Actions;

import planettrade.Classes.Galaxy;
import planettrade.Classes.Gamers;
import planettrade.Classes.Planet;
import project.gameengine.base.Action;

import java.util.List;
import java.util.Scanner;

public class MoveToAnotherPlanet implements Action {

    private Scanner scanner = new Scanner(System.in);
    Planet planet;

    private void displayPlanets(List<Planet> planetList) {
        planetList.forEach(System.out::println);
    }

    public MoveToAnotherPlanet(Gamers gamers, List<Planet> planetList) {
        planet = gamers.getCurrentPlanet();
        int cost = 0;

        System.out.println("Which Planet Would You Want To Go!");
        displayPlanets(planetList);
        int input = scanner.nextInt();

        System.out.println("Your Planet: " + planet.getName() + " -- Target Planet: Planet" + input);

        int distance;
        distance = (planet.getDistance() - planetList.get(input-1).getDistance());
        if (distance < 0)
        {
            distance *= -1;
        }

        if (gamers.getSpaceship().getCurrentFuel() <
                (distance * gamers.getSpaceship().getFuelUsagePerDistance()))
        {
            System.out.println("You Don't Have Enough Fuel To Make It");
            gamers.setCurrentMoney((int) (gamers.getCurrentMoney() - gamers.getCurrentPlanet().getParkingPrice()));
        }
        else
        {
            cost += planet.getDistance() * gamers.getSpaceship().getFuelUsagePerDistance();
            System.out.println("You Spend " + cost + " Liters Of Fuel");
            gamers.setCurrentPlanet(planetList.get(input-1));
            gamers.getSpaceship().setCurrentFuel(gamers.getSpaceship().getCurrentFuel()-cost);
        }
    }

    @Override
    public String toString() {
        return planet.toString();
    }
}
