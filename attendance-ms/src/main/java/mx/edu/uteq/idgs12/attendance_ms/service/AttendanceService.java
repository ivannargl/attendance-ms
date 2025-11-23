package mx.edu.uteq.idgs12.attendance_ms.service;

import mx.edu.uteq.idgs12.attendance_ms.dto.AttendanceDTO;
import mx.edu.uteq.idgs12.attendance_ms.entity.Attendance;
import mx.edu.uteq.idgs12.attendance_ms.entity.Schedule;
import mx.edu.uteq.idgs12.attendance_ms.repository.AttendanceRepository;
import mx.edu.uteq.idgs12.attendance_ms.repository.ScheduleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Optional<AttendanceDTO> getById(Integer id) {
        return attendanceRepository.findById(id)
                .map(this::toDTO);
    }

    public List<AttendanceDTO> getBySchedule(Integer idSchedule) {
        return attendanceRepository.findByIdSchedule(idSchedule)
                .stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<AttendanceDTO> getByStudent(Integer idStudent) {
        return attendanceRepository.findByIdStudent(idStudent)
                .stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    /** Obtener todas las asistencias por GroupCourse (todas las schedules de ese curso) */
    public List<AttendanceDTO> getByGroupCourse(Integer idGroupCourse) {
        List<Schedule> schedules = scheduleRepository.findByIdGroupCourse(idGroupCourse);
        if (schedules.isEmpty()) return List.of();

        List<Integer> scheduleIds = schedules.stream()
                .map(Schedule::getIdSchedule)
                .toList();

        return attendanceRepository.findByIdScheduleIn(scheduleIds)
                .stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public AttendanceDTO save(AttendanceDTO dto) {
        Attendance entity = new Attendance();
        BeanUtils.copyProperties(dto, entity);
        Attendance saved = attendanceRepository.save(entity);
        return toDTO(saved);
    }

    @Transactional
    public void delete(Integer id) {
        if (!attendanceRepository.existsById(id)) {
            throw new RuntimeException("Attendance not found with ID: " + id);
        }
        attendanceRepository.deleteById(id);
    }

    private AttendanceDTO toDTO(Attendance entity) {
        AttendanceDTO dto = new AttendanceDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
