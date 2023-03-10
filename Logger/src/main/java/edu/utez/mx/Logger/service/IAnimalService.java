package edu.utez.mx.Logger.service;

import edu.utez.mx.Logger.model.modelAnimales;

import java.util.List;
import java.util.Optional;

public interface IAnimalService {

    public List<modelAnimales> getAllAnimales();
    public Optional<modelAnimales> getAnimalById(int id);
    public int saveAnimal(modelAnimales animales);
    public void deleteAnimal(int id);

}
