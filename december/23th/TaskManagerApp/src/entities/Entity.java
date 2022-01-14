package entities;

public interface Entity {

    Long getId();

    static String getEntityName(Entity entity) {
        return entity.getClass().getName().substring(9);
    }
}
