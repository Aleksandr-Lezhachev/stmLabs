package api.v1.metrics.service;

import api.v1.metrics.entity.Attributes;

public interface AttributesService {

    Attributes getAttributeById(Long id);

    void save(Attributes attributes);

    void delete(Long id);



}
