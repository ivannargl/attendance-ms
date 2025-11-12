package mx.edu.uteq.idgs12.academic_ms.dto;

import lombok.Data;

@Data
public class CourseDTO {
    private Integer idCourse;
    private Integer idUniversity;
    private Integer idDivision;
    private String courseCode;
    private String courseName;
    private String semester; // puede ser null = curso general
    private Boolean status;
}
