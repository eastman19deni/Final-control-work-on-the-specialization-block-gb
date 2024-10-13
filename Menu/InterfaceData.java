package Menu;

import Animals.BaseAnimal;
import Animals.PackAnimals.Camel;
import Animals.PackAnimals.Donkey;
import Animals.PackAnimals.Horse;
import Animals.Pets.Cat;
import Animals.Pets.Dog;
import Animals.Pets.Humster;

import java.util.*;


public class InterfaceData extends AnimalIndex {
    private final AnimalIndex index;
    private final Map<Integer, BaseAnimal> animals;

    public InterfaceData() {
        this.index = new AnimalIndex();
        this.animals = new HashMap<Integer, BaseAnimal>();
    }


    /**
     * @return "Метод возвращает новое животное"
     */
    public void addNewAnimal (BaseAnimal animal){

        StringBuilder stringBuilder = new StringBuilder();
        animals.put(index.getIndex(), animal);
        this.index.upIndex();
    }

    /**
     * @return "Метод возвращает строку со списком всех живтоных в питомнике"
     */
    public StringBuilder showAllAnimals (){
        String dbToString = animals.toString();
        String pureString = dbToString.replace("{", "").replace("}", "").replace(",", "").replace("=", ": ");
        String[] splittedString = pureString.split(" ;");
        StringBuilder resultString = new StringBuilder();
        for (String s : splittedString) {
            resultString.append(s);
            resultString.append("\n");
        }
        resultString.append("\n");
        return resultString;
    }

    /**
     * @return "Метод возвращает строку с информацией о всех командах живтоного"
     */
    public String showCommands() {
        System.out.println("\nКоманды какого питомца вы хотите узнать?\n" +
                "Введите порядковый номер питомца: ");
        Scanner scan = new Scanner(System.in);
        BaseAnimal animal = animals.get(Integer.parseInt(scan.nextLine()));
        return "Команды, которые умеет выполнять " + animal.getName() + " : " + animal.getCommands();
    }

    /**
     * @return "Метод обучает животное новым командам"
     */
    public void learnAnimal() {
        System.out.println("\nКакого питомца вы хотите обучить?\n" +
                "Введите порядковый номер питомца: ");
        Scanner scan = new Scanner(System.in);
        BaseAnimal animal = animals.get(Integer.parseInt(scan.nextLine()));
        System.out.println("Введите команду, которую вы хотите добавить: ");
        String command = scan.nextLine();
        animal.setCommands(command);
        System.out.println("Команда успешно добавлена!" +
                "Теперь у " + animal.getName() + " есть команды: " + animal.getCommands());
    }

    /**
     * @return "Метод возвращает индекс последнего добавленного животного"
     */
    public int getAnimalsCount() {
        return index.getIndex() - 1;
    }


    /**
     * @return "Метод выводит на принт список животных одного года рождения"
     */
    public void showAnimalsSortedByBirthYear() {

        System.out.println("\nДля поиска животных по году рождения введите год: ");
        Scanner scan = new Scanner(System.in);
        String year = scan.nextLine();

        Set<BaseAnimal> sortedAnimals = new HashSet<BaseAnimal>();
        for (Map.Entry<Integer, BaseAnimal> animal : animals.entrySet()) {
            if (animal.getValue().getBirthDay().toString().contains(year)) {
                sortedAnimals.add(animal.getValue());
            }
                continue;
        }
        if (sortedAnimals.isEmpty()) {
            System.out.println("К сожалению, животных этого года рождения в базе данных нет");
        }else {
            for (BaseAnimal animal : sortedAnimals) {
                System.out.println(animal.getType() + " по кличке: " + animal.getName() + ", " + " год рождения: " + animal.getYear());
            }
        }
    }

    /**
     * @return "Метод создает базу данных животных"
     */
    public Map<Integer, BaseAnimal> animalDBCreator (){
        BaseAnimal animal1 = new Cat("Whiskers", "Cat", 2019, 5, 15, "Sit, Pounce");
        BaseAnimal animal2 = new Dog("Fido", "Dog", 2020, 1, 1, "Stay, Sit, Fetch");
        BaseAnimal animal3 = new Humster("Hummy", "Humster", 2021, 3, 10, "Roll, Hide");
        BaseAnimal animal8 = new Dog("Buddy", "Dog", 2018, 12, 10, "Sit, Paw, Bark");
        BaseAnimal animal9 = new Cat("Smudge", "Cat", 2020, 2, 20, "Sit, Pounce, Scratch");
        BaseAnimal animal10 = new Humster("Peanut", "Humster", 2021, 8, 1, "Roll, Spin");
        BaseAnimal animal11 = new Dog("Bella", "Dog", 2019, 11, 11, "Sit, Stay, Roll");
        BaseAnimal animal12 = new Cat("Oliver", "Cat", 2020, 6, 30, "Meow, Scratch, Jump");


        BaseAnimal animal4 = new Camel("Sandy", "Camel", 2016, 11, 3, "Walk, Carry, Load");
        BaseAnimal animal5 = new Donkey("Eeyore", "Donkey", 2017, 9, 18, "Walk, Carry, Load, Bray");
        BaseAnimal animal6 = new Horse("Thunder", "Horse", 2015, 7, 21, "Trot, Canter, Gallop");
        BaseAnimal animal7 = new Horse("Strom", "Horse", 2014, 5, 5, "Trot, Canter");
        BaseAnimal animal13 = new Camel("Dune", "Camel", 2018, 12, 12, "Walk, Sit");
        BaseAnimal animal14 = new Donkey("Burro", "Dokey", 2019, 1, 23, "Walk, Bray, Kick");
        BaseAnimal animal15 = new Horse("Blaze", "Horse", 2016, 2, 29, "Trot, Jump, Gallop");
        BaseAnimal animal16 = new Camel("Sahara", "Camel", 2015, 8, 14, "Walk, Run");

        animals.put(index.getIndex(), animal1);
        index.upIndex();
        animals.put(index.getIndex(), animal2);
        index.upIndex();
        animals.put(index.getIndex(), animal3);
        index.upIndex();
        animals.put(index.getIndex(), animal4);
        index.upIndex();
        animals.put(index.getIndex(), animal5);
        index.upIndex();
        animals.put(index.getIndex(), animal6);
        index.upIndex();
        animals.put(index.getIndex(), animal7);
        index.upIndex();
        animals.put(index.getIndex(), animal8);
        index.upIndex();
        animals.put(index.getIndex(), animal9);
        index.upIndex();
        animals.put(index.getIndex(), animal10);
        index.upIndex();
        animals.put(index.getIndex(), animal11);
        index.upIndex();
        animals.put(index.getIndex(), animal12);
        index.upIndex();
        animals.put(index.getIndex(), animal13);
        index.upIndex();
        animals.put(index.getIndex(), animal14);
        index.upIndex();
        animals.put(index.getIndex(), animal15);
        index.upIndex();
        animals.put(index.getIndex(), animal16);
        index.upIndex();

        return animals;
    }
}
