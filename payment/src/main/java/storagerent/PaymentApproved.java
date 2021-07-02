package storagerent;

public class PaymentApproved extends AbstractEvent {

    private Long paymentId;
    private Long reservationId;
    private Long storageId;
    private String paymentStatus;
    private Float amount;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
    public Long getRsvId() {
        return reservationId;
    }

    public void setRsvId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getRoomId() {
        return storageId;
    }

    public void setRoomId(Long storageId) {
        this.storageId = storageId;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}