package com.stackroute.service;

import com.stackroute.domain.Track;

public interface TrackService {

        public Track saveTrack(Track track);
        public Track getTrackById(int id);
        public Track deleteTrackById(int id);
        public Track updateTrackById(int id,Track track);


}
