package edu.utez.mx.Logger.service;

import edu.utez.mx.Logger.model.modelAnimales;
import org.springframework.data.repository.CrudRepository;

public interface IAnimal extends CrudRepository<modelAnimales, Integer> {

}
