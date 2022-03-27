package com.javaee9.javaee9finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Clock;
import java.time.ZonedDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long            id;

    String          header;
    String          content;
    String          author;
    
    ZonedDateTime   creationTimestamp;
    ZonedDateTime   updateTimestamp;

    // Called when the object is added to the database
    @PrePersist
    private void setInitialTimestamp() {
        ZonedDateTime timestamp = ZonedDateTime.now(Clock.systemUTC());
        this.creationTimestamp  = timestamp;
        this.updateTimestamp    = timestamp;
    }

    // Called when the object is updated
    @PreUpdate
    private void setUpdatedTimestamp() {
        this.updateTimestamp    = ZonedDateTime.now(Clock.systemUTC());
    }
}
