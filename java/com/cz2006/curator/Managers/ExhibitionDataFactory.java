package com.cz2006.curator.Managers;

import android.content.Context;
import android.util.Log;

import com.cz2006.curator.Constants.ExhibitionConstants;
import com.cz2006.curator.Crawler.ExhibitionCrawlerInterface;

/**
 * ExhibitionDataFactory is a class factory for selecting and instantiation
 * exhibition crawler class since there are many specific crawler for certain museum.
 * This class implement dynamic loading factory pattern by using
 * system class loader from java. The class name is from exhibitionClass HashMap
 * from ExhibitionConstants.
 */
public class ExhibitionDataFactory {

    public static final String packageName = "com.cz2006.curator.Crawler.";

    /**
     * This method is for selecting and instantiation exhibition crawler class.
     * @param exhibitionOption a string for selecting class name from exhibitionClass.
     * @param context a context of current activity/UI class.
     * @return Specific exhibition crawler object that has been selected.
     */
    public static ExhibitionCrawlerInterface getExhibitionCrawler(String exhibitionOption, Context context) {

        ExhibitionCrawlerInterface exhibitionCrawler = null;

        try {
            String name = ExhibitionConstants.exhibitionClass.get(exhibitionOption);

            String className = packageName + name;


            Log.e("classname", exhibitionOption + " " + name);

            Class exhibitionCrawlerImpl = context.getClass().getClassLoader().loadClass(className);

            Log.e("class", exhibitionCrawlerImpl.toString());

            exhibitionCrawler = (ExhibitionCrawlerInterface)exhibitionCrawlerImpl.newInstance();

            Log.e("exhibitionCraw", exhibitionCrawlerImpl.toString());


        } catch(Exception e) {
            Log.e("Exception", e.getMessage());

        }/* catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            Log.e("errorrrrr", "instantiation error");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            Log.e("errorrrrr", "illegal access error");
            e.printStackTrace();
        }*/

        return exhibitionCrawler;

    }

}
