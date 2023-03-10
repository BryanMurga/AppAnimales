package edu.utez.mx.Logger.service;
import edu.utez.mx.Logger.LoggerApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.utez.mx.Logger.model.modelAnimales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AnimalServiceImpl implements IAnimalService{
    private static final Logger LOGGER = LogManager.getLogger(AnimalServiceImpl.class);
    @Autowired
    private IAnimal data;

    @Override
    public List<modelAnimales> getAllAnimales() {
        LOGGER.info("Consulta general");
        return (List<modelAnimales>) data.findAll();
    }

    @Override
    public Optional<modelAnimales> getAnimalById(int id) {
        LOGGER.warn("Editar Objeto");
        return data.findById(id);
    }

    @Override
    public int saveAnimal(modelAnimales animales) {
        LOGGER.debug("Registro Objeto");
        int response = 0;
        modelAnimales animal = data.save(animales);

        if (animal != null){
            response = 1;
        }

        return response;
    }

    @Override
    public void deleteAnimal(int id) {

    }
}
