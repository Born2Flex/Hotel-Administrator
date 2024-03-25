package org.task.gfl_final.room;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.task.gfl_final.roomtype.RoomType;

import java.math.BigDecimal;

//STANDARD, COMFORT, DELUXE, PENTHOUSE
@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;
    @ManyToOne
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomType roomType;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "num_of_beds", nullable = false)
    private Integer numOfBeds;
    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;
//    @Column(name = "picture_path", nullable = false)
//    private String picture;
}