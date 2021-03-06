package com.github.braisdom.objsql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SQLExecutor<T> {

    List<T> query(Connection connection, String sql, DomainModelDescriptor domainModelDescriptor, Object... params) throws SQLException;

    T insert(Connection connection, String sql, DomainModelDescriptor domainModelDescriptor, Object... params) throws SQLException;

    int[] insert(Connection connection, String sql, DomainModelDescriptor domainModelDescriptor, Object[][] params) throws SQLException;

    int execute(Connection connection, String sql, Object... params) throws SQLException;

}
