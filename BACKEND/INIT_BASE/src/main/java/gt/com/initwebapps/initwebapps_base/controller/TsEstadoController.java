package gt.com.initwebapps.initwebapps_base.controller;

import javax.annotation.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import gt.com.initwebapps.initwebapps_base.exception.ResourceNotFoundException;
import gt.com.initwebapps.initwebapps_base.model.TsEstado;
import gt.com.initwebapps.initwebapps_base.repository.TsEstadoRepository;

@RestController
@RequestMapping("Estado")
public class TsEstadoController {

    @Autowired
    private TsEstadoRepository thisRepository;

    @GetMapping("all")
    public Page<TsEstado> getAll(Pageable pageable) {
        return thisRepository.findAll(pageable);
    }


    @PostMapping("new")
    public TsEstado create(@Valid @RequestBody TsEstado item) {
        return thisRepository.save(item);
    }

    @PutMapping("{id}")
    public TsEstado update(@PathVariable Long id,
                                   @Valid @RequestBody TsEstado item) {
        return thisRepository.findById(id)
                .map(newItem -> {
                    newItem.setEstado(item.getEstado());
                    newItem.setDescription(item.getDescription());
                    return thisRepository.save(newItem);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return thisRepository.findById(id)
                .map(item -> {
                    thisRepository.delete(item);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
    }
}