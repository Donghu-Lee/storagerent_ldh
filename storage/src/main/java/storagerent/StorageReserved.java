package storagerent;

public class StorageReserved extends AbstractEvent {

    private Long storageId;
    private String status;
    private String description;
    private Long reviewCnt;
    private String lastAction;
    private Float price;

    public StorageReserved(){
        super();
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Long getReviewCnt() {
        return reviewCnt;
    }

    public void setReviewCnt(Long reviewCnt) {
        this.reviewCnt = reviewCnt;
    }
    public String getLastAction() {
        return lastAction;
    }

    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
    }
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
