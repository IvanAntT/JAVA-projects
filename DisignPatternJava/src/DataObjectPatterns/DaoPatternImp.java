package DataObjectPatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johny on 17.01.16.
 * This class is responsible to get data from a data source which can be database / xml or any other storage mechanism.
 */
public class DaoPatternImp implements DaoPattern{

    public List<Child> allChildren;
    public List<Parent> allParents;

    public DaoPatternImp() {
        allChildren = new ArrayList<Child>();
        allParents = new ArrayList<Parent>();

        //Children
        Child firstChild = new Child("a","ma","fa",12,"Ivan","Todorov");
        Child secChild = new Child("b","mb","fb",22,"Petur","Ivanov");
        Child thrdChild = new Child("c","mc","fc",14,"Stoqn","Atanasov");
        Child forthChild = new Child("d","md","fd",16,"Svetoslav","Oldu");
        Child fifthChild = new Child("e","me","fe",15,"Ivana","Peneva");
        Child sixthChild = new Child("f","mf","ff",17,"Gloriq","Stoqnova");
        Child sevenChild = new Child("g","mg","fg",18,"Antoaneta","Peeva");
        Child eightChild = new Child("h","mh","fh",19,"Preslava","Todorova");
        Child ninthChild = new Child("i","mi","fi",11,"Galena","Melenova");
        Child tenthChild = new Child("j","mj","fj",10,"Petra","Vladimirova");

        //Parent
        Parent fparent = new Parent("ma","Gabriela","Todorova",30,"l","a");
        Parent sparent = new Parent("fa","Stoqn","Todorov",33,"m","a");
        Parent tparent = new Parent("mc","Petq","Atanasova",35,"l","c");
        Parent foparent = new Parent("fc","Trifon","Atanasov",36,"m","c");
        Parent fiparent = new Parent("mh","Vanq","Todorova",45,"l","h");
        Parent siparent = new Parent("fh","Iliqn","Todorov",47,"m","h");
        Parent separent = new Parent("mf","Kristina","Stoqnova",40,"l","f");
        Parent eparent = new Parent("ff","Gabriel","Stoqnov",36,"m","f");

        allChildren.add(firstChild);
        allChildren.add(secChild);
        allChildren.add(thrdChild);
        allChildren.add(forthChild);
        allChildren.add(fifthChild);
        allChildren.add(sixthChild);
        allChildren.add(sevenChild);
        allChildren.add(eightChild);
        allChildren.add(ninthChild);
        allChildren.add(tenthChild);

        allParents.add(fparent);
        allParents.add(sparent);
        allParents.add(tparent);
        allParents.add(foparent);
        allParents.add(fiparent);
        allParents.add(siparent);
        allParents.add(separent);
        allParents.add(eparent);

    }
    
    @Override
    public void updateChild(Child childForUpdate) {
        try {
            int childForUpindex = allChildren.indexOf(childForUpdate);
            Child findChildInList = allChildren.get(childForUpindex);
            findChildInList.setAge(childForUpdate.getAge());
            findChildInList.setName(childForUpdate.getName());
            findChildInList.setFamily(childForUpdate.getFamily());
            System.out.println("The chosen child was updated");
        }catch (Exception e)
        {
            System.out.println("The child is not correct object");
        }
    }

    @Override
    public void updateParent(Parent parentForUpdate) {
        try {
            int parentForUpindex = allParents.indexOf(parentForUpdate);
            Parent findParentInlist = allParents.get(parentForUpindex);
            findParentInlist.setAge(parentForUpdate.getAge());
            findParentInlist.setName(parentForUpdate.getName());
            findParentInlist.setFamily(parentForUpdate.getFamily());
            System.out.println("The chosen parent was updated");
        }catch (Exception e)
        {
            System.out.println("The parent is not correct object");
        }
    }

    @Override
    public void deleteChild(Child childForDel) {
        try {
            allChildren.remove(childForDel);
            System.out.println("The child " + childForDel.getName() + " " + childForDel.getFamily() + " with EGN=" + childForDel.getEgn() + "was deleted");
        }catch (Exception a)
        {
            System.out.println("There isn't child like this");
        }
    }

    @Override
    public void deleteParent(Parent parentForDel) {
        try {
            allParents.remove(parentForDel);
            System.out.println("The parent" + parentForDel.getName() + " " + parentForDel.getFamily() + " with EGN=" + parentForDel.getEgn() + "was deleted");
        } catch (Exception e)
        {
            System.out.println("There isn't parent like this");
        }
    }

    @Override
    public List<Parent> getAllParent() {
        return allParents;
    }

    @Override
    public List<Child> getAllChildren() {
        return allChildren;
    }

    @Override
    public Child getChild(String childEgn) {
        Child childForReturn=null;
        boolean exseption = false;
        try {
            for (Child someChild : allChildren) {
                if (someChild.getEgn().equals(childEgn)) {
                    childForReturn = someChild;
                }
            }
        } catch (Exception e)
        {
            System.out.println("There isn't child with EGN like that");
            exseption = true;
        }
        if(childForReturn == null && exseption == false)
        {
            System.out.println("There isn't child with EGN like that");
        }
        return childForReturn;
    }

    @Override
    public Parent getParent(String parentEgn) {
        Parent parentForReturn=null;
        boolean exseption = false;
        try {
            for (Parent someParent : allParents) {
                if (someParent.getEgn().equals(parentEgn)) {
                    parentForReturn = someParent;
                }
            }
        }catch (Exception e)
        {
            System.out.println("There isn't parent with EGN like that");
            exseption = true;
        }
        if(parentForReturn == null && exseption == false)
        {
            System.out.println("There isn't parent with EGN like that");
        }
        return parentForReturn;
    }

    @Override
    public void findParents(Child inspectedChild) {
        try {
            Child findChildInList = allChildren.get(allChildren.indexOf(inspectedChild));
            String matherEgn = findChildInList.getMotherEgn();
            String fatherEgn = findChildInList.getFatherEgn();
            boolean haveMather = false;
            boolean haveFather = false;

            for (Parent someParent : allParents) {
                if (someParent.getEgn().equals(matherEgn) && someParent.getGender().equals("l")) {
                    System.out.println("The mather of " + inspectedChild.getName() + " " + inspectedChild.getFamily() + " is " + someParent.getName() + " " + someParent.getFamily());
                    haveMather = true;
                }
                if (someParent.getEgn().equals(fatherEgn) && someParent.getGender().equals("m")) {
                    System.out.println("The father of " + inspectedChild.getName() + " " + inspectedChild.getFamily() + " is " + someParent.getName() + " " + someParent.getFamily());
                    haveFather = true;
                }
            }
            if(!haveFather && !haveMather)
            {
                System.out.println("This chile doesn't have parents ");
            }

        }catch (Exception e)
        {
            System.out.println("The child is not correct object");
        }

    }

    @Override
    public void findChild(Parent inspectedParent) {
        try {
            Parent findParentInList = allParents.get(allParents.indexOf(inspectedParent));
            String childEgn = findParentInList.getChildEgn();
            boolean haveChild = false;

            for (Child someChild : allChildren) {
                if (someChild.getEgn().equals(childEgn)) {
                    System.out.println("The child of " + inspectedParent.getName() + " " + inspectedParent.getFamily() + " is " + someChild.getName() + " " + someChild.getFamily());
                    haveChild = true;
                }
            }
            if(!haveChild)
            {
                System.out.println("This parent doesn't have children");
            }
        } catch (Exception e)
        {
            System.out.println("This parent is not correct object");
        }
    }

    @Override
    public String getDaoPatternName() {
        return "dao1";
    }
}
