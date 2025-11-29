package mx.edu.uteq.idgs12.attendance_ms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "attendance_sessions")
@Data
public class AttendanceSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSession;

    @Column(nullable = false)
    private Integer idGroupCourse;

    @Column(nullable = false)
    private Integer idSchedule;

    @Column(nullable = false)
    private Integer idProfessor;

    private Double geoLatitude;
    private Double geoLongitude;

    @Column(nullable = false, length = 20)
    private String status; // OPEN, CLOSED

    @Column(nullable = false, columnDefinition = "timestamptz")
    private Instant startTime;

    @Column(nullable = false, columnDefinition = "timestamptz")
    private Instant expiresAt;
}
