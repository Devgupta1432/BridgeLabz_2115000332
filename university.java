public class university {
    public static void main(String[] args) {
        double fee = 125000;
        double discountPercent = 10;
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
        System.out.printf(
            "The discount amount is INR %.2f and the final discounted fee is INR %.2f",
            discount, finalFee
        );
    }
}
