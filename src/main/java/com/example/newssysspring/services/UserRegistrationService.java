package com.example.newssysspring.services;

import com.example.newssysspring.dao.RoleDAO;
import com.example.newssysspring.dao.UzytkownicyDAO;
import com.example.newssysspring.dto.UserRegistrationDTO;
import com.example.newssysspring.entities.Uzytkownicy;
import com.example.newssysspring.exceptions.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    @Autowired
    private UzytkownicyDAO uzytkownicyDAO;
    @Autowired
    private RoleDAO roleDAO;


    public void registerUser(UserRegistrationDTO dto) throws UserExistsException {
        if (doUserExists(dto)) {
            throw new UserExistsException("Użytkownik już istnieje");
        }

        Uzytkownicy uzytkownik = new Uzytkownicy();

        uzytkownik.setLogin(dto.getLogin());
        uzytkownik.setPassword(dto.getPassword());
        uzytkownik.setPlec(dto.getGender());
        uzytkownik.setMiejscowosc(dto.getLocality());
        uzytkownik.setPowiat(dto.getCommune());
        uzytkownik.setDataUrodzenia(dto.getBirthDate());

        uzytkownik.setZbanowany(false);
        if (dto.getVoivodeship() != null) {
            //TODO ogarnąć województwa i role
            /*
            HashMap<Integer, String> voivodeships = new HashMap<>();
            voivodeships.put(1, "Małopolskie");
            voivodeships.put(2, "Śląskie");
            voivodeships.put(3, "Podkarpackie");
            voivodeships.put(4, "Świętokrzyskie");
            voivodeships.put(5, "Mazowieckie");
            voivodeships.put(6, "Dolnośląskie");
            voivodeships.put(7, "Kujawsko - pomorskie");
            voivodeships.put(8, "Lubelskie");
            voivodeships.put(9, "Lubuskie");
            voivodeships.put(10, "Łódzkie");
            voivodeships.put(11, "Opolskie");
            voivodeships.put(12, "Podlaskie");
            voivodeships.put(13, "Pomorskie");
            voivodeships.put(14, "Warmińsko - mazurskie");
            voivodeships.put(15, "Wielkopolskie");
            voivodeships.put(16, "Zachodniopomorskie");
            uzytkownik.setWojewodzstwo(dto.getVoivodeship());
            */
        }
        uzytkownicyDAO.addUser(uzytkownik);

    }

    private Boolean doUserExists(UserRegistrationDTO dto) {
        return uzytkownicyDAO.getAllUsers()
                .stream()
                .map(Uzytkownicy::getLogin)
                .anyMatch(login -> login.equals(dto.getLogin()));
    }
}
