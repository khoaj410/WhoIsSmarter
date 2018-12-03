package com.example.user.WhoIsSmarter.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.WhoIsSmarter.Model.GeneralQuestion;

import java.util.ArrayList;
import java.util.List;

public class GeneralOpenHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME = "GeneralQuiz";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "General";
    private static final String UID = "_UID";
    private static final String QUESTION = "QUESTION";
    private static final String OPTA = "OPTA";
    private static final String OPTB = "OPTB";
    private static final String OPTC = "OPTC";
    private static final String OPTD = "OPTD";
    private static final String ANSWER = "ANSWER";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public GeneralOpenHelper(Context context) {
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
        ArrayList<GeneralQuestion> generalQuestions = new ArrayList<>();

        generalQuestions.add(new GeneralQuestion("Với Nguyên Tử Khối 64, Là Chất Gì?","H (Hidro)","C (Cacbon)","Cu (Đồng)","Zn (Kẽm)","Cu (Đồng)"));

        generalQuestions.add(new GeneralQuestion("Năm Bao Nhiêu Là 1000 Năm Thăng Long","2010","2008","2015","2012","2010"));

        generalQuestions.add(new GeneralQuestion("Trận Lụt Lịch Sử Mà Được Nhắc Đến Trong Táo Quân Năm Bao Nhiêu","1990","2000","2005","2008","2008"));

        generalQuestions.add(new GeneralQuestion("Bộ Truyện Tranh Nổi Tiếng One Piece Có Nhân Vật Chính Tên Gì?","Naruto","Songoku","Deadpool","Luffy","Luffy"));

        generalQuestions.add(new GeneralQuestion("Bài Thơ Bánh Trôi Nước Do Ai Sáng Tác","Hồ Quỳnh Hương","Hồ Xuân Hương","Nam Cao","Tố Hữu","Hồ Xuân Hương"));

        generalQuestions.add(new GeneralQuestion("2 Thành Phố Hứng Chịu Thảm Họa Bom Nguyên Tử Tên Gì?","Tokyo Và Kyoto","Osaka Và Tokyo","Hiroshima Và Nagasaki","Fukushima Và Kyoto","Hiroshima Và Nagasaki"));

        generalQuestions.add(new GeneralQuestion("Deadpool Do Diễn Viên Nào Thủ Vai","Ryan Reynolds","Chris Evans","Johhny Depp","Leonardo D Caprio","Ryan Reynolds"));

        generalQuestions.add(new GeneralQuestion("FaceBook Do Ai Sáng Lập","Bill Gates","Steve Jobs","Mark Zuckerberg","Justin Bieber","Mark Zuckerberg"));

        generalQuestions.add(new GeneralQuestion("Halloween Diễn Ra Vào Ngày 31 Tháng Mấy","10","9","11","12","10"));

        generalQuestions.add(new GeneralQuestion("Vai Diễn Ngọc Hoàng Trong Táo Quân Do Nghệ Sĩ Nào Đóng?","Xuân Bắc","Quốc Khánh","Hiệp Gà","Tự Long","Quốc Khánh"));

        generalQuestions.add(new GeneralQuestion("Trong Tiếng Anh Libra Là Cung Gì","Bọ Cạp","Xử Nữ","Bảo Bình","Thiên Bình","Thiên Bình"));

        generalQuestions.add(new GeneralQuestion("Trưởng Nhóm Big Bang Là Ai?","G-Dragon","Sơn Tùng","Justin Bieber","Micheal Jackson","G-Dragon"));

        generalQuestions.add(new GeneralQuestion("Aishiteru Trong Tiếng Nhật Là Gì?","Tao Ghét Mày","Anh Yêu Em","Hãy Đợi Đấy","Đi Chơi Thôi","Anh Yêu Em"));

        generalQuestions.add(new GeneralQuestion("Ca Sĩ Ảo Nổi Tiếng Có Tên Là?","Hatsune Miku","Kizuna Ai","Taylor Swift","Miley Cyrus","Hatsune Miku"));

        generalQuestions.add(new GeneralQuestion("Ngày 1-5 là ngày kỉ niệm gì?","Quốc tế lao động","Quốc tế phụ nữ","Giải phóng miền Nam","Chiến thắng Điện Biên Phủ","Quốc tế lao động"));

        generalQuestions.add(new GeneralQuestion("Tác giả của bộ truyện tranh nổi tiếng Thám tử lừng danh Conan?","Fujico Fujio","Takahashi Monona","Gosho Aoyama","Kajuki Takahashi","Gosho Aoyama"));

        generalQuestions.add(new GeneralQuestion("Trong thế giới cờ, cờ nào có 32 quân?","Cờ tướng","Cờ cá ngựa","Cờ vây","Cờ vua và cờ tướng","Cờ vua và cờ tướng"));

        generalQuestions.add(new GeneralQuestion("Diễn viên đóng vai Vàng anh trong phần 1 của Nhật ký vàng anh là?","Hoàng Thùy Linh","Minh Hương","Thanh Vân","Thanh Hương","Minh Hương"));

        generalQuestions.add(new GeneralQuestion("Cầu Thủ Nào Đã Ghi Bàn Quyết Định Trong Trận Chung Kết AFF Cup 2008","Công Phương","Phan Văn Tài Em","Công Vinh","Quang Hải","Công Vinh"));

        generalQuestions.add(new GeneralQuestion("Hà Lan và Đan Mạch là 2 quốc gia có địa hình 100 là gì?","Biển","Đồng Bằng","Đồi Núi","Băng Tuyết","Đồng Bằng"));

        generalQuestions.add(new GeneralQuestion("Vị vua cuối cùng của triều Lý là ai?","Lý Huệ Tông","Lý Nam Đế","Lý Nhân Tông","Lý Chiêu Hoàng","Lý Chiêu Hoàng"));

        generalQuestions.add(new GeneralQuestion("April trong tiếng Anh là tháng mấy trong năm?","1","11","4","3","4"));

        generalQuestions.add(new GeneralQuestion("Kilimanjaro là ngọn núi cao nhất châu lục nào?","Châu Á","Châu Phi","Châu Dại Dương","Châu Âu","Châu Phi"));

        generalQuestions.add(new GeneralQuestion("Phần mềm nào sau đây để gõ tiếng việt có dấu?","Paint","Unikey","Keyboard","Keylock","Unikey"));

        generalQuestions.add(new GeneralQuestion("Tập đoàn nào sau đây chuyên sản xuất điện thoại di động?","Microsoft","Yahoo","Nokia","Google","Nokia"));

        generalQuestions.add(new GeneralQuestion("Trong cờ Tướng, mỗi quân Tốt có thể đi được bao nhiêu vị trí?","44","45","46","47","47"));

        generalQuestions.add(new GeneralQuestion("Trong các loài dưới đây, loài nào đã bị tuyệt chủng?","Tinh Tinh","Đại Bàng","Rắn Hổ Mang","Khủng Long","Khủng Long"));

        generalQuestions.add(new GeneralQuestion("Từ nào sau đây không cùng nhóm với các từ còn lại?","Good Morning","Thank You","Good Afternoon","Hello","Thank You"));

        generalQuestions.add(new GeneralQuestion("Ban đầu x=1, y=2. Sau khi sử dụng temp=x, x=y, y=temp. Vậy x=? y=?","x=1, y=2","x=1, y=1","x=2, y=2","x=2, y=1","x=2, y=1"));

        generalQuestions.add(new GeneralQuestion("Trong bài hát Dragostea Din Tei, câu hát nào có trong bài?","Mai Ya Hi","Alolo","La la la","Ahaha","Mai Ya Hi"));
        this.addAllQuestions(generalQuestions);
    }
    public void addAllQuestions(ArrayList<GeneralQuestion> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (GeneralQuestion question : allQuestions) {
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
    public List<GeneralQuestion> getAllOfTheQuestions() {

        List<GeneralQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);


        while (cursor.moveToNext()) {
            GeneralQuestion question = new GeneralQuestion();
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
