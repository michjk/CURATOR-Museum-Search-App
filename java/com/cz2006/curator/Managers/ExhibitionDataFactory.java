package com.cz2006.curator.Managers;

import android.content.Context;
import android.util.Log;

import com.cz2006.curator.Constants.ExhibitionConstants;
import com.cz2006.curator.Crawler.ExhibitionCrawlerInterface;

/**
 * Created by Acceleration on 06/04/2016.
 */
public class ExhibitionDataFactory {

    public static String packageName = "com.cz2006.curator.Crawler.";

    public static ExhibitionCrawlerInterface getExhibitionCrawler(String exhibitionOption, Context context) {

        ExhibitionCrawlerInterface exhibitionCrawler = null;

        try {
            String name = ExhibitionConstants.exhibitionClass.get(exhibitionOption);

            String packageName = "com.cz2006.curator";
            String className = "com.cz2006.curator.Crawler." + name;


            Log.e("classname", exhibitionOption + " " + name);

            Class exhibitionCrawlerImpl = context.getClass().getClassLoader().loadClass(className);

            Log.e("class", exhibitionCrawlerImpl.toString());

            exhibitionCrawler = (ExhibitionCrawlerInterface)exhibitionCrawlerImpl.newInstance();

            Log.e("exhibitionCraw", exhibitionCrawlerImpl.toString());





            /*

            String apkName = context.getPackageManager().getApplicationInfo(packageName, 0).sourceDir;
            PathClassLoader myClassLoader =
                    new dalvik.system.PathClassLoader(
                            apkName,
                            ClassLoader.getSystemClassLoader());
            Class handler = Class.forName(className, true, myClassLoader);

            exhibitionCrawler = (ExhibitionCrawlerInterface) handler.newInstance();
            */

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
