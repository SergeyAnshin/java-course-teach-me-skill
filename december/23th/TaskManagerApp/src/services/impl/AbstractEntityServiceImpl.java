package services.impl;

import concole.ConsoleColors;
import repositories.CrudRepository;
import services.EntityService;

import java.util.List;

import static enums.EntityServiceMessages.*;

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
                    printSuccessMessageForEntity(FAILED_SAVE_MESSAGE, entity);
                } else {
                    printSuccessMessageForEntity(SUCCESSFUL_SAVE_MESSAGE, entity);
                }
            }
        }
    }

    @Override
    public boolean exist(T entity) {
        if (entity != null) {
            if (repository.exist(entity)) {
                printSuccessMessageForEntity(FAILED_EXIST_MESSAGE, entity);
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public T findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean update(T entity) {
        if (repository.update(entity)) {
            printSuccessMessageForEntity(SUCCESSFUL_UPDATE_MESSAGE, entity);
            return true;
        } else {
            printSuccessMessageForEntity(FAILED_UPDATE_MESSAGE, entity);
            return false;
        }
    }

    @Override
    public boolean delete(T entity) {
        if (repository.delete(entity)) {
            printSuccessMessageForEntity(SUCCESSFUL_DELETE_MESSAGE, entity);
            return true;
        } else {
            printSuccessMessageForEntity(FAILED_DELETE_MESSAGE, entity);
            return false;
        }
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
