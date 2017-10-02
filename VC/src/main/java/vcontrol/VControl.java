/**
 * This class takes the hashmap into which the JSON from the front-end has been parsed.
 * It extracts the relevant keys from the hashmap and passes them to class DBQuery which manages the queries to be executed.
 *
 * @author Yordanka Ivanova
 * @since July 2017
 * @author j.s.robinson@soton.ac.uk
 */

package vcontrol;

import database.DBQuery;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import utils.TimeHelper;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.json.simple.JSONObject;

public class VControl {

    /**
     * @param map the hashmap which contains the keys from the JSON of an edge and their respective values
     * @return a hashmap with key: 'response' and value: 'success' if the data has been put into the db or 'fail' if some error occurred
     */
    public HashMap onAddEdges(HashMap map) {

        String toID = map.get("target").toString();
        String fromID = map.get("source").toString();
        String formEdgeID = null;
        if(map.get("formEdgeID") != null) {
            formEdgeID = map.get("formEdgeID").toString();
        }
        String edgeID = map.get("edgeID").toString();
        String graphID = null;
        if(map.get("graphID") != null){
            graphID = map.get("graphID").toString();
        }

        boolean isLocked = false;
        if(map.get("isLocked") != null){
            Boolean.parseBoolean(map.get("isLocked").toString());
        }

        DBQuery dbQuery = new DBQuery();
        dbQuery.insertEdge(toID, fromID, formEdgeID, edgeID, graphID, isLocked);

        map = new HashMap();
        map.put("response","success");

        return map;
    }

    /**
     * @param map the hashmap which contains the keys from the JSON of a node and their respective values
     * @return a hashmap with key: 'response' and value: 'success' if the data has been put into the db or 'fail' if some error occurred
     * Note that the nodes have varying number of keys in the JSON, thus they are checked for null.
     */
    public HashMap onAddNodes(HashMap map) {
        TimeHelper timeHelper = new TimeHelper();

        String nodeID = map.get("nodeID").toString();

        String source = null;
        if(map.get("source") != null) {
            source = map.get("source").toString();
        }

        String uncert = null;
        if(map.get("uncert") != null) {
            uncert = map.get("uncert").toString();
        }

        String eval = null;
        if(map.get("eval") != null) {
           eval = map.get("eval").toString();
        }

        String txt = null;
        if(map.get("text") != null) {
            txt = map.get("text").toString();
        }

        String input = null;
        if(map.get("input") != null) {
            input = map.get("input").toString();
        }

        Timestamp timestamp = null;
        if(map.get("dtg") != null) {
            timestamp = timeHelper.formatDateCIS(map.get("dtg").toString());
        }


        String commit = null;
        if(map.get("commit") != null) {
            commit = map.get("commit").toString();
        }

        String type = null;
        if(map.get("type") != null) {
             type = map.get("type").toString();
        }

        String annot = "N/A";
        if(map.get("annot") != null) {
            annot = map.get("annot").toString();
        }
      //  Clob prov =
        String graphID = "N/A";
        if(map.get("graphID") != null) {
            graphID = map.get("graphID").toString();
        }

        boolean isLocked = false;
        if(map.get("isLocked") != null){
            Boolean.parseBoolean(map.get("isLocked").toString());
        }

        DBQuery dbQuery = new DBQuery();
        dbQuery.insertNode(nodeID, source, uncert, eval, txt, input, timestamp, commit, type, annot, graphID, isLocked);

        map = new HashMap();
        map.put("response","success");

        return map;
    }

    /**
     * @param map the hashmap which contains the keys from the JSON of a graph
     */
    public void onAddGraph(HashMap map) {
        TimeHelper timeHelper = new TimeHelper();
        String graphID = map.get("graphID").toString();
        String userID = map.get("userID").toString();
        Timestamp timestamp = timeHelper.formatDateCIS(map.get("timest").toString());
        boolean isShared = Boolean.parseBoolean(map.get("isshared").toString());
        String parentGraphID = null;
        if(map.get("parentgraphid") != null){
            parentGraphID = map.get("parentgraphid").toString();
        }


        DBQuery dbQuery = new DBQuery();
        dbQuery.insertGraph(graphID, userID, timestamp, isShared, parentGraphID);
    }

    /**
     * Authenticate a login attempt by comparing the supplied password with the stored 
     * password hash for the supplied username 
     * @param map the hashmap which contains user credentials
     * @return a JSON string representing the authenticated user, or null if not
     * authenitcated
     */
    public String onLoginUser(HashMap map) {
        String username = map.get("username").toString();
        String suppliedPassword = map.get("password").toString();         
        DBQuery dbQuery = new DBQuery();
        JSONObject user = dbQuery.getUserByUsername(username);
        
        if(user != null){        
            boolean authenticated = false;
            try
            {
                authenticated = validatePassword(suppliedPassword, (String) user.get("password"));
            } catch (NoSuchAlgorithmException ex)
            {
                Logger.getLogger(VControl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex)
            {
                Logger.getLogger(VControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(authenticated){
                user.remove("password");
                return user.toJSONString();
            }
            else return null;
        }
        else return null;
    }
    
    /**
     * @param map the hashmap which contains a graph id, the id of the creator of the analysis and a title for the analysis
     * @return a string indicating whether the analysis has been saved successfully
     */
    public String onSaveAnalysis(HashMap map) {
        String graphID = map.get("graphID").toString();
        String title = null;
        if(map.get("title") != null){
            title = map.get("title").toString();
        }
        String userID = map.get("userID").toString();

        DBQuery dbQuery = new DBQuery();
        String result = dbQuery.saveLatestAnalysis(graphID,userID,title);
        return result;
    }
    
    /**
     * Add a user.
     * @param map
     * @return 
     */    
    public String onAddUser(HashMap map) {
        String userId = null;
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        String aff = null;
        if(map.get("affiliation") != null){
            aff = map.get("affiliation").toString();
        }
        String generatedSecuredPasswordHash = null;
        try
        {
            generatedSecuredPasswordHash = generateStrongPasswordHash(password);
        } catch (NoSuchAlgorithmException ex)
        {
            Logger.getLogger(VControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex)
        {
            Logger.getLogger(VControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DBQuery dbQuery = new DBQuery();        
        userId = dbQuery.insertUser(username, generatedSecuredPasswordHash, aff);
        return userId;
    }//onAddUser

    /**
     * Generate a strong password hash. Using the PBKDF2WithHmacSHA1 algorithm
     * @param password The user supplied password
     * @return a String of format "iterations : salt : hash"
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    private static String generateStrongPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();
         
        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }
    
    /**
     * Generate a random salt
     * @return The salt
     * @throws NoSuchAlgorithmException 
     */
    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
    
    /**
     * Validate the supplied password against the stored hash
     * @param suppliedPassword The user supplied password
     * @param storedSecuredPasswordHash String of format "iterations : salt : hash"
     * @return
     * @throws NoSuchAlgorithmException 
     */
   
    private static boolean validatePassword(String suppliedPassword, String storedSecuredPasswordHash) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String[] parts = storedSecuredPasswordHash.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);
         
        PBEKeySpec spec = new PBEKeySpec(suppliedPassword.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();
         
        int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }
    
    private static String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }    
    
    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
