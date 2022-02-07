package org.anshin.enums;

public enum Role {
    ADMIN(1), USER(2);

    private int DBId;

    Role(int DBId) {
        this.DBId = DBId;
    }

    public int getDBId() {
        return DBId;
    }
}

