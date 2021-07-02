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
    @Autowired StorageRepository storageRepository;
    @Autowired ReviewRepository reviewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReviewCreated_UpdateReviewCnt(@Payload ReviewCreated reviewCreated){

        if(!reviewCreated.validate()) return;

        System.out.println("\n\n##### listener UpdateReviewCnt : " + reviewCreated.toJson() + "\n\n");

        // Sample Logic //
        Storage storage = new Storage();
        storageRepository.save(storage);
        Review review = new Review();
        reviewRepository.save(review);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReviewDeleted_UpdateReviewCnt(@Payload ReviewDeleted reviewDeleted){

        if(!reviewDeleted.validate()) return;

        System.out.println("\n\n##### listener UpdateReviewCnt : " + reviewDeleted.toJson() + "\n\n");

        // Sample Logic //
        Storage storage = new Storage();
        storageRepository.save(storage);
        Review review = new Review();
        reviewRepository.save(review);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationConfirmed_ConfirmReserve(@Payload ReservationConfirmed reservationConfirmed){

        if(!reservationConfirmed.validate()) return;

        System.out.println("\n\n##### listener ConfirmReserve : " + reservationConfirmed.toJson() + "\n\n");

        // Sample Logic //
        Storage storage = new Storage();
        storageRepository.save(storage);
        Review review = new Review();
        reviewRepository.save(review);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCancelled_Cancel(@Payload ReservationCancelled reservationCancelled){

        if(!reservationCancelled.validate()) return;

        System.out.println("\n\n##### listener Cancel : " + reservationCancelled.toJson() + "\n\n");

        // Sample Logic //
        Storage storage = new Storage();
        storageRepository.save(storage);
        Review review = new Review();
        reviewRepository.save(review);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
