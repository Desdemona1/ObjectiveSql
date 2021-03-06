package com.github.braisdom.objsql.sql;

import com.github.braisdom.objsql.Tables;

import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractTable extends AbstractExpression implements Dataset {

    protected final Class modelClass;

    public AbstractTable(Class modelClass) {
        Objects.requireNonNull(modelClass, "The modelClass cannot be null");
        this.modelClass = modelClass;
    }

    @Override
    public String toSql(ExpressionContext expressionContext) {
        String[] nameParts = Tables.getTableName(modelClass).split("\\.");
        String[] quotedNameParts = Arrays.stream(nameParts)
                .map(namePart -> expressionContext.quoteTable(namePart)).toArray(String[]::new);
        String tableAlias = expressionContext.getAlias(this, true);
        return String.format("%s AS %s", String.join("\\.", quotedNameParts), tableAlias);
    }
}
