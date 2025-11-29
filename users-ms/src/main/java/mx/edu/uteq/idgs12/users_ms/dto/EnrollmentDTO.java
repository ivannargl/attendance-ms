package mx.edu.uteq.idgs12.users_ms.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EnrollmentDTO {
    private Integer idEnrollment;
    private Integer idStudent;
    private String studentName;
    private String studentEmail;
    private Integer idGroup;
    private String groupCode;
    private LocalDate enrollmentDate;
    private Boolean status;
}
