package com.example.user.WhoIsSmarter.Model;
import com.example.user.WhoIsSmarter.R;
public class EnglishQuestion {

    public Integer MyQuestions [] = {
            R.drawable.apple,
            R.drawable.bicycle,
            R.drawable.dinosaur,
            R.drawable.elephant,
            R.drawable.lightning,
            R.drawable.fire,
            R.drawable.doctor,
            R.drawable.eclipse,
            R.drawable.hunter,
            R.drawable.knife,
            R.drawable.knight,
            R.drawable.lion,
            R.drawable.moon,
            R.drawable.museum,
            R.drawable.police,
            R.drawable.shield,
            R.drawable.sky,
            R.drawable.wings,
            R.drawable.assassin,
            R.drawable.magic,
            R.drawable.basketball,
            R.drawable.flags,
            R.drawable.chair,
            R.drawable.gate,
            R.drawable.support,
            R.drawable.lantern,
            R.drawable.festival,
            R.drawable.balloons,
            R.drawable.monster,
            R.drawable.darkness


    };

    //array of multiple choices for each question
    private String MyChoices[][] = {
            {"Banana", "Apple", "Orange", "Cherry"},
            {"Bicycle", "Plane", "Boat", "Foot"},
            {"Dog", "Cat", "Dinosaur", "Monkey"},
            {"Bear", "Snake", "Panda", "Elephant"},
            {"Ice", "Wind", "Nature", "Lightning"},
            {"Iron", "Fire", "Water", "Rock"},
            {"Doctor", "Student", "Teacher", "Engineer"},
            {"Sun","Moon","Eclipse","Mars"},
            {"Teacher","Police","Trainer","Hunter"},
            {"Knife","Sword","Spear","Long Sword"},
            {"Samurai","Knight","Lancer","King"},
            {"Cheetah","Lion","Dog","Crocodile"},
            {"Sun","Venus","Moon","Eclipse"},
            {"Museum","School","Hospital","Art-Gallery"},
            {"Boss","Designer","Engineer","Police"},
            {"Barrier","Gun","Shield","Bow"},
            {"Cloud","Star","White","Sky"},
            {"Wings","Angel","Devil","Light"},
            {"Lancer","Ninja","Assassin","Rider"},
            {"Sparkle","Twinkle","Magic","Darkness"},
            {"Football","Basketball","Volleyball","Badminton"},
            {"Picture","Flag","Dragon","Image"},
            {"Table","Bag","Chair","Speaker"},
            {"Gate","Televison","Bed","Point"},
            {"Carry","Support","Mid","Top"},
            {"T-shirt","Lantern","Pillow","Remote"},
            {"Party","Meeting","Family","Festival"},
            {"Ball","Rainbow","Ballon","Fly"},
            {"Dog","Cat","Phoenix","Monster"},
            {"Light","Miracle","Darkness","Nothing"}

    };

    // array of correct answers - in the same order as array of questions
    private String MyCorrectAnswers[] = {"Apple", "Bicycle", "Dinosaur", "Elephant", "Lightning", "Fire", "Doctor", "Eclipse", "Hunter", "Knife", "Knight", "Lion", "Moon", "Museum", "Police"
            , "Shield", "Sky", "Wings", "Assassin", "Magic", "Basketball", "Flag", "Chair", "Gate", "Support", "Lantern", "Festival", "Ballon", "Monster", "Darkness"};

    // method returns number of questions
    public int getLength() {
        return MyQuestions.length;
    }

    // method returns question from array textQuestions[] based on array index
    public Integer getQuestion(int a) {
        Integer question = MyQuestions[a];
        return question;
    }

    // method returns a single multiple choice item for question based on array index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4 as an argument
    public String getChoice(int index, int num) {
        String choice0 = MyChoices[index][num - 1];
        return choice0;
    }

    //  method returns correct answer for the question based on array index
    public String getCorrectAnswer(int a) {
        String answer = MyCorrectAnswers[a];
        return answer;
    }
}
