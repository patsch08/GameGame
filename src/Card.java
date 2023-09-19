public class Card {
    int value = 0;
    String animal = "";

    public Card(int value) {
        switch(value){
            case 10:
                this.animal = "Cock";
                break;
            case 40:
                this.animal = "Goose";
                break;
            case 90:
                this.animal = "Cat";
                break;
            case 160:
                this.animal = "Dog";
                break;
            case 250:
                this.animal = "Sheep";
                break;
            case 350:
                this.animal = "Goat";
                break;
            case 500:
                this.animal = "Donkey";
                break;
            case 650:
                this.animal = "Pig";
                break;
            case 800:
                this.animal = "Cow";
                break;
            case 1000:
                this.animal = "Horse";
                break;
            default:
                throw new IllegalArgumentException();
        }
        this.value = value;
    }
    public int getValue() {return this.value;}
    public String getAnimal(){
        return this.animal;
    }
}
