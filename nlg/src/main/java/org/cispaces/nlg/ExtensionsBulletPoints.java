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

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Selector;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.rulesys.GenericRuleReasoner;
import org.apache.jena.reasoner.rulesys.Rule;
import org.apache.jena.util.iterator.ExtendedIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 * Class for generating a sequence of bullet points to summarise an Extension
 * 
 * @author Federico Cerutti <CeruttiF@cardiff.ac.uk>
 *
 */
public class ExtensionsBulletPoints implements URIs {

	private final String newline = "\n";

	private InfModel inf = null;
	
	public ExtensionsBulletPoints(String request, String eval) {
		NLG.log = Logger.getLogger(getClass().getName());


		this.parseJSONGraph(request, eval);
	}

	private void parseJSONGraph(String json, String eval) {
		JSONObject obj = new JSONObject(json);

		JSONObject graph = obj.getJSONObject("graph");

		for (Iterator<Object> it = graph.getJSONArray("nodes").iterator(); it
				.hasNext();) {
			JSONObject t = (JSONObject) it.next();
			Individual node = null;
			if (((String) t.get("type")).equalsIgnoreCase("RA")) {
				node = m.createIndividual(URI + (String) t.get("nodeID"),
						inference);

				if (((String) ((JSONObject) t.get("annot")).get("id"))
						.equalsIgnoreCase("LEO")) {
					m.add(node, fulfils, leo);
				} else if (((String) ((JSONObject) t.get("annot")).get("id"))
						.equalsIgnoreCase("LPK")) {
					m.add(node, fulfils, lpk);
				} else if (((String) ((JSONObject) t.get("annot")).get("id"))
						.equalsIgnoreCase("LAN")) {
					m.add(node, fulfils, lan);
				} else if (((String) ((JSONObject) t.get("annot")).get("id"))
						.equalsIgnoreCase("LCE")) {
					m.add(node, fulfils, lce);
				}

			} else if (((String) t.get("type")).equalsIgnoreCase("CA")) {
				node = m.createIndividual(URI + (String) t.get("nodeID"),
						conflict);
				// todo link with critical questions
			} else if (((String) t.get("type")).equalsIgnoreCase("I")) {
				node = m.createIndividual(URI + (String) t.get("nodeID"),
						statement);
				m.add(node, claimText, m.createLiteral((String) t.get("text")));

				/*
				 * for (Iterator<Object> ranodesIt = t.getJSONObject("annot")
				 * .getJSONObject("prem_assump").names() .iterator();
				 * ranodesIt.hasNext();) { String ranodename = (String)
				 * ranodesIt.next(); Individual ranode = m.getIndividual(URI +
				 * ranodename);
				 * 
				 * if (t.getJSONObject("annot").getJSONObject("prem_assump")
				 * .names() != null) { for (Iterator<Object> ranodesIt =
				 * t.getJSONObject("annot")
				 * .getJSONObject("prem_assump").names() .iterator();
				 * ranodesIt.hasNext();) { String ranodename = (String)
				 * ranodesIt.next(); Individual ranode = m.getIndividual(URI +
				 * ranodename);
				 * 
				 * // LCE if (t.getJSONObject("annot")
				 * .getJSONObject("prem_assump")
				 * .getJSONObject(ranodename).getString("id")
				 * .equalsIgnoreCase("LCE")) { for (int i = 0; i <
				 * t.getJSONObject("annot") .getJSONObject("prem_assump")
				 * .getJSONObject(ranodename) .getJSONArray("prem").length();
				 * i++) { // assuming tha PCE1 means causal desc if
				 * (t.getJSONObject("annot") .getJSONObject("prem_assump")
				 * .getJSONObject(ranodename) .getJSONArray("prem").getString(i)
				 * .equalsIgnoreCase("PCE1")) { m.add(ranode, hasCausalPremise,
				 * node); m.add(node, fulfils, causalDesc); // probably //
				 * useless, // we // can // write // a RL // rule // for // this
				 * } // assuming tha PCE2 means causal desc else if
				 * (t.getJSONObject("annot") .getJSONObject("prem_assump")
				 * .getJSONObject(ranodename) .getJSONArray("prem").getString(i)
				 * .equalsIgnoreCase("PCE2")) { m.add(ranode,
				 * hasOccurrenceAPremise, node); m.add(node, fulfils,
				 * occurrenceADesc); // probably // useless, // we // can //
				 * write // a // RL // rule // for // this }
				 * 
				 * } } // LEO else if (t.getJSONObject("annot")
				 * .getJSONObject("prem_assump")
				 * .getJSONObject(ranodename).getString("id")
				 * .equalsIgnoreCase("LEO")) { for (int i = 0; i <
				 * t.getJSONObject("annot") .getJSONObject("prem_assump")
				 * .getJSONObject(ranodename) .getJSONArray("prem").length();
				 * i++) { // assuming tha PEO1 means field expertise if
				 * (t.getJSONObject("annot") .getJSONObject("prem_assump")
				 * .getJSONObject(ranodename) .getJSONArray("prem").getString(i)
				 * .equalsIgnoreCase("PEO1")) { m.add(ranode,
				 * hasFieldExpertisePremise, node); m.add(node, fulfils,
				 * fieldExpertiseDesc); // probably // useless, // we // can //
				 * write // a // RL // rule // for // this } // assuming tha
				 * PEO2 means knowledge assertion else if
				 * (t.getJSONObject("annot") .getJSONObject("prem_assump")
				 * .getJSONObject(ranodename) .getJSONArray("prem").getString(i)
				 * .equalsIgnoreCase("PEO2")) { m.add(ranode,
				 * hasKnowledgeAssertionPremise, node); m.add(node, fulfils,
				 * knowledgeAssertionDesc); // probably // useless, // we // can
				 * // write // a RL // rule // for // this }
				 * 
				 * } } }
				 */

			}
			/*
			 * if (t.getJSONObject("annot").getJSONObject("conc") .names() !=
			 * null) { for (Iterator<Object> ranodesIt =
			 * t.getJSONObject("annot")
			 * .getJSONObject("conc").names().iterator(); ranodesIt .hasNext();)
			 * { String ranodename = (String) ranodesIt.next(); Individual
			 * ranode = m.getIndividual(URI + ranodename);
			 * 
			 * // LCE if (t.getJSONObject("annot").getJSONObject("conc")
			 * .getJSONObject(ranodename).getString("id")
			 * .equalsIgnoreCase("LCE")) { for (int i = 0; i <
			 * t.getJSONObject("annot") .getJSONObject("conc")
			 * .getJSONObject(ranodename) .getJSONArray("conc").length(); i++) {
			 * // assuming tha CCE1 means causal conclusion if
			 * (t.getJSONObject("annot") .getJSONObject("conc")
			 * .getJSONObject(ranodename) .getJSONArray("conc").getString(i)
			 * .equalsIgnoreCase("CCE1")) { m.add(ranode, hasConclusion, node);
			 * m.add(node, fulfils, occurrenceBDesc); // probably // useless, //
			 * we // can // write // a // RL // rule // for // this } } } // LEO
			 * else if (t.getJSONObject("annot").getJSONObject("conc")
			 * .getJSONObject(ranodename).getString("id")
			 * .equalsIgnoreCase("LEO")) { for (int i = 0; i <
			 * t.getJSONObject("annot") .getJSONObject("conc")
			 * .getJSONObject(ranodename) .getJSONArray("conc").length(); i++) {
			 * // assuming tha CEO1 means conclusion if
			 * (t.getJSONObject("annot") .getJSONObject("conc")
			 * .getJSONObject(ranodename) .getJSONArray("conc").getString(i)
			 * .equalsIgnoreCase("CEO1")) { m.add(ranode, hasConclusion, node);
			 * m.add(node, fulfils, knowledgePositionDesc); // probably //
			 * useless, // we // can // write // a // RL // rule // for // this
			 * } } } } } }
			 */

			if (node != null) {
				m.add(node, creationDate,
						m.createLiteral((String) t.get("dtg")));
				m.add(node, createdBy,
						m.createLiteral((String) t.get("source")));
			}

			// System.out.println(t);
		}

		for (Iterator<Object> it = graph.getJSONArray("edges").iterator(); it
				.hasNext();) {
			JSONObject t = (JSONObject) it.next();

			Individual destnode = m.getIndividual(URI + t.getString("target"));
			Individual sourcenode = m
					.getIndividual(URI + t.getString("source"));

			if (sourcenode.getOntClass().equals(conflict)) {
				m.add(sourcenode, hasConflictedElement, destnode);
			}
			if (destnode.getOntClass().equals(conflict)) {
				m.add(destnode, hasConflictingElement, sourcenode);
			}

			if (sourcenode.getOntClass().equals(inference)) {
				m.add(sourcenode, hasConclusion, destnode);
			}
			if (destnode.getOntClass().equals(inference)) {
				m.add(destnode, hasPremise, sourcenode);
			}

		}

		obj = new JSONObject(eval);
		JSONObject colors = obj.getJSONObject("colors");

		Iterator<?> exts = colors.keys();

		while (exts.hasNext()) {
			String ext = (String) exts.next();

			Individual lab = m.createIndividual(labelling);
			m.add(lab, labName, m.createLiteral(ext));

			// System.out.println("Ext: " + ext);
			if (colors.get(ext) instanceof JSONObject) {

				for (String key : JSONObject
						.getNames((JSONObject) colors.get(ext))) {
					if (((JSONObject) colors.get(ext)).get(key).toString()
							.equalsIgnoreCase("V")) {
						m.add(lab, inStatement, m.getIndividual(URI + key));
					} else if (((JSONObject) colors.get(ext)).get(key)
							.toString().equalsIgnoreCase("X")) {
						m.add(lab, outStatement, m.getIndividual(URI + key));
					} else if (((JSONObject) colors.get(ext)).get(key)
							.toString().equalsIgnoreCase("?")) {
						m.add(lab, undecStatement, m.getIndividual(URI + key));
					}
					// System.out.println(key + " -> " +
					// ((JSONObject)colors.get(ext)).get(key));
				}

			}
		}
		
		String rules = "[rule1: (?ra "+ hasPremise.toString() +" ?p) (?ra " + hasConclusion.toString() + " ?c) -> (?c "+ basedOn.toString() +" ?c)]";
		Reasoner reasoner = new GenericRuleReasoner(Rule.parseRules(rules));
		reasoner.setDerivationLogging(true);
		inf = ModelFactory.createInfModel(reasoner, m);
		
		// debug
		/*StringWriter outInf = new StringWriter(); inf.write(outInf, "TURTLE");
		NLG.log.log(Level.INFO, "***Inferred model begins:");
		NLG.log.log(Level.INFO, outInf.toString());
		NLG.log.log(Level.INFO, "***Inferred model ends.");*/

	}

	private Individual getSkepticalLabelling() {
		ExtendedIterator<Individual> labIter = m.listIndividuals(labelling);

		while (labIter.hasNext()) {
			Individual lab = labIter.next();
			if (lab.getPropertyValue(labName).toString()
					.contains("Skeptical")) {
				return lab;
			}
		}
		return null;
	}

	private Set<Individual> getCredulousLabellings() {
		Set<Individual> credulousLabellings = new HashSet<Individual>();

		ExtendedIterator<Individual> labIter = m.listIndividuals(labelling);

		while (labIter.hasNext()) {
			Individual lab = labIter.next();
			if (lab.getPropertyValue(labName).toString()
					.contains("Credulous")) {
				credulousLabellings.add(lab);
			}
		}
		return credulousLabellings;
	}

	private Set<Individual> getUndec(Individual lab) {
		Set<Individual> toRet = new HashSet<Individual>();
		if (lab != null) {
			for (StmtIterator undecIter = lab
					.listProperties(undecStatement); undecIter.hasNext();) {
				toRet.add(m.getIndividual(
						undecIter.next().getObject().toString()));
			}
		}
		return toRet;
	}

	private Set<Individual> getIn(Individual lab) {
		Set<Individual> toRet = new HashSet<Individual>();
		if (lab != null) {
			for (StmtIterator undecIter = lab
					.listProperties(inStatement); undecIter.hasNext();) {
				toRet.add(m.getIndividual(
						undecIter.next().getObject().toString()));
			}
		}
		return toRet;
	}

	private Set<Individual> getOut(Individual lab) {
		Set<Individual> toRet = new HashSet<Individual>();
		if (lab != null) {
			for (StmtIterator undecIter = lab
					.listProperties(outStatement); undecIter.hasNext();) {
				toRet.add(m.getIndividual(
						undecIter.next().getObject().toString()));
			}
		}
		return toRet;
	}
	
	private ResultSet selectSparqlQuery(String szQuery, Model m){
		Query query = QueryFactory.create(szQuery) ;
		return QueryExecutionFactory.create(query, m).execSelect();
	}
	
	private Set<Individual> rootBasedOn(Set <Individual> individuals){
		Set<Individual> roots = new HashSet<Individual>();
		
		for (Iterator<Individual> it = individuals.iterator(); it.hasNext();){
			Individual iInd = it.next();
			ResultSet r = this.selectSparqlQuery("SELECT * {?c <"+ basedOn.toString() +"> <" + iInd.toString() +">}", inf);
			if (!r.hasNext()){
				roots.add(iInd);
			}
		}
		
		//debug
		NLG.log.log(Level.INFO, "***Roots list begins:");
		for (Iterator<Individual> r = roots.iterator(); r.hasNext();){
			NLG.log.log(Level.INFO, r.next().toString());
		}
		NLG.log.log(Level.INFO, "***Roots list ends.");
		
		return roots;
	}
	
	private String individualsToString(Set<Individual> inIndividuals){
		StringBuilder out = new StringBuilder();
		Set<String> outputted = new HashSet<String>();
		
		Set<Individual> roots = this.rootBasedOn(inIndividuals);
		
		for (Iterator<Individual> it = roots.iterator(); it
				.hasNext();) {
			
			Individual node = it.next();
			
			
			out.append("<li>"
					+ node.getPropertyValue(claimText).toString());
			
			//outputted.add(node.getPropertyValue(claimText).toString());
			
			/*if (!reasons.isEmpty()){
				out.append(", because: ");
				for (Iterator<String> itReasons = reasons.iterator(); itReasons.hasNext();){
					String reasonString = itReasons.next();
					out.append(reasonString);
					outputted.add(reasonString);
					
					if (itReasons.hasNext()){
						out.append("; ");
					}
				}
			}*/
			
			
			out.append("</li>" + newline);
		}
		return out.toString();
	}

	public String getText() {

		StringBuilder out = new StringBuilder();
		Set<Individual> inIndividuals = new HashSet<Individual>();

		if (this.getSkepticalLabelling() == null) {
			NLG.log.log(Level.SEVERE, "Skeptical Labelling Not Found!");
		}

		if (this.getSkepticalLabelling() != null) {
			inIndividuals = this.getIn(this.getSkepticalLabelling());
			if (inIndividuals.isEmpty()) {
				NLG.log.log(Level.INFO,
						"Skeptical Labelling does not contain in statements");
			}
		}

		if (inIndividuals.isEmpty()) {
			// fallback to use credulous options
			Set<Individual> credulousLabellings = this.getCredulousLabellings();

			if (credulousLabellings.isEmpty()) {
				NLG.log.log(Level.SEVERE, "Credulous Labelling Not Found!");
			} else {
				for (Iterator<Individual> aCredulousLab = credulousLabellings
						.iterator(); aCredulousLab.hasNext();) {
					Set<Individual> aCredulousLabIN = this
							.getIn(aCredulousLab.next());

					if (inIndividuals == null
							|| inIndividuals.size() < aCredulousLabIN.size())
						inIndividuals = aCredulousLabIN;
				}
			}
		}

		if (inIndividuals == null) {
			out.append(
					"<p>We are sorry but the evaluation service seemed to have malfunctioned</p>");
		} else {
			out.append("<p>We have reasons to believe that:</p>" + newline);
			out.append("<ul>" + newline);
			out.append(this.individualsToString(inIndividuals));
			out.append("</ul>" + newline);
		}

		
		//StringWriter out2 = new StringWriter(); m.write(out2, "TURTLE");
		
		return out.toString();
	}

}