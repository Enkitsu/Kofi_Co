// Source code is decompiled from a .class file using FernFlower decompiler.
package Kofi_Co;

public class OrderItem {
   public String name;
   public String price;
   public int quantity;

   public OrderItem(String name, String price) {
      this.name = name;
      this.price = price;
      this.quantity = 1;
   }

   public OrderItem(String name, String price, int quantity) {
      this.name = name;
      this.price = price;
      this.quantity = quantity;
   }
}
