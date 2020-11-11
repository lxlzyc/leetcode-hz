package lxl.thread.syn;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-07-15 15:05
 **/
public class Customer implements Runnable {
    private SaleMan saleman;

    public Customer(SaleMan saleman) {
        this.saleman = saleman;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            saleman.removeProduct();
        }
    }

}
