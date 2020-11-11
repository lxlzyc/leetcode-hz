package lxl.temp;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-09-22 17:23
 **/
public class SingletonStaticStudy {


    private static class SingletonStaticHolder {
        private static final SingletonStaticStudy singletonStaticStudy = new SingletonStaticStudy();
    }

    private SingletonStaticStudy() {
    }

    public static final SingletonStaticStudy getInstance() {
        return SingletonStaticHolder.singletonStaticStudy;
    }
}
