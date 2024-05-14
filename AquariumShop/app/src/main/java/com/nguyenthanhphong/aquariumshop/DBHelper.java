 package com.nguyenthanhphong.aquariumshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;


import com.nguyenthanhphong.aquariumshop.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 2;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table orders" +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text, " +
                        "price int," +
                        "image int," +
                        "quantity int," +
                        "description text," +
                        "fishname text)"
        );
        sqLiteDatabase.execSQL(
                "CREATE TABLE users" +
                        " ( id integer primary key autoincrement," +
                        " hoten TEXT," +
                        " username TEXT," +
                        " country TEXT, " +
                        " email TEXT," +
                        " dob TEXT, " +
                        " password TEXT, " +
                        " gender TEXT )");
        sqLiteDatabase.execSQL("insert into orders values (0,null,null,null,null,null,null,null)");

    }
    //Đăng Ký
    public void insertUser(ContentValues contentValues){
        getWritableDatabase().insert("users", "", contentValues);
    }

    //Đăng Nhập
    public boolean checkhang(String username, String pasword){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from users where username = ? and password = ?", new String[]{username, pasword});
        if(cursor.getCount() >0)
            return true;
        else
            return false;
    }

    //Gọi Dữ Liệu
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            sqLiteDatabase.execSQL("DROP table if exists orders ");
            sqLiteDatabase.execSQL("DROP table if exists users ");
            onCreate(sqLiteDatabase);
    }

    //Thêm sản phẩm
    public boolean insertOrder(String name, String phone, int price, int image,String desc, String drinkname, int quantity){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("fishname", drinkname);
        values.put("quantity", quantity);
        long id = database.insert("orders", null,values);
        if (id <= 0){
            return false;
        }else {
            return true;
        }
    }

    public ArrayList<OrdersModel> getOrders(){
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,fishname,image,price from orders", null);
        if (cursor.moveToFirst()){
            while (cursor.moveToNext()){
                OrdersModel model = new OrdersModel();
                model.setOrderNumber(cursor.getInt(0) +"");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3) +"");
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }
    public Cursor getOrderById(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from orders where id =" + id, null);

        if(cursor != null)
            cursor.moveToFirst();


        return cursor;
    }
    public boolean updateOrder(String name, String phone, int price, int image,String desc, String fishname, int quantity, int id){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("fishname", fishname);
        values.put("quantity", quantity);
        long row = database.update("orders",values,"id="+id, null);
        if (row <= 0){
            return false;
        }else {
            return true;
        }
    }
    public int deleteOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders", "id = " + id, null);
    }
}
