package com.example.feilin.myapplication.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by feilin on 2016/8/19.
 */
public class Utility {

    /**
     * 文件持久化
     * @param context
     * @param content
     */
    public synchronized static void fileSave(Context context, String fileName, String content) {
        FileOutputStream out = null;
        BufferedWriter writer = null;

        try {
            out = context.openFileOutput(fileName, context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static String fileLoad(Context context, String fileName) {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuffer content = new StringBuffer();

        try {
            in = context.openFileInput(fileName);
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return content.toString();
    }

}
