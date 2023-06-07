package planettrade;

import java.util.Scanner;

public class Choose {

    String pickName()
    {
        Scanner pick = new Scanner(System.in);
        System.out.println("Enter Your Name");
        String myName = pick.nextLine();
        return String.valueOf(myName);
    }

    int playerCount()
    {
        Scanner pick = new Scanner(System.in);
        System.out.println("How Many Players There Will Be?");
        var myCount = pick.nextInt();
        return myCount;
    }

    public static int choseAction()
    {
        Scanner pick = new Scanner(System.in);
        var myCount = pick.nextInt();
        return myCount;
    }

    public static int choseCommodity()
    {
        Scanner pick = new Scanner(System.in);
        var myCount = pick.nextInt();
        return myCount;
    }


}
