package ServiceLocatorPattern;

import DataObjectPatterns.DaoPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johny on 18.01.16.
 */
public class Cache {
    private List<DaoPattern> daoServices;

    public Cache(){
        daoServices = new ArrayList<DaoPattern>();
    }

    public  DaoPattern getDao(String daoName){
        for(DaoPattern dao:daoServices)
        {
            if(dao.getDaoPatternName().equals(daoName))
            {
                System.out.println("Return by using cache object '"+dao.getDaoPatternName()+"'");
                return  dao;
            }
        }
        return null;
    }

    public void addDao(DaoPattern newDao)
    {
        boolean exist = false;

        for(DaoPattern dao:daoServices)
        {
            if(dao.getDaoPatternName().equals(newDao.getDaoPatternName()))
            {
                exist = true;
            }
        }
        if(!exist)
        {
            daoServices.add(newDao);
        }
    }
}
