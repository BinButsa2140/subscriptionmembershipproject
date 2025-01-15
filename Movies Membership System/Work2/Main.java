package Work2;
import java.time.LocalDate;
import java.util.TimerTask;

import Work2.Tools.Delete;
import Work2.UserPanel.BaseFromRegis;

import java.util.Timer;
class Main{
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();//set day 
        TimerTask task = new TimerTask() { // task ที่ใช้ร่วมกับ TIMER
            @Override
            public void run() {//เช็คหากเวลาตรงกับวันที่ต้องลบ ให้ลบเลย
                Delete d = new Delete();
                d.deleteByTime();
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000*60*60*24);//fix time to start task every 24 hour
        new BaseFromRegis();
    }
}