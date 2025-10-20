package mx.edu.uteq.idgs12.chat_ms.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ConversationDTO {
    private Long id;
    private String title;
    private String type; // PRIVATE or GROUP
    private LocalDateTime createdAt;
}
