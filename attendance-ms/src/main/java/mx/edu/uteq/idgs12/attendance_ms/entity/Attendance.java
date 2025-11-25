package mx.edu.uteq.idgs12.attendance_ms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "attendances")
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAttendance;

    @Column(nullable = false)
    private Integer idSchedule;

    @Column(nullable = false)
    private Integer idStudent;

    @Column(nullable = false, columnDefinition = "timestamptz")
    private Instant attendanceDate;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(length = 255)
    private String comments;
}
