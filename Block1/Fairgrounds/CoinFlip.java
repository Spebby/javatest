package Fairgrounds;
import java.util.Scanner;

public class CoinFlip
{
    Scanner scan = new Scanner(System.in);
    String c;
    
    public void Initialize()
    {
        System.out.print('\f');
        
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
        c = scan.nextLine();

        System.out.println();
        CFLogic(c);
    }

    void CFLogic(String c)
    {
        int flip = (int)((Math.random() * 100) + 1); // Trying to make a sudo percentage thing.

        if(flip >= 49)
        {
            System.out.print("The coin lands on its head, ");
            if(c.toLowerCase().charAt(0) == 'h')
                System.out.print("you guessed so! A win!");
            else
                System.out.print("you guessed not! A loss!");
        }
        else if (flip <= 50 && flip != 100)
        {
            System.out.print("The coin lands on its tail, ");
            if(c.toLowerCase().charAt(0) == 't')
                System.out.print("you guessed so! A win!");
            else
                System.out.print("you guessed not! A loss!");
        }

        else
            System.out.println("The coin landed on it's side! Remarkable!");
        
        System.out.println();
        System.out.println("Would you like to play again or choose another game?");
        System.out.println("Enter \"Yes\" to play again and \"No\"  to choose another game. To quit, type anything else");
        String input = scan.nextLine();

        System.out.println();

        DriverFeeder df = new DriverFeeder();
        
        if(input.toLowerCase().charAt(0) == 'y')
                Initialize();
        else if(input.toLowerCase().charAt(0) == 'n')
        {
            df.main(true);
            df = null;
        }
        else
        {
            df.QuitGame();
            df = null;
        }
    }
}