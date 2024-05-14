package com.nguyenthanhphong.aquariumshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nguyenthanhphong.aquariumshop.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    TextView prices, soluong;
    Button btn_back;
    ImageView up, down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type", 0) ==1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", price));
            binding.nameBox.setText(name);
            binding.detailDescription.setText(description);

            up = findViewById(R.id.add);
            down = findViewById(R.id.subtract);
            prices = findViewById(R.id.priceLbl);
            soluong = findViewById(R.id.quantity);
            btn_back=findViewById(R.id.btn_back);

            up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = Integer.parseInt(soluong.getText().toString())+1;
                    soluong.setText(count+"");

                    prices.setText(count* price+"");
                }
            });

            down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = Integer.parseInt(soluong.getText().toString()) - 1;
                    if (count == 0) {
                        Toast.makeText(DetailActivity.this,"Sản Phẩm Phải Lớn Hơn 0 !", Toast.LENGTH_SHORT).show();
                    } else {
                        soluong.setText(count + "");

                        prices.setText(count * price + "");
                    }
                }
            });

            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
            });

            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean inInserted = helper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())

                    );
                    if (inInserted)
                        Toast.makeText(DetailActivity.this, "Thêm Sản Phẩm Thành Công !.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Lỗi Thêm Sản Phẩm !.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            final int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
            final int image = cursor.getInt(4);
            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", cursor.getInt(3)));
            binding.nameBox.setText(cursor.getString(6));
            binding.detailDescription.setText(cursor.getString(5));

            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertBtn.setText("Update now");
            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isUpdate = helper.updateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.priceLbl.getText().toString()),
                            image,
                            binding.detailDescription.getText().toString(),
                            binding.nameLbl.getText().toString(),
                            1, id
                    );
                    if(isUpdate){
                        Toast.makeText(DetailActivity.this, "Update", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}