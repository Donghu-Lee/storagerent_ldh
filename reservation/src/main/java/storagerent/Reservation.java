package storagerent;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Reservation_table")
public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long reservationId;
    private Long storageId;
    private String reservationStatus;
    private Long paymentId;

    @PostPersist
    public void onPostPersist(){
        ReservationCreated reservationCreated = new ReservationCreated();
        BeanUtils.copyProperties(this, reservationCreated);
        reservationCreated.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        storagerent.external.Storage storage = new storagerent.external.Storage();
        // mappings goes here 
        // 이병관
        // Application.applicationContext.getBean(storagerent.external.StorageService.class)
        //    .chkAndReqReserve(storage);


    }

    @PostUpdate
    public void onPostUpdate(){
        ReservationCancelRequested reservationCancelRequested = new ReservationCancelRequested();
        BeanUtils.copyProperties(this, reservationCancelRequested);
        reservationCancelRequested.publishAfterCommit();


        ReservationConfirmed reservationConfirmed = new ReservationConfirmed();
        BeanUtils.copyProperties(this, reservationConfirmed);
        reservationConfirmed.publishAfterCommit();


        ReservationCancelled reservationCancelled = new ReservationCancelled();
        BeanUtils.copyProperties(this, reservationCancelled);
        reservationCancelled.publishAfterCommit();


    }


    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }
    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }




}
