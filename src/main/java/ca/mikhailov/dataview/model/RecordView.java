package ca.mikhailov.dataview.model;

import java.util.List;

public class RecordView {
    private Long id;
    private List<Field> field;

    public RecordView() {
    }

    public RecordView(Long id, List<Field> field) {
        this.id = id;
        this.field = field;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Field> getField() {
        return field;
    }

    public void setField(List<Field> field) {
        this.field = field;
    }
}
