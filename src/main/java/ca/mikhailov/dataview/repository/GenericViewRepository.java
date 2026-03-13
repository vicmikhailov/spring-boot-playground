package ca.mikhailov.dataview.repository;

import ca.mikhailov.dataview.model.RecordView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericViewRepository {
    Page<RecordView> findAll(Pageable pageable);
}
