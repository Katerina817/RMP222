package com.example.rmp222;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.example.rmp222.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Инициализация текстового компонента строковым ресурсом
        binding.textView.setText(getString(R.string.my_name));

        //Инициализация компонента изображения ресурсом картинки
        binding.imageView1.setImageResource(R.drawable.ice_cream_svgrepo_com);
        //обработка нажатия на кнопку
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyApp", "Кнопка была нажата программным способом");
            }
        });


        /* //Без ViewBinding
        setContentView(R.layout.linear_layout);
        //Инициализация текстового компонента строковым ресурсом
        TextView textView = findViewById(R.id.textView);
        String welcomeString = getResources().getString(R.string.welcome_string);
        textView.setText(welcomeString);
        //Инициализация кнопки
        Button button = findViewById(R.id.mainButton);
        String myName=getResources().getString(R.string.my_name);
        button.setText(myName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyApp", "Кнопка была нажата программным способом");
            }
        });
        // Инициализация компонента картинки – ресурсом картинки
        ImageView imageView = findViewById(R.id.imageView1);
        imageView.setImageResource(R.drawable.ice_cream_svgrepo_com);
        // Инициализация EditText
        EditText editText = findViewById(R.id.editText);
        editText.setHint("Введите что-нибудь здесь!!!!!!!");*/

    }
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //Результат получен
                        Intent data = result.getData();
                    }
                }
            });
    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        // передача объекта с ключом "hello" и значением "Hello World"
        //intent.putExtra("hello", "Hello World");
        mStartForResult.launch(intent);
    }
}