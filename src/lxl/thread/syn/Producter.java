package lxl.thread.syn;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-07-15 15:13
 **/
public class Producter implements Runnable {

    private SaleMan saleMan;

    public Producter(SaleMan saleMan) {
        this.saleMan = saleMan;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            saleMan.addProduct(new Product());
        }
    }
}
