package com.nguyenthanhphong.aquariumshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.nguyenthanhphong.aquariumshop.Adapters.MainAdapter;
import com.nguyenthanhphong.aquariumshop.HelperClasses.HomeAdapter.FeatureAdapter;
import com.nguyenthanhphong.aquariumshop.HelperClasses.HomeAdapter.FeaturedHelperClasss;
import com.nguyenthanhphong.aquariumshop.HelperClasses.HomeAdapter.MostAdapter;
import com.nguyenthanhphong.aquariumshop.HelperClasses.HomeAdapter.MostHelperClass;
import com.nguyenthanhphong.aquariumshop.Models.MainModel;
import com.nguyenthanhphong.aquariumshop.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView featurerecycler, most_view_card,recyclerView;
    RecyclerView.Adapter adapter, adapter2;
    ActivityMainBinding binding;
    Button btn_carts, btn_infoshop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.ca3duoi, "Cá 3 Đuôi", "150000","Là loài cá cảnh đẹp thuộc họ cá Chép. Loại cá này dễ thích nghi với điều kiện sống trong bể nuôi từ kích cỡ nhỏ đến to, hòn non bộ, bể cạn, bể kính…"));
        list.add(new MainModel(R.drawable.caali, "Cá Ali", "200000","Cá Ali- Pseudotropheus Demasoni. Có tên là tiếng anh là  Benga Peacock hoặc New Yellow Regal cá có nguồn gốc từ Tanzania"));
        list.add(new MainModel(R.drawable.cabaymau, "Cá Bảy Màu", "50000","Cá bảy màu là cái tên được người Việt mình gọi dân dã, là loài cá cảnh đẹp, dễ nuôi, không cần oxy. Một phần xuất phát từ màu sắc sặc sỡ bên ngoài."));
        list.add(new MainModel(R.drawable.cachepnhat, "Cá Chép Nhật", "500000","Cá Koi là loài cá chép lai tạo, có quan hệ họ hàng gần với cá vàng và được nuôi để làm cảnh. Cá Koi được cho là loại cá kiểng đẹp dễ nuôi mang lại may mắn."));
        list.add(new MainModel(R.drawable.cada, "Cá Đá", "100000","Cá đá (cá xiêm) là loài cá cảnh đẹp, vốn là loài Betta thuần dưỡng lâu đời ở Thái Lan rồi sau đó lan ra khắp thế giới."));
        list.add(new MainModel(R.drawable.caduoikiem, "Cá Đuôi Kiếm", "170000","Cá đuôi kiếm là một loại cá cảnh đẹp với chiếc đuôi dài và thướt tha."));
        list.add(new MainModel(R.drawable.cahongket, "Cá Hồng Két", "250000","Cá hồng két hay còn gọi là cá Két đỏ, cá huyết anh vũ, còn được biết đến với tên gọi tiếng Anh là blood parrot cichlid, parrot cichlid là một loài cá cảnh đẹp."));
        list.add(new MainModel(R.drawable.calaukieng, "Cá Lau Kiếng", "150000","Cá lau kính (còn gọi là cá lau kiếng, cá tỳ bá, cá dọn bể) là loại cá cảnh đẹp, chúng sẽ làm vệ sinh cho bể cá cảnh một cách tự nhiên giúp tránh các bệnh thường gặp ở cá cảnh."));
        list.add(new MainModel(R.drawable.cataituong, "Cá Tai Tượng", "300000","Cá Tài Phát hay Phát Tài (Tai tượng) là cá kiểng đẹp có kích thước lớn, cá phát tài trống có đầu gù to lớn rất đẹp."));
        list.add(new MainModel(R.drawable.cathanhngoc, "Cá Thanh Ngọc", "230000","Cá thanh ngọc hay cá bãi trầu, cá bảy trầu là một chi cá thuộc họ Cá sặc. Chúng dễ nuôi không cần oxy, phân bố ở vùng Đông Nam châu Á, từ Myanma, Thái Lan tới Việt Nam và bán đảo Mã Lai."));
        list.add(new MainModel(R.drawable.cathienduong, "Cá Thiên Đường", "250000","Cá thiên đường (đuôi cờ, lia thia ruộng) còn gọi là cá lia thia đồng, cá đuôi cờ có nhiều màu sắc đa dạng cùng với vây kỳ căng tròn."));
        list.add(new MainModel(R.drawable.cathoiloi, "Cá Thòi Lòi", "150000","Cá thòi lòi có tên khoa học là Periophthalmus schlosseri, là loại cá cảnh đẹp độc lạ. Nhiều người tưởng rằng chúng lưỡng cư vì chúng có đôi mắt lồi như mắt ếch và có thể di chuyển dễ dàng trên cạn bằng hai chi trước."));

        MainAdapter adapter = new MainAdapter(list , this);
        binding.recycleview.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recycleview.setLayoutManager(layoutManager);

        featurerecycler = findViewById(R.id.featured_recycler);
        most_view_card = findViewById(R.id.most_view);

        featurerecycler();
        most_view_card();

        btn_infoshop = findViewById(R.id.btn_infoshop);
        btn_infoshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InfomationShop.class));
            }
        });

        btn_carts = findViewById(R.id.btn_cart);
        btn_carts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
            }
        });
    }

    private void most_view_card() {
        most_view_card.setHasFixedSize(true);
        most_view_card.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostHelperClass> mostLocations = new ArrayList<>();
        mostLocations.add(new MostHelperClass(R.drawable.cachepnhat, "Cá Chép Nhật", "05 Reviews"));
        mostLocations.add(new MostHelperClass(R.drawable.cada, "Cá Đá", "51 Reviews"));
        mostLocations.add(new MostHelperClass(R.drawable.cathanhngoc, "Cá Thanh Ngọc", "10 Reviews"));
        mostLocations.add(new MostHelperClass(R.drawable.cataituong, "Cá Tai Tượng", "20 Reviews"));
        mostLocations.add(new MostHelperClass(R.drawable.cathoiloi, "Cá Thòi Lòi", "17 Reviews"));
        adapter2 = new MostAdapter(mostLocations);
        most_view_card.setAdapter(adapter2);

    }
    private void featurerecycler() {
        featurerecycler.setHasFixedSize(true);
        featurerecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FeaturedHelperClasss> featurelocations = new ArrayList<>();

        featurelocations.add(new FeaturedHelperClasss(R.drawable.cada, "Cá Đá", "Cá đá (cá xiêm) là loài cá cảnh đẹp, vốn là loài Betta thuần dưỡng lâu đời ở Thái Lan rồi sau đó lan ra khắp thế giới."));
        featurelocations.add(new FeaturedHelperClasss(R.drawable.caduoikiem, "Cá Đuôi Kiếm", "Cá đuôi kiếm là một loại cá cảnh đẹp với chiếc đuôi dài và thướt tha."));
        featurelocations.add(new FeaturedHelperClasss(R.drawable.cataituong, "Cá Tai Tượng", "Cá Tài Phát hay Phát Tài (Tai tượng) là cá kiểng đẹp có kích thước lớn, cá phát tài trống có đầu gù to lớn rất đẹp."));
        featurelocations.add(new FeaturedHelperClasss(R.drawable.cabaymau, "Cá Bảy Màu", "Cá bảy màu là cái tên được người Việt mình gọi dân dã, là loài cá cảnh đẹp, dễ nuôi, không cần oxy. Một phần xuất phát từ màu sắc sặc sỡ bên ngoài."));
        featurelocations.add(new FeaturedHelperClasss(R.drawable.cahongket, "Cá Hồng Két", "Cá hồng két hay còn gọi là cá Két đỏ, cá huyết anh vũ, còn được biết đến với tên gọi tiếng Anh là blood parrot cichlid, parrot cichlid là một loài cá cảnh đẹp."));
        featurelocations.add(new FeaturedHelperClasss(R.drawable.cathienduong, "Cá Thiên Đường", "Cá thiên đường (đuôi cờ, lia thia ruộng) còn gọi là cá lia thia đồng, cá đuôi cờ có nhiều màu sắc đa dạng cùng với vây kỳ căng tròn."));

        adapter = new FeatureAdapter(featurelocations);
        featurerecycler.setAdapter(adapter);
    }

}