public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered > 20) {
            System.out.println("Cart is full");
            return;
        }
        for(int i = 0; i <= qtyOrdered; i++) {
            if (itemsOrdered[i] == null) {
                itemsOrdered[i] = disc;
                qtyOrdered++;
                System.out.println("Your disc have been added");
                return;
            }
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered == 0) {
            System.out.println("Cart is empty");
            return;
        }
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i].equals(disc)) {
              itemsOrdered[i] = null;
              qtyOrdered--;
              System.out.println("Your disc has been removed");
              return;
            }
        }
    }
    public float totalCost() {
        double sumCost = 0;
        for(int i = 0; i < itemsOrdered.length; i++) {
            if(itemsOrdered[i] != null) {
                sumCost += itemsOrdered[i].getCost();
            }
        }
        return (float)sumCost;
    }
}
