/*
 * BaseEntity.java
 *
 */

package de.uni_stuttgart.vis.vowl.owl2vowl.model;

import de.uni_stuttgart.vis.vowl.owl2vowl.constants.Vowl_Lang;
import de.uni_stuttgart.vis.vowl.owl2vowl.export.JsonGeneratorVisitor;
import de.uni_stuttgart.vis.vowl.owl2vowl.model.nodes.BaseNode;
import de.uni_stuttgart.vis.vowl.owl2vowl.parser.container.Annotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vincent Link, Eduard Marbach
 */
public class BaseEntity {
	protected String id;
	protected String name;
	protected String comment;
	protected String type;
	protected String iri;
	protected String definedBy;
	protected String owlVersion;
	protected List<String> attributes;
	protected List<BaseNode> subClasses;
	protected List<BaseNode> superClasses;
	protected Map<String, String> comments;
	protected Map<String, String> labels;
	protected Map<String, List<Annotation>> annotations;

	/**
	 * Creates a new class object in owl form.
	 * Used for converting the RDF/XML and OWL/XML to the WebVOWL format.
	 */
	public BaseEntity() {
		attributes = new ArrayList<String>();
		subClasses = new ArrayList<BaseNode>();
		superClasses = new ArrayList<BaseNode>();
		comments = new HashMap<String, String>();
		labels = new HashMap<String, String>();
		annotations = new HashMap<String, List<Annotation>>();
	}

	public Map<String, List<Annotation>> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Map<String, List<Annotation>> annotations) {
		this.annotations = annotations;
	}

	public Map<String, String> getComments() {
		return comments;
	}

	public void setComments(Map<String, String> comments) {
		this.comments = comments;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public void setLabels(Map<String, String> labels) {
		this.labels = labels;
	}

	public void setName(String name) {
		labels.put(Vowl_Lang.LANG_DEFAULT, name);
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		comments.put(Vowl_Lang.LANG_DEFAULT, comment);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIri() {
		return iri;
	}

	public void setIri(String iri) {
		this.iri = iri;
	}

	public List<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

	public List<BaseNode> getSubClasses() {
		return subClasses;
	}

	public void setSubClasses(List<BaseNode> subClasses) {
		this.subClasses = subClasses;
	}

	public List<BaseNode> getSuperClasses() {
		return superClasses;
	}

	public void setSuperClasses(List<BaseNode> superClasses) {
		this.superClasses = superClasses;
	}

	public String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	public String getOwlVersion() {
		return owlVersion;
	}

	public void setOwlVersion(String owlVersion) {
		this.owlVersion = owlVersion;
	}

	public String getDefinedBy() {
		return definedBy;
	}

	public void setDefinedBy(String definedBy) {
		this.definedBy = definedBy;
	}

	public void accept(JsonGeneratorVisitor visitor) {
		visitor.visit(this);
	}
}
