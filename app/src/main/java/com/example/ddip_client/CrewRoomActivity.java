package com.example.ddip_client;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CrewRoomActivity extends AppCompatActivity {

    private RadioButton radioCalendar;
    private RadioButton radioExchange;
    private RadioButton radioWorkerList;
    private RadioGroup radioGroup;
    private TextView roomNameTextView; // 방 이름 표시용 TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crewroom);

        // ------------------ Intent로 전달받은 방 이름 표시 ------------------
        roomNameTextView = findViewById(R.id.room_name_text); // crewroom.xml에서 TextView ID
        String roomName = getIntent().getStringExtra("roomName"); // 전달받은 방 이름
        if (roomName != null) {
            roomNameTextView.setText(roomName); // 방 이름 설정
        } else {
            roomNameTextView.setText("방 이름 없음"); // 예외 처리
        }

        // ------------------ Bottom Navigation (하단 네비게이션 바) ------------------
        ImageButton homeButton = findViewById(R.id.home_button);
        ImageButton subCrewButton = findViewById(R.id.sub_crew_button);
        ImageButton alarmButton = findViewById(R.id.alarm_button);
        ImageButton myPageButton = findViewById(R.id.my_page_button);

        // 홈 버튼 클릭 리스너 설정
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(CrewRoomActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // 크루룸 이동 버튼 클릭 리스너 설정 (현재 Activity와 동일하므로 토스트만 표시)
        subCrewButton.setOnClickListener(v -> Toast.makeText(CrewRoomActivity.this, "크루룸 화면에 있습니다.", Toast.LENGTH_SHORT).show());

        // 알람 버튼 클릭 리스너 설정
        alarmButton.setOnClickListener(v -> {
            Intent intent = new Intent(CrewRoomActivity.this, AlarmActivity.class);
            startActivity(intent);
        });

        // 마이페이지 버튼 클릭 리스너 설정
        myPageButton.setOnClickListener(v -> {
            Intent intent = new Intent(CrewRoomActivity.this, MypageActivity.class);
            startActivity(intent);
        });

        // ------------------ Radio Buttons (라디오 버튼) ------------------
        radioCalendar = findViewById(R.id.radio_calendar);
        radioExchange = findViewById(R.id.radio_exchange);
        radioWorkerList = findViewById(R.id.radio_worker_list);
        radioGroup = findViewById(R.id.radio_group);

        // 라디오 버튼 선택 이벤트 리스너 설정
        radioCalendar.setOnClickListener(v -> {
            Intent intent = new Intent(CrewRoomActivity.this, CalendarActivity.class);
            startActivity(intent);
        });

        // 교환하기 페이지 이동 (구현 예정)
        radioExchange.setOnClickListener(v -> {
            // 교환하기 페이지로 이동 구현 필요
            Toast.makeText(CrewRoomActivity.this, "교환하기 선택됨", Toast.LENGTH_SHORT).show();
        });

        // 근무자 리스트 페이지로 이동
        radioWorkerList.setOnClickListener(v -> {
            Intent intent = new Intent(CrewRoomActivity.this, UserListActivity.class);
            startActivity(intent);
        });
    }
}
