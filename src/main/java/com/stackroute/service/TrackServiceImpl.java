package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public Track getTrackById(int id) {
        Track track = trackRepository.findById(id).get();
          return track;
    }

    //implement of getAllTracks() method
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();

    }

    //implement of deleteTrackById() method
    @Override
    public Track deleteTrackById(int id) {

        Optional<Track> optionalTrack = trackRepository.findById(id);
        trackRepository.deleteById(id);
        return optionalTrack.get();

    }

    @Override
    public Track updateTrackById(int id, Track track) {
        return null;
    }



}
