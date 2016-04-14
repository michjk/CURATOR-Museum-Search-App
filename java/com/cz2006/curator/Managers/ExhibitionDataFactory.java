package com.cz2006.curator.Managers;

import android.content.Context;
import android.util.Log;

import com.cz2006.curator.Constants.ExhibitionConstants;
import com.cz2006.curator.Crawler.ExhibitionCrawlerInterface;

/**
 * Created by Acceleration on 06/04/2016.
 */
public class ExhibitionDataFactory {

    public static final String packageName = "com.cz2006.curator.Crawler.";

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
            Log.e("errorrrrr", "insta error");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            Log.e("errorrrrr", "illegal error");
            e.printStackTrace();
        }*/

        return exhibitionCrawler;

    }

}
