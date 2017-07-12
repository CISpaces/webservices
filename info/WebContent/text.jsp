<!--
  This research was sponsored by the U.S. Army Research Laboratory and the
  U.K. Ministry of Defence under the Biennial Program Plane 2013 (BPP13),
  Project 6, Task 3: Collaborative Intelligence Analysis.
  The U.S. and U.K. Governments are authorized to reproduce and distribute
  reprints for Government purposes notwithstanding any copyright notation
  hereon.
 --------------------------------------------------------------
 
  This is used to see whether PROV DATA service is available
  
  @author      Alice Toniolo  
  @version     1.0  
  @since 	  August 2014           

-->
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Text Document</title>
<link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>


<h2>Add Info from TEXT DOCUMENT</h2>


<form name="Check" method="post" action="InfoServHttp">
<table>
<tr>
<td>Text</td><td><textarea rows="10"  cols="140" name="text">  text</textarea></td>
</tr>
<tr>
<td>Linguistic Provenance</td><td><textarea rows="10"  cols="140" name="lprov"> Key:Value</textarea></td>

</tr>
<tr> <td>Please insert values in the format Key:Value one per line </td> </tr>
<tr>
<td>Source</td><td><input type="text" name="source" size="50"/></td>
</tr>
<tr>
<td>Document ID</td><td><input type="text" name="dids" size="50"/></td>
</tr>
<tr>
<td>Document Collection Name (different from source)</td><td><input type="text" name="stream" size="50"/></td>
</tr>
<tr>
<td>Send to</td><td><input type="text" name="dest" size="30"/></td>
  
 

</tr>
</table>
<input type="submit" name="Send" value="Send"/>
</form>

</body>
</html>