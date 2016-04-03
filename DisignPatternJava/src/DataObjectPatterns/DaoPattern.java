package DataObjectPatterns;

import java.util.List;

/**
 * Created by johny on 17.01.16.
 * This interface defines the standard operations to be performed on a model object(s)
 */
public interface DaoPattern {
    public void updateChild(Child childForUpdate);
    public void updateParent(Parent parentForUpdate);
    public void deleteChild(Child childForDel);
    public void deleteParent(Parent parentForDel);
    public List<Parent> getAllParent();
    public List<Child> getAllChildren();
    public Child getChild(String childEgn);
    public Parent getParent(String parentEgn);
    public void findParents(Child inspectedChild);
    public void findChild(Parent inspectedParent);
    public String getDaoPatternName();
}
