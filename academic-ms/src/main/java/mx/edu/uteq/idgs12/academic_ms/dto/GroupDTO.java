package mx.edu.uteq.idgs12.academic_ms.dto;

import lombok.Data;

@Data
public class GroupDTO {
    private Integer idGroup;
    private Integer idProgram;
    private String programName;
    private Integer idTutor;
    private String tutorName;
    private String groupCode;
    private String semester;
    private String academicYear;
    private Long enrollmentCount;
    private Boolean status;
}
