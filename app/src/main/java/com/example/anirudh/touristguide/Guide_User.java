package com.example.anirudh.touristguide;

public class Guide_User {


    public String message;
   //     public String name;
     //   public String lang;

    public Guide_User( String message) {

        this.message = message;
    }

/*

        public Guide_User(String message, String name, String lang) {
            this.message = message;
            this.name = name;
            this.lang = lang;
        }
 */
public String getMessage() {
    return message;
}
}
