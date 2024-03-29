package com.example.tictactoeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tictactoeapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> combinationList = new ArrayList<>();
    private int[] boxPositions = {0,0,0,0,0,0,0,0,0};
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        combinationList.add(new int[] {0,1,2});
        combinationList.add(new int[] {3,4,5});
        combinationList.add(new int[] {6,7,8});
        combinationList.add(new int[] {0,3,6});
        combinationList.add(new int[] {1,4,7});
        combinationList.add(new int[] {2,5,8});
        combinationList.add(new int[] {2,4,6});
        combinationList.add(new int[] {0,4,8});

        String PlayerOneName = getIntent().getStringExtra("playerOne");
        String PlayerTwoName = getIntent().getStringExtra("playerTwo");

        binding.nameOfPlayer1.setText(PlayerOneName);
        binding.nameOfPlayer2.setText(PlayerTwoName);


        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(0)){
                    performAction((ImageView) view, 0);
                }
            }
        });

        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(1)){
                    performAction((ImageView) view, 1);
                }
            }
        });
        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(2)){
                    performAction((ImageView) view, 2);
                }
            }
        });
        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(3)){
                    performAction((ImageView) view, 3);
                }
            }
        });
        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(4)){
                    performAction((ImageView) view, 4);
                }
            }
        });
        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(5)){
                    performAction((ImageView) view, 5);
                }
            }
        });
        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(6)){
                    performAction((ImageView) view, 6);
                }
            }
        });
        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(7)){
                    performAction((ImageView) view, 7);
                }
            }
        });
        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(8)){
                    performAction((ImageView) view, 8);
                }
            }
        });
    }
    private void performAction(ImageView  imageView, int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = playerTurn;
        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.x_icon);
            if (checkResults()) {
                resultScreen rs = new resultScreen(MainActivity.this, binding.nameOfPlayer1.getText().toString()
                        + " is a Winner!", MainActivity.this);
                rs.setCancelable(false);
                rs.show();
            } else if(totalSelectedBoxes == 9) {
                resultScreen rs = new resultScreen(MainActivity.this, "Match Draw", MainActivity.this);
                rs.setCancelable(false);
                rs.show();
            } else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        }
        else {
            imageView.setImageResource(R.drawable.o_icon);
            if (checkResults()) {
                resultScreen rs = new resultScreen(MainActivity.this, binding.nameOfPlayer2.getText().toString()
                        + " is a Winner!", MainActivity.this);
                rs.setCancelable(false);
                rs.show();
            } else if(totalSelectedBoxes == 9) {
                resultScreen rs = new resultScreen(MainActivity.this, "Match Draw", MainActivity.this);
                rs.setCancelable(false);
                rs.show();
            } else {
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }
    private void changePlayerTurn(int currentPlayerTurn) {
        playerTurn = currentPlayerTurn;
        if (playerTurn == 1) {
            binding.layoutPlayer1.setBackgroundResource(R.drawable.redborder);
            binding.layoutPlayer2.setBackgroundResource(R.drawable.whitebox);
        } else {
            binding.layoutPlayer2.setBackgroundResource(R.drawable.redborder);
            binding.layoutPlayer1.setBackgroundResource(R.drawable.whitebox);
        }
    }
    private boolean checkResults(){
        boolean response = false;
        for (int i = 0; i < combinationList.size(); i++){
            final int[] combination = combinationList.get(i);
            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn &&
                    boxPositions[combination[2]] == playerTurn) {
                response = true;
            }
        }
        return response;
    }
    private boolean isBoxSelectable(int boxPosition) {
        boolean response = false;
        if (boxPositions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }
    public void restartMatch(){
        boxPositions = new int[] {0,0,0,0,0,0,0,0,0};
        playerTurn = 1;
        totalSelectedBoxes = 1;

        binding.image1.setImageResource(R.drawable.whitebox);
        binding.image2.setImageResource(R.drawable.whitebox);
        binding.image3.setImageResource(R.drawable.whitebox);
        binding.image4.setImageResource(R.drawable.whitebox);
        binding.image5.setImageResource(R.drawable.whitebox);
        binding.image6.setImageResource(R.drawable.whitebox);
        binding.image7.setImageResource(R.drawable.whitebox);
        binding.image8.setImageResource(R.drawable.whitebox);
        binding.image9.setImageResource(R.drawable.whitebox);

    }
}

