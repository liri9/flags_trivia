package com.example.trivia1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Question> questions = new ArrayList<>();
    private AppCompatImageView[] game_IMG_coins;

    private AppCompatImageView game_IMG_coin1;
    private AppCompatImageView game_IMG_coin2;
    private AppCompatImageView game_IMG_coin3;
    private AppCompatImageView game_IMG_coin4;
    private AppCompatImageView game_IMG_coin5;
    private AppCompatImageView game_IMG_coin6;
    private AppCompatImageView game_IMG_coin7;
    private AppCompatImageView game_IMG_coin8;
    private AppCompatImageView game_IMG_coin9;
    private AppCompatImageView game_IMG_coin10;
    private AppCompatImageView game_IMG_flag;
    private String answers[]= new String[4];
    private MaterialButton game_BTN_answer1;
    private MaterialButton game_BTN_answer2;
    private MaterialButton game_BTN_answer3;
    private MaterialButton game_BTN_answer4;
    private int score = 0;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        questions.add(new Question().setName("Bolivia")
                .setImage(R.drawable.img_bolivia_flag)
                .setAnswers(new String[]{"Ghana", "Bolivia", "India", "Cameroon"}));
        questions.add(new Question().setName("Canada")
                .setImage(R.drawable.img_canada_flag)
                .setAnswers(new String[]{"Canada", "USA", "Peru", "Monaco"}));
        questions.add(new Question().setName("England")
                .setImage(R.drawable.img_england_flag)
                .setAnswers(new String[]{"United Kingdom", "Norway", "England", "Gerorgia"}));
        questions.add(new Question().setName("India")
                .setImage(R.drawable.img_india_flag)
                .setAnswers(new String[]{"Bulgaria", "India", "Argentina", "Ireland"}));
        questions.add(new Question().setName("Italy")
                .setImage(R.drawable.img_italy_flag)
                .setAnswers(new String[]{"Mali", "France", "Belgium", "Italy"}));
        questions.add(new Question().setName("Romania")
                .setImage(R.drawable.img_romania_flag)
                .setAnswers(new String[]{"Ecuador", "Romania", "Colombia", "Chad"}));
        questions.add(new Question().setName("Serbia")
                .setImage(R.drawable.img_serbia_flag)
                .setAnswers(new String[]{"Serbia", "Russia", "Gabon", "Paraguay"}));
        questions.add(new Question().setName("Spain")
                .setImage(R.drawable.img_spain_flag)
                .setAnswers(new String[]{"North Macadonia", "Singapore", "Myanmar", "Spain"}));
        questions.add(new Question().setName("Yemen")
                .setImage(R.drawable.img_yemen_flag)
                .setAnswers(new String[]{"Germany", "Yemen", "Estonia", "Syria"}));
        questions.add(new Question().setName("New Zealand")
                .setImage(R.drawable.img_newzealand_flag)
                .setAnswers(new String[]{"New Zealand", "Falkland Islands", "Australia", "Montserrat"}));
        initViews();
        updateUI();

    }

    private void clicked(String answer) {
        Question question = questions.get(index);
        if (answer.equals(question.getAnswer())) addScore();
        next();
    }

    private void next() {
        index++;
        if (hasNext()) {
            updateUI();
        } else {
            refreshScoreUI();
            gameOver();
        }
    }

    private void gameOver() {
        Toast.makeText(this, "Game Over, the final score is: " + score, Toast.LENGTH_SHORT).show();
    }

    private boolean hasNext() {
        return index < questions.size();
    }

    private void updateUI() {
        refreshScoreUI();
        Question question = questions.get(index);
        game_IMG_flag.setImageResource(question.getImage());
        answers = question.getAnswers();
        game_BTN_answer1.setText(answers[0]);
        game_BTN_answer2.setText(answers[1]);
        game_BTN_answer3.setText(answers[2]);
        game_BTN_answer4.setText(answers[3]);

    }

    private void addScore() {
        score++;
    }

    private void refreshScoreUI() {
        for (int i = 0; i < score; i++) {
            game_IMG_coins[i].setVisibility(View.VISIBLE);
        }
        for (int i = score; i < game_IMG_coins.length; i++) {
            game_IMG_coins[i].setVisibility(View.INVISIBLE);
        }
    }

    private void initViews() {
        game_BTN_answer1.setOnClickListener(v -> clicked(game_BTN_answer1.getText().toString()));
        game_BTN_answer2.setOnClickListener(v -> clicked(game_BTN_answer2.getText().toString()));
        game_BTN_answer3.setOnClickListener(v -> clicked(game_BTN_answer3.getText().toString()));
        game_BTN_answer4.setOnClickListener(v -> clicked(game_BTN_answer4.getText().toString()));

    }

    private void findViews() {
        game_IMG_coin1 = findViewById(R.id.game_IMG_coin1);
        game_IMG_coin2 = findViewById(R.id.game_IMG_coin2);
        game_IMG_coin3 = findViewById(R.id.game_IMG_coin3);
        game_IMG_coin4 = findViewById(R.id.game_IMG_coin4);
        game_IMG_coin5 = findViewById(R.id.game_IMG_coin5);
        game_IMG_coin6 = findViewById(R.id.game_IMG_coin6);
        game_IMG_coin7 = findViewById(R.id.game_IMG_coin7);
        game_IMG_coin8 = findViewById(R.id.game_IMG_coin8);
        game_IMG_coin9 = findViewById(R.id.game_IMG_coin9);
        game_IMG_coin10 = findViewById(R.id.game_IMG_coin10);
        game_IMG_flag = findViewById(R.id.game_IMG_flag);

        game_BTN_answer1 = findViewById(R.id.game_answer_1);
        game_BTN_answer2 = findViewById(R.id.game_answer_2);
        game_BTN_answer3 = findViewById(R.id.game_answer_3);
        game_BTN_answer4 = findViewById(R.id.game_answer_4);

        game_IMG_coins = new AppCompatImageView[]{
                game_IMG_coin1,
                game_IMG_coin2,
                game_IMG_coin3,
                game_IMG_coin4,
                game_IMG_coin5,
                game_IMG_coin6,
                game_IMG_coin7,
                game_IMG_coin8,
                game_IMG_coin9,
                game_IMG_coin10,
        };
    }
}