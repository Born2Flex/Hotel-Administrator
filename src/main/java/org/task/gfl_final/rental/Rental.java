package org.task.gfl_final.rental;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.task.gfl_final.guest.GuestEntity;
import org.task.gfl_final.room.Room;

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
    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private GuestEntity guest;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    @Column(name = "total_price", nullable = false)
    private double totalPrice;
}