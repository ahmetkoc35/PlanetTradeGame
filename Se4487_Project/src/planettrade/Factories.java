package planettrade;

import planettrade.Classes.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Factories {

    private static List<String> commodities = Arrays.asList(
            "Wheat", "Corn", "Soybeans", "Rice", "Oats", "Barley", "Rye",
            "Cotton", "Sugar", "Coffee", "Cocoa", "Tea", "Palm oil",
            "Canola oil", "Sunflower oil", "Olive oil", "Soybean oil",
            "Rapeseed oil", "Peanut oil", "Coconut oil", "Beef", "Pork",
            "Chicken", "Lamb", "Fish", "Shrimp", "Lobster", "Aluminum",
            "Copper", "Gold", "Silver", "Platinum", "Palladium", "Nickel",
            "Lead", "Zinc", "Tin", "Iron ore", "Coal", "Natural gas",
            "Crude oil", "Petroleum", "Propane", "Ethanol", "Uranium",
            "Cement", "Lumber", "Natural rubber", "Cotton yarn", "Wool",
            "Cottonseed", "Cottonseed oil", "Cottonseed meal", "Orange juice",
            "Lemon juice", "Apple juice", "Grape juice", "Pineapple juice",
            "Tomato juice", "Carrot juice", "Cranberry juice", "Coconut water",
            "Milk", "Cheese", "Butter", "Yogurt", "Ice cream", "Eggs",
            "Honey", "Maple syrup", "Bread", "Rice noodles", "Wheat flour",
            "Rice flour", "Corn flour", "Potatoes", "Onions", "Carrots",
            "Lettuce", "Cabbage", "Broccoli", "Cauliflower", "Tomatoes",
            "Cucumbers", "Bell peppers", "Spinach", "Kale", "Garlic",
            "Ginger", "Chili peppers", "Bananas", "Apples", "Oranges",
            "Lemons", "Grapes", "Strawberries", "Blueberries", "Raspberries",
            "Blackberries", "Pineapples", "Watermelons", "Mangoes", "Papayas",
            "Avocados", "Pears", "Peaches", "Plums", "Cherries", "Dates",
            "Almonds", "Walnuts", "Pistachios", "Cashews", "Hazelnuts",
            "Brazil nuts", "Macadamia nuts", "Sesame seeds", "Flaxseeds",
            "Chia seeds", "Quinoa", "Sorghum", "Hemp", "Lentils",
            "Chickpeas", "Black beans", "Kidney beans", "Pinto beans",
            "Navy beans", "Lima beans", "Peas", "Mung beans", "Adzuki beans"
    );

    private static int getSecureRandomNumber()
    {
        Random rand = new SecureRandom();
        var result = rand.nextInt(10);

        return result;
    }

    private static int getRandomNumber(int lower, int upper)
    {
        Random rand = new Random();
        var result = rand.nextInt(upper - lower) + lower;

        return result;
    }

    public static List<Spaceship> spaceshipFactory(int playerCount)
    {
        List<Spaceship> spaceshipList = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            Spaceship spaceship = new Spaceship("GalaxyConqueror" + (getSecureRandomNumber()),
                    getRandomNumber(1500000, 2500000), commodityFactory(),
                    getRandomNumber(300, 500), getRandomNumber(800, 1200),
                    getRandomNumber(10000, 15000), getRandomNumber(18000, 22000),
                    getRandomNumber(20, 100));
            spaceshipList.add(spaceship);
        }
        return spaceshipList;
    }

    private static List<Commodity> commodityFactory()
    {
        List<Commodity> commodityList = new ArrayList<>();

        int count = getRandomNumber(20, 50);

        for (int i = 0; i < count; ++i)
            commodityList.add(new Commodity(commodities.get(getRandomNumber(0, commodities.size())),
                    getRandomNumber(0, 15), 0.5));

        return commodityList;
    }

    private static Market marketFactory()
    {
        var market = new Market(getRandomNumber(150,200),getRandomNumber(50,70),
                getRandomNumber(80,100), commodityFactory());
        return market;
    }

    public static List<Planet> planetFactory()
    {
        List<Planet> planetList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Planet planet = new Planet("Planet" + (i+1),marketFactory(),getRandomNumber(300,500),
                    getRandomNumber(100,150), getRandomNumber(10,100));
            planet.setMarket(marketFactory());
            planetList.add(planet);
        }

        return planetList;
    }


}
