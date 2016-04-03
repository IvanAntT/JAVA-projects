package DataObjectPatterns;

import java.util.List;

/**
 * Created by johny on 16.01.16.
 * Realize functionality of DAO and DTO. Acting as a client
 */
public class Test {

    /**
     * Realize functionality of DAO and DTO
     * @param args
     */
    public static void main(String[] args) {

        //Data Transfer Object design pattern. Client either requests or sends the Transfer Object to Business Object.

        System.out.println("*************Data Transfer Object************");
        DtoPatern personsWithDto = new DtoPatern();

        Child a = personsWithDto.getChild("a");
        personsWithDto.findParents(a);
        a.setFamily("Manolov");
        personsWithDto.updateChild(a);
        personsWithDto.findParents(a);

        System.out.println("||||||||||||||||||||||||||||||||||||||");

        Parent parent = personsWithDto.getParent("mc");
        personsWithDto.findChild(parent);
        parent.setFamily("Andreeva");
        personsWithDto.updateParent(parent);
        personsWithDto.findChild(parent);

        System.out.println();
        System.out.println("*************Data Access Object************");
        System.out.println();
        //Data Access Object
        DaoPattern personsWithDao = new DaoPatternImp();
        List<Parent> allParents = personsWithDao.getAllParent();
        for(Parent someParent:allParents)
        {
            System.out.println("EGN="+someParent.getEgn()+" name= "+someParent.getName()+" family= "+someParent.getFamily()+" Gender= "+someParent.getGender()+" Age="+someParent.getAge());
        }
        Parent parentForDel1 = personsWithDao.getParent("me");
        Parent parentForDel2 = personsWithDao.getParent("fe");

        personsWithDao.deleteParent(parentForDel1);
        personsWithDao.deleteParent(parentForDel2);
        System.out.println("After deletion the list with parents is:");

        allParents = personsWithDao.getAllParent();
        for(Parent someParent:allParents)
        {
            System.out.println("EGN="+someParent.getEgn()+" name= "+someParent.getName()+" family= "+someParent.getFamily()+" Gender= "+someParent.getGender()+" Age="+someParent.getAge());
        }
    }
}
