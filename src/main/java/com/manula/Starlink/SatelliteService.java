package com.manula.Starlink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SatelliteService {

    @Autowired
    private SatelliteRepository satelliteRepository;


    public List<Satellite> getAllSatellites(){
        //return topics;

        //CRUD ops
        List<Satellite> satellite = new ArrayList<>();
        satelliteRepository.findAll()
                .forEach(satellite::add);
        return satellite;
    }

    public Satellite getSatellite(String id){
        // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return satelliteRepository.findById(id).orElse(null);
    }


    public void addSatellite(Satellite satellite){

        //topics.add(topic);
        satelliteRepository.save(satellite);
    }


    public void updateSatellite(String id, Satellite satellite){

        satelliteRepository.save(satellite);
    }

    public void deleteSatellite(String id){
        //topics.removeIf(t -> t.getId().equals(id));

        satelliteRepository.deleteById(id);
    }
}
