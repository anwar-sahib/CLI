package com.anwar.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * This class demonstrates how to create command line interfaces using commons-cli
 * @author anwarsahib
 */
public class Calculator {
    
    public static void main(String[] args) {
        try {
            simpleExample(args);
        } catch (ParseException ex) {
           System.err.println("Error parsing command:" + ex.getMessage());
        }
    }
    
    private static void simpleExample(String[] args) throws ParseException {
        //***Definition Stage***
      // create Options object which holds all the options
      Options options = new Options();
      
      options.addOption("a", "add", true, "add numbers");
      
      options.addOption("m", "multiply", false, "multiply numbers");
      
      //***Parsing Stage***
      //Create a parser and parse the options passed as command line arguments
      CommandLineParser parser = new DefaultParser();
      CommandLine cmd = parser.parse(options, args);

      //***Interrogation Stage***
      if(cmd.hasOption("a") || cmd.hasOption("add")) {
         System.out.println("Sum of the numbers: " + getSum(args));
      } else if(cmd.hasOption("m") || cmd.hasOption("multiply")) {
         System.out.println("Multiplication of the numbers: " + getMultiplication(args));
      }
    }
    
    private static int getSum(String[] args) {
      int sum = 0;
      for(int i = 1; i < args.length ; i++) {
         sum += Integer.parseInt(args[i]);
      }
      return sum;
   }
    
   private static int getMultiplication(String[] args) {
      int multiplication = 1;
      for(int i = 1; i < args.length ; i++) {
         multiplication *= Integer.parseInt(args[i]);
      }
      return multiplication;
   }

}
