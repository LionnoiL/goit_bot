package ua.dpw.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatementParameters<T, E> {

    private final List<Parameter> items = new ArrayList<Parameter>();

    public StatementParameters() {
    }

    public StatementParameters(T value, E value2) {
        items.add(new Parameter<T>(value));
        items.add(new Parameter<E>(value2));
    }

    public StatementParameters(T value) {
        items.add(new Parameter<T>(value));
    }

    public void add(Parameter parametr) {
        items.add(parametr);
    }

    public void add(T value) {
        items.add(new Parameter<T>(value));
    }

    public List<Parameter> getItems() {
        return items;
    }

    public void fillStatement(PreparedStatement statement) throws SQLException {
        List<Parameter> params = getItems();
        int index = 1;
        for (Parameter p : params) {
            statement.setObject(index++, p.getValue());
        }
    }
}

