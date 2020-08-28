/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2020 The JavaParser Team.
 *
 * This file is part of JavaParser.
 *
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */
package com.github.braisdom.jds.ast.expr;

import com.github.braisdom.jds.ast.AllFieldsConstructor;
import com.github.braisdom.jds.ast.observer.ObservableProperty;
import com.github.braisdom.jds.ast.visitor.GenericVisitor;
import com.github.braisdom.jds.ast.visitor.VoidVisitor;
import java.util.Optional;
import com.github.braisdom.jds.ast.Node;
import com.github.braisdom.jds.ast.visitor.CloneVisitor;
import com.github.braisdom.jds.metamodel.OptionalProperty;
import com.github.braisdom.jds.metamodel.ThisExprMetaModel;
import com.github.braisdom.jds.metamodel.JavaParserMetaModel;
import com.github.braisdom.jds.TokenRange;
import com.github.braisdom.jds.resolution.Resolvable;
import com.github.braisdom.jds.resolution.declarations.ResolvedTypeDeclaration;
import java.util.function.Consumer;
import com.github.braisdom.jds.ast.Generated;

/**
 * An occurrence of the "this" keyword. <br>
 * {@code World.this.greet()} is a MethodCallExpr of method name greet,
 * and scope "World.this" which is a ThisExpr with typeName "World". <br>
 * {@code this.name} is a FieldAccessExpr of field greet, and a ThisExpr as its scope.
 * This ThisExpr has no typeName.
 *
 * @author Julio Vilmar Gesser
 * @see com.github.braisdom.jds.ast.stmt.ExplicitConstructorInvocationStmt
 * @see SuperExpr
 */
public class ThisExpr extends Expression implements Resolvable<ResolvedTypeDeclaration> {

    @OptionalProperty
    private Name typeName;

    public ThisExpr() {
        this(null, null);
    }

    @AllFieldsConstructor
    public ThisExpr(final Name typeName) {
        this(null, typeName);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.braisdom.jds.generator.core.node.MainConstructorGenerator")
    public ThisExpr(TokenRange tokenRange, Name typeName) {
        super(tokenRange);
        setTypeName(typeName);
        customInitialization();
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.AcceptGenerator")
    public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
        return v.visit(this, arg);
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.AcceptGenerator")
    public <A> void accept(final VoidVisitor<A> v, final A arg) {
        v.visit(this, arg);
    }

    @Generated("com.github.braisdom.jds.generator.core.node.PropertyGenerator")
    public Optional<Name> getTypeName() {
        return Optional.ofNullable(typeName);
    }

    @Generated("com.github.braisdom.jds.generator.core.node.PropertyGenerator")
    public ThisExpr setTypeName(final Name typeName) {
        if (typeName == this.typeName) {
            return (ThisExpr) this;
        }
        notifyPropertyChange(ObservableProperty.TYPE_NAME, this.typeName, typeName);
        if (this.typeName != null)
            this.typeName.setParentNode(null);
        this.typeName = typeName;
        setAsParentNodeOf(typeName);
        return this;
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        if (typeName != null) {
            if (node == typeName) {
                removeTypeName();
                return true;
            }
        }
        return super.remove(node);
    }

    @Generated("com.github.braisdom.jds.generator.core.node.RemoveMethodGenerator")
    public ThisExpr removeClassName() {
        return setTypeName((Name) null);
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.CloneGenerator")
    public ThisExpr clone() {
        return (ThisExpr) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.GetMetaModelGenerator")
    public ThisExprMetaModel getMetaModel() {
        return JavaParserMetaModel.thisExprMetaModel;
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        if (typeName != null) {
            if (node == typeName) {
                setTypeName((Name) replacementNode);
                return true;
            }
        }
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.TypeCastingGenerator")
    public boolean isThisExpr() {
        return true;
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.TypeCastingGenerator")
    public ThisExpr asThisExpr() {
        return this;
    }

    @Generated("com.github.braisdom.jds.generator.core.node.TypeCastingGenerator")
    public void ifThisExpr(Consumer<ThisExpr> action) {
        action.accept(this);
    }

    @Override
    public ResolvedTypeDeclaration resolve() {
        return getSymbolResolver().resolveDeclaration(this, ResolvedTypeDeclaration.class);
    }

    @Override
    @Generated("com.github.braisdom.jds.generator.core.node.TypeCastingGenerator")
    public Optional<ThisExpr> toThisExpr() {
        return Optional.of(this);
    }

    @Generated("com.github.braisdom.jds.generator.core.node.RemoveMethodGenerator")
    public ThisExpr removeTypeName() {
        return setTypeName((Name) null);
    }
}
