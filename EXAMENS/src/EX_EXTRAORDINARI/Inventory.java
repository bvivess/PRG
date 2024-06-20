package EX_EXTRAORDINARI;

public class Inventory {
    private int product_id;
    private int warehouse_id;
    private double quantity_on_hand_old;
    private double quantity_on_hand_new;

    public Inventory(int product_id, int warehouse_id, double quantity_on_hand_old, double quantity_on_hand_new) {
        this.product_id = product_id;
        this.warehouse_id = warehouse_id;
        this.quantity_on_hand_old = quantity_on_hand_old;
        this.quantity_on_hand_new = quantity_on_hand_new;
    }

    @Override
    public String toString() {
        return "Inventory{" + "product_id=" + product_id + ", warehouse_id=" + warehouse_id + ", quantity_on_hand_old=" + quantity_on_hand_old + ", quantity_on_hand_new=" + quantity_on_hand_new + '}';
    }
    
}
