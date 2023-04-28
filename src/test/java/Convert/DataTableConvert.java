package Convert;

import entity.Card;
import entity.Order;
import java.util.Map;

public class DataTableConvert {
    public static  Card convertToCard( Map<String,String> entry) {
        String name = entry.get("name");
        String cardNumber = entry.get("cardNumber");
        String CVC = entry.get("CVC");
        String month = entry.get("month");
        String year = entry.get("year");
        return new Card(name,  cardNumber, CVC,  month, year);
    }
    public static Order convertToOrder(Map<String,String> entry) {
        String category = entry.get("category");
        String type = entry.get("type");
        String name = entry.get("name");
        String quantity = entry.get("quantity");
        return new Order(category,  type, name,  quantity);
    }
}
