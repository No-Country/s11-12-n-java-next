package com.selecionado.quizwiz.controller;

import com.selecionado.quizwiz.DTO.request.RoleDtoReq;
import com.selecionado.quizwiz.model.Role;
import com.selecionado.quizwiz.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RoleController {
    @Autowired
    IRoleService roleService;

    @GetMapping(value ="/")
    public ResponseEntity<List<Role>> getAllRole(){
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{roleId}")
    public ResponseEntity<?> getRoleById(@PathVariable Long roleId){
        try {
            Role role = roleService.findById(roleId);
            return new ResponseEntity<>(role, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveRole(@RequestBody RoleDtoReq roleDtoReq){
        Role role = roleService.save(roleDtoReq);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{roleId}")
    public ResponseEntity<?> updateRole(@PathVariable Long roleId, @RequestBody RoleDtoReq roleDtoReq){
        try {
            Role roleUpdate = roleService.update(roleDtoReq, roleId);
            return new ResponseEntity<>(roleUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{roleId}")
    public ResponseEntity<?> deleteRole(@PathVariable Long roleId){
        try {
            roleService.delete(roleId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }
}
