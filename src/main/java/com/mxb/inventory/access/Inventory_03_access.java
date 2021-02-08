
// #################################
// 08.10.2020.

// SikuliX, Java
// http://sikulix.com/
// http://sikulix.com/quickstart/
// https://answers.launchpad.net/sikuli

// SikuliX-IDE, Run
// C:\xxx\JDK\bin\java -jar C:\xxx\SIKULIX_IDE\sikulix-2.0.0.jar

// https://github.com/RaiMan/SikuliX1
// Source and target level for Java is version 8 as long as supported by Oracle

// ---------------------------------
// 1) SikuliX Documentation
// http://sikulix-2014.readthedocs.org/en/latest/index.html
// Be aware: The online javadocs are created from the latest nightly builds.

// Try the Table of Contents
// https://sikulix-2014.readthedocs.io/en/latest/toc.html

// Look through the Index
// https://sikulix-2014.readthedocs.io/en/latest/genindex.html

// Use the Search Page
// https://sikulix-2014.readthedocs.io/en/latest/search.html

// ---------------------------------
// 2) SikuliX Documentation (built-in class)
// Look through the Index:
// https://sikulix-2014.readthedocs.io/en/latest/genindex.html

// (built-in class) :
// https://sikulix-2014.readthedocs.io/en/latest/appclass.html#App
// https://sikulix-2014.readthedocs.io/en/latest/screen.html#Screen
// https://sikulix-2014.readthedocs.io/en/latest/pattern.html#Pattern
// https://sikulix-2014.readthedocs.io/en/latest/keys.html#Key
// https://sikulix-2014.readthedocs.io/en/latest/region.html#Region
// https://sikulix-2014.readthedocs.io/en/latest/match.html#Match

// https://sikulix-2014.readthedocs.io/en/latest/finder.html#Finder.find

// image-search-path
// https://sikulix-2014.readthedocs.io/en/latest/scripting.html#image-search-path-where-sikulix-looks-for-image-files

// FindFailed
// https://sikulix-2014.readthedocs.io/en/latest/region.html?highlight=FindFailed#exception-findfailed

// https://sikulix-2014.readthedocs.io/en/latest/region.html#extracting-text-from-a-region

// import org.sikuli.script.Pattern;   # SikuliX, Java

// ---------------------------------
// 3) SikuliX Documentation (other)

// https://sikulix-2014.readthedocs.io/en/latest/region.html#Region.findAll
// https://sikulix-2014.readthedocs.io/en/latest/match.html#iteratingmatches

// https://stackoverflow.com/questions/47467133/how-to-check-in-sikuli-that-image-is-exist-in-screen-or-not-and-perform-if-else
// Because that will return a "match" object.

// https://stackoverflow.com/questions/811851/how-do-i-read-input-character-by-character-in-java
// http://eugenesautomation.blogspot.com/2015/01/optimizing-pattern-matching-using-sikuli_21.html

// ---------------------------------
// 4) SikuliX issues

// SikuliX 2.0.2:  screen.Paste and Key. dont work
// https://github.com/RaiMan/SikuliX1/issues/305
// https://github.com/RaiMan/SikuliX1/issues/241
// As long as English (United States) is in my language list, it works fine.

// -->
// Settings.AutoDetectKeyboardLayout = false;

// ---------------------------------
// 5) QUICKSTART

// https://sikulix-2014.readthedocs.io/en/latest/faq/030-java-dev.html
// http://www.gofreetodream.com/java-sikulix-windows-mac/java-sikulix-example-on-windows-machine/
// https://javapointers.com/tutorial/sikuli/sikuli-java-tutorial-and-example/

// ---------------------------------
// 6) JAVA

// https://kodejava.org/how-do-i-load-file-from-resources-directory/
// https://www.geeksforgeeks.org/throw-throws-java/
//
// https://www.baeldung.com/java-current-directory
// Get the Current Working Directory in Java | Baeldung

// https://www.baeldung.com/java-system-exit
// System.exit(0);


// ---------------------------------
// 7) SikuliX OCR

// https://sikulix-2014.readthedocs.io/en/latest/textandocr.html#textandocr
// Simply start using the text/OCR features with Region or Image (see the summary below).

// https://github.com/RaiMan/SikuliX1/wiki/How-to-get-the-best-from-OCR-and-text-features

// https://github.com/tesseract-ocr/tesseract
// https://mvnrepository.com
// tess4j

// https://sikulix-2014.readthedocs.io/en/latest/region.html#extracting-text-from-a-region

// import org.sikuli.script.OCR;

// Settings.OcrDataPath = "C:\\xxx\\Tesseract-OCR\\tessdata\\";
// Settings.OcrTextSearch = true;
// Settings.OcrTextRead = true;
// OCR.PSM.SINGLE_WORD; !?

// ---------------------------------
// https://github.com/suniljayaprakash/sikuli-ocr/blob/master/com/nanni/ExtractTextFromImageSikuli.java
// https://github.com/sarxos/sikuli-ocr


// #################################


package com.mxb.inventory.access;


import org.sikuli.basics.Settings;

// import org.sikuli.script.App;
import org.sikuli.script.Screen;
import org.sikuli.script.Pattern;
import org.sikuli.script.Key;

import org.sikuli.script.Region;
// import org.sikuli.script.Match;

import org.sikuli.script.FindFailed;

// ---------------------------------
// import org.sikuli.script.Finder;
// import org.sikuli.script.ImagePath;

// ---------------------------------
// import java.net.URISyntaxException;
// import java.net.URL;
// import java.net.MalformedURLException;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.IOException;

// import java.util.*;
// import java.util.List;
// import java.util.ArrayList;
// import java.util.Iterator;

// ---------------------------------


/**
 * Hello world!
 *
 */

public class Inventory_03_access
{

    // private App myApp;

    private Screen scr;
    private String basePath;

    private String point_id;

    private Region r1Top_GenID;
    private Region r2Bottom;


    // constructor to initialize the variable
    // httpstom.mcqueeney.tech/blog/the-terribly-misunderstood-super/
    public Inventory_03_access()
    {
        // General Settings and Access to Environment Information
        // https://sikulix-2014.readthedocs.io/en/latest/globals.html
        // Settings.AutoWaitTimeout = 2;  // (default 3 seconds)

        Settings.AutoDetectKeyboardLayout = false;
        Settings.AutoWaitTimeout  = 120;
        scr = new Screen(0);
        // scr.setAutoWaitTimeout(120);

        r1Top_GenID = new Region(0,0,1920,155);
        r2Bottom = new Region(0,939,1920,141);

        // https://www.baeldung.com/java-current-directory
        // Get the Current Working Directory in Java | Baeldung
        String currentWorkingDir = System.getProperty("user.dir");
        basePath = currentWorkingDir + "/images/";

    }


    // instance method
    private void startApp() throws FindFailed
    {
        m1MaximizeApp();
        m2FindPath();

        m3OpenPath();
        m4InsertUI();
    }


    // instance method
    private void m1MaximizeApp() throws FindFailed
    {
        // Java 1.8
        // By default, float numbers are double in java.
        // In order to store them into float variable, you need to explicitly add the suffix 'f' or 'F'.
        // scr.wait(p3Search_For_Path.similar(0.7F));

        try {
            // INV app, Click on the icon
            // Pattern p1AppIcon = new Pattern("C:\\xxx\\INV_01_ikona.png");
            Pattern p1AppIcon = new Pattern(basePath + "p1AppIkona.png");
            r2Bottom.click(p1AppIcon.similar(0.8));

            // myApp = new App("Inventory");
            // myApp.focus();

            // INV app, Wait for it to open
            Pattern p2AppWait = new Pattern(basePath + "p2AppWait.png");
            r1Top_GenID.wait(p2AppWait.similar(0.8));

        } catch(FindFailed e) {
            e.printStackTrace();
            System.out.println("Find failed " + e.getMessage());
            System.exit(1);
        }

    }


    // instance method
    private void m2FindPath() throws FindFailed
    {

        try {
            // INV: Object, Path
            scr.type("o", Key.ALT);   // Menu - Object
            scr.wait(0.1);   // wait 0.1 seconds
            scr.type("p");   // Path

            // ---------------------------------
            Pattern p3Search_For_Path = new Pattern(basePath + "p3Search_For_Path.png");
            r1Top_GenID.wait(p3Search_For_Path.similar(0.7));
            System.out.println("found p3Search_For_Path");

            scr.type("a", Key.CTRL);   // Select All
            scr.wait(0.1);
            scr.type(Key.DELETE);

            scr.wait(0.5);

            // ---------------------------------
            // Catagory:
            r1Top_GenID.click(p3Search_For_Path.similar(0.7).targetOffset(110, 75));
            scr.type(Key.END);
            scr.type(Key.PAGE_UP);
            scr.type(Key.PAGE_UP);
            scr.type(Key.PAGE_UP);
            scr.type(Key.DOWN);
            scr.type(Key.DOWN);
            scr.type(Key.DOWN);
            scr.type(Key.DOWN);
            scr.type(Key.ENTER);

            // ---------------------------------
            // DATA_ME_ACCESS
            r1Top_GenID.click(p3Search_For_Path.similar(0.7).targetOffset(-160, 500));
            scr.type(Key.HOME);

            // data_me_access
            scr.type("d");
            scr.type("d");
            scr.type("d");
            scr.type("d");

            // ---------------------------------
            Pattern p4Data_me_access = new Pattern(basePath + "p4Data_me_access.png");
            scr.wait(p4Data_me_access.similar(0.7));
            scr.click(p4Data_me_access.similar(0.7).targetOffset(400, -72));

            scr.type("a", Key.CTRL);   // Select All
            scr.type(Key.DELETE);

            scr.paste(point_id);
            scr.type(Key.TAB);

            // ---------------------------------
            Pattern p5Dvogled = new Pattern(basePath + "p5Dvogled.png");
            scr.click(p5Dvogled.similar(0.85));

            // ---------------------------------


        } catch(FindFailed e) {
            e.printStackTrace();
            System.out.println("Find failed " + e.getMessage());
            System.exit(1);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Some other exception occured " + e.getMessage());
        }

    }


    // instance method
    private void m3OpenPath() throws FindFailed
    {

        try {
            // ---------------------------------
            Pattern p6SearchResults = new Pattern(basePath + "p6SearchResults.png");
            r1Top_GenID.wait(p6SearchResults.similar(0.7));
            System.out.println("found p4SearchResults");

            scr.wait(0.1);
            r1Top_GenID.doubleClick(p6SearchResults.similar(0.7).targetOffset(100, 57));

            // ---------------------------------
            r1Top_GenID.waitVanish(p6SearchResults.similar(0.7));

            Pattern p7ViewPath = new Pattern(basePath + "p7ViewPath.png");
            r1Top_GenID.wait(p7ViewPath.similar(0.7));
            System.out.println("found p5ViewPath");

            scr.wait(0.1);
            scr.type("m", Key.CTRL);   // Modify
            scr.wait(0.5);

            // ---------------------------------
            r1Top_GenID.waitVanish(p7ViewPath.similar(0.7));

            Pattern p8ModifyPath = new Pattern(basePath + "p8ModifyPath.png");
            r1Top_GenID.wait(p8ModifyPath.similar(0.7));
            System.out.println("found p6ModifyPath");

            // scr.wait(1.0);   // wait 1 second
            scr.wait(0.1);
            // scr.wait(5.0);


        } catch(FindFailed e) {
            e.printStackTrace();
            System.out.println("Find failed " + e.getMessage());
            System.exit(1);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Some other exception occured " + e.getMessage());
        }

    }


    // instance method
    private void m4InsertUI() throws FindFailed
    {

        try {
            // ---------------------------------
            Pattern p9InsertEQ = new Pattern(basePath + "p9InsertEQ.png");
            scr.click(p9InsertEQ.similar(0.8).targetOffset(0,10));
            scr.type(Key.DOWN);
            scr.type(Key.DOWN);
            scr.type(Key.DOWN);
            scr.type(Key.RIGHT);
            scr.type(Key.DOWN);

            scr.type(Key.ENTER);

            // ---------------------------------
            Pattern p10SearchForPath = new Pattern(basePath + "p10SearchForPath.png");
            scr.wait(p10SearchForPath.similar(0.7));
            scr.wait(0.1);
            scr.type(Key.F5);


        } catch(FindFailed e) {
            e.printStackTrace();
            System.out.println("Find failed " + e.getMessage());
            System.exit(1);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Some other exception occured " + e.getMessage());
        }

    }


   // this is a static method and cannot call an instance method without a object
    public static void main(String[] args) throws FindFailed
    {
        System.out.println( "Hello World!" );
        // create instance of object
        Inventory_03_access uiObj = new Inventory_03_access();

        // Windows bat file (Look at the end!)
        // set POINT=%1
        uiObj.point_id = args[0].toString();

        uiObj.startApp();
    }

}


// Windows bat file
// Run_inventory_03_access.bat

// -------------------------------------------------------------
// set POINT=%1

// :: Change Current Directory to the location of this batch file
// :: http://ss64.com/nt/cd.html
// CD /d "%~dp0"

// CMD /c %JAVA_HOME%bin\java -cp Inventory_03_access-1.0-SNAPSHOT.jar;C:\xxx\dependency204/* com.mxb.inventory.access.Inventory_03_access %POINT%

