package api.v1.metrics.service.serviceImpl;

import api.v1.metrics.entity.Attributes;
import api.v1.metrics.repository.AttributesRepository;
import api.v1.metrics.service.AttributesService;


public class AttributesServiceImpl implements AttributesService {
    private final AttributesRepository attributesRepository;

    public AttributesServiceImpl(AttributesRepository attributesRepository) {
        this.attributesRepository = attributesRepository;
    }

    @Override
    public Attributes getAttributeById(Long id) {
        return attributesRepository.getOne(id);
    }

    @Override
    public void save(Attributes attributes) {
        attributesRepository.save(attributes);
    }

    @Override
    public void delete(Long id) {
        attributesRepository.deleteById(id);
    }

}
