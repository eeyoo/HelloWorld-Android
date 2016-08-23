package com.example;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.DaoGenerator;

public class ExampleDAOGenerator {

    public static void main(String[] args) throws Exception {

        Schema schema = new Schema(1, "com.example.greendao");

        addNote(schema);

        new DaoGenerator().generateAll(schema,
                "F:/Github/Android/HelloWorld/app/src/main/java-gen");
    }

    private static void addNote(Schema schema) {
        Entity note = schema.addEntity("Note");

        note.addIdProperty().autoincrement(); //id primary autoincrement
        note.addStringProperty("text").notNull(); // text not null
        note.addStringProperty("comment");
        note.addDateProperty("date");
    }
}
