package mx.edu.uteq.idgs12.attendance_ms.dto;

import lombok.Data;

@Data
public class AttendanceMarkDTO {
    private Integer idStudent;
    private Integer idGroupCourse;
    private Double latitude;
    private Double longitude;
}
