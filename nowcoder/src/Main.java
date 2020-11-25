import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
        User user1 = new User(19L);
        User user2 = new User(421L);
        User user3 = new User(19L);
        User user4 = new User(123L);
        /*users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);*/
        List<User> users = new ArrayList<>();
        List<UserAll> userAlls = new ArrayList<>();

        Map<Integer, Long> map = users.stream().collect(Collectors.groupingBy(User::getStudentType, Collectors.counting()));

        List<Map.Entry<Integer, Long>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Comparator.comparingInt(Map.Entry::getKey));

        int maxKey = 0;
        long maxValue = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        // 索引0代表1类型......
        int[] count = new int[4];
        for (User user : users) {
            // 计算每种类型的count
            switch (user.getStudentType()) {
                case 1 : count[0]++; break;
                case 2 : count[1]++; break;
                case 3 : count[2]++; break;
                case 4 : count[3]++; break;
            }
        }
        int maxIndex = -1;
        int maxVal = -1;
        // 遍历得到最大的值的索引
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxVal) {
                maxVal = count[i];
                maxIndex = i;
            }
        }

        for (User user : users) {
            if (user.getStudentType().equals(1))
                userAlls.add(new UserAll(user.getSchool(), user.getCla(), user.getStudentNum(), null, null));
            else if (user.getStudentType().equals(2))
                userAlls.add(new UserAll(user.getSchool(), user.getCla(), null, user.getStudentNum(), null));
            else
                userAlls.add(new UserAll(user.getSchool(), user.getCla(), null, null, user.getStudentNum()));
        }
    }
}
class User{
    private String school;

    private Long cla;

    private Integer studentNum;

    private Integer studentType;

    @Override
    public String toString() {
        return "User{" +
                "school='" + school + '\'' +
                ", cla='" + cla + '\'' +
                ", studentNum=" + studentNum +
                ", studentType=" + studentType +
                '}';
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Long getCla() {
        return cla;
    }

    public void setCla(Long cla) {
        this.cla = cla;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getStudentType() {
        return studentType;
    }

    public void setStudentType(Integer studentType) {
        this.studentType = studentType;
    }

    public User() {
    }

    public User(Long cla) {
        this.cla = cla;
    }
}
class UserAll{
    private String school;

    private Long cla;

    private Integer aStudent;

    private Integer bStudent;

    private Integer cStudent;

    public UserAll(String school, Long cla, Integer aStudent, Integer bStudent, Integer cStudent) {
        this.school = school;
        this.cla = cla;
        this.aStudent = aStudent;
        this.bStudent = bStudent;
        this.cStudent = cStudent;
    }

    public UserAll() {
    }

    @Override
    public String toString() {
        return "UserAll{" +
                "school='" + school + '\'' +
                ", cla=" + cla +
                ", aStudent=" + aStudent +
                ", bStudent=" + bStudent +
                ", cStudent=" + cStudent +
                '}';
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Long getCla() {
        return cla;
    }

    public void setCla(Long cla) {
        this.cla = cla;
    }

    public Integer getaStudent() {
        return aStudent;
    }

    public void setaStudent(Integer aStudent) {
        this.aStudent = aStudent;
    }

    public Integer getbStudent() {
        return bStudent;
    }

    public void setbStudent(Integer bStudent) {
        this.bStudent = bStudent;
    }

    public Integer getcStudent() {
        return cStudent;
    }

    public void setcStudent(Integer cStudent) {
        this.cStudent = cStudent;
    }
}