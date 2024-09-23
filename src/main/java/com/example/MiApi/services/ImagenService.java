package com.example.MiApi.services;

import com.example.MiApi.entities.Base;
import com.example.MiApi.entities.Imagen;
import com.example.MiApi.repositories.BaseRepository;
import com.example.MiApi.repositories.ImagenRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class ImagenService extends BaseService<Imagen, Long> {

    public ImagenService(BaseRepository<Imagen, Long> baseRepository) {
        super(baseRepository);
    }
}
