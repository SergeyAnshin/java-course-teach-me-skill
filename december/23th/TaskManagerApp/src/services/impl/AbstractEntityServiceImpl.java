package services.impl;

import concole.ConsoleColors;
import entities.Entity;
import repositories.CrudRepository;
import services.EntityService;

import java.util.List;

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
                    System.out.println(ConsoleColors.RED + "Could not save " + Entity.getEntityName((Entity) entity) + "!" +
                            ConsoleColors.RESET);
                } else {
                    System.out.println(ConsoleColors.GREEN + Entity.getEntityName((Entity) entity) +
                            " saved!" + ConsoleColors.RESET);
                }
            }
        }
    }

    @Override
    public boolean exist(T entity) {
        if (entity != null) {
            if (repository.exist(entity)) {
                System.out.println(ConsoleColors.RED + Entity.getEntityName((Entity) entity) + " already exist!" +
                            ConsoleColors.RESET);
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public T findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean update(T entity) {
        if (repository.update(entity)) {
            System.out.println(ConsoleColors.GREEN + Entity.getEntityName((Entity) entity) + " updated!" +
                    ConsoleColors.RESET);
            return true;
        } else {
            System.out.println(ConsoleColors.RED + "Could not update " + Entity.getEntityName((Entity) entity) + "!" +
                    ConsoleColors.RESET);
            return false;
        }
    }

    @Override
    public boolean delete(T entity) {
        if (repository.delete(entity)) {
            System.out.println(ConsoleColors.GREEN + Entity.getEntityName((Entity) entity) + " deleted!" +
                    ConsoleColors.RESET);
            return true;
        } else {
            System.out.println(ConsoleColors.RED + "Could not delete " + Entity.getEntityName((Entity) entity) + "!" +
                    ConsoleColors.RESET);
            return false;
        }
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
