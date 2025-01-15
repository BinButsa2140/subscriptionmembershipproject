package Work2.Tools;
import Work2.InterfaceClass.WriteUser;

public class Select_Status {//เอาไว้ใช้เลือกว่าจะพาไปเขียนที่ไฟล์ไหน
    private WriteUser typeUser;
    public void setTypeUser(WriteUser typeUser){
        this.typeUser = typeUser;
    }
    public void writeUser(String s,String info){
        typeUser.write(s, info);
    }
}
