package com.example.MiApi.controller;

import com.example.MiApi.entities.ArticuloManufacturado;
import com.example.MiApi.entities.ArticuloManufacturadoDetalle;
import com.example.MiApi.services.ArticuloManufacturadoDetalleService;
import com.example.MiApi.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manufacturadoDetalles")
public class ArticuloManufacturadoDetalleController extends BaseController<ArticuloManufacturadoDetalle, Long>{

    @Autowired
    private ArticuloManufacturadoDetalleService articuloManufacturadoDetalleService;

    public ArticuloManufacturadoDetalleController(ArticuloManufacturadoDetalleService articuloManufacturadoDetalleService){
        super(articuloManufacturadoDetalleService);
    }

    @GetMapping("/articuloInsumo/{id}")
    public List<ArticuloManufacturadoDetalle> listarPorArticuloInsumo(@PathVariable Long articuloInsumoId) throws Exception {
        try{
            List<ArticuloManufacturadoDetalle> articuloInsumo = articuloManufacturadoDetalleService.listarPorArticuloInsumo(articuloInsumoId);
            return ResponseEntity.ok(articuloInsumo).getBody();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @GetMapping("/articuloManufacturado/{id}")
    public List<ArticuloManufacturadoDetalle> listarPorArticuloManufacturado(@PathVariable Long articuloManufacturadoId) throws Exception {
        try{
            List<ArticuloManufacturadoDetalle> manufacturadoDetalles = articuloManufacturadoDetalleService.listarPorArticuloManufacturado(articuloManufacturadoId);
            return ResponseEntity.ok(manufacturadoDetalles).getBody();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }



}
