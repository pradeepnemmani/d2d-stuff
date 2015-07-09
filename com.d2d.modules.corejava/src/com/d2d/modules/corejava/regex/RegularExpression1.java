package com.d2d.modules.corejava.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression1
{
    private static final String pattern1 = "^[0-9]+.*";
    private static final String pattern2 = "[[0-9][0-9]{.,1}";
    private static final String pattern3 = "^[0-9]{4}.{3}";
    private static final String pattern4 = "((\\d{1,3}\\.{1}){3}\\d{1,3}).*(\\[\\d{1,2}/[a-zA-Z]{3}/\\d{4}:.*\\]).*";

    public static void main( String[] args )
    {
        String inputString = "100.200.300.400";
        String inputString2 = "100.";
        String inputString3 = "1234...";
        String inputString4 = "0~0.0.255";
        String inputString5 = "64.242.88.10 - - [07/Mar/2004:16:05:49 -0800] \"GET /twiki/bin/edit/Main/Double_bounce_sender?topicparent=Main.ConfigurationVariables HTTP/1.1\" 401 12846";

        // System.out.println( inputString + " matches the pattern : " +
        // inputString.matches( pattern5 ) );
        // System.out.println( inputString2 + " matches the pattern : " +
        // inputString2.matches( pattern4 ) );
        // System.out.println( inputString3 + " matches the pattern : " +
        // inputString3.matches( pattern4 ) );
        // System.out.println( inputString4 + " matches the pattern : " +
        // inputString4.matches( pattern4 ) );
        System.out.println( inputString5 + " matches the pattern : "
                + inputString5.matches( pattern4 ) );

        // Compile the pattern that we want to apply
        Pattern compiledPattern = Pattern.compile( pattern4 );

        Matcher matcher = compiledPattern.matcher( inputString5 );
        System.out.println( "Group Count : " + matcher.groupCount() );
        matcher.find();
        for ( int inx = 0; inx < matcher.groupCount(); inx++ )
        {
            System.out.println( matcher.group( inx ) );
        }
        System.out.println( "Alternative way..." );
        System.out.println( matcher.group( 1 ) );
        System.out.println( matcher.group( 3 ) );

        String replacedString = inputString5.replaceAll( pattern4, "$1- logged in time - $3" );
        System.out.println( "Replaced String : " + replacedString );
    }
}
