package menuControl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);
    static Integer userIdCounter = 0;

    public void printMenu(){ // Proste menu
        System.out.println("1 - Stwórz nową postać");
        System.out.println("2 - Wybierz już istniejącą postać");
        System.out.println("0 - Zakończ grę");
    }
    public void chooseMenuOption(){ //Metoda do wybierania opcji z menu
        int menuChoice = 0;
        do {
            try {
                menuChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawny wybór");
                continue;
            }
            if (menuChoice == 1) {
                createNewCharacter();
                //tu będdzie metoda do tworzenia nowej postaci
            } else if (menuChoice == 2) {
                chooseYourCharacter();
                //tu będzie metoda do wczytywania nowej postaci
            } else if (menuChoice == 0) {
                System.out.println("Koniec gry");
                break;
            }
        }while(true);
    }

    public void createNewCharacter() { //Metoda służy do tworzenia nowej postaci
        System.out.println("Wprowadź nazwę swojej postaci");
        String characterName = scanner.nextLine();
        System.out.println("Wybierz klasę swojej postaci: ");
        System.out.println("1 - Mag");
        System.out.println("2 - Wojownik");
        System.out.println("3 - Elf");
        System.out.println("0 - Cofnij do menu głównego");
        int chooseCharacterFromMenu = 0;
        do {
            try {
                chooseCharacterFromMenu = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawny wybór z menu");
                continue;
            }
            break;
        } while (true);
        String choosenCharacter = null;
        if (chooseCharacterFromMenu == 1) {
            choosenCharacter = "Mag";
        } else if (chooseCharacterFromMenu == 2){
            choosenCharacter = "Wojownik";
        } else if (chooseCharacterFromMenu == 3) {
            choosenCharacter = "Elf";
        } else if (chooseCharacterFromMenu == 0) {
            printMenu();
            chooseMenuOption();
        }

        String saveToFileData = userIdCounter.toString() +";"+choosenCharacter +";"+ characterName + "\n";
        userIdCounter++;
        System.out.println(saveToFileData);

        File characters = new File("C:" + File.separator + "pliki_tekstowe" + File.separator + "characters.txt");
        try {
            Files.write((Paths.get("C:" + File.separator + "pliki_tekstowe" + File.separator + "characters.txt")),saveToFileData.getBytes(),StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        openGameMenu();
    }
    public void chooseYourCharacter(){ // Metoda służy wypisania stworzonych
        File characters = new File("C:" + File.separator + "pliki_tekstowe" + File.separator + "characters.txt");//tu trzeba zmienić path w razie błędów
        if(characters.length()==0) {
            System.out.println("Brak zapisanych postaci - utwórz nową postać");
            createNewCharacter();
        } else {
            //System.out.println("");
        }
    }

    public void openGameMenu(){
        System.out.println("Wybierz akcje:");
        System.out.println("1 - Idź do mapy1");
        System.out.println("2 - Idź do mapy2");
        System.out.println("3 - Idź do tawerny");
//        System.out.println("Wybierz akcje:");



    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        System.out.println("Witaj! ");
        menu.printMenu();
        menu.chooseMenuOption();
    }
}
