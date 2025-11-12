package mx.edu.uteq.idgs12.attendance_ms.dto;

import lombok.Data;

@Data
public class GroupCourseDTO {
    private Integer idGroupCourse;
    private Integer idGroup;
    private Integer idCourse;
    private Integer idProfessor;
}
