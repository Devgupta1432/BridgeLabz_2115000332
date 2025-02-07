
class Order {
    protected int orderId;
    protected String orderDate;

    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }
}

class ShippedOrder extends Order {
    private String trackingNumber;

    public ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);        this.trackingNumber = trackingNumber;
    }

    
    public String getOrderStatus() {
        return "Order shipped with tracking number: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate + " with tracking number: " + super.trackingNumber;
    }
}

public class OrderQ {
    public static void main(String[] args) {
        Order order = new Order(101, "2025-02-01");
        ShippedOrder shippedOrder = new ShippedOrder(102, "2025-02-02", "TRACK1234");
        DeliveredOrder deliveredOrder = new DeliveredOrder(103, "2025-02-03", "TRACK5678", "2025-02-05");

        System.out.println(order.getOrderStatus());
        System.out.println(shippedOrder.getOrderStatus());
        System.out.println(deliveredOrder.getOrderStatus());
    }
}
