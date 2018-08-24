package com.face.pageFactory;
package Log4j;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;




public class Log {

//Initialize Log4j logs

  private static Logger Log = Logger.getLogger(Log.class.getName());//
  public static void main (String[] arg)
  {
   BasicConfigurator.configure();
  }


// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

public static void startTestCase(String sTestCaseName){


 Log.info("****************************************************************************************"+"<br/>");

 Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$"+"<br/>");

 Log.info("****************************************************************************************"+"<br/>");

 }

 //This is to print log for the ending of the test case

public static void endTestCase(String sTestCaseName){

 Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");

 Log.info("X");

 Log.info("X");


 }

 // Need to create these methods, so that they can be called  

public static void info(String message) {

  Log.info(message+"<br/>");

  }

public static void warn(String message) {

   Log.warn(message+"<br/>");

 }

public static void error(String message) {

   Log.error("<li style=\"color:red;\">"+message+"</li>");

 }

public static void fatal(String message) {

   Log.fatal(message+"<br/>");

 }

public static void debug(String message) {

   Log.debug(message+"<br/>");

 }

}