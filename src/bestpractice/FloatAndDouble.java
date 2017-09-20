package bestpractice;

public class FloatAndDouble {
    public static void main(String[] args) {
//        System.out.println(1.03 - .42);
//        System.out.println(1.00 - 9 * .10);

//        double funds = 1.00;
//        int itemsBought = 0;
//        for (double price = .10; funds >= price; price += .10) {
//            funds -= price;
//            itemsBought++;
//        }
//        System.out.println(itemsBought + " items bought.");
//        System.out.println("Change: $" + funds);

//        final BigDecimal TEN_CENTS = new BigDecimal( ".10");
//        int itemsBought = 0;
//        BigDecimal funds = new BigDecimal("1.00");
//        for (BigDecimal price = TEN_CENTS;
//             funds.compareTo(price) >= 0;
//             price = price.add(TEN_CENTS)) {
//            itemsBought++;
//            funds = funds.subtract(price);
//        }
//        System.out.println(itemsBought + " items bought.");

        int itemsBought = 0;
        int funds = 100;
        for (int price = 10; funds >= price; price += 10) {
            itemsBought++;
            funds -= price;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Money left over: "+ funds + " cents");
    }
}
