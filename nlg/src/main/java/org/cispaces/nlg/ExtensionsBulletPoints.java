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
import java.util.logging.Logger;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.iterator.ExtendedIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 * Class for generating a sequence of bullet points to 
 * summarise an Extension
 * 
 * @author Federico Cerutti <CeruttiF@cardiff.ac.uk>
 *
 */
public class ExtensionsBulletPoints implements URIs {

	private static Logger log;
	
	
	public ExtensionsBulletPoints(String request, String eval) {
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
						m.add(lab, inArgs, m.getIndividual(URI + key));
					} else if (((JSONObject) colors.get(ext)).get(key)
							.toString().equalsIgnoreCase("X")) {
						m.add(lab, outArgs, m.getIndividual(URI + key));
					} else if (((JSONObject) colors.get(ext)).get(key)
							.toString().equalsIgnoreCase("?")) {
						m.add(lab, undecArgs, m.getIndividual(URI + key));
					}
					// System.out.println(key + " -> " +
					// ((JSONObject)colors.get(ext)).get(key));
				}

			}
		}

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

	public String getText() {

		if (this.getSkepticalLabelling() == null)
		{
			log.log(Level.SEVERE, "Skeptical Labelling Not Found!");
		}
		
		StringWriter out = new StringWriter();
		m.write(out, "TURTLE");
		return out.toString();
	}

}