package com.example.mysuggestfood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="list_food";
    private static final String TABLE_NAME ="table_food";
    private static final String Id = "id";
    private static final String NameFood = "nameFood";
    private static final String NutritionalValue = "nutritionalValue";
    private static final String Resource = "resource";
    private static final String Tutorials = "tutorials";
    private static final String KindFood = "kindFood";
    private static final String ExecutionTime = "executionTime";
    private static final String ImageFood = "imageFood";
    private static final String Price = "price";
    private static final String DifficultLevel = "difficultTime";

    private Context context;


    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Nó được gọi khi database được nâng cấp, ví dụ như chỉnh sửa cấu trúc các bảng, thêm những thay đổi cho database,..
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(sqLiteDatabase);
        Toast.makeText(context, "Drop table successfully", Toast.LENGTH_SHORT).show();
    }

    //Truy van khong tra ve ket qua : CREATE , INSERT , DELETE , UPDATE , ...
    public void queryDB(String sql) {
        SQLiteDatabase database = getWritableDatabase();       //Tuong tac voi DB (ghi du lieu).
        database.execSQL(sql);          //De goi DB , truyen vao chuoi lenh SQL cua minh muon thuc hien.
    }

    //Contructor "database" la qua trinh tao database , onCreate la qua trinh tao table , onUpdate la qua trinh cap nhat CSDL.
    public database(Context context) {
        super(context, DATABASE_NAME,null, 1);
        this.context = context;
    }

    //Đây là nơi để chúng ta viết những câu lệnh tạo bảng. Nó được gọi khi database đã được tạo.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                Id + "INTEGER PRIMARY KEY, " +
                NameFood + "TEXT, " +
                NutritionalValue + "TEXT, " +
                Resource + "TEXT, " +
                Tutorials + "TEXT, " +
                KindFood + "TEXT, " +
                ExecutionTime + "TEXT, " +
                ImageFood + "TEXT, " +
                Price + "TEXT, " +
                DifficultLevel + " TEXT )";

        sqLiteDatabase.execSQL(sqlQuery);
        Toast.makeText(context, "Create table successfully", Toast.LENGTH_SHORT).show();
    }


    //Truy van co tra ve ket qua : SELECT , se tra ve du lieu bang con tro, con tro se duyet tung dong roi tra ve ket qua.
    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();        //chi lay du lieu , getReadable (chi doc du lieu).
        // getWritable (co the ca doc va ghi dud lieu).
        return database.rawQuery(sql, null);        //rawQuery de tra het du lieu ra.
    }

    //Add a new food .
    public void addFood(ListFood listFood) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();     // Dung de chen mot hang moi trong CSDL.
        values.put(NameFood, listFood.nameFood);
        values.put(NutritionalValue, listFood.nutritionalValue);
        values.put(Resource, listFood.resource);
        values.put(Tutorials, listFood.tutorials);
        values.put(KindFood, listFood.kindFood);
        values.put(ExecutionTime, listFood.executionTime);
        values.put(ImageFood, listFood.imageFood);
        values.put(Price, listFood.price);
        values.put(DifficultLevel, listFood.difficultLevel);

        //Neu de null thi khi value bang null thi loi

        sqLiteDatabase.insert(TABLE_NAME,null,values);

        sqLiteDatabase.close();
    }

    //Select a food by ID
    public ListFood getFoodById(int id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, new String[] {Id,
                NameFood,
                NutritionalValue,
                Resource,
                Tutorials,
                KindFood,
                ExecutionTime,
                ImageFood,
                Price,
                DifficultLevel },Id + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();       //Di chuyen con tri den hang dau tien trong ket qua truy van.

        //cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME +" WHERE id = '1'",null);
        ListFood listFood = new ListFood(cursor.getString(1),
                cursor.getFloat(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getInt(6),
                cursor.getString(7),
                cursor.getFloat(8),
                cursor.getString(9));

        cursor.close();
        sqLiteDatabase.close();
        return listFood;
    }

    //select all food
    public List<ListFood> getAllFood() {
        List<ListFood> listFoodList = new ArrayList<ListFood>();

        //Select all query.
        String selectQuery = "SELECT * FROM " +TABLE_NAME;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
    }
}
