package com.javaee9.javaee9finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    // TODO: Move limitation values to a single place
    @NotEmpty
    @Size(min = 3, message = "Your post is too short!")
    String          content;

    @NotEmpty
    @Size(min = 3, message = "Your author name is too short!")
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
