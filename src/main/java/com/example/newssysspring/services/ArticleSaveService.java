package com.example.newssysspring.services;

import com.example.newssysspring.dao.ArtykulyDAO;
import com.example.newssysspring.dao.UzytkownicyDAO;
import com.example.newssysspring.dto.ArtykulyDTO;
import com.example.newssysspring.entities.Artykuly;
import com.example.newssysspring.entities.Uzytkownicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class ArticleSaveService {
    @Autowired
    private ArtykulyDAO artykulyDAO;

    @Autowired
    private UzytkownicyDAO uzytkownicyDAO;

    public void saveArticle(ArtykulyDTO dto) {
        Artykuly artykuly = new Artykuly();
        artykuly.setTytul(dto.getTitle());
        if (dto.getDatePublication() != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            try {
                Date date = simpleDateFormat.parse(dto.getDatePublication());
                artykuly.setDataPublikacji(date.toInstant());
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        artykuly.setTresc(dto.getText());

        if (!dto.getImage().isEmpty()) {
            try {
                String uuid = UUID.randomUUID().toString();
                String fileExt = dto.getImage().getOriginalFilename();
                String newFileName = uuid + ".jpg";
                byte[] bytes = dto.getImage().getBytes();
                Path path = Paths.get(".\\src\\main\\resources\\static\\images\\" + newFileName);
                Files.write(path, bytes);

                artykuly.setObrazek(path.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Uzytkownicy uzytkownicy = uzytkownicyDAO.getUserById(21);
        artykuly.setAutor(uzytkownicy);
        artykuly.setDataDodania(Instant.now());
        artykuly.setZbanowany(0);
        artykulyDAO.save(artykuly);
    }
}
