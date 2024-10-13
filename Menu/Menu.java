package Menu;

import Animals.BaseAnimal;
import Animals.PackAnimals.Camel;
import Animals.PackAnimals.Donkey;
import Animals.PackAnimals.Horse;
import Animals.Pets.Cat;
import Animals.Pets.Dog;
import Animals.Pets.Humster;

import java.util.Scanner;

public class Menu {
    protected InterfaceData data;

    public Menu(){
        this.data = new InterfaceData();
    }

    public void showMenu (){
        System.out.println("\n Реестр домашних живтоных.\n" +
                            "\n Чтобы вы хотели сделать?\n" +
                            "1. Добавить новое житное\n" + 
                            "2. Показать всех животных в питомнике\n" +
                            "3. Узнать сколько всего животных сейчас в питомнике\n" +
                            "4. Обучить животное новым командам\n" + 
                            "5. Вывести список команд животного\n" +
                            "6. Вывести список живтоных по году рождения\n" +
                            "7. Выход");
    }
    public void startMenu () {
        data.animalDBCreator();
        showMenu();
        Scanner scan = new Scanner(System.in);
        boolean work = true;
        while (work) {
            int menuNum = Integer.parseInt(scan.nextLine());

            if (menuNum == 1) {
                data.addNewAnimal(createNewAnimal());
                showMenu();
            } else if (menuNum == 2) {
                System.out.println(data.showAllAnimals().toString());
                showMenu();
            } else if (menuNum == 3) {
                System.out.println("Всего животных в питомнике: " + data.getAnimalsCount());
                showMenu();
            } else if (menuNum == 4) {
                data.learnAnimal();
                showMenu();
            } else if (menuNum == 5) {
                System.out.println(data.showCommands());
                showMenu();
            } else if (menuNum == 6) {
                data.showAnimalsSortedByBirthYear();
                showMenu();
            }else if (menuNum == 7) {
                System.out.println("До новых встреч!");
                work = false;            }
            else {
                System.out.println("Команда не распознана. " +
                        "Выберите один из пунктов меню:\n");
                showMenu();
            }
        }
        scan.close();
    }

    private static BaseAnimal createNewAnimal(){
        System.out.println("To add a new animal, enter the data following the instructions.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the animal type. Choose one of the options:\n1 - Cat\n 2 - Dog\n 3 - Humster" +
                            " 4 - Camel\n 5 - Donkey\n 6 - Horse.");
        String type = scanner.nextLine();
        System.out.println("Enter name of a new animal: \n");
        String name = scanner.nextLine();
        System.out.println("Enter Year of birth of a new animal: \n");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Month of birth of a new animal: \n");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Day of birth of a new animal: \n");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter commands of a new animal separated by commas: \n");
        String commands = scanner.nextLine();

        BaseAnimal newAnimal = switch (type) {
            case "Cat" -> new Cat(name, type, year, month, day, commands);
            case "Dog" -> new Dog(name, type, year, month, day, commands);
            case "Humster" -> new Humster(name, type, year, month, day, commands);
            case "Camel" -> new Camel(name, type, year, month, day, commands);
            case "Donkey" -> new Donkey(name, type, year, month, day, commands);
            case "Horse" -> new Horse(name, type, year, month, day, commands);
            default -> null;
        };
        return newAnimal;
    }
}
