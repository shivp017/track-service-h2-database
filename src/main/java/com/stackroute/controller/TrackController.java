package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



    @Controller
    @RequestMapping("/api/v1")
    public class TrackController {
        private TrackService trackService;


        public TrackController(TrackService trackService) {
            this.trackService = trackService;
        }
        @PostMapping("Track")
        public ResponseEntity<?> setTrack(@RequestBody Track track){
            try {
                trackService.saveTrack(track);
                return new ResponseEntity<>("saveTrack", HttpStatus.OK);
            }
            catch (Exception ex){
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
            }
        }
        @GetMapping("Track/{id}")
        public ResponseEntity<?> getTrack(@PathVariable("id") int id) {
            ResponseEntity responseEntity;
            try {
                Track track=trackService.getTrackById(id);
                responseEntity=new ResponseEntity<>(track,HttpStatus.OK);
            }
           catch (Exception ex){
                responseEntity=new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
           }
            return responseEntity;
        }

        @DeleteMapping("track")
        public ResponseEntity<?> deleteTrackById(@PathVariable int id){
            ResponseEntity responseEntity;
            try {
                trackService.deleteTrackById(id);
                responseEntity = new ResponseEntity("delete success", HttpStatus.CREATED);
            } catch (Exception ex) {
                responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
            }
            return responseEntity;
        }
        @PostMapping("track/{id}")
        public ResponseEntity<?> updateTrack(@PathVariable int id,@RequestBody Track track){
            ResponseEntity responseEntity;
            try {
                trackService.updateTrackById(id,track);
                responseEntity = new ResponseEntity("update created", HttpStatus.CREATED);
            } catch (Exception ex) {
                responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
            }
            return responseEntity;
        }

    }



