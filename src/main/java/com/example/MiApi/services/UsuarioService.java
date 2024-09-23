package com.example.MiApi.services;

import com.example.MiApi.entities.Base;
import com.example.MiApi.entities.Usuario;
import com.example.MiApi.repositories.BaseRepository;
import com.example.MiApi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService extends BaseService<Usuario, Long> {
    public UsuarioService(BaseRepository<Usuario, Long> baseRepository) {
        super(baseRepository);
    }
}
