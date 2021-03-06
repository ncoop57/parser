/*
Copyright 2017 Mattia Atzeni, Maurizio Atzori

This file is part of CodeOntology.

CodeOntology is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

CodeOntology is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with CodeOntology.  If not, see <http://www.gnu.org/licenses/>
*/

package org.codeontology.extraction.support;

import com.hp.hpl.jena.rdf.model.Resource;
import org.codeontology.Ontology;
import spoon.reflect.declaration.ModifierKind;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public enum Modifier {
    PUBLIC (Ontology.PUBLIC_INDIVIDUAL),
    PRIVATE (Ontology.PRIVATE_INDIVIDUAL),
    PROTECTED (Ontology.PROTECTED_INDIVIDUAL),
    DEFAULT (Ontology.DEFAULT_INDIVIDUAL),
    ABSTRACT (Ontology.ABSTRACT_INDIVIDUAL),
    FINAL (Ontology.FINAL_INDIVIDUAL),
    STATIC (Ontology.STATIC_INDIVIDUAL),
    SYNCHRONIZED (Ontology.SYNCHRONIZED_INDIVIDUAL),
    VOLATILE (Ontology.VOLATILE_INDIVIDUAL);

    private Resource individual;

    Modifier(Resource individual) {
        this.individual = individual;
    }

    public Resource getIndividual() {
        return individual;
    }

    public static List<Modifier> asList(Set<ModifierKind> set) {
        List<Modifier> list = new ArrayList<>();
        for (ModifierKind current : set) {
            Modifier modifier = valueOf(current);
            if (modifier != null) {
                list.add(modifier);
            }
        }
        return list;
    }

    public static List<Modifier> asList(int code) {
        List<Modifier> list = new ArrayList<>();
        if (java.lang.reflect.Modifier.isPublic(code)) {
            list.add(PUBLIC);
        } else if (java.lang.reflect.Modifier.isPrivate(code)) {
            list.add(PRIVATE);
        } else if (java.lang.reflect.Modifier.isProtected(code)) {
            list.add(PROTECTED);
        } else {
            list.add(DEFAULT);
        }

        if (java.lang.reflect.Modifier.isAbstract(code)) {
            list.add(ABSTRACT);
        }

        if (java.lang.reflect.Modifier.isFinal(code)) {
            list.add(FINAL);
        }

        if (java.lang.reflect.Modifier.isStatic(code)) {
            list.add(STATIC);
        }

        if (java.lang.reflect.Modifier.isSynchronized(code)) {
            list.add(SYNCHRONIZED);
        }

        if (java.lang.reflect.Modifier.isVolatile(code)) {
            list.add(VOLATILE);
        }

        return list;
    }

    public static Modifier valueOf(ModifierKind modifier) {
        if (modifier != null) {
            switch (modifier) {
                case PUBLIC:
                    return PUBLIC;
                case PRIVATE:
                    return PRIVATE;
                case PROTECTED:
                    return PROTECTED;
                case ABSTRACT:
                    return ABSTRACT;
                case FINAL:
                    return FINAL;
                case STATIC:
                    return STATIC;
                case SYNCHRONIZED:
                    return SYNCHRONIZED;
                case VOLATILE:
                    return VOLATILE;
            }
        }

        return null;
    }
}