package ServiceLocatorPattern;

import DataObjectPatterns.DaoPattern;

/**
 * Created by johny on 18.01.16.
 */
public class ServiceLocator {
    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static DaoPattern getDaoService(String daoServiceName){
        DaoPattern daoFromCache = cache.getDao(daoServiceName);
        if(daoFromCache!=null)
        {
            return daoFromCache;
        }

        InitialContext context = new InitialContext();
        DaoPattern daoFromLookup = (DaoPattern)context.lookUp(daoServiceName);
        cache.addDao(daoFromLookup);
        return daoFromLookup;
    }
}
