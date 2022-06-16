public class Bat extends Mammal {

    //constructor for Bat
    public Bat(){
        this.setEnergyLevel(300); //default energy for the bat
    }

    public void fly() {
        System.out.println("Bat is flying!");
        this.setEnergyLevel(this.getEnergyLevel() - 50);
    }

    public void eatHumans() {
        System.out.println("Bat is eating humans.");
        this.setEnergyLevel(this.getEnergyLevel() + 25);
    }

    public void attackTown() {
        System.out.println("Bat is attacking a town!");
        this.setEnergyLevel(this.getEnergyLevel() - 100);
    }




}
