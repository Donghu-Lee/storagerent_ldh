package storagerent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StorageviewRepository extends CrudRepository<Storageview, Long> {
    List<Storageview> findByReservationId(Long reservationId);
    List<Storageview> findByPaymentId(Long paymentId);

}