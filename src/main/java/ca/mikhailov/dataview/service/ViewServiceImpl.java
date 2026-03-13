package ca.mikhailov.dataview.service;

import ca.mikhailov.dataview.model.RecordView;
import ca.mikhailov.dataview.repository.GenericViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ViewServiceImpl implements ViewService {

    private final GenericViewRepository genericViewRepository;

    @Autowired
    public ViewServiceImpl(GenericViewRepository genericViewRepository) {
        this.genericViewRepository = genericViewRepository;
    }

    @Override
    public Page<RecordView> findAll(Pageable pageable) {
        return genericViewRepository.findAll(pageable);
    }
}
