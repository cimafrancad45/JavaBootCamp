package com.company.reccolldao.dao;

import com.company.reccolldao.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AlbumDaoJdbcTemplateImpl implements AlbumDao {
    //prepared statement strings
    private static final String INSERT_ALBUM_SQL =
            "insert into album (album_id, title, artist_id, release_date, label_id, list_price) values (?,?,?,?,?,?)";
    private static final String GET_ALBUM_SQL =
            "select * from album where id = ?";
    private static final String GET_ALL_ALBUMS_SQL=
            "select * from album";
    private static final String UPDATE_ALBUM_SQL =
            "update album set title= ?, artist_id = ?, release_date = ?, label_id = ?, list_price = ?";
    private static final String DELETE_ALBUM_SQL =
            "delete from album where id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AlbumDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private Album mapRowtoAlbum(ResultSet rs, int rowNum) throws SQLException {
        Album album = new Album();
        album.setId(rs.getInt("album_id"));
        album.setTitle(rs.getString("title"));
        album.setArtistId(rs.getInt("artist_id"));
        album.setReleaseDate(rs.getDate("release_date"));
        album.setLabelId(rs.getInt("label_id"));
        album.setListPrice(rs.getBigDecimal("list_price"));
    }
    @Override
    public Album addAlbum(Album album) {
        \
                return null;
    }

    @Override
    public Album getAlbum(int id) {
        return null;
    }

    @Override
    public List<Album> getAllAlbums() {
        return null;
    }

    @Override
    public void updateAlbum(Album album) {

    }

    @Override
    public void deleteAlbum(int id) {

    }
}
