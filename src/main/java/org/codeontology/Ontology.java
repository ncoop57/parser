package org.codeontology;

/**
 * Provide basic interfaces with default ontologies.
 */

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * General programming language ontology interface.
 */
public class Ontology {

    public static final String RDF = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    public static final String RDFS = "http://www.w3.org/2000/01/rdf-schema#";
    public static final String WOC = "http://rdf.webofcode.org/woc/";

    private static Model ontology() {
        try {
            File ontology = new File(System.getProperty("user.dir") + "/ontology/woc.xml");
            FileInputStream reader = new FileInputStream(ontology);
            return ModelFactory.createDefaultModel().read(reader, "");
        } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
        }
    }

    public static Model getModel() {
        return ModelFactory.createDefaultModel();
    }

    public static Model model = ontology();

    public static final Resource PACKAGE_ENTITY = model.getResource(WOC + "Package");

    public static final Resource CLASS_ENTITY = model.getResource(WOC + "Class");

    public static final Resource INTERFACE_ENTITY = model.getResource(WOC + "Interface");

    public static final Resource ENUM_ENTITY = model.getResource(WOC + "Enum");

    public static final Resource ANNOTATION_ENTITY = model.getResource(WOC + "Annotation");

    public static final Resource PRIMITIVE_ENTITY = model.getResource(WOC + "Primitive");

    public static final Resource ARRAY_ENTITY = model.getResource(WOC + "Array");

    public static final Resource TYPE_VARIABLE_ENTITY =  model.getResource(WOC + "TypeVariable");

    public static final Resource PARAMETERIZED_TYPE_ENTITY =  model.getResource(WOC + "ParameterizedType");

    public static final Resource FIELD_ENTITY =  model.getResource(WOC + "Field");

    public static final Resource CONSTRUCTOR_ENTITY = model.getResource(WOC + "Constructor");

    public static final Resource METHOD_ENTITY = model.getResource(WOC + "Method");

    public static final Resource PARAMETER_ENTITY = model.getResource(WOC + "Parameter");

    public static final Resource VARIABLE_ENTITY = model.getResource(WOC + "Variable");

    public static final Resource LAMBDA_ENTITY = model.getResource(WOC + "Lambda");

    public static final Resource ANONYMOUS_CLASS_ENTITY = model.getResource(WOC + "AnonymousClass");

    public static final Resource TYPE_ARGUMENT_ENTITY = model.getResource(WOC + "TypeArgument");

    public static final Resource WILDCARD_ENTITY = model.getResource(WOC + "Wildcard");

    public static final Resource PROJECT_ENTITY = model.getResource(WOC + "Project");

    public static final Resource MAVEN_PROJECT_ENTITY = model.getResource(WOC + "MavenProject");

    public static final Resource GRADLE_PROJECT_ENTITY = model.getResource(WOC + "GradleProject");

    public static final Resource ANDROID_PROJECT_ENTITY = model.getResource(WOC + "AndroidProject");

    public static final Resource JAR_FILE_ENTITY = model.getResource(WOC + "JarFile");

    public static final Resource STATEMENT_ENTITY = model.getResource(WOC + "Statement");

    public static final Resource BLOCK_ENTITY = model.getResource(WOC + "Block");

    public static final Resource IF_THEN_ELSE_ENTITY = model.getResource(WOC + "IfThenElseStatement");

    public static final Resource SWITCH_ENTITY = model.getResource(WOC + "SwitchStatement");

    public static final Resource WHILE_ENTITY = model.getResource(WOC + "WhileStatement");

    public static final Resource DO_WHILE_ENTITY = model.getResource(WOC + "DoStatement");

    public static final Resource FOR_ENTITY = model.getResource(WOC + "ForStatement");

    public static final Resource FOR_EACH_ENTITY = model.getResource(WOC + "ForEachStatement");

    public static final Resource TRY_ENTITY = model.getResource(WOC + "TryStatement");

    public static final Resource RETURN_ENTITY = model.getResource(WOC + "ReturnStatement");

    public static final Resource THROW_ENTITY = model.getResource(WOC + "ThrowSatement");

    public static final Resource BREAK_ENTITY = model.getResource(WOC + "BreakStatement");

    public static final Resource CONTINUE_ENTITY = model.getResource(WOC + "ContinueStatement");

    public static final Resource ASSERT_ENTITY = model.getResource(WOC + "AssertStatement");

    public static final Resource STATEMENT_EXPRESSION_LIST_ENTITY = model.getResource(WOC + "StatementExpressionList");

    public static final Resource EXPRESSION_ENTITY = model.getResource(WOC + "Expression");


    public static final Property RDF_TYPE_PROPERTY = model.getProperty(RDF + "type");

    public static final Property RDFS_LABEL_PROPERTY = model.getProperty(RDFS + "label");

    public static final Property JAVA_TYPE_PROPERTY = model.getProperty(WOC + "type");

    public static final Property COMMENT_PROPERTY = model.getProperty(RDFS + "comment");

    public static final Property NAME_PROPERTY = model.getProperty(WOC + "name");

    public static final Property DECLARED_BY_PROPERTY = model.getProperty(WOC + "declaredBy");

    public static final Property RETURNS_PROPERTY = model.getProperty(WOC + "returns");

    public static final Property RETURNS_VAR_PROPERTY = model.getProperty(WOC + "returnsVar");

    public static final Property RETURNS_FIELD_PROPERTY = model.getProperty(WOC + "returnsField");

    public static final Property CONSTRUCTS_PROPERTY = model.getProperty(WOC + "constructs");

    public static final Property PARAMETER_PROPERTY = model.getProperty(WOC + "parameter");

    public static final Property POSITION_PROPERTY = model.getProperty(WOC + "position");

    public static final Property SOURCE_CODE_PROPERTY = model.getProperty(WOC + "sourceCode");

    public static final Property THROWS_PROPERTY = model.getProperty(WOC + "throws");

    public static final Property NESTED_IN_PROPERTY = model.getProperty(WOC + "nestedIn");

    public static final Property MODIFIER_PROPERTY = model.getProperty(WOC + "modifier");

    public static final Property VISIBILITY_PROPERTY = model.getProperty(WOC + "visibility");

    public static final Property REQUESTS_PROPERTY = model.getProperty(WOC + "requests");

    public static final Property EXTENDS_PROPERTY = model.getProperty(WOC + "extends");

    public static final Property IMPLEMENTS_PROPERTY = model.getProperty(WOC + "implements");

    public static final Property SUPER_PROPERTY = model.getProperty(WOC + "super");

    public static final Property PACKAGE_OF_PROPERTY = model.getProperty(WOC + "packageOf");

    public static final Property ARRAY_OF_PROPERTY = model.getProperty(WOC + "arrayOf");

    public static final Property DIMENSIONS_PROPERTY = model.getProperty(WOC + "dimensions");

    public static final Property FORMAL_TYPE_PARAMETER_PROPERTY = model.getProperty(WOC + "formalTypeParameter");

    public static final Property ACTUAL_TYPE_ARGUMENT_PROPERTY = model.getProperty(WOC + "actualTypeArgument");

    public static final Property RAW_TYPE_PROPERTY = model.getProperty(WOC + "rawType");

    public static final Property ANNOTATION_PROPERTY = model.getProperty(WOC + "annotation");

    public static final Property OVERRIDES_PROPERTY = model.getProperty(WOC + "overrides");

    public static final Property VAR_ARGS_PROPERTY = model.getProperty(WOC + "isVarArgs");

    public static final Property SUBPROJECT_PROPERTY = model.getProperty(WOC + "subProject");

    public static final Property BUILD_FILE_PROPERTY = model.getProperty(WOC + "buildFile");

    public static final Property DEPENDENCY_PROPERTY = model.getProperty(WOC + "dependency");

    public static final Property LINE_PROPERTY = model.getProperty(WOC + "line");

    public static final Property CONDITION_PROPERTY = model.getProperty(WOC + "condition");

    public static final Property STATEMENT_PROPERTY = model.getProperty(WOC + "statement");

    public static final Property THEN_PROPERTY = model.getProperty(WOC + "thenStatement");

    public static final Property ELSE_PROPERTY = model.getProperty(WOC + "elseStatement");

    public static final Property BODY_PROPERTY = model.getProperty(WOC + "body");

    public static final Property END_LINE_PROPERTY = model.getProperty(WOC + "endLine");

    public static final Property FOR_INIT_PROPERTY = model.getProperty(WOC + "forInit");

    public static final Property FOR_UPDATE_PROPERTY = model.getProperty(WOC + "forUpdate");

    public static final Property EXPRESSION_PROPERTY = model.getProperty(WOC + "expression");

    public static final Property RETURNED_EXPRESSION_PROPERTY = model.getProperty(WOC + "returnedExpression");

    public static final Property THROWN_EXPRESSION_PROPERTY = model.getProperty(WOC + "thrownExpression");

    public static final Property ASSERT_EXPRESSION_PROPERTY = model.getProperty(WOC + "assertExpression");

    public static final Property VARIABLE_PROPERTY = model.getProperty(WOC + "variable");

    public static final Property CATCH_CLAUSE_PROPERTY = model.getProperty(WOC + "catch");

    public static final Property CATCH_FORMAL_PARAMETER_PROPERTY = model.getProperty(WOC + "catchFormalParameter");

    public static final Property FINALLY_CLAUSE_PROPERTY = model.getProperty(WOC + "finally");

    public static final Property RESOURCE_PROPERTY = model.getProperty(WOC + "resource");

    public static final Property TARGETED_LABEL_PROPERTY = model.getProperty(WOC + "targetedLabel");

    public static final Property WOC_LABEL_PROPERTY = model.getProperty(WOC + "label");


    public static final Resource PUBLIC_INDIVIDUAL = model.getResource(WOC + "Public");

    public static final Resource PRIVATE_INDIVIDUAL = model.getResource(WOC + "Private");

    public static final Resource PROTECTED_INDIVIDUAL = model.getResource(WOC + "Protected");

    public static final Resource DEFAULT_INDIVIDUAL = model.getResource(WOC + "Default");

    public static final Resource ABSTRACT_INDIVIDUAL = model.getResource(WOC + "Abstract");

    public static final Resource FINAL_INDIVIDUAL = model.getResource(WOC + "Final");

    public static final Resource STATIC_INDIVIDUAL = model.getResource(WOC + "Static");

    public static final Resource SYNCHRONIZED_INDIVIDUAL = model.getResource(WOC + "Synchronized");

    public static final Resource VOLATILE_INDIVIDUAL = model.getResource(WOC + "Volatile");

}

