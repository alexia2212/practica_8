package com.example.pract_lab8.Daos;

import com.example.pract_lab8.DTO.CoinsResult;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class CoinDao {

    public CoinsResult listaCoinds(int pagina){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CoinsResult> response = restTemplate.getForEntity(
                "https://api.coinstats.app/public/v1/coins?skip="+(pagina-1)*10+"&limit="+(pagina*10), CoinsResult.class);
        return response.getBody();
    }

}
