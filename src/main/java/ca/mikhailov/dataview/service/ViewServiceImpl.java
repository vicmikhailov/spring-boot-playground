package ca.mikhailov.dataview.service;

import ca.mikhailov.dataview.model.RecordView;
import ca.mikhailov.dataview.repository.GenericViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewServiceImpl implements ViewService {

    private final GenericViewRepository genericViewRepository;

    @Autowired
    public ViewServiceImpl(GenericViewRepository genericViewRepository) {
        this.genericViewRepository = genericViewRepository;
    }

    @Override
    public List<RecordView> findAll() {
        return genericViewRepository.findAll();
    }
}
