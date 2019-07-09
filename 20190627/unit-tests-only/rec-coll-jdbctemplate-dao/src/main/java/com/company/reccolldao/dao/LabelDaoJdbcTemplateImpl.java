package com.company.reccolldao.dao;

import com.company.reccolldao.model.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LabelDaoJdbcTemplateImpl implements LabelDao {
    private JdbcTemplate jdbcTemplate;
    //statements
    private static final String INSERT_LABEL_SQL =
            "insert into label (name, website) values (?, ?)";
    private static final String SELECT_LABEL_SQL =
            "select * from label where label_id = ?";
    private static final String SELECT_ALL_LABELS_SQL =
            "select * from label";
    private static final String UPDATE_LABEL_SQL =
            "update label set name = ?, website = ?";
    private static final String DELETE_LABEL_SQL =
            "delete from label where label_id = ?";



    private Label mapToLabel(ResultSet rs, int rowNum) throws SQLException{
        Label label = new Label();
        label.setId(rs.getInt("label_id"));
        label.setName(rs.getString("name"));
        label.setWebsite(rs.getString("website"));


        return label;
    }



    @Autowired
    public LabelDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate){
        this.jdbcTemplate = newJdbcTemplate;
    }



    @Override
    @Transactional
    public Label addLabel(Label label) {
        jdbcTemplate.update(INSERT_LABEL_SQL,
                label.getName(),
                label.getWebsite());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        label.setId(id);

        return label;
    }

    @Override
    public Label getLabel(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_LABEL_SQL, this::mapToLabel, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Label> getAllLabels() {
        return jdbcTemplate.query(SELECT_ALL_LABELS_SQL, this::mapToLabel);
    }

    @Override
    public void updateLabel(Label label) {
        jdbcTemplate.update(UPDATE_LABEL_SQL,
                label.getName(),
                label.getWebsite());

    }

    @Override
    public void deleteLabel(int id) {
        jdbcTemplate.update(DELETE_LABEL_SQL, id);

    }
}
