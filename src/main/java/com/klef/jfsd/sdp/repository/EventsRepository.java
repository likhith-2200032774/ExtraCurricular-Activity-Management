package com.klef.jfsd.sdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.sdp.model.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer>
{
   // Method to check event status
   @Query("select e from Events e where e.eventId=?1 and e.status=?2")
   public Events checkeventstatus(int eventId, String status);
}
