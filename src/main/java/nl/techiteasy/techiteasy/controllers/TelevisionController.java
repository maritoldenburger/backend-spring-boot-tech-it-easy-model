package nl.techiteasy.techiteasy.controllers;

import nl.techiteasy.techiteasy.models.Television;
import nl.techiteasy.techiteasy.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionRepository repos;

    public TelevisionController(TelevisionRepository repos) {
        this.repos = repos;
    }

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions() {
        return ResponseEntity.ok(repos.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable Long id) {
        Optional<Television> optionalTelevision = this.repos.findById(id);
        if (optionalTelevision.isPresent()) {
            return ResponseEntity.ok(optionalTelevision.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Television> createTelevision(@RequestBody Television television) {
        Television savedTelevision = this.repos.save(television);
        return ResponseEntity.created(null).body(savedTelevision);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television television) {
        Optional<Television> optionalTelevision = this.repos.findById(id);
        if (optionalTelevision.isPresent()) {
            Television updatedTelevision = optionalTelevision.get();

            updatedTelevision.setType(television.getType());
            updatedTelevision.setBrand(television.getBrand());
            updatedTelevision.setName(television.getName());
            updatedTelevision.setPrice(television.getPrice());
            updatedTelevision.setAvailableSize(television.getAvailableSize());
            updatedTelevision.setRefreshRate(television.getRefreshRate());
            updatedTelevision.setScreenType(television.getScreenType());
            updatedTelevision.setScreenQuality(television.getScreenQuality());
            updatedTelevision.setSmartTv(television.isSmartTv());
            updatedTelevision.setWifi(television.isWifi());
            updatedTelevision.setVoiceControl(television.isVoiceControl());
            updatedTelevision.setHdr(television.isHdr());
            updatedTelevision.setBluetooth(television.isBluetooth());
            updatedTelevision.setAmbiLight(television.isAmbiLight());
            updatedTelevision.setOriginalStock(television.getOriginalStock());
            updatedTelevision.setSold(television.getSold());

            this.repos.save(updatedTelevision);
            return ResponseEntity.ok(updatedTelevision);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        Optional<Television> optionalTelevision = this.repos.findById(id);
        if (optionalTelevision.isPresent()) {
            this.repos.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
