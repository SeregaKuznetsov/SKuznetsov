import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Student [] students = new Student [6];
        Group group11506 = new Group("hikkas",students);
        students[0] = new Student("Sergey", 1998, Month.MARCH , 25);
        students[1] = new Student("Taras", 1997, Month.MAY , 24);
        students[2] = new Student("Nikita", 1997, Month.NOVEMBER , 9);
        students[3] = new Student("Elya", 1997, Month.SEPTEMBER, 6);
        students[4] = new Student("Danil", 1997, Month.JANUARY, 22);
        students[5] = new Student("Adel", 1997, Month.MARCH, 24);
        sort(students);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getName() + " " + students[i].getDate());
        }

    }


    public static void sort (Student [] students) {
        int size = students.length;
        int step = size / 2;//инициализируем шаг.
        while (step > 0)//пока шаг не 0
        {
            for (int i = 0; i < (size - step); i++)
            {
                int j = i;
                //будем идти начиная с i-го элемента
                while (j >= 0 && students[j].getDate().isAfter(students[j + step].getDate()))
                //пока не пришли к началу массива
                //и пока рассматриваемый элемент больше
                //чем элемент находящийся на расстоянии шага
                {
                    //меняем их местами
                    Student temp = students[j];
                    students[j] = students[j + step];
                    students[j + step] = temp;
                    j--;
                }
            }
        step = step / 2;//уменьшаем шаг
        }
    }
}

