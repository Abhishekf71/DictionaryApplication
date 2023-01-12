package com.example.worddictionary;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
public class JSONDecoder {
    public String decoder(String data){
        String deData = "";

        try {
            Object obj = JSONValue.parse(data);

            JSONArray jsonArray = (JSONArray) obj;
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
            deData = deData +"Word: "+ jsonObject.get("word");

            JSONArray jsonArray1 = (JSONArray) jsonObject.get("meanings");
            JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
            JSONArray jsonArray2 = (JSONArray) jsonObject1.get("definitions");

            JSONObject jsonObject2 = (JSONObject) jsonArray2.get(0);
            JSONArray jsonArray3 = (JSONArray) jsonObject2.get("synonyms");


            deData = deData + "\n Parts Of Speech: noun";
            deData = deData + "\n Definition: " + jsonObject2.get("definition");


//            JSONObject jsonObject1 = (JSONObject) jsonObject.get("meanings");
//            JSONArray jsonArray1 = (JSONArray) jsonObject1.get("noun");
//
//            JSONObject jsonObject2 = (JSONObject) jsonArray1.get(0);
//            deData = deData + "\n Part Of Speech: Noun";
//            deData = deData + "\n Definition: "+jsonObject2.get("definition");
//            deData = deData + "\n Example: "+jsonObject2.get("example");
//
//            JSONArray jsonArray2 = (JSONArray) jsonObject2.get("synonyms");
//            if (!(jsonArray2 == null)){
//                deData = deData + "\n Synonyms :";
//                for (int i=0; i < jsonArray2.size(); i++){
//                    deData = deData + "\n \t"+ jsonArray2.get(i);
//                }
//            }
        }catch (Exception e){
            deData = "error";
            e.printStackTrace();
        }
        return deData;
    }
}
