package com.selecionado.quizwiz.service;

import com.selecionado.quizwiz.dto.request.RoleDtoReq;
import com.selecionado.quizwiz.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    Role save(RoleDtoReq roleDtoReq);
    Role findById(Long id);
    Role update(RoleDtoReq roleDtoReq, Long id);
    void delete(Long id);
}
