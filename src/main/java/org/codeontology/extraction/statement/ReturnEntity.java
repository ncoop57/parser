package org.codeontology.extraction.statement;

import com.hp.hpl.jena.rdf.model.RDFNode;
import org.codeontology.Ontology;
import org.codeontology.extraction.expression.ExpressionEntity;
import org.codeontology.extraction.support.ExpressionHolderEntity;
import org.codeontology.extraction.support.ExpressionTagger;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtReturn;

public class ReturnEntity extends StatementEntity<CtReturn<?>> implements ExpressionHolderEntity<CtReturn<?>> {

    public ReturnEntity(CtReturn<?> element) {
        super(element);
    }

    @Override
    protected RDFNode getType() {
        return Ontology.RETURN_ENTITY;
    }

    @Override
    public void extract() {
        super.extract();
        tagExpression();
    }

    @Override
    public ExpressionEntity getExpression() {
        CtExpression<?> returnedExpression = getElement().getReturnedExpression();
        if (returnedExpression != null) {
            ExpressionEntity expression = getFactory().wrap(returnedExpression);
            expression.setParent(this);
            return expression;
        }

        return null;
    }

    @Override
    public void tagExpression() {
        new ExpressionTagger(this).tagExpression(Ontology.RETURNED_EXPRESSION_PROPERTY);
    }
}
