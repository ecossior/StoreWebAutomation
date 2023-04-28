package entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private String email;
    private String password;
    private String title;
    private String day;
    private String month;
    private String year;
    private String newsletter;
    private String receiveoOffers;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String address2;
    private String country;
    private String state;
    private String city;
    private String zipcode;
    private String mobileNumber;

    public User() {
    }

    public User(String title, String password, String day, String month, String year, String newsletter, String receiveoOffers, String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipcode, String mobileNumber) {
        this.title = title;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.newsletter = newsletter;
        this.receiveoOffers = receiveoOffers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address = address;
        this.address2 = address2;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.mobileNumber = mobileNumber;
    }
}
