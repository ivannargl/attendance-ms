package mx.edu.uteq.idgs12.attendance_ms.repository;

import mx.edu.uteq.idgs12.attendance_ms.entity.AttendanceSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendanceSessionRepository extends JpaRepository<AttendanceSession, Integer> {

    /** Busca la sesión activa (OPEN) más reciente por idGroupCourse */
    Optional<AttendanceSession> findTopByIdGroupCourseAndStatus(Integer idGroupCourse, String status);
}
