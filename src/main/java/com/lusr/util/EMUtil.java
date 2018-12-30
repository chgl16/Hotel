package com.lusr.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EMUtil {
    public static EntityManager getEM() {
        return Persistence.createEntityManagerFactory("hotel").createEntityManager();
    }
}
