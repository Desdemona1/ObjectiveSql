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
package com.github.braisdom.jds.metamodel;

import java.util.Optional;
import com.github.braisdom.jds.ast.body.ReceiverParameter;
import com.github.braisdom.jds.ast.Generated;

/**
 * This file, class, and its contents are completely generated based on:
 * <ul>
 *     <li>The contents and annotations within the package `com.github.braisdom.jds.ast`, and</li>
 *     <li>`ALL_NODE_CLASSES` within the class `com.github.braisdom.jds.generator.metamodel.MetaModelGenerator`.</li>
 * </ul>
 *
 * For this reason, any changes made directly to this file will be overwritten the next time generators are run.
 */
@Generated("com.github.braisdom.jds.generator.metamodel.NodeMetaModelGenerator")
public class ReceiverParameterMetaModel extends NodeMetaModel {

    @Generated("com.github.braisdom.jds.generator.metamodel.NodeMetaModelGenerator")
    ReceiverParameterMetaModel(Optional<BaseNodeMetaModel> superBaseNodeMetaModel) {
        super(superBaseNodeMetaModel, ReceiverParameter.class, "ReceiverParameter", "com.github.braisdom.jds.ast.body", false, false);
    }

    public PropertyMetaModel annotationsPropertyMetaModel;

    public PropertyMetaModel namePropertyMetaModel;

    public PropertyMetaModel typePropertyMetaModel;
}
