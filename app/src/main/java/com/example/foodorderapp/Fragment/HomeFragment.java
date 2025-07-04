package com.example.foodorderapp.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.foodorderapp.DetailsActivity;
import com.example.foodorderapp.Model.PopularModel;
import com.example.foodorderapp.R;
import com.example.foodorderapp.adapter.PopularAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ImageSlider imageSlider;
    private RecyclerView recyclerView;


    public HomeFragment() {
        // Required empty public constructor
    }

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imageSlider = view.findViewById(R.id.image_slider);
        recyclerView = view.findViewById(R.id.recyclerView);

        TextView menuItemBtn = view.findViewById(R.id.menu_button);
        menuItemBtn.setOnClickListener(v -> {
            BottomSheetFragment bottomSheet = new BottomSheetFragment();
            bottomSheet.show(getParentFragmentManager(), "MenuBottomSheet");
        });


        setupImageSlider();
        setupPopularItems();

        return view;
    }



    private void setupImageSlider() {
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.food_one, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.food_two, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.food_three, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.food_four, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.food_one, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.food_two, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.food_three, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.food_four, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels);

        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                Toast.makeText(requireContext(), "Item clicked: " + i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void doubleClick(int i) {
                Toast.makeText(requireContext(), "Item double-clicked: " + i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupPopularItems() {
        List<PopularModel> popularList = new ArrayList<>();
        popularList.add(new PopularModel(R.drawable.food_three, "Herbal Pancake", "$7", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Salad Bowl", "$5", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Vegan Wrap", "$6", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Herbal Pancake", "$7", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Salad Bowl", "$5", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Vegan Wrap", "$6", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Herbal Pancake", "$7", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Salad Bowl", "$5", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Vegan Wrap", "$6", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Herbal Pancake", "$7", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Salad Bowl", "$5", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Vegan Wrap", "$6", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Herbal Pancake", "$7", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Salad Bowl", "$5", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Vegan Wrap", "$6", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Herbal Pancake", "$7", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Salad Bowl", "$5", "Add to cart"));
        popularList.add(new PopularModel(R.drawable.food_three, "Vegan Wrap", "$6", "Add to cart"));


        PopularAdapter adapter = new PopularAdapter(popularList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(item -> {
            Intent intent = new Intent(getActivity(), DetailsActivity.class);
            intent.putExtra("food_name", item.getName());
            intent.putExtra("food_image", item.getImageResId());
            startActivity(intent);
        });
    }


}
