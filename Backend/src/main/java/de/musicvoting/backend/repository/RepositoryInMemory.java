package de.musicvoting.backend.repository;

import de.musicvoting.backend.domain.Identifiable;

import java.util.*;

public class RepositoryInMemory<T extends Identifiable> {

    private final HashMap<String, T> daten = new HashMap<>();     // Speicherort
    private long nextID = 1;

    public T save(T objekt) {
        String id = String.valueOf(nextID++);
        objekt.setID(id);
        daten.put(id, objekt);
        return objekt;
    }

    public T findById(String id) {
        return daten.get(id);
    }

    public Collection<T> findAll() {
        return daten.values();
    }

    public void delete(String id) { daten.remove(id); }
}
