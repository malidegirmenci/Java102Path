import Characters.Player;
import Locations.BattleAreas.Downhang;
import Locations.BattleAreas.Dungeons;
import Locations.BattleAreas.Jangan;
import Locations.BattleAreas.Taklamakan;
import Locations.City.Blacksmith;
import Locations.City.Home;
import Locations.Location;
import java.util.Scanner;

public class Game {
    private final Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Silkroad Online");
        String dbUsername = "malidegirmenci";
        String dbPassword = "pol23spebo";
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        while(true){
            if(!(dbUsername.equals(username) && dbPassword.equals(password))){
                System.out.println("Invalid information. Please try again!");
                System.out.print("Username: ");
                username = input.nextLine();
                System.out.print("Password: ");
                password = input.nextLine();
            }else {
                break;
            }
        }
        System.out.print("Who are you novice? I'm ");
        String nickName = input.nextLine();
        Player player = new Player(nickName);

        System.out.println("Welcome to Silkroad World, " + player.getName() + "!");
        System.out.println("""
                What do you want to be?
                (1) The Warrior is a like Mountain! | Attack:+   Defence:+++ Dodge:+
                (2) The Archer is a like Hawk!      | Attack:++  Defence:+   Dodge:+++
                (3) The Mage is a like Owl!         | Attack:+++ Defence:+   Dodge:+
                """);
        System.out.print("Do you want to see detail of characters? (Y/N) : ");
        String seeDetail = input.nextLine().toUpperCase();
        while (true) {
            if (seeDetail.equals("Y")) {
                player.detailCharList();
                player.selectChar();
                break;
            } else if (seeDetail.equals("N")) {
                player.selectChar();
                break;
            } else {
                System.out.println("Invalid entry!");
                System.out.println("Do you want to see detail of characters? (Y/N)");
                seeDetail = input.nextLine().toUpperCase();
            }
        }
        Location location = null;
        while (true) {
            System.out.println("Areas");
            System.out.println("""
                    1- Home
                    2- Blacksmith
                    3- Jangan
                    4- Downhang
                    5- Taklamakan
                    6- Dungeons
                    0- Quit
                    Where do you want to go?
                    """);
            System.out.print("I want to go ... ");
            String selectArea = input.nextLine();

            switch (selectArea) {
                case "0" -> System.exit(0);
                case "1" -> {
                    player.printInfo();
                    location = new Home(player);
                }
                case "2" -> {
                    player.printInfo();
                    location = new Blacksmith(player);
                }
                case "3" -> {
                    if (Jangan.isCompletedLoc()) {
                        noEntry();
                        continue;
                    } else {
                        location = new Jangan(player);
                    }
                }
                case "4" -> {
                    if (Downhang.isCompletedLoc()) {
                        noEntry();
                        continue;
                    } else {
                        location = new Downhang(player);
                    }
                }
                case "5" -> {
                    if (Taklamakan.isCompletedLoc()) {
                        noEntry();
                        continue;
                    } else {
                        location = new Taklamakan(player);
                    }
                }
                case "6" -> location = new Dungeons(player);
                default -> {
                    System.out.println("##########################################");
                    System.out.println("You don't know what you do? C'mon choose one!");
                    System.out.println("##########################################");
                    continue;
                }
            }
            if (!location.onLocation()) {
                System.out.println("THE END!");
                break;
            }
        }
    }

    public void noEntry() {
        System.out.println();
        System.out.println("##########################################");
        System.out.println("You can not entry again in here!");
        System.out.println("##########################################");
        System.out.println();
    }
}
