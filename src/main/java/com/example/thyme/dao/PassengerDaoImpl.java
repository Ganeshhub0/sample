package com.example.thyme.dao;

import com.example.thyme.entities.Passenger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassengerDaoImpl implements PassengerDao {
    @Autowired
    private EntityManager entityManager;

    public PassengerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Passenger insert(Passenger passenger) {
        return entityManager.merge(passenger);
    }

    @Override
    public Passenger update(Passenger passenger) {
        return entityManager.merge(passenger);
    }

    @Override
    public void delete(int id) {
        Passenger passenger=entityManager.find(Passenger.class,id);
        entityManager.remove(passenger);
    }

    @Override
    public Passenger findbyid(int id) {
        return entityManager.find(Passenger.class, id);
    }

    @Override
    public List<Passenger> findall() {
        TypedQuery<Passenger> typedQuery = entityManager.createQuery("from Passenger", Passenger.class);
        List<Passenger> list = typedQuery.getResultList();
        return list;
    }
}
