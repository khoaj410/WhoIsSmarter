package com.example.user.trungthph06234_project1.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.trungthph06234_project1.Model.GameQuestion;
import com.example.user.trungthph06234_project1.Model.GeneralQuestion;
import com.example.user.trungthph06234_project1.Model.SportsQuestion;

import java.util.ArrayList;
import java.util.List;

public class SportsOpenHepler extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME = "SportQuiz";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Sport";
    private static final String UID = "_UID";
    private static final String QUESTION = "QUESTION";
    private static final String OPTA = "OPTA";
    private static final String OPTB = "OPTB";
    private static final String OPTC = "OPTC";
    private static final String OPTD = "OPTD";
    private static final String ANSWER = "ANSWER";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public SportsOpenHepler(Context context) {
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

    public void allQuestion() {
        ArrayList<SportsQuestion> sportsQuestions = new ArrayList<>();

        sportsQuestions.add(new SportsQuestion("Thủ môn duy nhất giành quả bóng vàng","Edwin Van Der Sar","Gianluigi Buffon","Lev Yashin","Manuel Neuer","Lev Yashin"));

        sportsQuestions.add(new SportsQuestion("Việt Nam đã thất bại trong trận chung kết U23 Châu Á vào tháng 1-2018 trước đội tuyển nào","Lào","Thái Lan","Hàn Quốc","Uzbekistan","Uzbekistan"));

        sportsQuestions.add(new SportsQuestion("World Cup 2002 đc tổ chức ở đâu","Hàn Quốc Và Nhật Bản","Đức","Nga","Nam Phi","Hàn Quốc Và Nhật Bản"));

        sportsQuestions.add(new SportsQuestion("Bài hát chủ đề của World Cup 2010 là gì?","Cup Of Life","La La La","Un Estate Italiana","Wavin' Flag","Wavin' Flag"));

        sportsQuestions.add(new SportsQuestion("Ai dành quả bóng vàng World Cup 2018","Cristiano Ronaldo","Luka Modric","Kylian Mbappe","Eden Hazard","Luka Modric"));

        sportsQuestions.add(new SportsQuestion("Olympic 2020 tổ chức ở đâu?","Nhật Bản","Brazil","Việt Nam","Đông-Ti-Mo","Nhật Bản"));

        sportsQuestions.add(new SportsQuestion("Vận động viên đc mệnh danh là Kình Ngư ở Việt Nam là","Nguyễn Tiến Minh","Công Vinh","Nguyễn Thị Ánh Viên","Lê Thanh Hải","Nguyễn Thị Ánh Viên"));

        sportsQuestions.add(new SportsQuestion("Esport đc gọi là gì?","Thể thao thông tin","Thể thao E","Thể thao tích hợp","Thể thao điện tử","Thể thao điện tử"));

        sportsQuestions.add(new SportsQuestion("Tuyển thù liên minh huyền thoại đi vào lịch sử với pha backdoor tên gì?","Faker","Levi","Xpeke","Doublelift","Xpeke"));

        sportsQuestions.add(new SportsQuestion("Cầu thủ nào đã từng chơi cho AC Milan, Chelsea, Altetico Madrid và Liverpool","Cristiano Ronaldo","Fernando Torres","Andrea Pirlo","Van Persie","Fernando Torres"));

        sportsQuestions.add(new SportsQuestion("Ai là người dành quả bóng vàng 2014","Lionel Messi","Neymar Jr","Manuel Neuer","Cristano Ronaldo","Cristiano Ronaldo"));

        sportsQuestions.add(new SportsQuestion("Nước nào vô địch World Cup 2014","Hà Lan","Anh","Pháp","Đức","Đức"));

        sportsQuestions.add(new SportsQuestion("Vận động viên nào đạt huy chương vàng môn nhảy xa ASIAD 2018?","Nguyễn Thu Thảo","Nguyễn Tiến Minh","Nguyễn Văn Trí","Phạm Thu Trang","Nguyễn Thu Thảo"));

        sportsQuestions.add(new SportsQuestion("Đội tuyển nào vô địch The International 7 trong tựa Esport Dota 2?","Navi","Liquid","OG","Secret","Liquid"));

        sportsQuestions.add(new SportsQuestion("Cristiano Ronaldo rời Real Madrid để sang đội bóng nào?","Juventus","Manchester United","PSG","Barcelona","Juventus"));

        sportsQuestions.add(new SportsQuestion("Lebron James là vận động viên nổi tiếng trong bộ môn","Bóng đá","Bóng chày","Bóng chuyền","Bóng rổ","Bóng rổ"));

        sportsQuestions.add(new SportsQuestion("Tay vợt cầu lông cừ khôi đã đạt huy chương đồng trong giải BMF World Championships có tên là","Trần Hoàng Trung","Lin Dan","Nguyễn Tiến Minh","Chou Tien-chen","Nguyễn Tiến Minh"));

        sportsQuestions.add(new SportsQuestion("Olympic 2016 đc tổ chức ở đâu","Anh","Brazil","Việt Nam","Thụy Điển","Brazil"));

        sportsQuestions.add(new SportsQuestion("Hoàng Xuân Vinh là vận dộng viên đã dành huy chương vàng trong bộ môn gì?","Bơi lội","Điền Kinh","Bắn súng","Cầu lông","Bắn súng"));

        sportsQuestions.add(new SportsQuestion("Tựa Esport nào có tổng giá trị giải thường cao nhất?","League Of Legends","DOTA2","Starcraft","AOE","DOTA2"));
        this.addAllQuestions(sportsQuestions);
    }
    public void addAllQuestions(ArrayList<SportsQuestion> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (SportsQuestion question : allQuestions) {
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
    public List<SportsQuestion> getAllOfTheQuestions() {

        List<SportsQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);


        while (cursor.moveToNext()) {
            SportsQuestion question = new SportsQuestion();
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
