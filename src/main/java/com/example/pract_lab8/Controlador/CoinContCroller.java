package com.example.pract_lab8.Controlador;

import com.example.pract_lab8.DTO.Coin;
import com.example.pract_lab8.DTO.Noticias;
import com.example.pract_lab8.Daos.CoinDao;
import com.example.pract_lab8.Daos.NoticiaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/inicio")
public class CoinContCroller {
    @Autowired
    CoinDao coinDao;
    @Autowired
    NoticiaDao noticiaDao;
    @GetMapping("/lista")
    public String listar(Model model){

        List<Coin> lista = coinDao.listaCoinds(1).getCoins();
        System.out.println(lista.get(7).getName()+" "+ lista.get(7).getVolume());
        model.addAttribute("listacoins", lista);
        return "lista";
    }

    @GetMapping("listarNoticias")
    public String listarNews(Model model){
        List<Noticias> noticias = noticiaDao.listaDeNoticias().getNews();
        model.addAttribute("listanoticias",noticias);
        return "listaNoticias";
    }

}
