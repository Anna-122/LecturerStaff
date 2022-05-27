package edu.goncharova.services;

import edu.goncharova.exceptions.ValidateException;
import edu.goncharova.validator.CustomOValValidator;

import java.util.List;

public interface ServiceFactory<Entity, Key> {
    CustomOValValidator validator = new CustomOValValidator();

    void saveOrUpdate(Entity model) throws ValidateException;

    void delete(Entity model);

    Entity getById(Key id);

    List<Entity> getAllRecords();
}

