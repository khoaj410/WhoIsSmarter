package com.example.user.WhoIsSmarter.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.WhoIsSmarter.Model.MusicQuestion;
import com.example.user.WhoIsSmarter.R;

import java.util.ArrayList;
import java.util.List;

public class MusicOpenHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME = "MusicQuiz";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Music";
    private static final String UID = "_UID";
    private static final String QUESTION = "QUESTION";
    private static final String OPTA = "OPTA";
    private static final String OPTB = "OPTB";
    private static final String OPTC = "OPTC";
    private static final String OPTD = "OPTD";
    private static final String ANSWER = "ANSWER";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public MusicOpenHelper(Context context) {
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
        ArrayList<MusicQuestion> musicQuestions = new ArrayList<>();

        musicQuestions.add(new MusicQuestion(R.raw.endlesslove,"Endless Love","Endless Summer","Endless Tear","Endless Winter","Endless Love"));

        musicQuestions.add(new MusicQuestion(R.raw.noinaycoanh,"Bùa Yêu","Nơi Này Có Anh","Lạc Trôi","Em của ngày hôm qua","Nơi Này Có Anh"));

        musicQuestions.add(new MusicQuestion(R.raw.uptownfunk, "Baby","Lazy Song","Uptown Funk","Diamond","Uptown Funk"));

        musicQuestions.add(new MusicQuestion(R.raw.hurricanesanjou,"Bad Day","Opening Gao","Hurricane Sanjou","Excite","Hurricane Sanjou"));

        musicQuestions.add(new MusicQuestion(R.raw.sutekidane,"Best Friend","Ichiban No Takaramono","My Soul, Your Beats","Suteki Da Ne","Suteki Da Ne"));

        musicQuestions.add(new MusicQuestion(R.raw.chieckhangioam,"Chiếc Khăn Gió Ấm","Cầu Vồng Khuyết","Lạc Trôi","Lạnh","Chiếc Khăn Gió Ấm"));

        musicQuestions.add(new MusicQuestion(R.raw.dragondintea,"Barbie Girl","Daddy Cool","Smooth Criminal","Dragonstea Din Tei","Dragonstea Din Tei"));

        musicQuestions.add(new MusicQuestion(R.raw.kda,"Gangnam Style","KDA Pop Stars","Roly Poly","Rise","KDA Pop Stars"));

        musicQuestions.add(new MusicQuestion(R.raw.yeulaitudau,"Như Vậy Nhé","Yêu Lại Từ Đầu","Thu Cuối","Gọi Tên Em Trong Đêm","Yêu Lại Từ Đầu"));

        musicQuestions.add(new MusicQuestion(R.raw.haruharu,"Haru Haru","Lies","Last Farewell","Sorry Sorry","Haru Haru"));

        musicQuestions.add(new MusicQuestion(R.raw.bongbongbangbang,"Bang Bang Bang","Hai Cô Tiên","Bống Bống Bang Bang","Lọ Lem","Bống Bống Bang Bang"));

        musicQuestions.add(new MusicQuestion(R.raw.hocmeokeu,"Học Chó Kêu","Học Mèo Kêu","Thần Thoại","Có Chút Ngọt Ngào","Học Mèo Kêu"));

        musicQuestions.add(new MusicQuestion(R.raw.yeu5,"Yêu 2","Yêu 3","Yêu 5","Yêu 6","Yêu 5"));

        musicQuestions.add(new MusicQuestion(R.raw.mylove,"I Lay My Love On You","Uptown Girl","Season In The Sun","My Love","My Love"));

        musicQuestions.add(new MusicQuestion(R.raw.takemetoyourheart,"Take Me To Your Heart","Cry On My Shoulder","I Want It That Way","Numb","Take Me To Your Heart"));

        musicQuestions.add(new MusicQuestion(R.raw.doraemonnouta,"Conan Opening","Doraemon Opening","Pokemon Opening","One Piece Opening","Doraemon Opening"));

        musicQuestions.add(new MusicQuestion(R.raw.haohanca,"Tào Phớ","Anh Hùng Ca","Hảo Hán Ca","Tây Du Ký","Hảo Hán Ca"));

        musicQuestions.add(new MusicQuestion(R.raw.tuyetyeuthuong,"Tiểu Thuyết Tình Yêu","Number 1","Thu Cuối","Tuyết Yêu Thương","Tuyết Yêu Thương"));

        musicQuestions.add(new MusicQuestion(R.raw.partyrockantham,"Sexy And I Know It","Party Rock Anthem","Hangover","Baby","Party Rock Anthem"));

        musicQuestions.add(new MusicQuestion(R.raw.suthanhhoa,"Hair Like Snow","Độc Thoại","Sứ Thanh Hoa","Tóc Như Tuyết","Sứ Thanh Hoa"));

        musicQuestions.add(new MusicQuestion(R.raw.wavinflag,"La La La","Cup Of Life","Live It On","Wavin Flag","Wavin Flag"));

        musicQuestions.add(new MusicQuestion(R.raw.tarzanandjane,"Best Friend","Barbie Girl","Tarzan And Jane","Bye Bye Bye","Tarzan And Jane"));

        musicQuestions.add(new MusicQuestion(R.raw.gentleman,"Gangnam Style","Gentleman","Hangover","New Face","Gentleman"));

        musicQuestions.add(new MusicQuestion(R.raw.cupoflife,"La La La","Wavin Flag","Cup Of Life","Alele","Cup Of Life"));

        musicQuestions.add(new MusicQuestion(R.raw.chibimaruko,"Chibi Maruko Opening","Shin Opening","Pokemon Opening","Inuyasha Opening","Chibi Maruko Opening"));
        this.addAllQuestions(musicQuestions);
    }
    public void addAllQuestions(ArrayList<MusicQuestion> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (MusicQuestion question : allQuestions) {
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
    public List<MusicQuestion> getAllOfTheQuestions() {

        List<MusicQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);


        while (cursor.moveToNext()) {
            MusicQuestion question = new MusicQuestion();
            question.setId(cursor.getInt(0));
            question.setQuestion(cursor.getInt(1));
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
