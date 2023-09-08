package crud.word;

public interface ICRUD {
    public Object Add();
    public int Update(Object obj);
    public int Delete(Object obj);
    public void SelectOne(int id);
}
