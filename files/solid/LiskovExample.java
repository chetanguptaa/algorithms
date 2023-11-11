package solid;

public class LiskovExample {
    public static class MenuItem {
        public int price;
        public String name;
        public String description;

        public MenuItem(int price, String name, String description) {
            this.price = price;
            this.name = name;
            this.description = description;
        }

        public double getPrice() {
            return this.price;
        }
    }

    public static class BeverageItem extends MenuItem {
        public BeverageItem(int price, String name, String description) {
            super(price, name, description);
        }

        public double getPriceWithDiscount(int discountPercent) {
            return this.price - (discountPercent * 0.01 * this.price);
        }
    }

    public static void printItemPrice(MenuItem item) {
        /**
         * This will violate Liskov, and we would have to check if this is an instance
         * of beverageItem
         * and call item.getPrice MenuItem's price and print 100 in both cases.
         * This check is violating Liskov, and we would have to fix it
         */
        if (item instanceof BeverageItem) {
            System.out.println("Beverage Item Price: ");
            System.out.println(((BeverageItem) item).getPriceWithDiscount(10));
        } else {
            System.out.println("Menu Item Price: ");
            System.out.println(item.getPrice());
        }
    }

    public static void main(String[] args) {
        MenuItem menuItem = new MenuItem(100, "Bread", "Wheat Flour Bread");
        BeverageItem beverageItem = new BeverageItem(60, "Coke", "Cold Beverage");
        printItemPrice(menuItem);
        printItemPrice(beverageItem);
    }
}
