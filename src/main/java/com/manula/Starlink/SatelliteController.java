package com.manula.Starlink;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SatelliteController {

    @Autowired // CONNECTION TO Satellite service. Marks as it requires the Satellite service dependency
    private SatelliteService satelliteService;

    @RequestMapping("/satellite")
    public List<Satellite> getAllSatellites(){
        return satelliteService.getAllSatellites();
    }

    @RequestMapping("/satellite/{id}")
    public Satellite getSatellite(@PathVariable String id) {
        return satelliteService.getSatellite(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/addsatellite")
    public void addSatellite(@RequestBody Satellite satellite) {
        satelliteService.addSatellite(satellite);
    }


    @RequestMapping(method = RequestMethod.PUT, value="/updatesatellite/{id}")
    public void updateConstellation(@RequestBody Satellite satellite, @PathVariable String id){
        satelliteService.updateSatellite(id, satellite);


    }

    @RequestMapping(method = RequestMethod.DELETE, value="/Satellites/{id}")
    public void deleteSatellite(@PathVariable String id){
        satelliteService.deleteSatellite(id);


    }
}
