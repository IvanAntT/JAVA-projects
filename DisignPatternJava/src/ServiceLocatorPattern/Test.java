package ServiceLocatorPattern;

import DataObjectPatterns.DaoPattern;

/**
 * Created by johny on 18.01.16.
 */
public class Test {
    public static void main(String[] args) {
        DaoPattern dao1 = ServiceLocator.getDaoService("dao1");
        dao1.getDaoPatternName();
        dao1 = ServiceLocator.getDaoService("dao1");
        dao1.getDaoPatternName();
        dao1 = ServiceLocator.getDaoService("dao1");
        dao1.getDaoPatternName();
    }
}
