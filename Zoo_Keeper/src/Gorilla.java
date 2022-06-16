public class Gorilla extends Mammal {

    public void throwSomething() {
        System.out.println("Gorilla has thrown something.");
        this.setEnergyLevel(this.getEnergyLevel() - 5);
    }

    public void eatBananas() {
        System.out.println("Gorilla ate a banana!");
        this.setEnergyLevel(this.getEnergyLevel() + 10);
    }

    public void climb() {
        System.out.println("Gorilla has climbed a tree.");
        this.setEnergyLevel(this.getEnergyLevel() - 10);
    }
}
