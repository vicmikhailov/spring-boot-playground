package ca.mikhailov.dataview.service;

import ca.mikhailov.dataview.model.RecordView;

import java.util.List;

public interface ViewService {
    List<RecordView> findAll();
}
