package storagerent;

import storagerent.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StorageviewViewHandler {


    @Autowired
    private StorageviewRepository storageviewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenStorageRegistered_then_CREATE_1 (@Payload StorageRegistered storageRegistered) {
        try {

            if (!storageRegistered.validate()) return;

            // view 객체 생성
            Storageview storageview = new Storageview();
            // view 객체에 이벤트의 Value 를 set 함
            storageview.setStorageId(storageRegistered.getStorageId());
            storageview.setStorageStatus(storageRegistered.getStatus());
            storageview.setDescription(storageRegistered.getDescription());
            storageview.setPrice(storageRegistered.getPrice());
            // view 레파지 토리에 save
            storageviewRepository.save(storageview);
        
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenStorageModified_then_UPDATE_1(@Payload StorageModified storageModified) {
        try {
            if (!storageModified.validate()) return;
                // view 객체 조회
            Optional<Storageview> storageviewOptional = storageviewRepository.findById(storageModified.getStorageId());
            if( storageviewOptional.isPresent()) {
                Storageview storageview = storageviewOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                    storageview.setStorageStatus(storageModified.getStatus());
                    storageview.setDescription(storageModified.getDescription());
                    storageview.setPrice(storageModified.getPrice());
                    storageview.setReviewCnt(storageModified.getReviewCnt());
                // view 레파지 토리에 save
                storageviewRepository.save(storageview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationConfirmed_then_UPDATE_2(@Payload ReservationConfirmed reservationConfirmed) {
        try {
            if (!reservationConfirmed.validate()) return;
                // view 객체 조회
            Optional<Storageview> storageviewOptional = storageviewRepository.findById(reservationConfirmed.getStorageId());
            if( storageviewOptional.isPresent()) {
                Storageview storageview = storageviewOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                    storageview.setReservationId(reservationConfirmed.getReservationId());
                    storageview.setReservationStatus(reservationConfirmed.getStatus());
                // view 레파지 토리에 save
                storageviewRepository.save(storageview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_UPDATE_3(@Payload PaymentApproved paymentApproved) {
        try {
            if (!paymentApproved.validate()) return;
                // view 객체 조회
            List<Storageview> storageviewList = storageviewRepository.findByReservationId(paymentApproved.getRsvId());
            for(Storageview storageview : storageviewList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                storageview.setPaymentId(paymentApproved.getPaymentId());
                storageview.setPaymentStatus(paymentApproved.getPaymentStatus());
                // view 레파지 토리에 save
                storageviewRepository.save(storageview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCancelled_then_UPDATE_4(@Payload ReservationCancelled reservationCancelled) {
        try {
            if (!reservationCancelled.validate()) return;
                // view 객체 조회
            List<Storageview> storageviewList = storageviewRepository.findByReservationId(reservationCancelled.getRsvId());
            for(Storageview storageview : storageviewList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                storageview.setReservationStatus(reservationCancelled.getStatus());
                // view 레파지 토리에 save
                storageviewRepository.save(storageview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCancelled_then_UPDATE_5(@Payload PaymentCancelled paymentCancelled) {
        try {
            if (!paymentCancelled.validate()) return;
                // view 객체 조회
            List<Storageview> storageviewList = storageviewRepository.findByPaymentId(paymentCancelled.getPayId());
            for(Storageview storageview : storageviewList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                storageview.setPaymentStatus(paymentCancelled.getPaymentStatus());
                // view 레파지 토리에 save
                storageviewRepository.save(storageview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenStorageDeleted_then_DELETE_1(@Payload StorageDeleted storageDeleted) {
        try {
            if (!storageDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            storageviewRepository.deleteById(storageDeleted.getStorageId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}