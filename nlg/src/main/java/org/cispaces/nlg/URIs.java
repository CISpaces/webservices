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
public interface URIs {

	public static final String pmArg = "http://www.arg.dundee.ac.uk/aif";
	public static final SimpleDateFormat cispaceDate = new SimpleDateFormat(
			"yyy/MM/dd HH:mm:ss", Locale.ENGLISH);

	public static final SimpleDateFormat xmlDate = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss");

	/**public static final Map<String, String[]> schemesMap;
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

	public final String URI = "http://cispaces.org/";

	public final OntModel m = ModelFactory.createOntologyModel();

	// public final OntClass labellings = m.createClass(URI + "Labellings");
	public final OntClass labelling = m.createClass(URI + "Labelling");
	// public final ObjectProperty containsLab = m.createObjectProperty(URI +
	// "containsLabelling");

	public final DatatypeProperty labName = m
			.createDatatypeProperty(URI + "labelingName");

	public final ObjectProperty inStatement = m
			.createObjectProperty(URI + "inStatement");
	public final ObjectProperty outStatement = m
			.createObjectProperty(URI + "outStatement");
	public final ObjectProperty undecStatement = m
			.createObjectProperty(URI + "undecStatement");

	public final OntClass inference = m
			.createClass("http://arg.dundee.ac.uk/aif#Inference");
	public final OntClass conflict = m
			.createClass("http://arg.dundee.ac.uk/aif#Conflict");
	public final ObjectProperty hasConflictingElement = m.createObjectProperty(
			"http://arg.dundee.ac.uk/aif#hasConflictingElement");
	public final ObjectProperty hasConflictedElement = m.createObjectProperty(
			"http://arg.dundee.ac.uk/aif#hasConflictedElement");

	public final OntClass statement = m
			.createClass("http://arg.dundee.ac.uk/aif#Statement");
	public final DatatypeProperty text = m
			.createDatatypeProperty(URI + "text");
	public final DatatypeProperty creationDate = m
			.createDatatypeProperty("http://arg.dundee.ac.uk/aif#creationDate");
	public final DatatypeProperty createdBy = m
			.createDatatypeProperty("http://arg.dundee.ac.uk/aif#createdBy");
	public final DatatypeProperty claimText = m
			.createDatatypeProperty("http://arg.dundee.ac.uk/aif#claimText");

	public final ObjectProperty fulfils = m
			.createObjectProperty("http://arg.dundee.ac.uk/aif#fulfils");

	public final String lpk = "http://arg.dundee.ac.uk/aif#PositionToKnow_Inference";

	public final String leo = "http://arg.dundee.ac.uk/aif#ExpertOpinion_Inference";
	public final String knowledgePositionDesc = "http://arg.dundee.ac.uk/aif#KnowledgePosition_Desc";
	public final ObjectProperty hasFieldExpertisePremise = m
			.createObjectProperty(
					"http://arg.dundee.ac.uk/aif#hasFieldExpertise_Premise");
	public final String fieldExpertiseDesc = "http://arg.dundee.ac.uk/aif#FieldExpertise_Desc";
	public final ObjectProperty hasKnowledgeAssertionPremise = m
			.createObjectProperty(
					"http://arg.dundee.ac.uk/aif#hasKnowledgeAssertion_Premise");
	public final String knowledgeAssertionDesc = "http://arg.dundee.ac.uk/aif#KnowledgeAssertion_Desc";

	public final String lan = "http://arg.dundee.ac.uk/aif#Analogy_Inference";
	// String lcs = "http://arg.dundee.ac.uk/aif#ExpertOpinion_Inference";

	public final String lce = "http://arg.dundee.ac.uk/aif#CauseToEffect_Inference";
	public final String causalDesc = "http://arg.dundee.ac.uk/aif#Causal_Desc";
	public final String occurrenceADesc = "http://arg.dundee.ac.uk/aif#OccurrenceA_Desc";
	public final String occurrenceBDesc = "http://arg.dundee.ac.uk/aif#OccurrenceB_Desc";
	public final ObjectProperty hasCausalPremise = m.createObjectProperty(
			"http://arg.dundee.ac.uk/aif#hasCausal_Premise");
	public final ObjectProperty hasOccurrenceAPremise = m.createObjectProperty(
			"http://arg.dundee.ac.uk/aif#hasOccurrenceA_Premise");

	public final ObjectProperty hasPremise = m
			.createObjectProperty("http://arg.dundee.ac.uk/aif#hasPremise");
	public final ObjectProperty hasConclusion = m
			.createObjectProperty("http://arg.dundee.ac.uk/aif#hasConclusion");

	
}
