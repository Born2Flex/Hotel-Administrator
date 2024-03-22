package org.task.gfl_final.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @OneToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private GuestEntity guest;
    @OneToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    @Column(name = "total_price", nullable = false)
    private double totalPrice;
}