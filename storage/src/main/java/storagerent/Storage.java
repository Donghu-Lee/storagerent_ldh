package storagerent;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Storage_table")
public class Storage {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long storageId;
    private String storageStatus;
    private String description;
    private Long reviewCnt;
    private String lastAction;
    private Float price;

    @PostPersist
    public void onPostPersist(){
        StorageRegistered storageRegistered = new StorageRegistered();
        BeanUtils.copyProperties(this, storageRegistered);
        storageRegistered.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        StorageModified storageModified = new StorageModified();
        BeanUtils.copyProperties(this, storageModified);
        storageModified.publishAfterCommit();


        StorageReserved storageReserved = new StorageReserved();
        BeanUtils.copyProperties(this, storageReserved);
        storageReserved.publishAfterCommit();


        StorageCancelled storageCancelled = new StorageCancelled();
        BeanUtils.copyProperties(this, storageCancelled);
        storageCancelled.publishAfterCommit();


    }

    @PreRemove
    public void onPreRemove(){
        StorageDeleted storageDeleted = new StorageDeleted();
        BeanUtils.copyProperties(this, storageDeleted);
        storageDeleted.publishAfterCommit();


    }


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
