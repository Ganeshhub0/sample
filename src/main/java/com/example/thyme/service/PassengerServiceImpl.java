package com.example.thyme.service;

import com.example.thyme.dao.PassengerDaoImpl;
import com.example.thyme.entities.Passenger;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    PassengerDaoImpl passengerDao;

    @Transactional
    @Override
    public Passenger insert(Passenger passenger) {
        return passengerDao.insert(passenger);
    }

    @Transactional
    @Override
    public Passenger update(Passenger passenger) {
        return passengerDao.update(passenger);
    }

    @Transactional
    @Override
    public void delete(int id) {
        passengerDao.delete(id);
    }

    @Override
    public Passenger findbyid(int id) {
        return passengerDao.findbyid(id);
    }

    @Override
    public List<Passenger> findall() {
        return passengerDao.findall();
    }
}
