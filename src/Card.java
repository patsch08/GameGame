/**
 * The Card class represents a playing card in GameGame.
 * Each card has a numerical value and an associated animal name.
 */
public class Card {
    //numerical value of the card
    int value = 0;
    //the animal it represents
    String animal = "";
    /**
     * Constructs a new Card object with the specified value.
     * 
     * @param value The numerical value of the card. Valid values are 10, 40, 90, 160, 250,
     *              350, 500, 650, 800, and 1000.
     * @throws IllegalArgumentException if an invalid value is provided.
     */
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
    
    /**
     * Gets the numerical value of the card.
     * 
     * @return The numerical value of the card.
     */
    public int getValue() {return this.value;}
    /**
    * Gets the represented animal.
    * 
    * @return The represented animal.
    */
    public String getAnimal(){
        return this.animal;
    }
}
