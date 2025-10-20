package mx.edu.uteq.idgs12.chat_ms.service;

import mx.edu.uteq.idgs12.chat_ms.entity.Conversation;
import mx.edu.uteq.idgs12.chat_ms.entity.Message;
import mx.edu.uteq.idgs12.chat_ms.entity.Participant;
import mx.edu.uteq.idgs12.chat_ms.repository.ConversationRepository;
import mx.edu.uteq.idgs12.chat_ms.repository.MessageRepository;
import mx.edu.uteq.idgs12.chat_ms.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatService {

    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;
    private final ParticipantRepository participantRepository;

    public ChatService(ConversationRepository conversationRepository, MessageRepository messageRepository, ParticipantRepository participantRepository) {
        this.conversationRepository = conversationRepository;
        this.messageRepository = messageRepository;
        this.participantRepository = participantRepository;
    }

    // === Conversations ===
    public List<Conversation> getConversationsByUser(Long userId) {
        List<Participant> participants = participantRepository.findByUserId(userId);
        return participants.stream()
                .map(Participant::getConversation)
                .distinct()
                .collect(Collectors.toList());
    }

    public Optional<Conversation> getConversationById(Long id) {
        return conversationRepository.findById(id);
    }

    public Conversation saveConversation(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    public void deleteConversation(Long id) {
        conversationRepository.deleteById(id);
    }

    // === Messages ===
    public List<Message> getMessagesByConversation(Long conversationId) {
        return messageRepository.findByConversationIdOrderBySentAtAsc(conversationId);
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    // === Participants ===
    public List<Participant> getParticipantsByUser(Long userId) {
        return participantRepository.findByUserId(userId);
    }

    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }
}
