package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track,Integer> {
}