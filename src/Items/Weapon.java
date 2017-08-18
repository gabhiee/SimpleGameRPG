package Items;

import java.util.Random;

public class Weapon extends Item{

    String[] itemNamesPrefix = {"Fine", "Rusted", "Fluffy", "Magic", "Normal", "Shiny", "Broken", "Great"};
    String[] itemNameSuffix = {"Sword", "Axe", "Bow", "Dagger"};


    public Weapon(){
        setName(nameGenerator());
        setDamage(((random.nextInt(10))+ 5)*(day));
        setPrice(getDamage()*2);
        setWeight(random.nextInt(10));
    }

    public String nameGenerator(){
        String pre = itemNamesPrefix[random.nextInt(itemNamesPrefix.length-1)]; //generuje prefix
        String suf = itemNameSuffix[random.nextInt(itemNameSuffix.length-1)]; // generuje suffix
        return pre + " " + suf; //mozna zapisac w jednej lini ale jest widoczniej bardziej
    }


}
