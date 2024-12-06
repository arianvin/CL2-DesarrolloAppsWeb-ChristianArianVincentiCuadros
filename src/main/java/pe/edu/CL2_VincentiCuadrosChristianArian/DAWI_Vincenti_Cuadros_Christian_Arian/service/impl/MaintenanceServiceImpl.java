package pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.dto.FilmCreateDto;
import pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.dto.FilmDetailDto;
import pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.dto.FilmDto;
import pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.entity.Film;
import pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.entity.Inventory;
import pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.entity.Language;
import pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.repository.*;
import pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.service.MaintenanceService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private FilmActorRepository filmActorRepository;
    @Autowired
    private FilmCategoryRepository filmCategoryRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Override
    public List<FilmDto> findAllFilms() {
        List<FilmDto> films = new ArrayList<>();

        filmRepository.findAll().forEach(film -> {films.add(new FilmDto(
                    film.getFilmId(),
                    film.getTitle(),
                    film.getReleaseYear(),
                    film.getRentalDuration(),
                    film.getRentalRate(),
                    film.getLanguage() != null ? film.getLanguage().getName() : null,
                    film.getLanguage() != null ? film.getLanguage().getLanguageId() : null,
                    film.getInventories().stream().map(Inventory::getInventoryId).toList(),
                    film.getFilmCategories().stream().map(category -> category.getCategory().getCategoryId()).toList(),
                    film.getFilmActors().stream().map(actor -> actor.getActor().getActorId()).toList()
            ));
        });

        return films;
    }

    @Override
    public FilmDetailDto findFilmById(int id) {Optional<Film> optional = filmRepository.findById(id);
        return optional.map(film -> new FilmDetailDto(
                film.getFilmId(),
                film.getTitle(),
                film.getDescription(),
                film.getReleaseYear(),
                film.getRentalDuration(),
                film.getRentalRate(),
                film.getLength(),
                film.getRating(),
                film.getLanguage() != null ? film.getLanguage().getName() : null,
                film.getLanguage() != null ? film.getLanguage().getLanguageId() : null,
                film.getInventories().stream().map(Inventory::getInventoryId).toList(),
                film.getFilmCategories().stream().map(category -> category.getCategory().getCategoryId()).toList(),
                film.getFilmActors().stream().map(actor -> actor.getActor().getActorId()).toList()
        )).orElse(null);
    }

    @Override
    public Boolean updateFilm(FilmDetailDto filmDetailDto) {Optional<Film> optional = filmRepository.findById(filmDetailDto.filmId());

        return optional.map(film -> {
            film.setTitle(filmDetailDto.title());
            film.setDescription(filmDetailDto.description());
            film.setReleaseYear(filmDetailDto.releaseYear());
            film.setRentalDuration(filmDetailDto.rentalDuration());
            film.setRentalRate(filmDetailDto.rentalRate());
            film.setLength(filmDetailDto.length());
            film.setRating(filmDetailDto.rating());
            film.setLastUpdate(new Date());

            filmRepository.save(film);

            return true;
        }).orElse(false);
    }

    @Override
    public Boolean createFilm(FilmCreateDto filmCreateDto) {
        try {
            Film film = new Film();
            film.setTitle(filmCreateDto.title());
            film.setDescription(filmCreateDto.description());
            film.setReleaseYear(filmCreateDto.releaseYear());
            Optional<Language> language = languageRepository.findById(filmCreateDto.languageId());
            if (language.isPresent()) {
                film.setLanguage(language.get());
            } else {
                throw new RuntimeException("Language not found with id " + filmCreateDto.languageId());
            }

            film.setRentalDuration(filmCreateDto.rentalDuration());
            film.setRentalRate(filmCreateDto.rentalRate());
            film.setLength(filmCreateDto.length());
            film.setReplacementCost(filmCreateDto.replacementCost());
            film.setRating(filmCreateDto.rating());
            film.setSpecialFeatures(filmCreateDto.specialFeatures());
            film.setLastUpdate(new Date());
            filmRepository.save(film);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteFilm(int filmId) {
        try {
            filmActorRepository.deleteByFilmId(filmId);

            filmCategoryRepository.deleteByFilmId(filmId);

            rentalRepository.deleteByFilmId(filmId);

            inventoryRepository.deleteByFilmId(filmId);

            filmRepository.deleteById(filmId);
            filmRepository.deleteByFilmId(filmId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
