package ca.mikhailov.dataview.repository;

import ca.mikhailov.dataview.model.RecordView;

import java.util.List;

public interface GenericViewRepository {
    List<RecordView> findAll();
}
