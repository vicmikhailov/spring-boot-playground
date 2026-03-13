package ca.mikhailov.dataview.service;

import ca.mikhailov.dataview.model.RecordView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ViewService {
    Page<RecordView> findAll(Pageable pageable);
}
