package storagerent;

import storagerent.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired MessageRepository messageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationConfirmed_SendConfirmMsg(@Payload ReservationConfirmed reservationConfirmed){

        if(!reservationConfirmed.validate()) return;

        System.out.println("\n\n##### listener SendConfirmMsg : " + reservationConfirmed.toJson() + "\n\n");

        // Sample Logic //
        Message message = new Message();
        messageRepository.save(message);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCancelled_SendCancelMsg(@Payload ReservationCancelled reservationCancelled){

        if(!reservationCancelled.validate()) return;

        System.out.println("\n\n##### listener SendCancelMsg : " + reservationCancelled.toJson() + "\n\n");

        // Sample Logic //
        Message message = new Message();
        messageRepository.save(message);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
