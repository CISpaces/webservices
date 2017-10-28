package org.cispaces.nlg;
/**
 * Copyright (c) 2017 Federico Cerutti <CeruttiF@cardiff.ac.uk>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;

/**
 * Interface with final URIs and properties used when transforming
 * the JSON format into the OWL AIF model
 * @author Federico Cerutti <CeruttiF@cardiff.ac.uk>
 *
 */
public abstract class URIs {

	protected String pmArg = "http://www.arg.dundee.ac.uk/aif";
	protected SimpleDateFormat cispaceDate = new SimpleDateFormat(
			"yyy/MM/dd HH:mm:ss", Locale.ENGLISH);

	protected SimpleDateFormat xmlDate = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss");

	/**protected Map<String, String[]> schemesMap;
	static {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("LPV", new String[]{pmArg + "#Provenance_Inference",
				pmArg + "#Provenance_Scheme"});
		map.put("LPK", new String[]{pmArg + "#PositionToKnow_Inference",
				pmArg + "#PositionToKnow_Scheme"});
		map.put("LEO", new String[]{pmArg + "#ExpertOpinion_Inference",
				pmArg + "#ExpertOpinion_Scheme"});
		map.put("LAN", new String[]{pmArg + "#Analogy_Inference",
				pmArg + "#Analogy_Scheme"});
		map.put("LCS", new String[]{pmArg + "#CrowdOpinion_Inference",
				pmArg + "#CrowdOpinion_Scheme"});
		map.put("LCE", new String[]{pmArg + "#CauseToEffect_Inference",
				pmArg + "#CauseToEffect_Scheme"});

		schemesMap = Collections.unmodifiableMap(map);
	}*/

	protected String URI = "http://cispaces.org/";

	protected OntModel m = ModelFactory.createOntologyModel();

	// protected OntClass labellings = m.createClass(URI + "Labellings");
	protected OntClass labelling = m.createClass(URI + "Labelling");
	// protected ObjectProperty containsLab = m.createObjectProperty(URI +
	// "containsLabelling");

	protected DatatypeProperty labName = m
			.createDatatypeProperty(URI + "labelingName");

	protected ObjectProperty inStatement = m
			.createObjectProperty(URI + "inStatement");
	protected ObjectProperty outStatement = m
			.createObjectProperty(URI + "outStatement");
	protected ObjectProperty undecStatement = m
			.createObjectProperty(URI + "undecStatement");

	protected OntClass inference = m
			.createClass("http://arg.dundee.ac.uk/aif#Inference");
	protected OntClass conflict = m
			.createClass("http://arg.dundee.ac.uk/aif#Conflict");
	protected ObjectProperty hasConflictingElement = m.createObjectProperty(
			"http://arg.dundee.ac.uk/aif#hasConflictingElement");
	protected ObjectProperty hasConflictedElement = m.createObjectProperty(
			"http://arg.dundee.ac.uk/aif#hasConflictedElement");

	protected OntClass statement = m
			.createClass("http://arg.dundee.ac.uk/aif#Statement");
	protected DatatypeProperty text = m
			.createDatatypeProperty(URI + "text");
	protected DatatypeProperty creationDate = m
			.createDatatypeProperty("http://arg.dundee.ac.uk/aif#creationDate");
	protected DatatypeProperty createdBy = m
			.createDatatypeProperty("http://arg.dundee.ac.uk/aif#createdBy");
	protected DatatypeProperty claimText = m
			.createDatatypeProperty("http://arg.dundee.ac.uk/aif#claimText");

	protected ObjectProperty fulfils = m
			.createObjectProperty("http://arg.dundee.ac.uk/aif#fulfils");

	protected String lpk = "http://arg.dundee.ac.uk/aif#PositionToKnow_Inference";

	protected String leo = "http://arg.dundee.ac.uk/aif#ExpertOpinion_Inference";
	protected String knowledgePositionDesc = "http://arg.dundee.ac.uk/aif#KnowledgePosition_Desc";
	protected ObjectProperty hasFieldExpertisePremise = m
			.createObjectProperty(
					"http://arg.dundee.ac.uk/aif#hasFieldExpertise_Premise");
	protected String fieldExpertiseDesc = "http://arg.dundee.ac.uk/aif#FieldExpertise_Desc";
	protected ObjectProperty hasKnowledgeAssertionPremise = m
			.createObjectProperty(
					"http://arg.dundee.ac.uk/aif#hasKnowledgeAssertion_Premise");
	protected String knowledgeAssertionDesc = "http://arg.dundee.ac.uk/aif#KnowledgeAssertion_Desc";

	protected String lan = "http://arg.dundee.ac.uk/aif#Analogy_Inference";
	// String lcs = "http://arg.dundee.ac.uk/aif#ExpertOpinion_Inference";

	protected String lce = "http://arg.dundee.ac.uk/aif#CauseToEffect_Inference";
	protected String causalDesc = "http://arg.dundee.ac.uk/aif#Causal_Desc";
	protected String occurrenceADesc = "http://arg.dundee.ac.uk/aif#OccurrenceA_Desc";
	protected String occurrenceBDesc = "http://arg.dundee.ac.uk/aif#OccurrenceB_Desc";
	protected ObjectProperty hasCausalPremise = m.createObjectProperty(
			"http://arg.dundee.ac.uk/aif#hasCausal_Premise");
	protected ObjectProperty hasOccurrenceAPremise = m.createObjectProperty(
			"http://arg.dundee.ac.uk/aif#hasOccurrenceA_Premise");

	protected ObjectProperty hasPremise = m
			.createObjectProperty("http://arg.dundee.ac.uk/aif#hasPremise");
	protected ObjectProperty hasConclusion = m
			.createObjectProperty("http://arg.dundee.ac.uk/aif#hasConclusion");
	
	protected ObjectProperty basedOn = m.createObjectProperty(URI + "basedOn");

	
}
