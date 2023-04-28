package entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
    private String name;
    private String cardNumber;
    private String CVC;
    private String month;
    private String year;
    public Card(String name, String cardNumber, String CVC, String month, String year) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.CVC = CVC;
        this.month = month;
        this.year = year;
    }

    public Card() {
    }
}
