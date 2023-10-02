package solid;

public class LiskovExampleCorrection {
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
            return this.price - this.getDiscount();
        }
        private double getDiscount() {
            return 0;
        }
    };
    public static class BeverageItem extends MenuItem {
        public BeverageItem(int price, String name, String description) {
            super(price, name, description);
        }
        public double getPrice() {
            return this.price - this.discountPrice();
        }
        private double discountPrice() {
            int discountPercent = 10;
            return discountPercent * 0.01 * this.price;
        }
    };
    public static void printItemPrice(MenuItem item) {
        if(item instanceof BeverageItem) System.out.println("Beverage Item Price: ");
        else System.out.println("Menu Item Price: ");
        System.out.println(item.getPrice());
    }
    public static void main(String[] args) {
        MenuItem menuItem = new MenuItem(100, "Bread", "Wheat Flour Bread");
        BeverageItem beverageItem = new BeverageItem(60, "Coke", "Cold Beverage");
        printItemPrice(menuItem);
        printItemPrice(beverageItem);
    }
}
