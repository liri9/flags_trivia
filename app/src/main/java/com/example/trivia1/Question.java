package com.example.trivia1;

public class Question {
    private String name;
    private int image;
    private String answers []= new String [4];

    public Question (){}

    public Question (String name, int image, String [] str){
        this.name = name;
        this.image = image;
        setAnswers(str);
    }

    public Question setName (String name) {
        this.name = name;
        return this;
    }
    public String getName (){
        return name;
    }
    public Question setImage (int img){
        this.image = img;
        return this;
    }
    public int getImage(){
        return image;
    }

    public Question setAnswers (String [] str){
        for (int i=0; i<4; i++) {
            answers[i]=str[i];
        }
        return this;
    }
    public String [] getAnswers(){
        return answers;
    }
    public String getAnswer (){
        return name;
    }

}
