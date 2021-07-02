package storagerent;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Storageview_table")
public class Storageview {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long storageId;
        private String storageStatus;
        private String description;
        private Float price;
        private Long reservationId;
        private String reservationStatus;
        private Long paymentId;
        private String paymentStatus;
        private Long reviewCnt;


        public Long getStorageId() {
            return storageId;
        }

        public void setStorageId(Long storageId) {
            this.storageId = storageId;
        }
        public String getStorageStatus() {
            return storageStatus;
        }

        public void setStorageStatus(String storageStatus) {
            this.storageStatus = storageStatus;
        }
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }
        public Long getReservationId() {
            return reservationId;
        }

        public void setReservationId(Long reservationId) {
            this.reservationId = reservationId;
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
        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }
        public Long getReviewCnt() {
            return reviewCnt;
        }

        public void setReviewCnt(Long reviewCnt) {
            this.reviewCnt = reviewCnt;
        }

}
