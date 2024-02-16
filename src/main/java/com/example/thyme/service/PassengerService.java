package com.example.thyme.service;

import com.example.thyme.entities.Passenger;

import java.util.List;

public interface PassengerService {
    public Passenger insert(Passenger passenger);

    public Passenger update(Passenger passenger);

    public void delete(int id);

    public Passenger findbyid(int id);

    public List<Passenger> findall();
}
