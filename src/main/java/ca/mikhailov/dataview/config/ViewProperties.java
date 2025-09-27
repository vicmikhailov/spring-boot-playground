package ca.mikhailov.dataview.config;

import java.util.ArrayList;
import java.util.List;

public class ViewProperties {
    private String name;
    private String label;
    private String sqlPath;
    private String sqlCommand;
    private List<Field> fields = new ArrayList<>();

    public String getSqlCommand() {
        return sqlCommand;
    }

    public void setSqlCommand(String sqlCommand) {
        this.sqlCommand = sqlCommand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSqlPath() {
        return sqlPath;
    }

    public void setSqlPath(String sqlPath) {
        this.sqlPath = sqlPath;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "ViewProperties{" +
                "name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", sqlPath='" + sqlPath + '\'' +
                ", fields=" + fields +
                '}';
    }

    public static class Field {
        private String name;
        private String label;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Field{" +
                    "name='" + name + '\'' +
                    ", label='" + label + '\'' +
                    '}';
        }
    }
}
