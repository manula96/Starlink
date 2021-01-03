package com.manula.Starlink;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SatelliteService {

    @Autowired
    private SatelliteRepository satelliteRepository;

//    private List<Satellite> satellite = new ArrayList<>(Arrays.asList(
//            new Topic("Lunar","framework","description"),
//            new Topic("Mars","python framework"," python description"),
//            new Topic("java","java framework"," java description")
//    ));

    public List<Satellite> getAllSatellites(){
        //return topics;

        //CRUD ops
        List<Satellite> satellites = new ArrayList<>();
        satelliteRepository.findAll()
                .forEach(satellites::add);
        return satellites;
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
//            for (int i=0; i<topics.size(); i++){
//                Topic t = topics.get(i);
//                if (t.getId().equals(id)){
//                    topics.set(i,topic);
//                    return;
//                }
//            }
        satelliteRepository.save(satellite);
    }

    public void deleteSatellite(String id){
        //topics.removeIf(t -> t.getId().equals(id));

        satelliteRepository.deleteById(id);
    }
}
