package dea.luclinders.dataaccess.dao;

public interface DAO<T> {

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    T find(int id);

}
