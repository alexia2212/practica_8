package com.example.pract_lab8.Daos;

import com.example.pract_lab8.DTO.CoinsResult;
import com.example.pract_lab8.DTO.Noticias;
import com.example.pract_lab8.DTO.NoticiasResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NoticiaDao {
    public NoticiasResult listaDeNoticias(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NoticiasResult> response = restTemplate.getForEntity("https://api.coinstats.app/public/v1/news?skip", NoticiasResult.class);
        return response.getBody();
    }

}
