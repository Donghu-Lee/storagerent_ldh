package storagerent;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Review_table")
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long reviewId;
    private Long storageId;
    private Integer rate;
    private String content;

    @PostPersist
    public void onPostPersist(){
        ReviewCreated reviewCreated = new ReviewCreated();
        BeanUtils.copyProperties(this, reviewCreated);
        reviewCreated.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        ReviewModified reviewModified = new ReviewModified();
        BeanUtils.copyProperties(this, reviewModified);
        reviewModified.publishAfterCommit();


    }

    @PreRemove
    public void onPreRemove(){
        ReviewDeleted reviewDeleted = new ReviewDeleted();
        BeanUtils.copyProperties(this, reviewDeleted);
        reviewDeleted.publishAfterCommit();


    }


    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }
    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }




}
