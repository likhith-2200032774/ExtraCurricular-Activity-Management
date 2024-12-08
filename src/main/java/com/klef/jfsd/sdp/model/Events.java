package com.klef.jfsd.sdp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="events_table")
public class Events 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="event_id")
   private int eventId;
   
   @Column(name="event_name", nullable=false, length=100)
   private String name;
   
   @Column(name="event_description", nullable=false, length=255)
   private String description;
   
   @Column(name="event_date", nullable=false, length=20)
   private String date;
   
   @Column(name="event_time", nullable=false, length=10)
   private String eventTime;
   
   @Column(name="event_status", nullable=false, length=50)
   private String status;
   
   @Column(name="students_registered_count", nullable=false)
   private int studentsRegisteredCount;

   @Column(name="total_count", nullable=false)  // New field for total count
   private int totalCount;
   
   // Getters and Setters
   public int getEventId() {
     return eventId;
   }
   
   public void setEventId(int eventId) {
     this.eventId = eventId;
   }
   
   public String getName() {
     return name;
   }
   
   public void setName(String name) {
     this.name = name;
   }
   
   public String getDescription() {
     return description;
   }
   
   public void setDescription(String description) {
     this.description = description;
   }
   
   public String getDate() {
     return date;
   }
   
   public void setDate(String date) {
     this.date = date;
   }
   
   public String getEventTime() {
     return eventTime;
   }
   
   public void setEventTime(String eventTime) {
     this.eventTime = eventTime;
   }
   
   public String getStatus() {
     return status;
   }
   
   public void setStatus(String status) {
     this.status = status;
   }
   
   public int getStudentsRegisteredCount() {
     return studentsRegisteredCount;
   }
   
   public void setStudentsRegisteredCount(int studentsRegisteredCount) {
     this.studentsRegisteredCount = studentsRegisteredCount;
   }
   
   public int getTotalCount() {  // Getter for total count
     return totalCount;
   }
   
   public void setTotalCount(int totalCount) {  // Setter for total count
     this.totalCount = totalCount;
   }
}