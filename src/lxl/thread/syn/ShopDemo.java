package lxl.thread.syn;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-07-15 15:14
 **/
public class ShopDemo {

    public static void main(String[] args) {
        SaleMan saleMan = new SaleMan();
        Producter producter = new Producter(saleMan);
        Customer customer = new Customer(saleMan);
        Thread producterOne = new Thread(producter);
        Thread customerOne = new Thread(customer);
        customerOne.start();
        producterOne.start();

    }

}
