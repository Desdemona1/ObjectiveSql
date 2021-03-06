package com.github.braisdom.objsql;

import com.github.braisdom.objsql.relation.Relationship;
import com.github.braisdom.objsql.relation.RelationshipNetwork;
import com.github.braisdom.objsql.util.StringUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class DefaultQuery<T> extends AbstractQuery<T> {

    private static final String SELECT_STATEMENT = "SELECT %s FROM %s";

    public DefaultQuery(Class<T> domainModelClass) {
        super(domainModelClass);
    }

    @Override
    public List<T> execute(Relationship... relationships) throws SQLException {
        ConnectionFactory connectionFactory = Databases.getConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        try {
            String tableName = domainModelDescriptor.getTableName();
            String sql = createQuerySQL(tableName, projection, filter, groupBy,
                    having, orderBy, offset, limit);
            List<T> rows = executeInternally(connection, sql);

            if (relationships.length > 0)
                new RelationshipNetwork(connection, domainModelDescriptor).process(rows, relationships);

            return rows;
        } finally {
            if (connection != null)
                connection.close();
        }
    }

    @Override
    public T queryFirst(Relationship... relationships) throws SQLException {
        List<T> results = execute(relationships);
        if (results.size() > 0)
            return results.get(0);
        return null;
    }

    @Override
    public <C extends Class> List<C> execute(C relevantDomainClass, Relationship... relationships) throws SQLException {
        String sql = createQuerySQL(getTableName(relevantDomainClass), projection, filter, groupBy,
                having, orderBy, offset, limit);

        return null;
    }

    private String createQuerySQL(String tableName, String projections, String filter, String groupBy,
                                  String having, String orderBy, int offset, int limit) {
        Objects.requireNonNull(tableName, "The tableName cannot be null");

        StringBuilder sql = new StringBuilder();

        projections = (projections == null || projections.length() < 0) ? "*" : projections;
        String standardSql = String.format(SELECT_STATEMENT, projections, tableName);

        sql.append(standardSql);

        if (!StringUtil.isBlank(filter))
            sql.append(" WHERE ").append(filter);

        if (!StringUtil.isBlank(groupBy))
            sql.append(" GROUP BY ").append(groupBy);

        if (!StringUtil.isBlank(having))
            sql.append(" HAVING ").append(having);

        if (!StringUtil.isBlank(orderBy))
            sql.append(" ORDER BY ").append(orderBy);

        if (offset > 0)
            sql.append(" OFFSET ").append(offset);

        if (limit > 0)
            sql.append(" LIMIT ").append(limit);

        return sql.toString();
    }
}
