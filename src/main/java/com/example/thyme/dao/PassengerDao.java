package com.example.thyme.dao;

import com.example.thyme.entities.Passenger;

import java.util.List;

public interface PassengerDao {
    public Passenger insert(Passenger passenger);

    public Passenger update(Passenger passenger);

    public void delete(int id);

    public Passenger findbyid(int id);

    public List<Passenger> findall();
}
