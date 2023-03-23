package ua.dpw.database;

import java.sql.ResultSet;

public interface Mapper<T> {
    T map(ResultSet rs);
}