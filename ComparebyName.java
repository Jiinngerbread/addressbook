public class ComparebyName implements Comparator<Contact>

{
  public int compare(Contact con1, Contact con2)
  {
    String name1 = con1.getName();
    String name2 = con2.getName();
    
    String lName1 = name1[1];
    String lName2 = name2[1];
    
    String fName1 = name1[0];
    String fName2 = name2[0];
    
    if (lName1.equals(lName2))
    {
      return fName1.compareTo(fName2);
    } else
    {
      return lName1.compareTo(lName2);
    }
  }
}
