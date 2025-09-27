package ca.mikhailov.dataview.repository;

import ca.mikhailov.dataview.model.Field;
import ca.mikhailov.dataview.model.RecordView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GenericViewRepositoryImpl implements GenericViewRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GenericViewRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<RecordView> findAll() {
        String sql = "SELECT * FROM users";
        ResultSetExtractor<List<RecordView>> rse = new ListResultSetExtractor();
        return jdbcTemplate.query(sql, rse);
    }

    private static class ListResultSetExtractor implements ResultSetExtractor<List<RecordView>> {
        @Override
        public List<RecordView> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<RecordView> records = new ArrayList<>();
            long seq = 1L;
            while (rs.next()) {
                List<Field> fields = new ArrayList<>();
                ResultSetMetaData meta = rs.getMetaData();
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    fields.add(new Field(meta.getColumnLabel(i), rs.getObject(i), meta.getColumnTypeName(i)));
                }
                records.add(new RecordView(seq++, fields));
            }
            return records;
        }
    }
}
