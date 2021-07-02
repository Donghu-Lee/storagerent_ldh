package storagerent;

public class ReservationCancelled extends AbstractEvent {

    private Long reservationId;
    private Long storageId;
    private String reservationStatus;
    private Long paymentId;

    public Long getRsvId() {
        return reservationId;
    }

    public void setRsvId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }
    public String getStatus() {
        return reservationStatus;
    }

    public void setStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
    public Long getPayId() {
        return paymentId;
    }

    public void setPayId(Long paymentId) {
        this.paymentId = paymentId;
    }
}