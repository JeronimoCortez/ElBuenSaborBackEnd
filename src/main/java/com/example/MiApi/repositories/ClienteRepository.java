package com.example.MiApi.repositories;


import com.example.MiApi.entities.Cliente;
import com.example.MiApi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c JOIN c.domicilios i WHERE i.id = :domicilioId")
    List<Cliente> findAllByDomicilioId(@Param("domicilioId") Long domicilioId);

}
