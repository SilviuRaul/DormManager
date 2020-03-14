package ro.siit.dormmanager;

public interface CRUDOperations<T> {

    T create();
    T read();
    T update();
    void delete();

}
