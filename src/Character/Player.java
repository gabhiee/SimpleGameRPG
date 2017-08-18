package Character;

import Items.Item;
import menuControl.Menu;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private int hp;
    private int mana;
    private int strength;
    private int defence;
    private int experience;
    private int capacity;//udźwig
    private int characterLevel;
    private int expToLevel;
    private List<Item> ekwipunek;

    public Player(int hp, int mana, int strength, int defence, List<Item> ekwipunek) {
        this.hp = hp;
        this.mana = mana;
        this.strength = strength;
        this.defence = defence;
        this.capacity = strength;
        this.ekwipunek = ekwipunek;
    }
    /*
    metoda do startowego ekwipunku
     */

    public void makeAttack(int strength){//zaatakuj
        //this.strength
    }
    public void receiveDamage(int hp){//dostaje od monstera
        this.hp -= hp;
    }

    public void castASpell(int mana){//rzuć zaklęcie
        this.mana -= mana;
    }

    public void healHp(int hp){
        this.hp += hp;
    }

//    public boolean canPickUpItem(){
//        return pickUpTheItem() < capacity;
//    }

    public int pickUpTheItem(Item i) {
        ekwipunek.add(i);
        //uzupelnic sprawdzanie warunkow czy mozemy podniesc przedmiot
    }

    public void showEq(){
        for (Item item : ekwipunek) {
            System.out.println(item);
        }
        //zrobic metode do wyswietlenia ekwipunku + null
    }
    public void dropEq(){
        int command;
        for (int i = 0; i <ekwipunek.size(); i++){
            System.out.println(i+ ". " + ekwipunek.get(i);
        } System.out.println("Wskaż, który usunąć:");
        command = Integer.parseInt(Menu.scanner.nextLine());
        ekwipunek.remove(command);
    }

    public void addExp(int experience){//dodaj doświadczenie
        this.experience += experience;
        checkIfLevelUp();
    }

    private void checkIfLevelUp(){//zmiana poziomu
        if (experience >= expToLevel){
            characterLevel++;
            experience = 0;
            expToLevel = experience + experience*characterLevel;
            System.out.println("Zmieniłeś poziom!");
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(int characterLevel) {
        this.characterLevel = characterLevel;
    }

    public int getExpToLevel() {
        return expToLevel;
    }

    public void setExpToLevel(int expToLevel) {
        this.expToLevel = expToLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (hp != player.hp) return false;
        if (mana != player.mana) return false;
        if (strength != player.strength) return false;
        if (defence != player.defence) return false;
        if (experience != player.experience) return false;
        if (capacity != player.capacity) return false;
        if (characterLevel != player.characterLevel) return false;
        return expToLevel == player.expToLevel;
    }

    @Override
    public int hashCode() {
        int result = hp;
        result = 31 * result + mana;
        result = 31 * result + strength;
        result = 31 * result + defence;
        result = 31 * result + experience;
        result = 31 * result + capacity;
        result = 31 * result + characterLevel;
        result = 31 * result + expToLevel;
        return result;
    }
}
