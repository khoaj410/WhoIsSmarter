package com.example.user.WhoIsSmarter.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.WhoIsSmarter.Model.GameQuestion;

import java.util.ArrayList;
import java.util.List;

public class GameOpenHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME = "GameQuiz";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Game";
    private static final String UID = "_UID";
    private static final String QUESTION = "QUESTION";
    private static final String OPTA = "OPTA";
    private static final String OPTB = "OPTB";
    private static final String OPTC = "OPTC";
    private static final String OPTD = "OPTD";
    private static final String ANSWER = "ANSWER";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public GameOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
    public void allQuestion(){
        ArrayList<GameQuestion> gameQuestions = new ArrayList<>();

        gameQuestions.add(new GameQuestion("Trong Game Liên Minh Huyền Thoại, Nhân Vật Nào Là Nam Được Mở Chơi Free Vào Ngày Phụ Nữ 8/3","Taric","Zed","Jarvan IV","Garen","Taric"));

        gameQuestions.add(new GameQuestion("Cha Đẻ Của Valve Là Ai?","Beethoven","Bill Gates","Gabe Newell","Micheal Jackson","Gabe Newell"));

        gameQuestions.add(new GameQuestion("Cha Đẻ Game Flappy Bird Nổi Tiếng Là Ai?","Hideo Kojima","Dương Quá","Nguyễn Hà Đông","Trần Hoàng Trung","Nguyễn Hà Đông"));

        gameQuestions.add(new GameQuestion("Gabe Newell Ko Bao H Ra Game Đến Phần Mấy?","1","2","3","4","3"));

        gameQuestions.add(new GameQuestion("RPG Viết Tắt Của Gì?","Raiden Plot Game","Rocket Propelled Grenade","Russia Playing Game","Role Playing Game","Role Playing Game"));

        gameQuestions.add(new GameQuestion("Phiên Bản Đầu Tiên Của Tựa Game AOE (Đế Chế) Ra Đời Năm Nào?","1999","1997","2000","2002","1997"));

        gameQuestions.add(new GameQuestion("Bài Nhạc Nổi Tiếng Trong Tựa Game Final Fantasy X Tên Gì?","Suteki Da Ne","Renai Circulation","PPAP","Blue Bird","Suteki Da Ne"));

        gameQuestions.add(new GameQuestion("Tuyển Thủ Vĩ Đại Nhất Dành Đc 3 Cúp CKTG Trong Tựa Game League Of Legends Là Ai","Dendi","Faker","Chim Sẻ Đi Nắng","Ninja","Faker"));

        gameQuestions.add(new GameQuestion("Tựa Game Nổi Tiếng Just Dance Do Công Ty Nào Làm?","Ubisoft","EA","Garena","Vinagame","Ubisoft"));

        gameQuestions.add(new GameQuestion("Tựa Game Nổi Tiếng Giới Trẻ PUBG Do Công Ty Nước Nào Sản Xuất","Việt Nam","Trung Quốc","Mỹ","Hàn Quốc","Hàn Quốc"));

        gameQuestions.add(new GameQuestion("Lần Đầu Tựa Game CF (Đột Kích) Xuất Hiện Ở VN Là Lúc Nào","1/4/2009","15/3/2008","2/9/2012","4/10/2006","15/3/2008"));

        gameQuestions.add(new GameQuestion("Nhân Vật Chính Trong Tựa Game Devil May Cry Tên Gì?","Songoku","Naruto","Dante","Ezio","Dante"));

        gameQuestions.add(new GameQuestion("Game God Of War Xoay Quanh Nhân Vật Chính Làm Gì?","Giết Lợn","Giết Rồng","Giết Thần","Giết Người","Giết Thần"));

        gameQuestions.add(new GameQuestion("Game Of The Year 2017 Là Game Gì?","The Legend of Zelda: Breath of the Wild","Nier Automata","Spiderman","Splatoon 2","The Legend of Zelda: Breath of the Wild"));

        gameQuestions.add(new GameQuestion("Cha Đẻ Của League Of Legends?","Valve","Tencent","Garena","Riot Games","Riot Games"));

        gameQuestions.add(new GameQuestion("Nhân Vật Nào Trong Tựa Game Mario Làm Mưa Làm Gió Trong Tháng 10","Bowser","Mario","Luigi","Sonic","Bowser"));

        gameQuestions.add(new GameQuestion("Tựa Game Moba Nổi Tiếng Do Garena Phát Hành Là Gì?","Liên Quân Mobile","Tiểu Bá Vương","Võ Lâm","Phi Đội Không Gian","Liên Quân Mobile"));

        gameQuestions.add(new GameQuestion("Tựa Game Visual Novel Kinh Dị Có Thể Can Thiệp Vào Máy Tính Chúng Ta Có Tên Là?","Outlast","Slient Hill","DokiDoki Literature Club","Resident Evil","DokiDoki Literature Club"));

        gameQuestions.add(new GameQuestion("Half Life, Left 4 Dead, DOTA Có Đặc Điểm Chung Là Gì?","Cùng Là FPS","Cùng Là RPG","Cùng là MMORPG","Đều Ko Có Phần 3","Đều Ko Có Phần 3"));

        gameQuestions.add(new GameQuestion("Game Gì Nổi Tiếng Đạt Kỷ Lục Guiness Với Độ Khó Cực Cao Khiến Người Chơi Mù Mắt?","Chicken Invader","Touhou","League Of Legends","Alien Shooter","Touhou"));

        gameQuestions.add(new GameQuestion("Tựa Game Đối Kháng Có Tên Gọi Là Rồng Đen","Guilty Gear","Mortal Kombat","Street Fighter","King Of Fighter","Mortal Kombat"));

        gameQuestions.add(new GameQuestion("Nhân Vật Chính Trong Tựa Game Final Fantasy XIII Có Tên Là Gì?","Lightning","Cloud","Dagger","Zidane","Lightning"));

        gameQuestions.add(new GameQuestion("Trong Vice City, Nhân Vật Chính Ko Biết Gì?","Biết Đá Bóng","Biết Bắn Súng","Biết Bơi","Biết Giết Người","Biết Bơi"));

        gameQuestions.add(new GameQuestion("Trong Game Kingdom Hearts, Vũ Khí Của Nhân Vật Chính Là?","Kar98","Hellscythe","Key Blade","Excalibur","Key Blade"));

        gameQuestions.add(new GameQuestion("Con Zombie Có Khả Năng 1 Hit Trong Left 4 Dead Tên Gì?","Charger","Tank","Hunter","Witch","Witch"));

        gameQuestions.add(new GameQuestion("Trong FIFA Bạn Có Thể Tạo Cầu Thủ Có Chỉ Số Max Là Bao Nhiêu?","99","100","200","50","99"));

        gameQuestions.add(new GameQuestion("Youtuber Về Game Có Lượt Subscribe Lớn Nhất Là Ai?","Niga Higa","PewDiePie","Smoosh","Dũng CT","PewDiePie"));

        gameQuestions.add(new GameQuestion("Thể Loại Của Game DOTA2 Là?","MOBA","FPS","RPG","MMO","MOBA"));

        gameQuestions.add(new GameQuestion("Tựa Game MMORPG Vừa Đc Garena Phát Hành Tháng 9 Năm Ngoái Có Tên Là?","Tera","AION","LOL","Blade And Soul","Blade And Soul"));

        gameQuestions.add(new GameQuestion("Trong Cốt Truyện L4D2, Nhân Vật Nào Bỏ Mạng Để Cho Đồng Đội Chạy Thoát","Bill","Francis","Nick","Coach","Bill"));

        this.addAllQuestions(gameQuestions);
    }
    public void addAllQuestions(ArrayList<GameQuestion> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (GameQuestion question : allQuestions) {
                values.put(QUESTION, question.getQuestion());
                values.put(OPTA, question.getOptionA());
                values.put(OPTB, question.getOptionB());
                values.put(OPTC, question.getOptionC());
                values.put(OPTD, question.getOptionD());
                values.put(ANSWER, question.getAnswer());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }
    public List<GameQuestion> getAllOfTheQuestions() {

        List<GameQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);


        while (cursor.moveToNext()) {
            GameQuestion question = new GameQuestion();
            question.setId(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setOptionA(cursor.getString(2));
            question.setOptionB(cursor.getString(3));
            question.setOptionC(cursor.getString(4));
            question.setOptionD(cursor.getString(5));
            question.setAnswer(cursor.getString(6));
            questionsList.add(question);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }
}
