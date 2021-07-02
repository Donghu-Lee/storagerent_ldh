
package storagerent.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="storage", url="http://storage:8080")
public interface StorageService {

    @RequestMapping(method= RequestMethod.GET, path="/storages")
    public void chkAndReqReserve(@RequestBody Storage storage);

}