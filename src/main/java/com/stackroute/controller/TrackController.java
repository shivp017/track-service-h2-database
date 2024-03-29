package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
    @RequestMapping("/api/v1")
    public class TrackController {
        private TrackService trackService;


        public TrackController(TrackService trackService) {
            this.trackService = trackService;
        }
    //use postMapping to set tracks
        @PostMapping("Track")
        public ResponseEntity<?> setTrack(@RequestBody Track track){
            try {
                trackService.saveTrack(track);
                return new ResponseEntity<>("savedTrack", HttpStatus.OK);
            }
            catch (Exception ex){
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
            }
        }
    //use getMapping to gettracksById
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
//use getMapping to get all tracks
        @GetMapping("Track")
        public ResponseEntity<?> getAllTrack() {
            return new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.OK);
        }
        //Use DeleteMapping to delete a particular track given by id
        @DeleteMapping("Track/{id}")
        public ResponseEntity<?> deleteTrackById(@PathVariable int id) {
            Optional<Track> trackRemoved = Optional.of(trackService.deleteTrackById(id));
            return new ResponseEntity<>(trackRemoved, HttpStatus.OK);
        }


    //Use PatchMapping to update the element in database
    @PatchMapping("/Track/{id}")
    public ResponseEntity<?> updateTrack(@RequestBody Track track, @PathVariable("id") int id) {
        Track track1 = trackService.updateTrackById(id, track);
        return new ResponseEntity < > (track1, HttpStatus.OK);
    }
    }



