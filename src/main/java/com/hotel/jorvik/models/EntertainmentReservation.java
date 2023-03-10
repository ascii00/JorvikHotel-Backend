package com.hotel.jorvik.models;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "EntertainmentReservation")
public class EntertainmentReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotNull(message = "Date is required")
    @Column(name = "date", nullable = false)
    @FutureOrPresent
    private Date date;

    @NotNull(message = "Time is required")
    @Column(name = "time", nullable = false)
    private Time time;

    @NotNull(message = "User is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    private User user;

    @NotNull(message = "Entertainment is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entertainmentID")
    private Entertainment entertainment;

    @NotNull(message = "Payment is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentID")
    private Payment payment;

    public EntertainmentReservation() {
    }

    public EntertainmentReservation(Date date, Time time, User user, Entertainment entertainment, Payment payment) {
        this.date = date;
        this.time = time;
        this.user = user;
        this.entertainment = entertainment;
        this.payment = payment;
    }
}
