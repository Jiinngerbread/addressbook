public class ComparebyEntryNum implements Comparator<Contact>
{
  public int compare(Contact con1, Contact con2)
  {
    Integer entryNum1 = con1.getEntry();
    Integer entryNum2 = con2.getEntry();
    
    return entryNum1.compareTo(entryNum2);
  }
}
