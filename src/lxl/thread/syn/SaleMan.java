package lxl.thread.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-07-15 15:06
 **/
public class SaleMan {

    private List products = new ArrayList();

    public synchronized void addProduct(Product product) {
        while (products.size() > 2) {
            System.out.println("货架已满，可以销售");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products.add(product);
        System.out.println("销售员添加第" + products.size() + "个商品");
        notifyAll();
    }

    public void removeProduct() {
        while (products.size() == 0) {
            System.out.println("当前货物已卖完，请等待上货");
            //try {
            //    wait();
            //}catch (InterruptedException e){
            //    e.printStackTrace();
            //}
        }

        System.out.println("顾客买第" + products.size() + "商品");
        products.remove(products.size() - 1);
        notifyAll();
    }

}
