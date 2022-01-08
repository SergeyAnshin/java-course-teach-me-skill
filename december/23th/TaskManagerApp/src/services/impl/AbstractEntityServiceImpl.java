package services.impl;

import concole.ConsoleColors;
import repositories.CrudRepository;
import services.EntityService;

public abstract class AbstractEntityServiceImpl<T> implements EntityService<T> {
    private CrudRepository<T> repository;

    public AbstractEntityServiceImpl(CrudRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void save(T entity) {
        if (entity == null) {
            System.out.println(ConsoleColors.RED + "You try to save empty entity!" + ConsoleColors.RESET);
        } else {
            if (!exist(entity)) {
                if (!repository.save(entity)) {
                    System.out.println(ConsoleColors.RED + "Could not save " + entity.getClass().getName() + "!" +
                            ConsoleColors.RESET);
                }
            } else {
                System.out.println(ConsoleColors.RED + entity.getClass().getName() + " already exist!" +
                        ConsoleColors.RESET);
            }
        }
    }

    @Override
    public boolean exist(T entity) {
        if (entity != null) {
            return repository.exist(entity);
        }
        return true;
    }

    @Override
    public T findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean update(T entity) {
        return repository.update(entity);
    }

    @Override
    public boolean delete(T entity) {
        return repository.delete(entity);
    }
}
