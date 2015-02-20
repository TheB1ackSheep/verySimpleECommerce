package model;

import java.io.Serializable;
import java.util.*;

/**
 * Created by INT303 on 20/2/2558.
 */
public class Cart implements Serializable {
    public class CartItem implements Serializable, Comparable<CartItem> {
        private Product product;
        private int qty;
        private double discount = 0.1;

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public CartItem(Product product) {
            this.product = product;
        }

        public CartItem(Product product, int qty) {
            this.product = product;
            this.qty = qty;
        }

        public CartItem(Product product, int qty, double discount) {
            this.product = product;
            this.qty = qty;
            this.discount = discount;
        }

        @Override
        public String toString() {
            return "CartItem{" +
                    "product=" + product +
                    ", qty=" + qty +
                    ", discount=" + discount +
                    '}';
        }

        @Override
        public int compareTo(CartItem o) {
            return this.product.getId() - o.product.getId();
        }


    }

    public List<CartItem> items = new ArrayList<CartItem>();

    public void add(Product p,int qty){
        CartItem item = new CartItem(p,qty);
        int pos = Collections.binarySearch(items,item);
        if( pos >= 0){
            item = items.get(pos);
            item.setQty(item.getQty()+qty);
        }else{
            items.add(item);
        }
    }

    public void remove(Product p){
        CartItem item = new CartItem(p);
        int pos = Collections.binarySearch(items,item);
        items.remove(pos);
    }

    public void replace(Product p,int qty){
        CartItem item = new CartItem(p,qty);
        int pos = Collections.binarySearch(items,item);
        if( pos > 0){
            items.get(pos).qty = qty;
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }
}


