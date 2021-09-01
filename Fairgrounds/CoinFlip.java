import java.util.Scanner;

public class CoinFlip
{
    Scanner scan = new Scanner(System.in);

    public void Initialize()
    {
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("      ::::::::   :::::::: ::::::::::: ::::    :::          :::::::::: :::        ::::::::::: :::::::::");
        System.out.println("    :+:    :+: :+:    :+:    :+:     :+:+:   :+:          :+:        :+:            :+:     :+:    :+:");
        System.out.println("   +:+        +:+    +:+    +:+     :+:+:+  +:+          +:+        +:+            +:+     +:+    +:+");
        System.out.println("  +#+        +#+    +:+    +#+     +#+ +:+ +#+          :#::+::#   +#+            +#+     +#++:++#+");
        System.out.println(" +#+        +#+    +#+    +#+     +#+  +#+#+#          +#+        +#+            +#+     +#+");
        System.out.println("#+#    #+# #+#    #+#    #+#     #+#   #+#+#          #+#        #+#            #+#     #+#");
        System.out.println("########   ######## ########### ###    ####          ###        ########## ########### ###");
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("Welcome to Flip a Coin!");
        System.out.println("To get started, guess the result of the flip.");
        String c = scan.nextLine();

        System.out.println();
        CFLogic(c);
    }

    void CFLogic(String c)
    {
        int flip = (int)((Math.random() * 100) + 1); // Trying to make a sudo percentage thing.

        if(flip >= 49)
        {
            System.out.print("The coin lands on its head, ");
            if(c == "Heads" || c == "H")
                System.out.print("you guessed so! A win!");
            else
                System.out.print("you guessed not! A loss!");
        }
        else if (flip <= 50 && flip != 100)
        {
            System.out.print("The coin lands on its tail, ");
            if(c == "Tails" || c == "T")
                System.out.print("you guessed so! A win!");
            else
                System.out.print("you guessed not! A loss!");
        }

        else
            System.out.println("The coin landed on it's side! Remarkable!");
        
        System.out.println();
        System.out.println("Would you like to play again or choose another game?");
        System.out.println("Enter \"Yes\" to play again and No to choose another game. To quit, type anything else");
        c = scan.nextLine(); // Reusing variable
        scan = null;

        System.out.println();

        DriverFeeder df = new DriverFeeder();
        switch(c)
        {
            case "Yes":
            case "Y":
            case "y":
                Initialize();
                break;
            case "No":
            case "N":
            case "n":
                df.main(true);
                df = null;
                break;
            default:
                df.QuitGame();
                df = null;
                break;
        }

        c = null;
    }
}