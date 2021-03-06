package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplyLocationRestController {
    private SupplyLocationRepository supplyLocationRepository;

    @Autowired
    public SupplyLocationRestController(SupplyLocationRepository supplyLocationRepository){
        this.supplyLocationRepository = supplyLocationRepository;
    }

    @RequestMapping(value = "/bulk/supplyLocations", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<SupplyLocation> locations){
        this.supplyLocationRepository.save(locations);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.DELETE)
    public void delete(){
        this.supplyLocationRepository.deleteAll();
    }
}
