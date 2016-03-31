package ru.kpfu.itis.group11506.studentBubleSort;

public class Student implements Comparable
{
    public int score;
    public String last_name;
    public String first_name;

    public Student(int score, String last_name, String first_name)
    {
        this.score = score;
        this.last_name = last_name;
        this.first_name = first_name;
    }


    public int compareTo(Object obj)
    {
        Student tmp = (Student)obj;
        if(this.score < tmp.score)
        {
            return -1;
        }
        else if(this.score > tmp.score)
        {
            return 1;
        }
        return 0;
    }

    public int compareToName(Object obj)
    {
        Student tmp = (Student)obj;
        if(this.first_name.charAt(0) < tmp.first_name.charAt(0))
        {
            return -1;
        }
        else if(this.first_name.charAt(0) > tmp.first_name.charAt(0))
        {
            return 1;
        }
        return 0;
    }

}

