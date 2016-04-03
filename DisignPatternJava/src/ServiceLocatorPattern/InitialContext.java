package ServiceLocatorPattern;

import DataObjectPatterns.*;

/**
 * Created by johny on 18.01.16.
 */
public class InitialContext {
    public Object lookUp(String daoServiceName)
    {
        if(daoServiceName.equalsIgnoreCase("dao1"))
        {
            System.out.println("Using look up and create 'dao1' object");
            return new DaoPatternImp();
        }
        return null;
    }
}
