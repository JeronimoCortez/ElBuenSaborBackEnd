package com.example.MiApi.controller;

import com.example.MiApi.entities.Pedido;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mp")
public class MercadoPagoController {

    @Value("${codigo.mercadoPago}")
    private String mpToken;

    @PostMapping()
    public String getList(@RequestBody Pedido pedido){
        if(pedido == null){return "Error al recibir el pedido";}
        String title = "Pedido nro" + pedido.getId();
        int quantity = 1;
        Double price = pedido.getTotal();

        try{
            MercadoPagoConfig.setAccessToken(mpToken);

            //Creamos la preferencia
            //Venta
            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .title(title)
                    .quantity(quantity)
                    .unitPrice(new BigDecimal(price))
                    .currencyId("ARS") // Moneda
                    .build();

            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(itemRequest);

            //Control de suceso
            PreferenceBackUrlsRequest backUrlsRequest = PreferenceBackUrlsRequest.builder()
                    .success("direccion de pago exitoso")
                    .pending("direccion por pago pendiente")
                    .failure("direccion por pago fallido")
                    .build();

            //Concluyendo preferencia
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .backUrls(backUrlsRequest)
                    .build();

            //Creamos el cliente que se comunicara con mp
            PreferenceClient client = new PreferenceClient();

            //Creamos una variable para guardar la respusta generada
            Preference preference = client.create(preferenceRequest);

            return preference.getId();
        }catch (MPApiException | MPException mpE){
            return mpE.getMessage();
        }
    }
}















