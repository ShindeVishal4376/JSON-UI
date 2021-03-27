package com.example.jsonui;

public class Constatnts {
    public static final String JSON_STRING="[\n" +
            "{\n" +
            "\"type\": \"textbox\",\n" +
            "\"prompt\": \"First Name\",\n" +
            "\"identifier\": \"unique_id_of_first_name\",\n" +
            "\"value\": \"\"\n" +
            "},\n" +
            "{\n" +
            "\"type\": \"textbox\",\n" +
            "\"prompt\": \"Last Name\",\n" +
            "\"identifier\": \"unique_id_of_last_name\",\n" +
            "\"value\": \"\"\n" +
            "},\n" +
            "{\n" +
            "\"type\": \"formula\",\n" +
            "\"prompt\": \"Full Name\",\n" +
            "\"identifier\": \"unique_id_of_full_name_formula\",\n" +
            "\"jslogic\": \"function compute() { return unique_id_of_first_name + ' ' + unique_id_of_last_name; }\",\n" +
            "\"value\": \"\"\n" +
            "},\n" +
            "{\n" +
            "\"type\": \"date_picker\",\n" +
            "\"identifier\": \"unique_id_of_date_picker\",\n" +
            "\"prompt\": \"Date\",\n" +
            "\"value\": \"\"\n" +
            "},\n" +
            "{\n" +
            "\"type\": \"choice\",\n" +
            "\"identifier\": \"unique_id_of_choice\",\n" +
            "\"choices\": [\n" +
            "\"choice1\",\n" +
            "\"choice2\",\n" +
            "\"choice3\"\n" +
            "],\n" +
            "\"value\": \"\"\n" +
            "}\n" +
            "]";
    public static final String TEXTBOX="textbox";
    public static final String DATE_PICKER="date_picker";
    public static final String CHOICE="choice";
    public static final String FORMULA="formula";
}
