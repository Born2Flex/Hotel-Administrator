package org.task.gfl_final.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "room_type")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "type", nullable = false, length = 20)
    private String type;
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Column(name = "price", nullable = false)
    private Double price;
}