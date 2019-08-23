package gt.com.initwebapps.initwebapps_base.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import gt.com.initwebapps.initwebapps_base.exception.ResourceNotFoundException;
import gt.com.initwebapps.initwebapps_base.model.TcUsuario;
import gt.com.initwebapps.initwebapps_base.repository.TcUsuarioRepository;

/**
 * TcUsuarioController
 */

 @RestController
 @RequestMapping("Usuario")
public class TcUsuarioController {

    @Autowired
    private TcUsuarioRepository thisRepository;

    @GetMapping("all")
    public Page<TcUsuario> getAll(Pageable pageable) {
        return thisRepository.findAll(pageable);
    }


    @PostMapping("new")
    public TcUsuario create(@Valid @RequestBody TcUsuario item) {
        System.out.println("******************************************************************************"+item.getTsEstado());
        return thisRepository.save(item);
    }

    @PutMapping("{id}")
    public TcUsuario update(@PathVariable Long id,
                                   @Valid @RequestBody TcUsuario item) {
        return thisRepository.findById(id)
                .map(newItem -> {
                    newItem.setUsuario(item.getUsuario());
                    newItem.setPassword(item.getPassword());
                    newItem.setTsEstado(item.getTsEstado());
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