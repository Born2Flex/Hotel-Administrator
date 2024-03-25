package org.task.gfl_final.rental;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.task.gfl_final.guest.Guest;
import org.task.gfl_final.room.Room;

import java.math.BigDecimal;
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
    @Column(name = "check_in_date", nullable = false)
    private LocalDate checkInDate;
    @Column(name = "check_out_date", nullable = false)
    private LocalDate checkOutDate;
    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;
}