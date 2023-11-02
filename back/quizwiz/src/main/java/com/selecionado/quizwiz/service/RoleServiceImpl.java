package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.RoleDtoReq;
import com.selecionado.quizwiz.model.Role;
import com.selecionado.quizwiz.repository.IRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService{

    @Autowired
    IRoleRepository roleRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(RoleDtoReq roleDtoReq) {
        Role role = modelMapper.map(roleDtoReq, Role.class);
        roleRepository.save(role);
        return role;
    }

    @Override
    public Role findById(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow( () -> new RuntimeException("Role no encontrado"));
    }

    @Override
    public Role update(RoleDtoReq roleDtoReq, Long roleId) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (!optionalRole.isPresent()) {
            throw new RuntimeException("Role no encontrado");
        }
        Role roleUpdate = modelMapper.map(roleDtoReq, Role.class);
        return roleRepository.save(roleUpdate);
    }

    @Override
    public void delete(Long roleId) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (!optionalRole.isPresent()) {
            throw new RuntimeException("Role no encontrado");
        }
        roleRepository.deleteById(roleId);
    }
}
